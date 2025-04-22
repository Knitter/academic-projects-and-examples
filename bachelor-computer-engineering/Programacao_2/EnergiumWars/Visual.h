#ifndef VisualH
#define VisualH

#include "Arvores.h"
#include "Definicoes.h"
#include "Estruturas.h"
#include "Funcoes.h"

/** @brief */
void creditos(int x,int y,char versao[]);
/** @brief */
void linhaH(int x,int y,int fim,char caract,int cor);
/** @brief */
void linhaV(int x,int y,int fim,char caract,int cor);
/** @brief */
void ponto(int x,int y,char caract,int cor);
/** @brief */
void text_box(int x,int y,int vertical,int horizontal,char *texto,int cor);
/** @brief */
void molduras(int x,int y,int vertical,int horizontal,int cor);
/** @brief */
void frases(int x,int y,char *texto,int cor);
/** @brief */
void apresentar_menus(char *menus[],int x,int y,int num_linhas,int cor);
/** @brief */
void tabela_comprar(int x,int y,int max,T_noD_soldados *lista_top);
/** @brief */
void tabela_passarJogada(void);
/** @brief */
void tabela_escolherPlaneta(int x,int y,T_noD_planetas *lista_top,char *texto);
/** @brief */
void tabelaPosses(void);
/** @brief */
void listar_unidades(T_noDC_batalhoes *lista_top);
/** @brief */
void tabela_batalhoes(int x,int y,T_noDC_batalhoes *lista_top);
/** @brief */
void tabela_nome(int x,int y,int posicao);

#endif
