/**
* @file funcoes_pschedule.c
* @brief Fun��es referentes � execu��o paralela do programa "ps_schedule" com o programa "schedule".
*
* @author Fl�vio Tim�teo nr. 10580
* @author S�rgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#include "funcoes_pschedule.h"

/**
*	Fun��o que permite escrever no ecr� os dados da lista simples de processos. Fun��o usada pelo programa "ps_schedule"
* para apresentar os resultados.
*
* @param lista Ponteiro para a lista a mostrar.
*
* @return A fun��o n�o possui valores de retorno.
*/
void mostra_info(t_listaS_processos *lista){
  clrscr();
  printf("\n%7s%6s%15s%20s%20s\n","Nome","ID","Estado","Tempo ja usado","Tempo de resposta");
  while(lista && lista->elemento.estado!=Novo){
    printf("%7s%6d",lista->elemento.nome,lista->elemento.id);
    switch(lista->elemento.estado){
    case Pronto:printf("%15s","Pronto");
      break;
    case Execucao:printf("%15s","Execucao");
      break;
    default:printf("%15s","Terminacao");
    }
    printf("%20d%20d\n",lista->elemento.tempo_usado,lista->elemento.tempo_resposta);
    lista=lista->prox;
  }
}

/**
*	Fun��o que permite limpar os dados do ecr�.
*	Fun��o retirada do site http://www.cppfrance.com/code.aspx?ID=10611
*
* @return A fun��o n�o possui valores de retorno.
*/
void clrscr(void)
 {
 printf("\033[2J");
 gotoxy(0,0);
 }

/**
*	Fun��o que permite efectuar uma opera��o de up a um sem�foro.
*
* @param semid Identifica��o do sem�foro.
*
* @return A fun��o n�o possui valores de retorno.
*/
void up(int semid)
{
struct sembuf buf;
buf.sem_num = 0;
buf.sem_op = 1;
buf.sem_flg = SEM_UNDO;
if (semop(semid, &buf, 1) < 0)
 ERROR(-1, "UP");
}

/**
*	Fun��o que permite efectuar uma opera��o de down a um sem�foro.
*
* @param semid Identifica��o do sem�foro.
*
* @return A fun��o n�o possui valores de retorno.
*/
void down(int semid)
{
struct sembuf buf;
buf.sem_num = 0;
buf.sem_op = -1;
buf.sem_flg = SEM_UNDO;
if (semop(semid, &buf, 1) < 0)
 ERROR(-2, "DOWN");
}
