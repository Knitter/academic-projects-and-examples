/**
 * @file functions.h
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#ifndef FUNCTIONS_H_
#define FUNCTIONS_H_

#define _GNU_SOURCE

#include "cmdline.h"
#include "structures.h"

#include <netinet/in.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <time.h>
#include <errno.h>

#include "debug.h"
#include "defines.h"
#include "securitas.h"

#define INVALID_CHARS "^\\|\"?;,:"
#define VALID_CHAR '0'

typedef int (*PROCESSOR) (int, void*, char *);

/*
 * Funcao que permite validar um caminho para um ficheiro 
 */
int validate_path(char *path);

/*
 * Funcao que imprime no stdout e no stderr mensagens de erro e que termina a aplicacao
 */
void print_error_exit(char *user_mesg, char *error_mesg, int exit_code);

/*
 * Funcao que permite efectuar o parsing de argumentos passados a' aplicacao
 */
int parse_args(int argc, char *argv[], char **c_filr, char **m_file, int *porto, int *tempo);

/*
 * Funcao que permite abrir um socket
 */
int open_socket(uint16_t porto, PROCESSOR processa_pedido, void *args_processor, int *stoping_condition);

/*
 * Funcao que permite validar um IP no formato pontos e numeros
 */
int validate_ip(char *ip);

/*
 * Funcao que permite ler uma linha de um ficheiro identificado pelo descritor
 */
int readline (int fd, char *linha, int max);

/*
 * Funcao que permite efectuar uma escrita para um socket
 */
int write_to_socket(int fd, char *mesg, char *error_mesg);

/*
 * Funcao que permite eliminar sequencias de CRLF de fim de linhas de texto
 */
void trim_crlf(char *line);

#endif /*FUNCTIONS_H_*/
