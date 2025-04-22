/**
 * @file structures.c
 * 
 * Implementacao das funcoes responsaveis por criar, manter e remover as varias estruturas de dados utilizadas. 
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#include "structures.h"

/**
 * Funcao que permite efectuar a alocacao dinamica da estrutura com os parametros a passar 'a thread de monitorizacao.
 * 
 * @param sessions Ponteiro para a estrutura que guarda as sessoes abertas no servidor.
 * @param tempo Tempo correspondente ao parametro session length.
 * @param mutex Ponteiro para o mutex que controla a seccao crititica.
 * @param cond Ponteiro para a condicao que, associada ao mutex, permite controlar a seccao critica.
 *  
 * @return Ponteiro para a zona de memoria alocada.
 * 
 * @see free_args_monitor()
 */
t_args_monitor *create_args_monitor(HASHTABLE_T *sessions, int tempo, pthread_mutex_t *mutex, pthread_cond_t *cond)
  {
  t_args_monitor *args = NULL;
  if(sessions && mutex && cond)
    {
    args = (t_args_monitor *)malloc(sizeof(t_args_monitor));
    args->sessions = sessions;
    args->session_len = tempo;
    args->mutex = mutex;
    args->cond = cond;
    }
  return args;
  }

/**
 * Liberta memoria alocada dinamicamente para alojar dados do tipo t_args_monitor.
 * 
 * @param args Ponteiro para a estrutura a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 * 
 * @see create_args_monitor()
 */
void free_args_monitor(t_args_monitor *args)
  {
  free(args);
  }

/**
 * Funcao que permite efectuar a alocacao dinamica a estrutura com os parametros a passar 'a funcao
 * que ira processar os pedidos dos clientes.
 * 
 * @param sessions Ponteiro para a estrutura que guarda a informacao das
 * @param contas Ponteiro para a estrutura que guarda a informacao das contas.
 * @param maquinas Ponteiro para a estrutura que guarda a informacao das maquinas.
 * @param tempo Tempo correspondente ao parametro session length.
 * @param mutex Ponteiro para o mutex que controla a seccao crititica.
 * 
 * @return Ponteiro para a zona de memoria alocada.
 * 
 * @see free_args_processor()
 */
t_args_processor *create_args_processor(HASHTABLE_T *sessions, HASHTABLE_T *contas, HASHTABLE_T *maquinas, int tempo, pthread_mutex_t *mutex)
  {
  t_args_processor *args = NULL;
  args = (t_args_processor *)malloc(sizeof(t_args_processor));
  args->hash_sessions = sessions;
  args->hash_contas = contas;
  args->hash_maquinas = maquinas;
  args->session_len = tempo;
  args->mutex = mutex;
  return args;
  }

/**
 * Liberta memoria alocada dinamicamente para alojar dados do tipo t_args_processor.
 * 
 * @param args Ponteiro para a estrutura a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 * 
 * @see create_args_processor()
 */ 
void free_args_processor(t_args_processor *args)
  {
  free(args);
  }

/**
 * Funcao que permite efectuar a alocacao dinamica de uma sessao.
 * 
 * @param login String com o login.
 * 
 * @return Ponteiro para a zona de memoria alocada.
 * 
 * @see free_session()
 */
t_session *create_session(char *login)
  {
  static char format[20]; 
  t_session *session = NULL;
  time_t relogio;
  if(login)
    {
    time(&relogio);
    srandom(getpid() + relogio);
    session = (t_session *) malloc(sizeof(t_session));
    sprintf(format, "%%0%dlx:%%0%dlx", sizeof(long int) * 2, sizeof(long int) *2 );
    sprintf(session->sessionid, format, relogio, random());
    session->login = strdup(login);
    time(&(session->working_time));
    }
  return session;
  } 

/**
 * Liberta memoria alocada dinamicamente para alojar dados do tipo t_session.
 * 
 * @param session Ponteiro para a estrutura a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 * 
 * @see create_session()
 */
void free_session(t_session *session)
  {
  free(session->login);
  free(session->sessionid);
  free(session);
  }
/**
 * Funcao que permite libertar a memoria alocada dinmicamente para a estrutura t_maquina.
 * A funcao tem em conta o modo de funcionamento do securitas e das hashtables usadas.
 * 
 * @param maq Ponteiro para a zona de memoria a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 */
/*void fake_free_maquina(t_maquina *maq)
  {
  if((--maq->num_ips) == 0)
    free_maquina(maq);
  }*/

/**
 * Funcao que permite efectuar a alocacao dinamica das informacoes de uma maquina.
 * 
 * @param ip Ponteiro para o IP da maquina. 
 * @param logins Tabela de hash de logins.
 * @param pastas Ponteiro para a lista de pastas da maquina.
 * 
 * @return Ponteiro para a zona de memoria alocada.
 * 
 * @see free_conta()
 */
t_maquina *create_maquina(char *ip, HASHTABLE_T *logins, LISTA_GENERICA_T *pastas)
  {
  t_maquina *maquina = NULL;
  if(ip && logins && pastas)
    {
    maquina = (t_maquina *)malloc(sizeof(t_maquina));
    maquina->ip = strdup(ip);
    maquina->logins = logins;
    maquina->pastas = pastas;
    }
  return maquina;
  }

/**
 * Liberta memoria alocada dinamicamente para alojar dados do tipo t_maquina.
 * 
 * @param maq Ponteiro para a estrutura a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 */
void free_maquina(t_maquina *maq)
  {
  free(maq->ip);
  free(maq->logins);
  free(maq->pastas);
  free(maq);
  }

/**
 * Funcao que permite efectuar a alocacao dinamica de uma conta.
 * 
 * @param login String com o login. 
 * @param password String com a password.
 * 
 * @return Ponteiro para a zona de memoria alocada.
 * 
 * @see free_conta()
 */
t_conta *create_conta(char *login, char *password)
  {
  t_conta *conta = NULL;
  if(login && password)
    {
    conta = (t_conta *) malloc(sizeof(t_conta));
    conta->login = strdup(login);
    conta->password = strdup(password);
    }
  return conta;
  }

/**
 * Liberta memoria alocada dinamicamente para alojar dados do tipo t_conta.
 * 
 * @param conta Ponteiro para a estrutura a libertar.
 * 
 * @return A funcao nao possui valores de retorno.
 * 
 * @see create_conta()
 */
void free_conta(t_conta *conta)
  {
  free(conta->login);
  free(conta->password);
  free(conta);
  }
