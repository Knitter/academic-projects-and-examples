/**
 * @file files.c
 * 
 * Implementacao das funcoes referentes ao tratamento dos ficheiros de configuracao.
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#include "files.h"
  
/**
 * @brief Efectua o parsing do ficheiro de maquinas.
 * 
 * A funcao permite ler o ficheiro de maquinas e retirar a informacao fundamental para a execucao do securitas.
 * Os dados sao introduzidos na hashtable passada como parametro.A funcao ASSUME que a memoria para a estrutura ja 
 * se encontra alocada.A funcao NAO tenta alocar memoria para a estrutura.
 * 
 * @param file Ponteiro para o ficheiro de maquinas a ler.
 * @param maquinas Ponteiro para a estrutura onde serao guardados os dados lidos.
 * @return A funcao retorna ALL_GOES_WELL em sucesso e ERROR_VAL se ocorrer um erro na leitura.
 * 
 * @see defines.h
 */
int parse_maquinas(FILE *file, HASHTABLE_T *maquinas)
  {
  char* line = NULL, chave[MAX_IP_LEN + 1] = {'\0'}, logins[MAX_LOGIN_LIST_LEN + 1] = {'\0'}, pastas[MAX_FOLDER_LIST_LEN + 1] = {'\0'};
  size_t size;
  LISTA_GENERICA_T *lista_pastas = NULL;
  HASHTABLE_T *hash_logins = NULL;
  size_t  bufsize = 512;
  char *token = NULL, *token_buf = NULL, *buf = (char *) malloc(sizeof(char) * bufsize);
  t_maquina *maquina;
  struct hostent ret, *result;
  int error, ip_error = 0;
  
  if (!file)
  	return ERROR_VAL;
  
  #ifdef SHOW_DEBUG
    DEBUG("A inciar a leitura do ficheiro de maquinas.");
  #endif
  
  while ((getline(&line, &size, file)) != -1)
    if(sscanf(line, "%[^#]", line) > 0)
      {
      sscanf(line, "%[^;];%[^;];%s", chave, logins, pastas);
      if(strlen(chave) < 1 || strlen(logins) < 1 || strlen(pastas) < 1)
        {
        WARNING("Formato do ficheiro de maquinas incorrecto. IP, conjunto de logins ou pastas invalidos");
        continue;
        }
      result  = NULL; 
      if(validate_ip(chave))
        {
        while((ip_error = gethostbyname_r(chave, &ret, buf, bufsize, &result, &error)) == ERANGE)
          {
          bufsize *= 2;
          buf = (char *) malloc(sizeof(char) * bufsize);
          }
        if(ip_error || result == NULL)
          {
          WARNING("Erro ao resolver o ip da maquina %s", chave);
          continue;
          }
        }
      hash_logins = tabela_criar(HASHBASE, free);
      lista_pastas = lista_criar(free);
      token = strtok_r(logins, "|", &token_buf);
      tabela_inserir(hash_logins, strdup(token), strdup(token));
      while((token = strtok_r(NULL, "|", &token_buf)))
        {
        if(strlen(token) > MAX_LOGIN_LEN)
          {
          WARNING("Login demasiado grande.");
          continue;
          }
        tabela_inserir(hash_logins, strdup(token), strdup(token));
        }

      token = strtok_r(pastas, "|", &token_buf);
      lista_inserir(lista_pastas, strdup(token));
      while((token = strtok_r(NULL, "|", &token_buf)))
        lista_inserir(lista_pastas, strdup(token));
      
      /* Se foi necessario resolver o nome o IP da maquina estara na estrutura 'result'
       * caso contrario sera usado o valor existente na variavel 'chave'*/
      if(result)
        maquina = create_maquina(result->h_addr_list[0], hash_logins, lista_pastas);
      else
        maquina = create_maquina(chave, hash_logins, lista_pastas);
      tabela_inserir(maquinas, maquina->ip, maquina);
      }
  
  #ifdef SHOW_DEBUG
    DEBUG("A terminar a leitura do ficheiro de maquinas.");
  #endif
  
  if(!feof(file))
  	return ERROR_VAL;
  if (line)
   free(line);
  free(buf);
  return ALL_GOES_WELL;
  }

/**
 * @brief Efectua o parsing do ficheiro de contas.
 * 
 * A funcao permite ler o ficheiro de contas e retirar a informacao fundamental para a execucao do securitas.
 * Os dados sao introduzidos na hashtable passada como parametro.A funcao ASSUME que a memoria para a estrutura ja 
 * se encontra alocada.A funcao NAO tenta alocar memoria para a estrutura.
 * 
 * @param file Ponteiro para o ficheiro de contas a ler.
 * @param contas Ponteiro para a estrutura onde serao guardados os dados lidos.
 * 
 * @return A funcao retorna ALL_GOES_WELL em sucesso e ERROR_VAL se ocorrer um erro na leitura.
 * 
 * @see defines.h
 */
int parse_contas(FILE *file, HASHTABLE_T *contas)
  {
  char* line = NULL;
  size_t size;
  char login[MAX_LOGIN_LEN + 1] = {'\0'}, pass[MAX_PASS_LEN + 1] = {'\0'};
    
  if (!file)
  	return ERROR_VAL;

  #ifdef SHOW_DEBUG
    DEBUG("A inciar a leitura do ficheiro de contas.");
  #endif

  while (getline(&line, &size, file) != -1)
    if(sscanf(line, "%[^#]", line) > 0)
      {
      sscanf(line, "%[^;];%s", login, pass);
      
      #ifdef SHOW_DEBUG
        DEBUG("Linha do ficheiro de contas lida: ^%s^", line);
      #endif
      
      if(strlen(login) < 1  || strlen(pass) < 1)
        {
        
        #ifdef SHOW_DEBUG
        DEBUG("LOGIN ou PASSWORD sem tamanho valido.");
        #endif
        
        WARNING("Formato do ficheiro de contas incorrecto. Login ou password invalidos.");
        continue;
        }
      if(strlen(login) > MAX_LOGIN_LEN  || strlen(pass) > MAX_PASS_LEN)
        {
        
        #ifdef SHOW_DEBUG
        DEBUG("LOGIN ou PASSWORD exederam o tamanho permitido.");
        #endif
        
        WARNING("Tamanho do login ou da password demasiado grande.");
        continue;
        }
      tabela_inserir(contas, login, create_conta(login, pass));
      }
  
  #ifdef SHOW_DEBUG
    DEBUG("A terminar a leitura do ficheiro de contas.");
  #endif
  
  if(!feof(file))
  	return ERROR_VAL;
  if (line)
   free(line);
  return ALL_GOES_WELL;
  }
