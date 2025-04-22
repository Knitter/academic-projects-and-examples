/**
 * @file securitas.c
 * 
 * Implementacao das funcoes especificas do servico Securitas.
 * Implementacao da funcao 'main'.
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#include "securitas.h"

int global_status = OK_STATUS;

int main(int argc, char* argv[])
  {
  HASHTABLE_T *sessions = NULL, *contas = NULL, *maquinas = NULL;
  FILE *f_contas = NULL, *f_maquinas = NULL;
  char *c_file = NULL, *m_file = NULL;   /* -1 indica fim de vector de sinais */
  int session_len = 0, porto = 0, sinais[] = {SIGINT, SIGALRM, SIGPIPE,-1}, z=0;
  t_args_processor *args_processor;
  t_args_monitor *args_thread;
  pthread_mutex_t mutex;
  pthread_cond_t cond;
  pthread_t tid;
  
  t_sigaction act,oldact;
  
  /* Iniciar e registar sinais */
  act.sa_handler=signal_handling;
  sigemptyset(&act.sa_mask);
  act.sa_flags=0;
  
                /* sinais++ */
  for(;sinais[z] != -1; z++)
    sigaction(sinais[z],&act,&oldact);
    
  /* Iniciar variaveis */  
  sessions = tabela_criar(HASHBASE, (LIBERTAR_FUNC)free_session);
  /* Iniciar mutex e condicao*/
  if(pthread_mutex_init(&mutex, NULL) != 0)
    {
    tabela_destruir(&sessions);
    print_error_exit("Impossivel iniciar estruturas de controlo de thread.", "Impossivel iniciar o mutex.", ERROR_VAL);
    }
    
  if(pthread_cond_init(&cond, NULL) != 0)
    {
    pthread_mutex_destroy(&mutex);
    tabela_destruir(&sessions);
    print_error_exit("Impossivel iniciar estruturas de controlo de thread.", "Impossivel iniciar a condicao.", ERROR_VAL);
    }
     
  /* Efectuar parsing dos parametros de entrada */
  if(parse_args(argc, argv, &c_file, &m_file, &porto, &session_len) != ALL_GOES_WELL)
    {
    destroy_3_resources(&cond, &mutex, &sessions);
    print_error_exit("Argumentos invalidos.", "Erro na chamada ao cmdline_parser.", ERROR_VAL);
    }
    
  /* Validar o porto passado */
  if(porto < 0)
    {
    destroy_3_resources(&cond, &mutex, &sessions);
	print_error_exit("O porto especificado nao se encontra dentro dos limites.\nIndique valores superiores a 0 (zero)", "Passado ao Securitas um porto inferiror a 0", ERROR_VAL);
    }
    
  /* Validar caminhos passados por parametro */
  if(validate_path(c_file) != 0)
    {
   destroy_3_resources(&cond, &mutex, &sessions);
    print_error_exit("Caminho para ficheiro de contas invalido.", "Caminho para contas invalido.", ERROR_VAL);
    }
    
  if(validate_path(m_file) != 0)
    {
    destroy_3_resources(&cond, &mutex, &sessions);
    print_error_exit("Caminho para ficheiro de maquinas invalido.", "Caminho para maquinas invalido.", ERROR_VAL);
    }
  
  /* Abrir ficheiros */
  if(!(f_contas = fopen(c_file, "r")))
    {
    destroy_3_resources(&cond, &mutex, &sessions);
    print_error_exit("Erro ao abrir o ficheiro de contas", "fopen() falhou no ficheiro de contas.", ERROR_VAL);
    }
    
  if(!(f_maquinas = fopen(m_file, "r")))
    {
    destroy_3_resources(&cond, &mutex, &sessions);
    print_error_exit("Erro ao abrir o ficheiro de maquinas", "fopen() falhou no ficheiro de maquinas.", ERROR_VAL);
    }
    
  /* Criar hastables *//*This code is not to be 'speed user friendly' */
  contas = tabela_criar(HASHBASE, (LIBERTAR_FUNC)free_conta);
  maquinas = tabela_criar(HASHBASE, (LIBERTAR_FUNC)free_maquina);
  
  /* Efectuar parsing de ficheiros de configuracao */
  if(parse_contas(f_contas, contas) == ERROR_VAL)
    {
    destroy_5_resources(&cond, &mutex, &contas, &maquinas, &sessions);
    print_error_exit("Formato do ficheiro de contas invalido ou a funcao foi interrompida pelo sistema.",
      "O formato do ficheiro de contas nao esta correcto ou a funcao getline() falhou.", ERROR_VAL);
    }
    
  if(parse_maquinas(f_maquinas, maquinas) == ERROR_VAL)
    {
    destroy_5_resources(&cond, &mutex, &contas, &maquinas, &sessions);
    print_error_exit("Formato do ficheiro de maquinas invalido  ou a funcao foi interrompida pelo sistema.",
      "O formato do ficheiro de maquinas nao esta correcto ou a funcao getline() falhou.", ERROR_VAL);
    }
  
  /* Libertar os recursos que ja nao sao necessarios */
  fclose(f_contas);
  fclose(f_maquinas);
  free(c_file);
  free(m_file);
  
  /* Criar thread de monitorizacao */
  args_thread = create_args_monitor(sessions, session_len, &mutex, &cond);
  if(pthread_create(&tid, NULL, monitor_thread, args_thread) != 0)
    {
    destroy_final_resources(&cond, &mutex, &contas, &maquinas, &sessions, args_processor, args_thread);
    print_error_exit("Erro ao criar o sistema de monitorizacao.", "Impossivel criar a thread.", ERROR_VAL);
    }

  /* Iniciar o socket de comunicacao no porto especificado */
  args_processor = create_args_processor(sessions, contas, maquinas, session_len, &mutex);
  open_socket((uint16_t)porto, proc_pedido, args_processor, &global_status);
  
  /* Desbloquear a thread e esperar que ela termine para poder libertar os recursos */
  pthread_cond_signal(&cond);
  pthread_join(tid, NULL);
  
  /* Libertar recursos e sair */
  destroy_final_resources(&cond, &mutex, &contas, &maquinas, &sessions, args_processor, args_thread);
  printf("Securitas a terminar. Tenha um bom dia.");
  
  #ifdef SHOW_DEBUG
    DEBUG("Sair do main do Securitas");
  #endif
  return 0;
  }
  
