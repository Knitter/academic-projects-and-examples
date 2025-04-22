//---------------------------------------------------------------------------

#ifndef MatrizesH
#define MatrizesH
#include "Geral.h"
/**
* \brief Inicializa a matriz.
*
*Recebe a matriz a inicializar as linhas, colunas e o
*caracter com que será inicializada.*
*/
void zeroMatriz(char matriz[][MAXCOLUNAS],int linhas, int colunas,char caract);
/**
* \brief Verifica se a posição seguinte à indicada está ou não ocupada por
* um determinado caracter.
*
* Recebe a matriz, o numero de linhas, colunas, o caracter a verificar e a
*direcção em que será feita a verificação
*/
int verificarEspaco(char matriz[][MAXCOLUNAS],int linha,int coluna,int info,char caract);
/**
* \brief Efectua o movimento do boneco no sentido esquerdo.
*
* Recebe a matriz, a posição do boneco na matriz, a posição do boneco no ecrã
* e se o boneco está isolado ou se se encontra perto de uma caixa.
*/
void esquerda(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual à função anterior referindo-se apenas ao movimento no sentido da direita
*/
void direita(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual à função anterior referindo-se apenas ao movimento no sentido descendente
*/
void subir(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual à função anterior referindo-se apenas ao movimento no sentido ascendente
*/
void descer(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Atribui o nome do jogador a tabela de classificações.
*
* Recebe a matriz com dom os nomes e uma variavel lugar responsável pelo indice na matriz.
*/
void nome(char players[MAXPLAYERS][MAXCOLUNAS],int lugar);
/**
* \brief Escreve linhas horizontais numa matriz.
*
* recebe a matriz, a linha e coluna onde será colocada a linha o tamanho da mesma e o caracter.
*/
void escreveLinhasH(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter);
/**
* \brief Igual à função anterior tratando-se apenas de linhas verticais.
*/
void escreveLinhasV(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter);
//---------------------------------------------------------------------------
#endif
