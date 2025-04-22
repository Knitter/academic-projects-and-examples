/**
 * @file exemplo1.c
 * @brief Exemplo de utilizacao de hashtables
 *
 * Exemplo que ilustra como utilizar a biblioteca de hashtables. 
 *
 * @Vitor Carreira
 * @date Abril 2004
 * @version 1
 */
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

/* Incluir a definicao das funcoes para listas genericas e para hashtables */
#include "listas.h"
#include "hashtables.h"

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
 * Funcao que liberta a memória ocupada por um aluno
 */
void free_aluno(ALUNO_T*);


int main(int argc, char ** argv) {
	HASHTABLE_T* tabela;
	LISTA_GENERICA_T* lista_aux;
	ITERADOR_T* it;
	ALUNO_T *aluno, *result;
	char chave[200];
	char *str;
	
	
	/* Constroi a tabela. A tabela vai indexar alunos pelo seu nome.
	   A funcao para libertar os elementos sera' a funcao definida pelo
	   utilizador (ver exemplo 2)	   	 
	*/
	tabela = tabela_criar(101, (LIBERTAR_FUNC)free_aluno);
	
	/* 
	 Preenche a tabela com os dados introduzidos pelo utilizador,
	 indexando os alunos pelo seu nome 
	*/
	printf("Introduza os alunos pretendidos. Introduza um aluno com um numero <= 0 para terminar.\n");
	while ((aluno = ler_aluno())->numero > 0) {
		tabela_inserir(tabela, aluno->nome, aluno);
	}
	free_aluno(aluno); /* o ultimo aluno nao foi inserido */
	
	/* Escreve o numero de elementos da tabela */
	printf("Numero de elementos: %d\n", tabela_numero_elementos(tabela));
	
	/* Consulta pelo nome */
	printf("Introduza o nome do aluno a pesquisar:\n> ");
	fflush(stdout);
	scanf("%s%*c", chave);
	result = (ALUNO_T*)tabela_consultar(tabela, chave);
	
	if (result != NULL) {
		escrever_aluno(result);				
	} else {
		printf("Não existe nenhum aluno com o nome fornecido\n");
	}

	/* Remove um aluno pelo nome */
	printf("Introduza o nome do aluno a remover:\n> ");
	fflush(stdout);
	scanf("%s%*c", chave);
	
	result = (ALUNO_T*)tabela_consultar(tabela, chave);
	
	if (result != NULL) {
		result = (ALUNO_T*)tabela_remover(tabela, chave);
		printf("O seguinte aluno foi removido com sucesso\n");
		escrever_aluno(result);				
		free_aluno(result);
	} else {
		printf("Não existe nenhum aluno com o nome fornecido\n");
	}

	/* Exemplo de como obter a lista de chaves */
	lista_aux = tabela_criar_lista_chaves(tabela);
	it = lista_criar_iterador(lista_aux);
	printf("Lista de chaves:\n");
	while ((str = (char*)iterador_proximo_elemento(it)) != NULL)
		printf("\t%s\n", str);
	iterador_destruir(&it);
	lista_destruir(&lista_aux);


	/* Exemplo de como obter a lista de elementos */
	lista_aux = tabela_criar_lista_elementos(tabela);
	it = lista_criar_iterador(lista_aux);
	printf("Lista de elementos:\n");
	while ((aluno = (ALUNO_T*)iterador_proximo_elemento(it)) != NULL)
		escrever_aluno(aluno);
	iterador_destruir(&it);
	lista_destruir(&lista_aux);

	
	/* Remove todos os elementos da tabela, libertando a memoria ocupada por estes. 
	   A partir deste ponto a tabela pode ser reutilizada para armazenar novos elementos
	 */	 
	 tabela_remover_todos(tabela);
	
	
	
	/* Antes de terminar deve-se libertar a tabela */
	tabela_destruir(&tabela);
	
	assert(tabela == NULL);
		
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
 * Funcao que liberta a memória ocupada por um aluno
 */
void free_aluno(ALUNO_T* a) {
	/* liberta a memoria ocupada pelo nome */
	free(a->nome);
	/* liberat a memoria ocupada pelo aluno */
	free(a);
}