void signal_handling(int sig)
  {
  switch(sig)
    {
    case SIGINT:
      global_status = EXIT_STATUS;
      break;
    case SIGALRM:
      #ifdef SHOW_DEBUG
        DEBUG("Recebido o sinal SIGALRM");
      #endif
      break;
    case SIGPIPE:
      #ifdef SHOW_DEBUG
        DEBUG("Recebido o sinal SIGPIPE");
      #endif
      break;
    }
  }

void *monitor_thread(void *args)
  {
  t_args_monitor *info = (t_args_monitor *)args;
  ITERADOR_T *it = NULL;
  LISTA_GENERICA_T *lista_elem = NULL;
  t_timespec time_speck;
  time_t tick;
  sigset_t set, oset;
  int cond_error = 0;
  
  time_speck.tv_nsec = 0;
  /* Bloquer a recepcao de sinais */
  sigemptyset(&set);
  sigemptyset(&oset);
  
  sigaddset(&set, SIGINT);
  sigaddset(&set, SIGALRM);
  sigaddset(&set, SIGPIPE);
  
  pthread_sigmask(SIG_BLOCK, &set, &oset);
  
  while(global_status)
    {
    /* Tendo em conta que o parametro 'tempo' se encontra em minutos */
    time(&tick);
    time_speck.tv_sec = tick + info->session_len * 60;
    pthread_mutex_lock(info->mutex);
    cond_error = pthread_cond_timedwait(info->cond, info->mutex, &time_speck);
    pthread_mutex_unlock(info->mutex);
    if(cond_error != ETIMEDOUT)
      continue;

    #ifdef SHOW_DEBUG
      DEBUG("Thread a acordar.");
    #endif

    pthread_mutex_lock(info->mutex);
    if(tabela_numero_elementos(info->sessions) != 0)
      {
      lista_elem = tabela_criar_lista_elementos(info->sessions);
      it = lista_criar_iterador(lista_elem);
      while(iterador_proximo_elemento(it))      
        if((time_speck.tv_sec - ((t_session *)it->actual->elem)->working_time) > info->session_len * 60)
          {
          #ifdef SHOW_DEBUG
          DEBUG("A remover a sessao: ^%s^", ((t_session *)it->actual->elem)->sessionid);
          #endif
          
          tabela_remover(info->sessions, ((t_session *)it->actual->elem)->sessionid);
          }
      }
    pthread_mutex_unlock(info->mutex);
    }
  pthread_exit(NULL);
  return NULL;
  }
 
