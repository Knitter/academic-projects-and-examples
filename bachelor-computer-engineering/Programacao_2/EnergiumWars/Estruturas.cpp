#pragma hdrstop
#include "Estruturas.h"
#pragma package(smart_init)

void mostrar_soldados(T_soldado *soldado)
 {
 printf("\nTipo: %s\nPreco: %d\nAtaque: %d\nDefesa: %d\n",soldado->nome,soldado->preco,soldado->ataque,soldado->defesa);
 }

void mostrar_planetas(T_planeta *planeta)
 {
 printf("\nNome: %s\nRentabilidade: %d\n",planeta->nome,planeta->rentabilidade);
 }

void ler_player(T_player *temp)
 {
 char aloc_aux[61];
 printf("Introduza o nome do Jogador: ");
 fflush(stdin);
 gets(aloc_aux);
 temp->nome=(char *)malloc((strlen(aloc_aux)+1)*sizeof(char));
 strcpy(temp->nome,aloc_aux);
 }
