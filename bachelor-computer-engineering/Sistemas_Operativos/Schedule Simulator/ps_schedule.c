/**
* @file ps_schedule.c
* @brief C�digo do programa "ps_schedule"
*
* @author Fl�vio Tim�teo nr. 10580
* @author S�rgio Lopes nr. 10635
*
* @date
* @version 1.0
*/
#include "funcoes_pschedule.h"
#include "ps_opts.h"

#define DEFAULT_FREQ 1 /* Valor em segundos */

t_listaS_processos *lista;
/* A vari�vel "flag" permite indicar ao programa "ps_schedule" se deve ou n�o terminar a sua execu��o. */
int flag=1,pid_schedule=0;

void busca_argumentos(int *argc,char *argv[],int *freq);

/**
 *	Fun��o respons�vel pelo tratamento de sinais.
 *
 * @param signum Identifica��o do sinal a tratar.
 */ 
void trata_sinal(int signum){
  if(signum==SIGALRM){}
    
  else if(signum==SIGUSR1){
    mostra_info(lista);
    kill(pid_schedule,SIGCONT);
    flag=0;
  }
}

int main(int argc,char *argv[])
 {
 int shmID_nProcs,semID,*nProcs,freq=DEFAULT_FREQ,shmID;
 key_t chaveSHM=ftok(".",'s'),chaveSHM_nProcs=ftok(".",'S'),chaveSEM=ftok(".",'e');
 struct itimerval newTimer,oldTimer;
 struct sigaction act,oldact;

busca_argumentos(&argc,argv,&freq);

 if((shmID_nProcs=shmget(chaveSHM_nProcs,3*sizeof(int),0700))<0)
 	 ERROR(-1,"erro na criacao da memoria partilhada");
 nProcs=(int *)shmat(shmID_nProcs,0,0);
 if((shmID=shmget(chaveSHM,(*nProcs)*sizeof(t_listaS_processos),0700))<0)
   ERROR(-3,"erro na criacao da memoria partilhada dos processos");
 lista=(t_listaS_processos *)shmat(shmID,0,0);
 if((semID=semget(chaveSEM,NUM_SEMS,0700))<0)
 	 ERROR(-2,"erro na criacao do semaforo");

 newTimer.it_interval.tv_usec=0;
 newTimer.it_interval.tv_sec=freq;
 newTimer.it_value.tv_usec=0;
 newTimer.it_value.tv_sec=freq;
 if (setitimer (ITIMER_REAL, &newTimer, &oldTimer) < 0){
  	ERROR(4,"ERRO:setitimer");
  	exit(4);	
  }
 
 act.sa_handler=trata_sinal;
 sigemptyset(&act.sa_mask);
 act.sa_flags=0;
 if(sigaction(SIGALRM,&act,&oldact)<0){
   ERROR(2,"ERRO:sigaction error");
   exit(2);
 }
 if(sigaction(SIGUSR1,&act,&oldact)<0){
   ERROR(2,"ERRO:sigaction error");
   exit(2);
 }
/* Coloca em memoria partilhada o seu pid para comunica�ao entre schedule e ps_schedule */ 
 *(nProcs+1)=getpid(); 
/* Recebe da mem�ria o pid de schedule pelo motivo anterior */
 pid_schedule=*(nProcs+2); 
 while(flag){
   pause();
   down(semID);
   /* Zona cr�tica */
   mostra_info(lista); 
   up(semID);
 }
 shmdt(nProcs);
 shmdt(lista);
 return 0;
 }


/**
 * Fun��o responsavel pela passagem de argumentos para o "schedule"
 *
 * @param argc Ponteiro para a vari�vel do tipo inteiro que cont�m o n�mero de argumentos passados por par�metro.
 * @param argv[] Vector de ponteiros para uma cadeia de caracteres. Possui os par�metros passados.
 * @param freq Ponteiro para a vari�vel do tipo inteiro que cont�m o valor de frequ�ncia de actualiza��o usada pelo 
 * programa "ps_schedule" para mostrar informa��o. 
 *
 * @return A fun��o n�o tem valores de retorno
 */
void busca_argumentos(int *argc,char *argv[],int *freq){
  struct gengetopt_args_info args_info;
  if(cmdline_parser(*argc,argv,&args_info)){
    printf("\nERRO: cmdline_parser");
    return ;
  }
  if(args_info.freq_given && args_info.freq_arg>0)
    *freq=args_info.freq_arg;
    }
