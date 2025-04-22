/**
* @file funcoes_pschedule.h
* @brief Prot�tipos das fun��es declaradas no ficheiro "funcoes_pschedule.c".
*
* @author Fl�vio Tim�teo nr. 10580
* @author S�rgio Lopes nr. 10635
*
* @date
* @version 1.0
*/
#ifndef funcoes_pscheduleH
#define funcoes_pscheduleH

#include <stdio.h>
#include "debug.h"
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <sys/time.h>
#include <unistd.h>
#include <signal.h>
#include "listas.h"

#define NUM_SEMS 1
#define gotoxy( x, y) printf("\033[%d;%dH", y, x)

/**
 * @union semun
 * 
 * Usada no tratamento/opera��es de sem�foros.
 */
union semun{
  int val;
  struct semid_ds *buf;
  ushort *array;
};

void down(int semid);
void up(int semid);
void clrscr(void);
void mostra_info(t_listaS_processos *lista);

#endif
