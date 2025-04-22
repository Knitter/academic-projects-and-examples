/**
* @file listas.h
* @brief Protótipos das funções que manipulam as listas.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/

#ifndef listasH
#define listasH
#include "estruturas.h"
#include <stdlib.h>
#include <string.h>

t_listaS_inicial *criar_no_ls(t_ps_inicial *elemento);
t_listaS_inicial *inserir_inicio_ls(t_listaS_inicial *lista,t_ps_inicial *elemento);
t_listaS_inicial *remover_inicio_ls(t_listaS_inicial *lista);
t_listaDC_prontos *criar_no_ldc(int *elemento);
t_listaDC_prontos *inserir_fim_ldc(t_listaDC_prontos *lista,int *elemento);
t_listaDC_prontos *inserir_inicio_ldc(t_listaDC_prontos *lista,int *elemento);
int remover_inicio_ldc(t_listaDC_prontos **lista);
t_listaS_inicial *inserir_ord_ls(t_listaS_inicial *lista,t_ps_inicial *elemento);
int comparar_ls(t_ps_inicial *elemento_1,t_ps_inicial *elemento_2);
int contar_nos_ls(t_listaS_inicial *lista);
t_listaS_inicial *libertar_ls(t_listaS_inicial *lista);
void mostra_listaS_inicial(t_listaS_inicial *lista);
void criar_no_lsP(t_ps_info *elem,t_ps_inicial *elemento);
t_listaS_processos *devolve_ult_valido(t_listaS_processos *lista);
t_listaS_processos *inserir_listaS_processos(t_listaS_processos *lista,t_ps_inicial *elemento,int *contador);
void mostra_listaS_processos(t_listaS_processos *lista);
t_listaS_processos *verificar_execucao(t_listaS_processos *lista);
t_listaDC_prontos *libertar_ldc(t_listaDC_prontos *lista);

#endif
