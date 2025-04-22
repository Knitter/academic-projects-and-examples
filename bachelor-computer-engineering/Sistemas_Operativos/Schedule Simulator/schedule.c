/**
* @file schedule.c
* @brief Código do programa "schedule".
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date
* @version 1.0
*/
#include "funcoes.h"
#include "funcoes_pschedule.h"

void ini_tratamento_sinais(struct sigaction *act, struct sigaction*oldact,int *sinais,void(*trataSinal)(int));

/* Declaração das variáveis globais */
t_schedule_info *schedule_info=NULL;
t_listaS_processos *lista_processos=NULL;
t_listaDC_prontos *lista_prontos=NULL;
int semID;

/* Função para tratar os sinais recebidos pelo processo pai, "schedule" */
void trataSinal_schedule(int sigNum){
	t_listaS_processos *aux1=lista_processos;
	switch(sigNum){
		case SIGALRM: 
			 while(aux1 && aux1->elemento.pID_proc){
			 	if(aux1->elemento.estado==Terminacao){
			 		DEBUG("id: %d TERMINATED",aux1->elemento.id);
			 		aux1=aux1->prox;
			 		continue;
			 	}
			 	DEBUG("SIGUSR1 (passagem de quanta) para id: %d",aux1->elemento.id);
			 	if(kill(aux1->elemento.pID_proc,SIGUSR1)<0)
				  return ;
			 	pause();
			 	if(aux1->elemento.estado==Execucao && aux1->elemento.tempo_usado && !(aux1->elemento.tempo_usado%schedule_info->time_slice)){
			 		DEBUG("id:%d , MOD: %d",aux1->elemento.id,aux1->elemento.tempo_usado%schedule_info->time_slice);
			 		DEBUG("SIGUSR2 para processo em execucao, PAI:%d ,aux->elemento.pID_proc: %d\nEstado: %d",getpid(),aux1->elemento.pID_proc,aux1->elemento.estado);
			 		kill(aux1->elemento.pID_proc,SIGUSR2);
			 		lista_prontos=inserir_fim_ldc(lista_prontos,&aux1->elemento.id);	
			 		pause();
			 	}
			 	aux1=aux1->prox;
			 }
			 DEBUG("FINAL DE ITERACAO DO SIGALRM");
			 break;
		/* Processo terminou, schedule faz novo escalonamento */
		case SIGUSR1:   DEBUG("Novo escalonamento");
				if((aux1=getproc_by_id(lista_processos,remover_inicio_ldc(&lista_prontos)))){
					DEBUG("Dar despacho");
					down(semID);
					/* Zona crítica */
					aux1->elemento.estado=Execucao;/* DA DESPACHO */
					up(semID);
					if(!(aux1->elemento.ja_executou))
						{
						DEBUG("Incremento de ja executou");
						aux1->elemento.ja_executou=1;
						}
			       }
			       break;
	 	case SIGCONT:DEBUG("PAI: SIGCONT recebido (fazer nada)");
	 		    break;
	 	case SIGCHLD:DEBUG("PAI: SIGCHLD recebido (fazer nada)");
	 		    break;
		default:
			DEBUG("Sinal desconhecido, funcao trataSinal_schedule");
	}
}

/* Função para tratar os sinais recebidos pelos processos filhos */
void trataSinal_processos(int signum){
	t_listaS_processos *aux=NULL;
	switch(signum){
		//sinal de notificao do escalonador de passagem do quanta
		case SIGUSR1: 	DEBUG("Recebeu sinal de passagem de quanta");//praticamente todo o case,SC
				if((aux=getproc_by_pid(lista_processos,getpid()))){//buscar o no/processo a ser actualizado
					down(semID);
					/* Zona crítica */
					aux->elemento.tempo_turnaround++;
					up(semID);
					if(!(aux->elemento.ja_executou)){
					  down(semID);
					  /* Zona crítica */
					  aux->elemento.tempo_resposta++;					
					  up(semID);
					}				
					if(aux->elemento.estado==Execucao)
					  if((++aux->elemento.tempo_usado)==aux->elemento.tempo_servico){
					    down(semID);
						/* Zona crítica */
					    aux->elemento.estado=Terminacao;
					    up(semID);
					    DEBUG("Estado: %d",aux->elemento.estado);
					    DEBUG("Vai morrer e envia sinal SIGCONT ao pai");
					    kill(getpid(),SIGKILL);//morte do processo
					}
			  DEBUG("TurnAround: %d Tempo Resposta: %d",aux->elemento.tempo_turnaround,aux->elemento.tempo_resposta);	
			  DEBUG("\nEstado: %d\nTempo usado: %d\nTempo de servico: %d",aux->elemento.estado,aux->elemento.tempo_usado,aux->elemento.tempo_servico);
			  }
			  DEBUG("(SIGUSR1)id:%d envia SIGCONT a pai",aux->elemento.id);
			  kill(getppid(),SIGCONT);
			  
			  break;
		/* Tempo de processamento esgotado */
		case SIGUSR2: DEBUG("SIGUSR2 (processamento esgotado)");
				/* Buscar o nó/processo a ser actualizado */
				if((aux=getproc_by_pid(lista_processos,getpid()))){
			 	DEBUG("Entrou no if de SIGUSR2");
				down(semID);
				/* Zona crítica */
			 	aux->elemento.estado=Pronto;
				up(semID);
			     }
			     DEBUG("(SIGUSR2)id:%d envia SIGCONT a pai",aux->elemento.id);
			     kill(getppid(),SIGCONT);
			 break;
		default: 
			DEBUG("Sinal desconhecido, funcao trataSinal_processos");
	}	
}

