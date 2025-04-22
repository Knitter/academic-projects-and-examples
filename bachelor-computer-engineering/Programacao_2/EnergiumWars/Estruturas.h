#ifndef EstruturasH
#define EstruturasH

#include "Definicoes.h"
/** @brief Estrutura que armazena as informações do tipo de unidades militares */
typedef struct
 {
 /** Nome do tipo de unidade militar */
 char *nome;
 /** Preco do tipo de unidade militar */
 int preco;
 /** Forca de ataque */
 int ataque;
 /** Forca de defesa */
 int defesa;
 }T_soldado;

/** @brief Estrutura que guarda as unidades militares */
typedef struct
 {
 /** Ponteiro para o tipo de unidade militar */
 T_soldado *p_unit;
 /** Quantiddes de tipos de unidades militares */
 int quantidade;
 }T_batalhao;

/** @brief Estrutura que define um nó da lista dupla e circular de unidades militares */
typedef struct T_noDC_batalhoes
 {
 /***/
 struct T_noDC_batalhoes *ant;
 /***/
 struct T_noDC_batalhoes *prox;
 /***/
 T_batalhao batalhao;
 }T_noDC_batalhoes;

/** @brief Estrutura que guarda as informações referentes aos planetas */
typedef struct
 {
 /***/
 char *nome;
 /***/
 int rentabilidade;
 /***/
 T_noDC_batalhoes *lista_top;
 /***/
 struct T_player *p_owner;
 }T_planeta;

/** @brief Estruturas que define um nó de um lista simples de planetas */
typedef struct T_noS_planetas
 {
 /***/
 struct T_noS_planetas *prox;
 /***/
 T_planeta planeta;
 }T_noS_planetas;

/** @brief Estrutura que guarda as informações referentes aos jogadores */
typedef struct T_player
 {
 /***/
 char *nome;
 /***/
 int saldo;
 /***/
 int num_mov;
 /***/
 T_noS_planetas *lista_top;
 }T_player;

/** @brief Estrutura que define um nó de uma árvore binária de unidades militares */
typedef struct Tarv_soldados
 {
 /***/
 T_soldado soldado;
 /***/
 struct Tarv_soldados *esq;
 /***/
 struct Tarv_soldados *drt;
 }Tarv_soldados;

/** @brief Estruturas que define um nó de um lista dupla de unidades militares */
typedef struct listaD_soldados
 {
 /***/
 Tarv_soldados *p_rSoldados;
 /***/
 struct listaD_soldados *ant;
 /***/
 struct listaD_soldados *prox;
 }T_noD_soldados;

/** @brief Estruturas que define um nó de um lista dupla de planetas */
typedef struct listaD_planetas
 {
 /***/
 T_noS_planetas *p_lPlanetas;
 /***/
 struct listaD_planetas *ant;
 /***/
 struct listaD_planetas  *prox;
 }T_noD_planetas;

/** @brief  */
void ler_player(T_player *temp);
/** @brief  */
void mostrar_planetas(T_planeta *planeta);
/** @brief  */
void mostrar_soldados(T_soldado *soldado);

#endif


