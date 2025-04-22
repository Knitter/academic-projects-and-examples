/**
 * @file securitas.h
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#ifndef SECURITAS_H_
#define SECURITAS_H_

#include "structures.h"
#include "files.h"
#include "functions.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <signal.h>
#include <sys/time.h>
#include "hashtables.h"
#include "defines.h"

/*
 * A funcao permite remover alguns dos recursos abertos para a criacao do socket de comunicacao
 */
void destroy_final_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **contas, HASHTABLE_T **maquinas, HASHTABLE_T **sessions, t_args_processor *args_processor, t_args_monitor *args_thread);

/*
 * A funcao permite remover alguns dos recursos abertos para a criacao do socket de comunicacao
 */
void destroy_3_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **sessions);

/*
 * A funcao permite remover todos os recursos abertos para a criacao do socket
 */
void destroy_5_resources(pthread_cond_t *condicao, pthread_mutex_t *mutex, HASHTABLE_T **contas, HASHTABLE_T **maquinas, HASHTABLE_T **sessions);

/*
 * Forma como os pedidos dos clientes irao ser processados
 */
int proc_pedido(int fd, void *args, char *ip_cliente);

/*
 * Funcao a executar pela thread de monitorizacao
 */
void *monitor_thread(void *args);

/*
 * Funcao que permite tratar os sinais recebidos pelo servidor
 */
void signal_handling(int sig);

#endif /*SECURITAS_H_*/
