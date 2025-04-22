/**
* @file funcoes.c
* @brief Biblioteca de funções gerais.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#include "funcoes.h"
#include <string.h>
#include <stdlib.h>

/**
 * Função que escreve o cabeçalho do ficheiro de log.
 *
 * @param log_file Ponteiro para ponteiro. Refere o ficheiro que será usado para escrever.
 * @param time_slice Ponteiro para um inteiro que guarda o "time_slice".
 * @param listaP Ponteiro o início da lista. Permitirá escrever o nome dos processos definidos
 * nos ficheiros de configuração.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_log_header(FILE **log_file,int *time_slice,t_listaS_processos *listaP){
	fprintf(*log_file,"# Legenda:\n");
	fprintf(*log_file,"# e : em execucao\n");
	fprintf(*log_file,"# - : outro estado\n");
	fprintf(*log_file,"\ntime_slice = %d\n",*time_slice);
	fprintf(*log_file,"\n%2c ",'Q');
	while(listaP){
		fprintf(*log_file,"%2s ",listaP->elemento.nome);
		listaP=listaP->prox;
	}
}

/**
 * Função que escreve o corpo do ficheiro de log.
 *
 * @param log_file Ponteiro para ponteiro. Refere o ficheiro que será usado para escrever.
 * @param quanta Ponteiro para um inteiro que guarda o "quanta".
 * @param listaP Ponteiro o início da lista. Permitirá escrever o estado dos processos definidos
 * nos ficheiros de configuração.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_log_body(FILE **log_file,int *quanta,t_listaS_processos *listaP){
	fprintf(*log_file,"\n%2d",*quanta);
	while(listaP){
		fprintf(*log_file," %2c",listaP->elemento.estado==Execucao ? 'e' : '-');
		listaP=listaP->prox;
	}
}

/**
 * Função que escreve o fim do ficheiro de log.
 *
 * @param log_file Ponteiro para ponteiro. Refere o ficheiro que será usado para escrever.
 * @param listaP Ponteiro o início da lista. Permitirá escrever o nome dos processos definidos
 * nos ficheiros de configuração.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_log_end(FILE **log_file,t_listaS_processos *listaP){
	fprintf(*log_file,"\n\n# nome do processo (tempo de resposta; tempo de turnaaround)");
	while(listaP){
		fprintf(*log_file,"\n%s (%d;%d)",listaP->elemento.nome,listaP->elemento.tempo_resposta,listaP->elemento.tempo_turnaround);
		listaP=listaP->prox;
	}
	fprintf(*log_file,"\n\n\t\t***END OF LOG FILE***\n");
}

/**
 * Função que inicializa a estrutura "t_schedule_info"
 *
 * @param info Ponteiro para a variável a inicializar.
 *
 * @return A função não tem valores de retorno.
 */
 void inicializar_schedule_info(t_schedule_info *info){
/* Valor negativo permite saber que a variável "time slice" ainda não foi alterada */
 info->time_slice=-1;
 info->quantum=-1;
 info->process_file=NULL;
 info->log_file=NULL;	
 }

 /**
 *	Função que permite verificar se os valores lidos do ficheiro de configuração estão correctos.
 *
 * @param info Ponteiro para a estrutura a verificar.
 *
 * @return A função não tem valores de retorno.
 */
 void aprovar_schedule_info(t_schedule_info *info){
 	if(info->time_slice==-1)
 		info->time_slice=DEFAULT_TIME_SLICE;
 	if(info->quantum==-1)
 		info->quantum=DEFAULT_QUANTUM;
 	if(!info->process_file)
 		strcpy(info->process_file,DEFAULT_PROCESS_FILE);
 	if(!info->log_file)
 		strcpy(info->log_file,DEFAULT_LOG_FILE);
 }

 /**
 * 	Função que permite obter os dados de um processo através do seu ID.
 *
 * @param lista Ponteiro para o início de lista a pesquisar.
 * @param id Identificação do processo.
 *
 * @return Ponteiro para o elemento encontrado.
 */
 t_listaS_processos *getproc_by_id(t_listaS_processos *lista,int id){
 	while(lista){
 		if((id==lista->elemento.id) && (lista->elemento.estado!=Terminacao))
 			return lista;	
 		lista=lista->prox;	
 	}
 	return NULL;
 }



