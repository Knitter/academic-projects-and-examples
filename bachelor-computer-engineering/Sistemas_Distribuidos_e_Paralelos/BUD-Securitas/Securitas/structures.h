/**
 * @file structures.h
 * 
 * Definicao das estruturas de dados utilizadas.
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#ifndef STRUCTURES_H_
#define STRUCTURES_H_

#include "defines.h"
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <pthread.h>
#include "hashtables.h"
#include "debug.h"

typedef struct
  {
  char *login;
  char *password;
  }t_conta;
  
typedef struct
  {
  char *ip;
  HASHTABLE_T *logins;
  LISTA_GENERICA_T *pastas;
  }t_maquina;

typedef struct
  {
  char sessionid[MAX_SESSINON_ID];
  char *login;
  time_t working_time;
  }t_session;

typedef struct
  {
  HASHTABLE_T *sessions;
  int session_len;
  pthread_mutex_t *mutex;
  pthread_cond_t *cond;
  }t_args_monitor;
  
typedef struct
  {
  HASHTABLE_T *hash_sessions, *hash_contas, *hash_maquinas;
  int session_len;
  pthread_mutex_t *mutex;
  }t_args_processor;
 
/*
 * Funcao que permite libertar a memoria ocupada pela estrutura 't_conta'
 */
void free_conta(t_conta *conta);

/*
 * A funcao permite criar e alocar espaco para a estrutura 't_conta'
 */
t_conta *create_conta(char *login, char *password);

/*
 * Funcao que permite libertar memoria ocupada pela estrutura 't_maquina'
 */
void free_maquina(t_maquina *maq);

/*
 * A funcao permite criar e alocar espaco para a estrutura 't_maquina'
 */
t_maquina *create_maquina(char *ip, HASHTABLE_T *logins, LISTA_GENERICA_T *pastas);

/*
 * Funcao que permite libertar memoria ocupada pela estrutura 't_session'
 */
void free_session(t_session *session);

/*
 * A funcao permite criar e alocar espaco para a estrutura 't_session'
 */
t_session *create_session(char *login);

/*
 * Funcao que permite libertar memoria ocupada pela estrutura 't_args_processor'
 */
void free_args_processor(t_args_processor *args);

/*
 * A funcao permite criar e alocar espaco para a estrutura 't_args_processor'
 */
t_args_processor *create_args_processor(HASHTABLE_T *sessions, HASHTABLE_T *contas, HASHTABLE_T *maquinas, int tempo, pthread_mutex_t *mutex);

/*
 * Funcao que permite libertar memoria ocupada pela estrutura 't_args_monitor'
 */
void free_args_monitor(t_args_monitor *args);

/*
 * A funcao permite criar e alocar espaco para a estrutura 't_args_monitor'
 */
t_args_monitor *create_args_monitor(HASHTABLE_T *sessions, int tempo, pthread_mutex_t *mutex, pthread_cond_t *cond);

#endif /*STRUCTURES_H_*/