int main(int argc,char *argv[])
 {
 /* Declaração de variáveis*/
 struct sigaction act,oldact;
 /* 0 indica final de vector de sinais */
 int sinais_schedule[]={SIGALRM,SIGUSR1,SIGCONT,SIGCHLD,0};
 int sinais_processos[]={SIGUSR1,SIGUSR2,0},quanta_total=0;
 union semun semopts;
 struct itimerval newTimer,oldTimer;
 FILE *ficheiro;
 char *config_file;
 key_t chaveSHM,chaveSHM_nProcs,chaveSEM;
 int shmID,shmID_nProcs,*nProcs=NULL,proc_ID=ID_INICIO,schedule_ID=ID_INICIO;
 t_listaS_inicial *lista_inicial=NULL;
 t_listaS_processos *aux=NULL;
 /* memory allocation */
 schedule_info=(t_schedule_info *)malloc(sizeof(t_schedule_info));
 inicializar_schedule_info(schedule_info);
 /* utilização de gengetopt */
 busca_argumentos(&argc,argv,&config_file,&schedule_info->time_slice);
 /* ler ficheiros de configurações */
 open_file(&ficheiro,config_file,"r");
 ler_schedule(ficheiro,&schedule_info);
 fclose(ficheiro);
 open_file(&ficheiro,schedule_info->process_file,"r");
 ler_process_file(ficheiro,&lista_inicial);
 fclose(ficheiro);
 if(!lista_inicial){
 	ERROR(0,"ERRO:Nao existem processos no ficheiro");
	exit(2);
 }
 /* criacao de memoria partilhada */
 chaveSHM=ftok(".",'s');
 /* para partilhar com "ps_schedule" */
 chaveSHM_nProcs=ftok(".",'S');
 chaveSEM=ftok(".",'e');
 if((semID=semget(chaveSEM,NUM_SEMS,0700|IPC_CREAT|IPC_EXCL))==-1){
   ERROR(-3,"\nERRO: criacao do semaforo");
   exit(3);
 }
 semopts.val=1;
 if((semctl(semID,0,SETVAL,semopts))==-1){
   ERROR(-4,"\nERRO: inicializacao do valor do semaforo");
   exit(4);
 }
 if((shmID_nProcs=shmget(chaveSHM_nProcs,3*sizeof(int),0700|IPC_CREAT|IPC_EXCL))==-1){
   ERROR(2,"\nERRO: criacao da memoria partilhada dos n processos");
   exit(2);
 }
 nProcs=(int *)shmat(shmID_nProcs,0,0);
 *nProcs=contar_nos_ls(lista_inicial);
  /* pid de psschedule*/
 *(nProcs+1)=0;
 *(nProcs+2)=getpid();
 if((shmID=shmget(chaveSHM,sizeof(t_listaS_processos)*(*nProcs),0700|IPC_CREAT|IPC_EXCL))==-1){
	ERROR(1,"\nERRO: criacao da memoria partilhada");
	exit(1);
 }
 lista_processos=(t_listaS_processos *) shmat(shmID,0,0);

 lista_processos=transferir_dados(lista_inicial,lista_processos);
 /* libertação de recursos ocupados pela lista inicial */
 lista_inicial=libertar_ls(lista_inicial);
 /* associa uma rotina de tratamento aos sinais que se pretendem tratar */
 ini_tratamento_sinais(&act,&oldact,sinais_schedule,trataSinal_schedule);
 /* inicializacao do temporizador */
  newTimer.it_interval.tv_usec = ((long int)schedule_info->quantum) * CONVERTER_Us_ms;//(milisegundos)
  newTimer.it_interval.tv_sec = 0;
  newTimer.it_value.tv_usec = ((long int)schedule_info->quantum) * CONVERTER_Us_ms;//(milisegundos)
  newTimer.it_value.tv_sec = 0;
  if (setitimer (ITIMER_REAL, &newTimer, &oldTimer) < 0){
  	ERROR(4,"ERRO:setitimer");
  	exit(4);	
  }

  /* escrever log_file header */
  open_file(&ficheiro,schedule_info->log_file,"w");
  escrever_log_header(&ficheiro,&schedule_info->time_slice,lista_processos);
  fclose(ficheiro);
  
  while(n_processos_por_terminar(lista_processos,*nProcs)){
  	while(schedule_ID && (aux=verifica_admissao(lista_processos,&quanta_total))){//se nao for null, processo a ser admitido
  		down(semID);
		aux->elemento.id=++proc_ID;
  		aux->elemento.estado=Pronto;//admissao
		up(semID);
  		switch(fork()){
  			case 0: DEBUG("Filho criado %d",proc_ID);
  				down(semID);
				aux->elemento.pID_proc=getpid();
				up(semID);
  				schedule_ID=0;
  				ini_tratamento_sinais(&act,&oldact,sinais_processos,trataSinal_processos); 
 				break;
  			case -1:DEBUG("ERRO: erro na admissao/criacao do processo filho");
  				exit(5);	
  			default:DEBUG("processo criado  quanta:%d",quanta_total);
  				lista_prontos=inserir_fim_ldc(lista_prontos,&proc_ID);
  		}	
  	}/* Fim do ciclo "while" de admissão */
  	
   	if(schedule_ID){
   		if(!(verificar_execucao(lista_processos))){
   			DEBUG("Pai manda escalonar");
   			kill(getpid(),SIGUSR1);
   		}
		open_file(&ficheiro,schedule_info->log_file,"a");
		escrever_log_body(&ficheiro,&quanta_total,lista_processos);
		fclose(ficheiro);
		DEBUG("Pai em espera");
   		DEBUG("Quanta incrementado");
  		quanta_total++;
  		DEBUG("quanta: %d",quanta_total);
  		pause();
  	}
  	else{
  	 	DEBUG("Filho id:%d em espera",proc_ID);
  		pause();
  	}
  }
  open_file(&ficheiro,schedule_info->log_file,"a");
  escrever_log_end(&ficheiro,lista_processos);
  fclose(ficheiro);
  newTimer.it_interval.tv_usec=0;
  newTimer.it_value.tv_usec=0;
  setitimer (ITIMER_REAL, &newTimer, &oldTimer);
  DEBUG("pid de psschedule : %d",*(nProcs+1));
  if(*(nProcs+1)){
    DEBUG("KILL enviado a psschedule : %d",*(nProcs+1));
    kill(*(nProcs+1),SIGUSR1);
    pause();
  }
 /* libertacao de recursos */
 lista_prontos=libertar_ldc(lista_prontos);
 semctl(semID,0,IPC_RMID,(union semun)0);
 shmdt(lista_processos);
 shmdt(nProcs);
 shmctl(shmID,IPC_RMID,0);
 shmctl(shmID_nProcs,IPC_RMID,0);
 free(schedule_info->log_file);
 free(schedule_info->process_file);
 free(schedule_info);
 DEBUG("Processo a sair %d",getpid());
 return 0;
 }
 
 /**
 *	Função que tem por objectivo a inicialização das informações referentes aos sinais.
 *
 * @param act Ponteiro que indica a estrutura onde serão guardadas as informações para o tratamento dos sinais.
 * @param oldact Ponteiro que permite restituir as informações para o tratamento do sinal ao seu estado anterior.
 * @param sinais Vector de sinais.
 * @param trataSinal Ponteiro para a função que irá tratar os sinais.
 *
 * @return A função não possui valores de retorno.
 */
 void ini_tratamento_sinais(struct sigaction *act, struct sigaction *oldact,int *sinais,void (*trataSinal)(int)){
 	act->sa_handler=trataSinal;
 	sigemptyset(&act->sa_mask);
 	act->sa_flags=0;
 	for(;*sinais!=0;sinais++){
 		if(sigaction(*sinais,act,oldact)<0){
 			ERROR(2,"ERRO:sigaction error");
 			return;
 		}
 	}
 }
 