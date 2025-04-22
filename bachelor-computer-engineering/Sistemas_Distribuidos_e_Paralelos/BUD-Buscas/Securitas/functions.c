/**
 * @file functions.c
 * 
 * Implementacao das funcoes gerais utilizadas.
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#include "functions.h"

/**
 * @brief A funcao permite eliminar o CRLF de uma mensagem.
 * 
 * A funcao assume que o conteudo correcto da mensagem aparece antes do CRLF e que tudo o que aparecer depois e' para
 * ser removido.
 * Embora o objectivo seja eliminar a sequencia '\r\n', a funcao termina assim que apareca um dos dois caracteres 
 * do conjunto nao verificando se o outro caracter se encontra efectivamente na mensagem, assim, o efeito pratico 
 * da funcao resulta na remocao de TODOS os caracteres que aparecam apos uma ocorrencia do caracter '\r' ou do
 * caracter '\n'.
 * 
 * @param line Ponteiro para a mensagem a tratar.
 * 
 * @return A funcao nao possui valores de retorno.
 */
void trim_crlf(char *line)
  {
  char *aux = line;
  while(*aux != '\r' && *aux != '\n')
    aux++;
  *aux = '\0';
  } 

/**
 * @brief Funcao que permite escrever para um socket previamente aberto.
 * 
 * A funcao permite a escrita de mensagens para um socket que tenha sido aberto antes da chamada 'a funcao.
 * Em caso de erro a funcao envia para o stderr a mensagem definida pelo utilizador e fecha o socket para onde tentou escrever..
 * 
 * @param fd Descritor do socket para onde se pretende escrever.
 * @param mesg Ponteiro para a mensagem a escrever.
 * @param error_mesg Ponteiro para a mensagem de erro a enviar para o stderr.
 * 
 * @return A funcao devolve ALL_GOES_WELL em caso de sucesso e ERROR_VAL em caso de erro.
 */
int write_to_socket(int fd, char *mesg, char *error_mesg)
  {
  if(write(fd, mesg, strlen(mesg)) < 0)
  	{
    DEBUG(error_mesg);
    close(fd);
    return ERROR_VAL;
  	}
  return ALL_GOES_WELL;
  }

/**
 * @brief Funcao responsavel pela leitura de texto atraves de um descritor de ficheiro.
 * 
 * 
 * @param fd Descritor onde sera efectuada a leitura.
 * @param linha Ponteiro para a linha onde seram guardados os dados lidos
 * @param max Numero maximo de caracteres a ler.
 * 
 * @return A funcao devolve o numero de caracteres lidos.
 */
int readline (int fd, char *linha, int max)
  {
  int index = 0;
  char ch;
  memset (linha, 0, max);
  do
    {
    switch (read (fd, linha + index, sizeof (char)))
      {
	  case 0:
	    return index;
	  case -1:
	    switch (errno)
	      {
	      case EINTR:
	        return index;
	      case EWOULDBLOCK:
		    continue;
	      default:
		    return index;
	      }
      }
    ch = linha[index++];
    }
  while (ch != '\n' && index < max - 1);
  return index;
  }

/**
 * @brief Permite verificar a validade de um endereco IP.
 * 
 * Enderecos de broadcast e de rede nao sao considerados IPs validos.
 * 
 * @param ip Ponteiro para a string que representa o IP a testar.
 * 
 * return ALL_GOES_WELL caso a string passada represente um IP valido ou ERROR_VAL caso contrario. 
 */
int validate_ip(char *ip)
  {
  struct in_addr temp;
  int ip_size = strlen(ip);
  
  #ifdef SHOW_DEBUG
    DEBUG("A tentar validar o IP: %s", ip);
  #endif
  
  if(ip_size < MIN_IP_LEN || ip_size > MAX_IP_LEN)
    return ERROR_VAL;
  
  if((ip[ip_size] == '0' && ip[ip_size - 1] == '.') || (ip[ip_size] >= '5' && ip[ip_size - 1] >= '5' && ip[ip_size -2] >= '2'))
  	return ERROR_VAL;
 
  if(!(inet_pton(AF_INET, ip, &temp)))
    return ERROR_VAL;
  
  return ALL_GOES_WELL;
  }

/**
 * Funcao responsavel pela abertura de um socket.
 * 
 * @return ERROR_VAL, caso ocorra um erro ou valor ALL_GOES_WELL, se a funcao terminar sem erros.
 */
