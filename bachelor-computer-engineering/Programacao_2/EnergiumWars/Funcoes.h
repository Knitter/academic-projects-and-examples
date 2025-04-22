#ifndef FuncoesH
#define FuncoesH

#include "Arvores.h"
#include "Definicoes.h"
#include "Estruturas.h"
#include "Files.h"
#include "Visual.h"

/** @brief */
int ler_valor(int min,int max,char *text);
/** @brief */
void pause(void);
/** @brief */
int aleatorio(int max);
/** @brief */
char *alocar_nome(int tamanho);
/** @brief */
T_soldado *alocar_soldado(int tamanho);
/** @brief */
T_planeta *alocar_planeta(int tamanho);
/** @brief */
int menus(char *menu[],int x,int y,int linha_max,int vertical,int horizontal);
/** @brief */
Tarv_soldados *alocar_arvSoldados(int tamanho);
/** @brief */
void mostrar_compras(T_soldado *soldado);
/** @brief */
T_player *alocar_jogadores(int tamanho);
/** @brief */
T_player *eliminar_jogador(T_player **p_vJogadores,int *num_jogadores,int jogador_eliminar);
/** @brief */
void libertar_jogador(T_player *jogador);
/** @brief */
void copiar_jogador(T_player **p_vJogadores,int origem,int destino);
/** @brief */
int validar_nomeSaveGame(char *nome_validar);
/** @brief */
Tarv_soldados *iniciar_jogo(Tarv_soldados *root_soldados,T_player **p_vJogadores,int *num_jogadores,int *num_planetas,FILE *pF_unidades,FILE *pF_planetas);
/** @brief */
void opcao_gravar(int num_jogadores,T_player *p_vJogadores);
/** @brief */
void continuar_jogo(T_player **p_vJogadores,int *num_jogadores);
/** @brief */
void anular_listaPlanetas(T_player **p_vJogadores,int num_jogadores);
/** @brief */
int batalha(T_batalhao *atacante,T_noDC_batalhoes *lista_defensora);
/** @brief */
int contar_Saldo(T_noS_planetas *lista_top);
/** @brief */
char ler_teclaMenu(void);
/** @brief */
Tarv_soldados *opcao_EscolherSoldados(int x,int y,T_noD_soldados *lista_top,int num_unidades);
/** @brief */
void passar_jogada(int *num_jogadorActual,int num_jogadores,T_player **p_vJogadores);
/** @brief */
T_noS_planetas *opcao_EscolherPlaneta(int x,int y,T_noD_planetas *lista_top,char *texto);
/** @brief */
int acrescentar_compras(T_noS_planetas *destino,Tarv_soldados *compras);
/** @brief */
void acresentarBatalhao_movel(T_noS_planetas *destino,T_batalhao *batalhao);
/** @brief */
void mover_tropas(T_player **p_vJogadores,T_noD_planetas *listaDPlanetas_top,int num_jogadorActual,int num_jogadores);
/** @brief */
void listar_posses(T_player *jogador);
/** @brief */
int vender_tropas(T_player *p_vJogadores,T_noD_planetas *lista_planetas);
/** @brief */
T_batalhao *escolher_batalhao(int x,int y,T_noDC_batalhoes *lista_top);
/** @brief */
void perguntarNomes(int x,int y,T_player **p_vJogadores,int num_jogadores);
/** @brief */
T_player *pesquisarOwner_nome(char *nome,T_player *p_vJogadores,int num_jogadores);

#endif
