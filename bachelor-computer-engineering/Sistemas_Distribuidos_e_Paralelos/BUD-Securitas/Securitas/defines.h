/**
 * @file defines.h
 * 
 * Definicao das macros e 'alias' utilizados.
 *  
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#ifndef DEFINES_H_
#define DEFINES_H_
/* Definicao de macros de erro */
#define ERROR_VAL -1
#define ALL_GOES_WELL 0

/* Definciao de macros gerais */
#define MAX_LOGIN_LEN 26
#define MAX_PASS_LEN 26
#define MAX_SESSINON_ID sizeof(long int) * 4 + 2
#define MAX_MESSAGE_LEN 1024
#define TIMEOUT 60
#define HASHBASE 127
#define OK_STATUS 1
#define EXIT_STATUS 0
#define MAX_IP_LEN 15
#define MIN_IP_LEN 7
#define MAX_FOLDER_LIST_LEN 1024
#define MAX_LOGIN_LIST_LEN 512 

/* Definicao de macros para funcao que processa pedidos */
#define LISTENING 0
#define LOGIN 1
#define PASSWORD 2
#define AUTORIZACAO 3
#define LOGOUT 4
#define EXIT 5
#define HACK 6

/* Alias para estruturas utilizadas */
typedef struct timespec t_timespec;
typedef struct sigaction t_sigaction;
typedef struct gengetopt_args_info t_gen_args;

#endif /*DEFINES_H_*/