int open_socket(uint16_t porto, PROCESSOR processa_pedido, void *args_processor, int *stoping_condition)
  {
  int server_fd, client_fd;
  socklen_t client_len;
  struct sockaddr_in server_addr, client_addr;
  int option = 1;
  
  /* Criar o Socket */
  if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    return ERROR_VAL;
  /* Preencher estrutura */
  memset(&server_addr, 0, sizeof(server_addr));
  server_addr.sin_family = AF_INET;
  server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
  server_addr.sin_port = htons(porto);
    
  if(setsockopt(server_fd, SOL_SOCKET, SO_REUSEADDR, &option, sizeof(int)) == -1)
    return ERROR_VAL;
  
  if (bind(server_fd, (struct sockaddr *) &server_addr, sizeof(server_addr)) < 0)
    return ERROR_VAL;
  if (listen(server_fd, 5) < 0)
    return ERROR_VAL;
  client_len = sizeof(struct sockaddr);
  
  /* Ciclo para atender clientes */
  while (*stoping_condition)
    {
    /* Aceitar ligacoes */
    client_fd = accept(server_fd, (struct sockaddr *) &client_addr, &client_len);
	if (client_fd < 0)
	  switch(errno)
	    {
	    case EINTR:
	    case ECONNABORTED:
	      continue;
	    default:
	      return ERROR_VAL;
	    }
	    
	#ifdef SHOW_DEBUG
	  DEBUG("cliente [%s@%d]", inet_ntoa(client_addr.sin_addr), htons(client_addr.sin_port));
	#endif
	
    processa_pedido(client_fd, args_processor, strdup(inet_ntoa(client_addr.sin_addr)));
    
    #ifdef SHOW_DEBUG
      DEBUG("Pedido do cliente processado");
    #endif
    }
  return ALL_GOES_WELL;
  }

/**
 * @brief Efectua o parsing dos argumentos passados 'a funcao.
 * 
 * Permite efectuar o tratamento dos paramentros passados 'a aplicacao. A funcao nao valida os paramentros, apenas a 
 * correspondencia aos tipos de dados e' verificada, qualquer validacao tera de ser efectuada exteriormente.
 * 
 * @param argc Numero de argumentos passados 'a aplicacao.
 * @param argv Conjunto de argumentos passados 'a aplicacao e recebidos pela funcao main.
 * @param c_file Ponteiro para a variavel que ira conter a string representatica do caminho para o ficheiro de contas.
 * @param m_file Ponteiro para a variavel que ira conter a string representatica do caminho para o ficheiro de maquinas.
 * @param porto Ponteiro para a variavel que ira conter o valor do porto passado 'a aplicacao.
 * @param tempo Ponteiro para a variavel que ira conter o valor do tempo passado 'a aplicacao.
 * 
 * @return A funcao -1 em caso de erro e 0 caso contrario.
 */
int parse_args(int argc, char *argv[], char **c_file, char **m_file, int *porto, int *tempo)
  {
  t_gen_args args;
  if(cmdline_parser (argc, argv, &args) != 0)
  	return ERROR_VAL;
  *c_file = strdup(args.contas_arg);
  *m_file = strdup(args.maquinas_arg);
  *porto = args.porto_arg;
  *tempo = args.tempo_arg;
  return ALL_GOES_WELL;
  }

/**
 * @brief Funcao que mostra mensagens de erro e termina a aplicacao.
 * 
 * A funcao mostra uma mensagem de erro ao utilizador e coloca no stderr uma 
 * mensagem e o codigo do erro, de seguida o programa e'terminado.
 * 
 * @param user_mesg Mensagem de erro a mostrar ao utilizador.
 * @param error_mesg Mensagem de erro a enviar para o stderr.
 * @param exit_code Codigo do erro que ocorreu.
 * 
 * @return A funcao nao retorna valores.
 */
void print_error_exit(char *user_mesg, char *error_mesg, int exit_code)
  {
  printf("%s", user_mesg);
  fflush(stdout);
  ERROR(exit_code, "%s.", error_mesg);
  }

/**
 * @brief Valida uma string, representativa de um caminho para um ficheiro, passada por parametro.
 * 
 * A funcao validate_path permite determinar se uma string representa correctamente um caminho para um ficheiro ou
 * directoria. A funcao nao altera a string de entrada e nao verifica se os ficheiros e/ou pastas existem, 
 * verifica apenas se, sintaticamente, o caminho e' valido.
 * 
 * @param path Ponteiro para a string a validar.
 * 
 * @return A funcao devolde -1 caso o caminho seja invalido e 0 caso contrario.
 */
int validate_path(char *path)
  {
  int z = 0, size, value = -1;
  char *test;
  
  if(path == NULL)
    return 0;
  
  #ifdef SHOW_DEBUG
    DEBUG("Caminho a validar: ^%s^", path);
  #endif
  
  test = strdup(path);
  size = strlen(path); 
  for(;z < size; z++)
    if(test[z] == '/')
      {
      if(test[z + 1] == '/')
        return -1;
      test[z] = VALID_CHAR;
      }
  value = strpbrk(test, INVALID_CHARS) == NULL ? 0 : -1;
  free(test);
  return value;
  }