int proc_pedido(int fd, void *args, char *ip_cliente)
  {
  int state = 0, folder_count = 0;
  char mesg[MAX_MESSAGE_LEN + 1] = {'\0'}, *pasta = NULL, line[MAX_MESSAGE_LEN + 1] = {'\0'} , lixo[MAX_MESSAGE_LEN + 1] = {'\0'}, user_login[MAX_LOGIN_LEN + 1] = {'\0'}, 
    user_pass[MAX_PASS_LEN + 1] = {'\0'}, sessionid[MAX_SESSINON_ID + 1]= {'\0'};
  t_conta *user = NULL;
  t_session *session = NULL;
  t_maquina *maquina = NULL;
  ITERADOR_T *it = NULL;
  t_args_processor *info = (t_args_processor *)args;
  time_t acesso_actual;
  memset(line, 0, MAX_MESSAGE_LEN + 1);
  
  /* Cumprimentar o cliente */
  sprintf(mesg, "Bem vido ao Securitas. Ligacao OK\r\n");
  if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
    return ERROR_VAL;
  do
    {
    /* Antes de activar o alarme garantir que a variavel de teste tem o valor correcto *//*One bit towards PARANOIA*/
    alarm(TIMEOUT);
    if(readline(fd, line, MAX_MESSAGE_LEN) <= 0)
      {
      DEBUG("Erro ao tentar ler informacaoes do socket. 'readline' falhou.");
      close(fd);
      alarm(0);
      return ERROR_VAL;
      }
    /* Desativar o alarme uma vez que ja foi efectuada uma leitura */
    alarm(0);
    /* O servidor nao admite mensagens de pedidos que nao sejam terminadas com CRLF 
     * no entanto admite um numero de CRLF indefenidos e, caso o cliente nao respeite o protocolo, 
     * lixo depois da mensagem correcta desde que exista um CRLF a separar os campos */
    trim_crlf(line);
    
    #ifdef SHOW_DEBUG
      DEBUG("A entrar no estado: %d", state);
    #endif
    
    switch(state)
      {	
      /* Espera por instrucao inicial, AUTENTICACAO, AUTORIZACAO ou LOGOUT */
      case LISTENING:
        if(strcmp(line, "AUTENTICACAO") == 0)
          state = LOGIN;
        else
          if(strcmp(line, "AUTORIZACAO") == 0)
            state = AUTORIZACAO;
          else
            if(strcmp(line, "LOGOUT") == 0)
              state = LOGOUT;
            else
              state = EXIT;
        break;
      /* Espera por LOGIN */
      case LOGIN:
        #ifdef SHOW_DEBUG
          DEBUG("A receber login, lido: ^%s^", line);
        #endif
      
        if(strncmp(line, "LOGIN|", 6) == 0)
          {
          sscanf(line, "%[^|]|%s", lixo, user_login);
          state = PASSWORD;
          }
        else
          state = EXIT;
        break;
      /* Espera por PASS */
      case PASSWORD:
        #ifdef SHOW_DEBUG
          DEBUG("A receber password, lido: %s", line);
        #endif
        
        if(strncmp(line, "PASW|", 5) == 0)
          {
          sscanf(line, "%[^|]|%s", lixo, user_pass);
          if((user = tabela_consultar(info->hash_contas, user_login)) && (strcmp(user_pass, user->password) == 0))
            {
            session = create_session(user_login);
            pthread_mutex_lock(info->mutex);
            tabela_inserir(info->hash_sessions, session->sessionid, session);
            pthread_mutex_unlock(info->mutex);
            sprintf(mesg, "SESSIONID|%s\r\n", session->sessionid);
            if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
              return ERROR_VAL;
            }
          else
            {
            sprintf(mesg, "%s\r\n","LOGIN_FAILED");
            if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
              return ERROR_VAL;
            }
          }
        state = EXIT;
        break;
      /* AUTORIZACAO */
      case AUTORIZACAO:
        if(strncmp(line, "SESSIONID|", 10) == 0)
          {
          #ifdef SHOW_DEBUG
            DEBUG("A efectuar a autorizacao.");
          #endif
          
          sscanf(line, "%[^|]|%s", lixo, sessionid);
          maquina = tabela_consultar(info->hash_maquinas, ip_cliente);   
          if(maquina)
            {
            pthread_mutex_lock(info->mutex);
            session = tabela_consultar(info->hash_sessions, sessionid);               
            if(session)
              {
              time(&acesso_actual);
              if((acesso_actual - session->working_time) < info->session_len * 60)
                {
                session->working_time = acesso_actual;
                if(tabela_consultar(maquina->logins, session->login))
                  {
                  pthread_mutex_unlock(info->mutex);	
                  sprintf(mesg, "FOLDERS|%d\r\n", maquina->pastas->numero_elementos);
                  if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                    return ERROR_VAL;
                  it = lista_criar_iterador(maquina->pastas);
                  while((pasta = iterador_proximo_elemento(it)))
                    {
                    sprintf(mesg, "F%d|%s\r\n", ++folder_count, pasta);
                    if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                      {
                      iterador_destruir(&it);
                      return ERROR_VAL;
                      }
                    }
                  iterador_destruir(&it);
                  sprintf(mesg, "%s\r\n","END_FOLDERS");
                  if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                    return ERROR_VAL;
                  }
                else
                  {
                  pthread_mutex_unlock(info->mutex);
                  sprintf(mesg, "%s\r\n", "ACCESS_DENIED");
                  if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                    return ERROR_VAL;
                  }
                }
              else
                {
                pthread_mutex_unlock(info->mutex);
                sprintf(mesg, "%s\r\n", "SESSION_EXPIRED");
                if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                  return ERROR_VAL;
                }
              }
            else
              {
              pthread_mutex_unlock(info->mutex);
              sprintf(mesg, "%s\r\n", "SESSION_EXPIRED");
              if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
                return ERROR_VAL;
              }
            }
          else
            {
            sprintf(mesg, "%s\r\n", "ACCESS_DENIED");
            if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
              return ERROR_VAL;
            }
          }
        state = EXIT;
        break;
      /*ANULACAO*/
      case LOGOUT:
        if(strncmp(line, "SESSID|", 7) == 0)
          {
          #ifdef SHOW_DEBUG
            DEBUG("A efectuar o logout.");
          #endif
          
          sscanf(line, "%[^|]|%s", lixo, sessionid);
          if((session = tabela_consultar(info->hash_sessions, sessionid)))
            {
            pthread_mutex_lock(info->mutex);
            tabela_remover(info->hash_sessions, sessionid);
            pthread_mutex_unlock(info->mutex);
            sprintf(mesg, "%s\r\n", "SUCCESS");
            if(write_to_socket(fd, mesg, "Erro de escrita para o cliente.") != ALL_GOES_WELL)
              return ERROR_VAL;
            }
          else
            {
            sprintf(mesg, "%s\r\n", "LOGOUT_FAILED");
            if(write_to_socket(fd, mesg, "Erro de escrita para o cliente. Cliente teminado.") != ALL_GOES_WELL)
              return ERROR_VAL;
            
            #ifdef SHOW_DEBUG
              DEBUG("Pedido para fecho de uma sessao inexistente.");
            #endif
            }
          }
        state = EXIT;
        break;    
      default:
        /* Fechar ligacao ao cliente. *//*ESTAMOS A SER HACKADOS!*/
        DEBUG("Atingido estado de escuta indefinido.");
        state = EXIT;
      }
    }
  while(state != EXIT);
  close(fd);
  free(ip_cliente);
  return 0;
  }

/* As funcoes seguintes permitem libertar os recursos reservados ate determinada altura da vida do servidor */
void destroy_5_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **contas, HASHTABLE_T **maquinas, HASHTABLE_T **sessions)
  {
  pthread_mutex_destroy(mutex);
  pthread_cond_destroy(condicao);
  tabela_destruir(contas);
  tabela_destruir(maquinas);
  tabela_destruir(sessions);
  }

void destroy_3_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **sessions)
  {
  pthread_mutex_destroy(mutex);
  pthread_cond_destroy(condicao);
  tabela_destruir(sessions);
  }

void destroy_final_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **contas, HASHTABLE_T **maquinas, HASHTABLE_T **sessions, t_args_processor *args_processor, t_args_monitor *args_thread)
  {
  pthread_mutex_destroy(mutex);
  pthread_cond_destroy(condicao);
  tabela_destruir(contas);
  tabela_destruir(maquinas);
  tabela_destruir(sessions);
  free_args_processor(args_processor);
  free_args_monitor(args_thread);
  }
