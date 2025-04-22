/**
* @file funcoes.h
* @brief Protótipos das funções gerais.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#ifndef funcoesH
#define funcoesH
#include <stdio.h>
#include "estruturas.h"
#include "opts.h"
#include "listas.h"

#ifndef DEFAULT_CONFIG_FILE
#define DEFAULT_CONFIG_FILE "./schedule.conf"
#endif

#ifndef DEFAULT_QUANTUM
#define DEFAULT_QUANTUM 500   /* Valor em milisegundos */
#endif

#ifndef CONVERTER_Us_ms
#define CONVERTER_Us_ms 1000
#endif

#ifndef DEFAULT_LOG_FILE
#define DEFAULT_LOG_FILE "./log.txt"
#endif

#ifndef DEFAULT_PROCESS_FILE
#define DEFAULT_PROCESS_FILE "./processos.conf"
#endif

#ifndef DEFAULT_TIME_SLICE
#define DEFAULT_TIME_SLICE 3
#endif

void open_file(FILE **ficheiro,char *caminho,char *modo);
void ler_schedule(FILE *ficheiro,t_schedule_info **info);
void ler_process_file(FILE *ficheiro,t_listaS_inicial **lista);
char *eliminar_espacos(char *string);
void busca_argumentos(int *,char *[],char **,int *);
t_listaS_processos *transferir_dados(t_listaS_inicial *lista_inicial,t_listaS_processos *lista_processos);
int n_processos_por_terminar(t_listaS_processos *lista,int numProcs);
t_listaS_processos *verifica_admissao(t_listaS_processos *lista,int *quanta_total);
t_listaS_processos *getproc_by_pid(t_listaS_processos *lista,int pid);
t_listaS_processos *getproc_by_id(t_listaS_processos *lista,int id);
void inicializar_schedule_info(t_schedule_info *info);
void aprovar_schedule_info(t_schedule_info *info);
void escrever_log_end(FILE **log_file,t_listaS_processos *listaP);
void escrever_log_body(FILE **log_file,int *quanta,t_listaS_processos *listaP);
void escrever_log_header(FILE **log_file,int *time_slice,t_listaS_processos *listaP);

#endif
