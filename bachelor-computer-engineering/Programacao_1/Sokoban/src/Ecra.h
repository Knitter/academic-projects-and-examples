//---------------------------------------------------------------------------

#ifndef EcraH
#define EcraH
#include "Geral.h"
/**
* \brief Todas as seguintes funções são responsaveis por todo o inteface do
*trabalho.
*
*
* Recebe um x e um y corespondentes á posição de começo
* e um fim corespondente ao fim. Recebe ainda o caracter a se apresentado.
*/
void linhaH(int x,int y,int fim,char caract);
/* \brief Igual a função anterior.
*/
void linhaV(int x,int y,int fim,char caract);
/**
* \brief  Recebe a posição e o caracter a imprimir.
*/
void ponto(int x,int y,char caract);
/**
* \brief Recebe um x e y referentes à posição.
*/
void escreveMe(int x,int y);
/**
* \brief Recebe a posição dos elementos a apagar.
*/
void apaga(int x,int y);
/**
* \brief Recebe um x e um y referentes à posição da tabela.
*/
void Tclassificacoes(int x,int y);
/**
* \brief Recebe a matriz com os nomes dos jogadores e a posição onde será apresentada.
*/
void mostrarPlayers(char players[MAXPLAYERS][MAXCOLUNAS],int x,int y);
/**
* \brief Recebe a matriz com as classificações e a posicao onde a vai apresentar os niveis.
*/
void mostrarNivel(int score[MAXPLAYERS][2],int x,int y);
/**
* \brief Recebe a matriz com as classificações e a posicao onde a vai apresentar as jogadas.
*/
void mostrarJogadas(int score[MAXPLAYERS][2],int x,int y);
/**
* \brief Recebe a posicao onde apresenta os numeros referentes à posicao dos
* jogadores na classificação.
*/
void numeros(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um cubo sem a parede da direita
*/
void right(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um cubo sem a parede da esquerda
*/
void left(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um cubo sem a parede de baixo
*/
void down(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um cubo sem a parede de cima
*/
void up(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um a caixa
*/
void escreveB(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um o destino
*/
void escreveD(int x,int y);
/**
* \brief Recebe a posicao onde apresenta um cubo
*/
void cubo(int x,int y);
/**
* \brief Recebe a matriz e os destinos a reescrever
*/
void rescreveD(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2]);
//---------------------------------------------------------------------------
#endif