/**
 * 	Função que permite obter os dados de um processo através do seu pid.
 *
 * @param lista Ponteiro para o início de lista a pesquisar.
 * @param id pid do processo.
 *
 * @return Ponteiro para o elemento encontrado.
 */
 t_listaS_processos *getproc_by_pid(t_listaS_processos *lista,int pid){
 	while(lista){
 		if(pid==lista->elemento.pID_proc && lista->elemento.estado!=Terminacao)
 			return lista;	
 		lista=lista->prox;	
 	}
 	return NULL;
 }
  	
/**
 * 	Função que permite verificar se existe algum processo para entrar em execução.
 *
 * @param lista Ponteiro para a lista a pesquisar.
 * @param quanta_total Ponteiro para a variável do tipo inteiro que contém o valor a comparar.
 *
 * @return Ponteiro para o processo a colocar em execução.
 */
 t_listaS_processos *verifica_admissao(t_listaS_processos *lista,int *quanta_total){
 	while(lista){
 		if(lista->elemento.tempo_entrada>*quanta_total)
 			break;
 		if(lista->elemento.tempo_entrada==*quanta_total && lista->elemento.estado==Novo)
 			return lista;
 		lista=lista->prox;		
 	}	
 	return NULL;
 }
 
 
/**
 * 	Função que conta o número de processos que ainda não terminaram.
 *
 * @param lista Ponteiro para a lista a pesquisar.
 * @param numProcs Número total de processos lidos do ficheiro de configuração.
 *
 * @return Devolve número de processos que faltam terminar.
 */
int n_processos_por_terminar(t_listaS_processos *lista,int numProcs){
int i=numProcs;
while(lista){
	if(lista->elemento.estado==Terminacao)
		i--;
	lista=lista->prox;	
}/* fim while */
return i;	
}/* fim isProcessosTerminados */

/**
 * 	Função responsável pela transferência dos dados entre a lista simples inicial e a
 * lista simples de processos.
 *
 * @param lista_incial Ponteiro para a lista simples inicial, origem dos dados.
 * @param lista_processos Ponteiro para a lista simples de processos, destino dos dados.
 *
 * @return Ponteiro para a lista simples de processos alterada.
 */
t_listaS_processos *transferir_dados(t_listaS_inicial *lista_inicial,t_listaS_processos *lista_processos)
 {
 int contador=0;
 while(lista_inicial)
  {
  lista_processos=inserir_listaS_processos(lista_processos,&lista_inicial->elemento,&contador);
  lista_inicial=lista_inicial->prox;
  contador++;
  }
 return lista_processos;
 }


/**
 * 	Função que elimina os espaços do início e do fim de uma string.
 *
 * @param string Ponteiro para o início da string a tratar.
 *
 * @return Ponteiro para a string resultante.
 */
char *eliminar_espacos(char *string)
 {
 int i=0;
 while((*string)==' ')
  string++;
 while(string[i++]!=' ');
 return (char *)strndup(string,(sizeof(char)*(i-1)));
 }

/**
 * 	Função responsável pela leitura do ficheiro de configuração dos processos.
 *
 * @param ficheiro Ponteiro para o ficheiro a ler.
 * @param lista Ponteiro para ponteiro. Lista onde serão intruduzidos os valores lidos
 *
 * @return A função nnão tem valores de retorno.
 */
