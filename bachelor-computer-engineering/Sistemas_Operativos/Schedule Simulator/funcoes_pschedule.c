/**
* @file funcoes_pschedule.c
* @brief Funções referentes à execução paralela do programa "ps_schedule" com o programa "schedule".
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#include "funcoes_pschedule.h"

/**
*	Função que permite escrever no ecrã os dados da lista simples de processos. Função usada pelo programa "ps_schedule"
* para apresentar os resultados.
*
* @param lista Ponteiro para a lista a mostrar.
*
* @return A função não possui valores de retorno.
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
*	Função que permite limpar os dados do ecrã.
*	Função retirada do site http://www.cppfrance.com/code.aspx?ID=10611
*
* @return A função não possui valores de retorno.
*/
void clrscr(void)
 {
 printf("\033[2J");
 gotoxy(0,0);
 }

/**
*	Função que permite efectuar uma operação de up a um semáforo.
*
* @param semid Identificação do semáforo.
*
* @return A função não possui valores de retorno.
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
*	Função que permite efectuar uma operação de down a um semáforo.
*
* @param semid Identificação do semáforo.
*
* @return A função não possui valores de retorno.
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
