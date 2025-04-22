#ifndef FilesH
#define FilesH

#include "Definicoes.h"
#include "Estruturas.h"
#include "Funcoes.h"
#include "Listas.h"
/******************************Ler em ficheiro texto***************************/
/** @brief */
void ler_soldadoFileT(T_soldado *temp,FILE *pF);
/** @brief */
void ler_planetaFileT(T_planeta *temp,FILE *pF);
/** @brief */
int ler_FilePlanetas(T_planeta **p_vPlanetas,FILE *pF);
/** @brief */
int ler_FileUnidades(T_soldado **p_vSoldados,FILE *pF);
/*****************************Escrever em ficheiro binario*********************/
void escrever_lsPlanetasFileB(T_noS_planetas *lista_top,FILE *pF);
/** @brief */
void escrever_planetaFileB(T_planeta *planeta,FILE *pF);
/** @brief */
void escrever_ldBatalhoesFileB(T_noDC_batalhoes *lista_top,FILE *pF);
/** @brief */
void escrever_batalhaoFilesB(T_batalhao *batalhao,FILE *pF);
/** @brief */
void gravar_jogo(int num_jogadores,T_player *p_vJogadores,FILE *pF);
/** @brief */
void escrever_nomesFileB(char *nome,FILE *pF);
/** @brief */
void escrever_playerFileB(T_player *jogador,FILE *pF);
/*****************************Ler em ficheiro binario**************************/
/** @brief */
void carregar_jogo(T_player **p_Vjogadores,int *num_jogadores,FILE *pF);
/** @brief */
T_noS_planetas *ler_lsPlanetasFileB(FILE *pF,T_player *p_vJogadores,int num_jogadores);
/** @brief */
void ler_playerFileB(FILE *pF,T_player **p_vJogadores,int num_jogadorActual,int num_jogadores);
/** @brief */
T_planeta ler_planetaFileB(FILE *pF,T_player *p_vJogadores,int num_jogadores);/*(1)*/
/** @brief */
T_noDC_batalhoes *ler_ldBatalhoesFileB(FILE *pF);
/** @brief */
T_batalhao ler_batalhaoFilesB(FILE *pF);
/** @brief */
char *ler_nomesFileB(FILE *pF);

#endif

