/**
 * @file exemplo1.c
 * @brief Exemplo de utilizacao de listas genericas
 *
 * Exemplo que ilustra como utilizar a biblioteca de listas genericas. Este exemplo focara' o modo como sao
 * criadas listas de estruturas complexas (que contém a sua propria funcao para libertar a memoria);
 *
 * @Vitor Carreira
 * @date Abril 2004
 * @version 1
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

/* Incluir a definicao das funcoes para listas genericas */
#include "listas.h"

/* Estrutura utilizada no exemplo */
typedef struct aluno {
	char* nome; /* o nome e' alocado dinamicamente */
	int numero;
} ALUNO_T;


#define FIM "fim"


/**
 * Funcao que pede os dados de um aluno ao utilizador
 */
ALUNO_T* ler_aluno(void);

/**
 * Funcao que lê uma string e devolve uma string alocada dinamicamente identica à string lida
 */
char* ler_string(void);


/**
 * Funcao que escreve os dados de um aluno.
 */
void escrever_aluno(ALUNO_T*);

/**
 * Funcao que compara os alunos pelo seu numero
 */
int comparar_por_numero(ALUNO_T*, ALUNO_T*);

/**
 * Funcao que compara os alunos pelo seu nome
 */
int comparar_por_nome(ALUNO_T*, ALUNO_T*);


/**
 * Funcao que liberta a memória ocupada por um aluno
 */
void free_aluno(ALUNO_T*);


int main(int argc, char ** argv) {
	LISTA_GENERICA_T* lista;
	ITERADOR_T* it;
	ALUNO_T *aluno, *result;
	ALUNO_T chave_pesquisa;
	
	
	/* Constroi a lista. Neste caso, e' necessario utilizar uma funcao definida pelo 
	   utilizador para libertar a memória alocada para o elemento 
	*/
	lista = lista_criar((LIBERTAR_FUNC)free_aluno);
	
	/* Preenche a lista com os dados introduzidos pelo utilizador */
	printf("Introduza os alunos pretendidos. Introduza um aluno com um numero <= 0 para terminar.\n");
	while ((aluno = ler_aluno())->numero > 0) {
		lista_inserir(lista, aluno);
	}
	free_aluno(aluno); /* o ultimo aluno nao foi inserido */
	
	/* Escreve o numero de elementos na lista */
	printf("Numero de elementos: %d\n", lista_numero_elementos(lista));
	
	/* Pesquisa por numero */
	printf("Introduza o numero do aluno a pesquisar:\n> ");
	fflush(stdout);
	scanf("%d%*c", &chave_pesquisa.numero);
	
	/* Efectua uma pesquisa utilizando a funcao comparar_por_numero */
	result = lista_pesquisar(lista, &chave_pesquisa, (COMPARAR_FUNC)comparar_por_numero);
	
	if (result != NULL) {
		escrever_aluno(result);
	} else {
		printf("Não existe nenhum aluno com o número fornecido\n");
	}


	/* Pesquisa por nome */
	printf("Introduza o nome do aluno a pesquisar:\n");
	chave_pesquisa.nome = ler_string();
	
	/* Efectua uma pesquisa utilizando a funcao comparar_por_nome  */
	result = lista_pesquisar(lista, &chave_pesquisa, (COMPARAR_FUNC)comparar_por_nome);
	
	free(chave_pesquisa.nome); 
	
	if (result != NULL) {
		escrever_aluno(result);
	} else {
		printf("Não existe nenhum aluno com o nome fornecido\n");
	}


	/* 
	Exemplo do iterador para uma lista ordenada pelo numero 
	NOTA: Enquanto se utiliza um iterador, não se devem remover os elementos de uma lista
	*/
	it = lista_criar_iterador_ordenado(lista, (COMPARAR_FUNC)comparar_por_numero);
	printf("Lista de alunos ordenados pelo numero:\n");
	while ((aluno = (ALUNO_T*)iterador_proximo_elemento(it)) != NULL)
		escrever_aluno(aluno);
	iterador_destruir(&it);

	
	/* Remove todos os elementos da lista, libertando a memoria ocupada por estes. 
	   A partir deste ponto a lista pode ser reutilizada para armazenar novos elementos
	 */	 
	 lista_remover_todos(lista);
	
	
	
	/* Antes de terminar deve-se libertar a lista */
	lista_destruir(&lista);
	
	assert(lista == NULL);
		
	return 0;
}


/**
 * Funcao que pede os dados de um aluno ao utilizador
 */
ALUNO_T* ler_aluno(void) {
	ALUNO_T* a = (ALUNO_T*)malloc(sizeof(ALUNO_T));
	printf("Introduz os dados de um aluno:\nNome ");
	a->nome = ler_string();
	printf("Numero > ");
	fflush(stdout);
	scanf("%d%*c", &a->numero);
	
	return a;
}

/**
 * Funcao que lê uma string e devolve uma string alocada dinamicamente identica à string lida
 */
char* ler_string(void) {
	char buffer[255];
	char* aux;

	printf("> ");
	fflush(stdout);
	
	scanf("%[^\n]%*c", buffer);		

	aux = (char*)malloc(strlen(buffer) + 1);
	strcpy(aux, buffer);
	
	return aux;
	
}


/**
 * Funcao que escreve os dados de um aluno.
 */
void escrever_aluno(ALUNO_T* a) {
	printf("\tNome:  %s\n\tNumero:%d\n", a->nome, a->numero);
}

/**
 * Funcao que compara os alunos pelo seu numero
 */
int comparar_por_numero(ALUNO_T* a1, ALUNO_T* a2) {
	return a1->numero - a2->numero;
}

/**
 * Funcao que compara os alunos pelo seu nome
 */
int comparar_por_nome(ALUNO_T* a1, ALUNO_T* a2) {
	return strcmp(a1->nome, a2->nome);
}


/**
 * Funcao que liberta a memória ocupada por um aluno
 */
void free_aluno(ALUNO_T* a) {
	/* liberta a memoria ocupada pelo nome */
	free(a->nome);
	/* liberat a memoria ocupada pelo aluno */
	free(a);
}
