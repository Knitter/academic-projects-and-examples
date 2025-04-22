/**
 * @file files.h
 * 
 * @date Novembro 2005
 * @author Sergio Miguel Neves Lopes, EI10635
 * @version 1.0
 */
#ifndef FILES_H_
#define FILES_H_

#define _GNU_SOURCE

#include "structures.h"
#include "defines.h"
#include "functions.h"
#include "structures.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashtables.h"
#include "debug.h"
#include "listas.h"

/***/
#include <netdb.h>

/*
 * Funcao que permite efecutar o parsing do ficheiro de contas
 */
int parse_contas(FILE *file, HASHTABLE_T *contas);

/*
 * Funcao que permite efecutar o parsing do ficheiro de maquinas 
 */
int parse_maquinas(FILE *file, HASHTABLE_T *maquinas);

#endif /*FILES_H_*/
