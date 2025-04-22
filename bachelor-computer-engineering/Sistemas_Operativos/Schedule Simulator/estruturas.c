/**
* @file estruturas.c
* @brief Funções que tratam directamente as estruturas.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date
* @version 1.0
*/
#include "estruturas.h"

/**
 * 	Função responsável pela escrita no ecrã dos valores da estrutura do tipo
 * 	t_ps_info.
 *
 * @param info Ponteiro para a estrutura a escrever.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_t_ps_info(t_ps_info *info)
 {
 printf("\nPS id: %d\nEstado: %d\nNome: %s\nTempo de entrada: %d",info->id,info->estado,info->nome,info->tempo_entrada);
 printf("\nTempo de servico: %d\nTempo usado: %d\nTempo de resposta: %d",info->tempo_servico,info->tempo_usado,info->tempo_resposta);
 printf("\nTempo de Turn Around: %d\npid: %d\n",info->tempo_turnaround,info->pID_proc);
 }

/**
 * 	Função responsável pela escrita no ecrã dos valores da estrutura do tipo
 * 	t_ps_inicial.
 *
 * @param info Ponteiro para a estrutura a escrever.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_t_ps_inicial(t_ps_inicial *info)
 {
 printf("\nNome Processo: %s\nTempo de entrada: %d\nTempo de Execucao: %d\n",info->nome,info->tempo_entrada,info->tempo_execucao);
 }

/**
 * 	Função responsável pela escrita no ecrã dos valores da estrutura do tipo
 * 	t_schedule_info.
 *
 * @param info Ponteiro para a estrutura a escrever.
 *
 * @return A função não tem valores de retorno.
 */
void escrever_t_schedule_info(t_schedule_info *info)
 {
 printf("Quantum: %d\nTime Slice: %d\n",info->quantum,info->time_slice);
 printf("Ficheiro de conf: %s\nFicheiro de log: %s\n",info->process_file,info->log_file);
 }
