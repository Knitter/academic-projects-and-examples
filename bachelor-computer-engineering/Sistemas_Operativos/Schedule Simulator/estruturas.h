/**
* @file estruturas.h
* @brief Definição das estruturas a usar e declaração dos protótipos das suas funções.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#ifndef estruturasH
#define estruturasH
#include <stdio.h>
#include "debug.h"
#define MAXNOME 2
#define ID_INICIO 100

/**
 *@enum t_state
 *
 * Enumeracao que define o estado dos processos desde a sua criação até ao seu fim.
 * Estado "Novo" corresponde ao valor 1 apenas por uma questão lógica.
 */
typedef enum {Novo=1,Pronto,Execucao,Terminacao}t_state;

/**
 * @struct t_ps_inicial
 *
 * 	Estrutura que guarda os valores correspondentes aos processos que forma lidos do
 * ficheiro de configurações.
 */
typedef struct
 {
 char *nome;
 int tempo_entrada;
 int tempo_execucao;
 }t_ps_inicial;

/**
 * @struct t_ps_info
 *
 * 	Estrutura que guarda todos valores correspondentes aos processos durante a execução do
 * escalonador.
 */
typedef struct
 {
 int id;
 int pID_proc;
 int tempo_entrada;
 t_state estado;
 int ja_executou;
 char nome[MAXNOME];
 int tempo_servico;
 int tempo_usado;
 int tempo_resposta;
 int tempo_turnaround;
 }t_ps_info;

/**
 * @struct t_schedule_info
 *
 * 	Estrutura que guarda as informações de configuração, que serão usadas pelo "escalonador"
 * durante a sua execução.
 */
typedef struct
 {
 int quantum;
 int time_slice;
 char *process_file;
 char *log_file;
 }t_schedule_info;

/**
 * @struct t_listaS_inicial
 *
 * 	Estrutura que define um nó da lista simples de processos.
 * 	A lista permite guardar os valores iniciais dos processos e preparar a criação da
 * memóia partilhada, para onde serão depois movidos os dados.
 * 	A lista é apenas temporária e visível só pelo "escalonador".
 */
typedef struct no_listaS_inicial
 {
 t_ps_inicial elemento;
 struct no_listaS_inicial *prox;
 }t_listaS_inicial;

/**
 * @struct t_listaS_processos
 *
 * 	Estrutura que define um nó da lista simples de processos.
 * 	Lista comum a todos oa "escalonador" e aos processos e que permite guardar e manter
 * actualizados todos os dados correspondentes a estes.
 * 	A lista será mantida em memória partilhada e permitirá o acesso a todos os processos,
 * ao "escalonador" e ao programa monitorizador.
 */
typedef struct no_listaS_processos
 {
 t_ps_info elemento;
 struct no_listaS_processos *prox;
 }t_listaS_processos;

/**
 * @struct t_listaDC_prontos
 *
 * 	Estrutura que define um nó da lista dupla e circular de processos que estão no
 * estado pronto.
 * 	A lista é usada apenas pelo "escalonador" e pretende manter para este um registo dos
 * processos que se encontram disponiveis para escalonar.
 */
typedef struct no_listaDC_prontos
 {
 int id;
 struct no_listaDC_prontos *prox;
 struct no_listaDC_prontos *ant;
 }t_listaDC_prontos;

/**
 * @brief Protótipos das funções que tratam as estruturas.
 */
void escrever_t_schedule_info(t_schedule_info *info);
void escrever_t_ps_inicial(t_ps_inicial *info);
void escrever_t_ps_info(t_ps_info *info);

#endif