void ler_process_file(FILE *ficheiro,t_listaS_inicial **lista)
 {
 t_ps_inicial proc_info;
 char buffer[256],proc_name[256];
 while(fscanf(ficheiro,"%[^\n]\n",buffer)!=EOF){
	if(sscanf(buffer,"%[^#]",buffer)>0)
		if(sscanf(buffer,"%s %d %d",proc_name,&proc_info.tempo_entrada,&proc_info.tempo_execucao)==3){
			proc_info.nome=(char *)malloc((strlen(proc_name)+1)*sizeof(char));
			strcpy(proc_info.nome,proc_name);
			*lista=inserir_ord_ls(*lista,&proc_info);
		}
 }/* fim do while */

 }/* fim de ler_process_file */

/**
 * 	Função responsável pela leitura do ficheiro de configuração do "escalonador".
 *
 * @param ficheiro Ponteiro para o ficheiro a ler.
 * @param info Ponteiro para ponteiro. Estrutura onde serão intruduzidos os valores lidos.
 *
 * @return A função nnão tem valores de retorno.
 */
void ler_schedule(FILE *ficheiro,t_schedule_info **info)
 {
 char param[256],valor[256],lixo[256];
 while((fscanf(ficheiro,"%[^\n]\n",lixo))!=EOF)
  {
  if(sscanf(lixo,"%[^#]",lixo)>0)
   if(sscanf(lixo,"%[^=]=%s",param,valor)>0)
    {
    strcpy(param,eliminar_espacos(param));
    if(!(strcmp(param,"quantum")))
     (*info)->quantum=atoi(valor);
    else
     if(!(strcmp(param,"time_slice")) && (*info)->time_slice==-1)
      (*info)->time_slice=atoi(valor);
     else
      if(!(strcmp(param,"process_file")))
       {
       (*info)->process_file=(char *)malloc(sizeof(char)*(strlen(valor)+1));
       strcpy((*info)->process_file,valor);
       }
      else
       if(!(strcmp(param,"log_file")))
       {
       (*info)->log_file=(char *)malloc(sizeof(char)*(strlen(valor)+1));
       strcpy((*info)->log_file,valor);
       }
    }
  }/* fim do ciclo WHILE */
  aprovar_schedule_info(*info);
 }

/**
 * 	Função que permite abrir ficheiros.
 *
 * @param ficheiro Ponteiro para ponteiro. Handler para o ficheiro a abrir.
 * @param caminho String que indica o caminho do ficheiro.
 * @param modo String que indica o modo de abertura do ficheiro.
 *
 * @return A função não tem valores de retorno
 */
void open_file(FILE **ficheiro,char *caminho,char *modo)
 {
 if(!((*ficheiro)=fopen(caminho,modo)))
  {
  printf("Erro de abertura do ficheiro \"%s\"\n",caminho);
  exit(1);
  }
 }

/**
 * Função responsavel pela passagem de argumentos para o "schedule"
 *
 * @param argc Ponteiro para a variável do tipo inteiro que contém o número de argumentos passados por parâmetro.
 * @param argv[] Vector de ponteiros para uma cadeia de caracteres. Possui os parâmetros passados.
 * @param conf_file Ponteiro para ponteiro. String que indica o nome do ficheiro que será usado por defaul caso não
 * tenha sido especificado nenhum outro como parâmetro.
 * @param time_slice Ponteiro para a variável do tipo inteiro que contém o valor do "time_slice".
 *
 * @return A função não tem valores de retorno
 */
void busca_argumentos(int *argc,char *argv[], char **conf_file, int *time_slice){
	struct gengetopt_args_info args_info;
if(cmdline_parser(*argc,argv,&args_info)){
	printf("\nERRO: cmdline_parser");
	return ;													
}
if(args_info.conf_given){
	*conf_file=(char *)malloc(strlen(args_info.conf_arg)*sizeof(char)+1);
	strcpy(*conf_file,args_info.conf_arg);					
}else{
	*conf_file=(char *)malloc(strlen(DEFAULT_CONFIG_FILE)*sizeof(char)+1);
	strcpy(*conf_file,DEFAULT_CONFIG_FILE);	
}
if(args_info.time_slice_given && args_info.time_slice_arg)
	*time_slice=args_info.time_slice_arg;
											
}
