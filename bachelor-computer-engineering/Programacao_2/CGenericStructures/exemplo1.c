/**
 * @file exemplo1.c
 * @brief Exemplo de utilizacao de listas genericas
 *
 * Exemplo que ilustra como utilizar a biblioteca de listas genericas. Este exemplo, recorre a uma lista
 * de strings construida dinamicamente a partir dos dados fornecidos pelo utilizador. 
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

#define FIM "fim"


/**
 * Funcao que pede uma frase ao utilizador e devolve um string alocada dinamicamente contendo a frase
 * introduzida.
 */
char* ler_frase(void);


/**
 * Funcao que escreve uma string e o respectivo tamanho.
 */
void escreve_string(void*);

/**
 * Funcao que compara duas strings de acordo com o numero de caracteres.
 */
int compara_tamanhos(void* s1, void* s2);


int main(int argc, char ** argv) {
	LISTA_GENERICA_T* lista;
	ITERADOR_T* it;
	char *frase, *aux;
	
	
	/* Constroi a lista. Como a lista vai ter elementos simples, a funcao para libertar a memoria e'
	   a funcao free
	*/
	lista = lista_criar(free);
	
	/* Preenche a lista com as frases introduzidas pelo utilizador */
	printf("Introduza as frases pretendidas. Introduza a palavra fim para terminar.\n");
	while (strcmp(frase = ler_frase(), FIM) != 0) {
		lista_inserir(lista, frase);
	}
	free(frase); /* A ultima frase nao foi inserida */
	
	/* Escreve o numero de elementos na lista */
	printf("Numero de elementos: %d\n", lista_numero_elementos(lista));
	
	/* Utiliza um iterador para percorrer a lista e imprimir as frases introduzidas */
	/* NOTA: enquanto o iterador não for destruido NAO SE DEVE remover nenhum elemento da lista */
	/* 1 - Cria o iterador */
	it = lista_criar_iterador(lista);

	/* 2 - Percorre o iterador */
	printf("Lista de frases:\n");
	while ((frase = (char*)iterador_proximo_elemento(it)) != NULL)
		printf("\t%s\n", frase);
		
	/* 3 - Destroi o iterador */
	iterador_destruir(&it);

	/* Pesquisa por frase */
	printf("Introduza a frase a remover.\n");
	aux = ler_frase();
	
	/* Efectua uma pesquisa utilizando a funcao strcmp para comparar */
	frase = lista_pesquisar(lista, aux, (COMPARAR_FUNC)strcmp);
	
	free(aux);
	
	if (frase != NULL) {
		printf("A frase foi encontrada\n");
		aux = lista_remover(lista, frase);
		/* esta verificao nao e' necessaria porque ja' se sabe q a frase existe */
		if (aux != NULL) {
			printf("Frase removida com sucesso\n");
			free(aux); /* liberta a memoria ocupada pelo elemento que foi removido */
		} else
			printf("Nao foi possivel remover a frase\n");		
	} else {
		printf("A frase não existe\n");
	}
	
	/* Exemplo da funcao aplicar_todos. Neste exemplo, vamos aplicar a todos os elementos a funcao escreve_string */
	lista_aplicar_todos(lista, escreve_string);
	
	/* Exemplo do iterador para uma lista ordenada. Neste exemplo, vamos ordenar a lista pelo seu tamanho */
	/* 1 - Cria o iterador passando a funcao compara_tamanhos */
	it = lista_criar_iterador_ordenado(lista, compara_tamanhos);

	/* 2 - Percorre o iterador */
	printf("Lista de frases ordenadas pelo tamanho:\n");
	while ((frase = (char*)iterador_proximo_elemento(it)) != NULL)
		printf("\t%s\n", frase);
		
	/* 3 - Destroi o iterador */
	iterador_destruir(&it);

	/* 
	  Antes de terminar deve-se libertar a lista. Caso se pretenda apenas remover 
	  os elementos da lista, deve-se chamar a funcao: remover_todos(lista);
	*/
	lista_destruir(&lista);
	
	assert(lista == NULL);
		
	return 0;
}



/**
 * Funcao que pede uma frase ao utilizador e devolve um string alocada dinamicamente contendo a frase
 * introduzida.
 */
char* ler_frase(void) {
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
 * Funcao que escreve uma string e o respectivo tamanho.
 */
void escreve_string(void* s) {
	char* str = (char*)s;
	printf("\t%s: %d caracteres\n", str, strlen(str));
}

/**
 * Funcao que compara duas strings de acordo com o numero de caracteres.
 */
int compara_tamanhos(void* s1, void* s2) {
	char* str1 = (char*)s1;
	char* str2 = (char*)s2;
	
	return strlen(str1)-strlen(str2);
}

