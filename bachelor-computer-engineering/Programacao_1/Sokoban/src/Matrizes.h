//---------------------------------------------------------------------------

#ifndef MatrizesH
#define MatrizesH
#include "Geral.h"
/**
* \brief Inicializa a matriz.
*
*Recebe a matriz a inicializar as linhas, colunas e o
*caracter com que ser� inicializada.*
*/
void zeroMatriz(char matriz[][MAXCOLUNAS],int linhas, int colunas,char caract);
/**
* \brief Verifica se a posi��o seguinte � indicada est� ou n�o ocupada por
* um determinado caracter.
*
* Recebe a matriz, o numero de linhas, colunas, o caracter a verificar e a
*direc��o em que ser� feita a verifica��o
*/
int verificarEspaco(char matriz[][MAXCOLUNAS],int linha,int coluna,int info,char caract);
/**
* \brief Efectua o movimento do boneco no sentido esquerdo.
*
* Recebe a matriz, a posi��o do boneco na matriz, a posi��o do boneco no ecr�
* e se o boneco est� isolado ou se se encontra perto de uma caixa.
*/
void esquerda(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual � fun��o anterior referindo-se apenas ao movimento no sentido da direita
*/
void direita(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual � fun��o anterior referindo-se apenas ao movimento no sentido descendente
*/
void subir(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Igual � fun��o anterior referindo-se apenas ao movimento no sentido ascendente
*/
void descer(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info);
/**
* \brief Atribui o nome do jogador a tabela de classifica��es.
*
* Recebe a matriz com dom os nomes e uma variavel lugar respons�vel pelo indice na matriz.
*/
void nome(char players[MAXPLAYERS][MAXCOLUNAS],int lugar);
/**
* \brief Escreve linhas horizontais numa matriz.
*
* recebe a matriz, a linha e coluna onde ser� colocada a linha o tamanho da mesma e o caracter.
*/
void escreveLinhasH(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter);
/**
* \brief Igual � fun��o anterior tratando-se apenas de linhas verticais.
*/
void escreveLinhasV(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter);
//---------------------------------------------------------------------------
#endif
