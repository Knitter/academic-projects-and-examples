//---------------------------------------------------------------------------

#ifndef NiveisH
#define NiveisH
#include "Geral.h"
#include "Ecra.h"
/**
* \brief Todas as funcoes seguintes são responsaveis pelos niveis do jogo desde o decimo
* até ao primeiro alternado entre as que inicializam a matriz e as que escrevem no ecrã.
* Recebem, respectivamente: a matriz, os destinos, o numero de caixas e a posição do boneco;
* e a posicao onde apresentar o nivel.
*/
void decimoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void decimoE(int x,int y);
void nonoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void nonoE(int x,int y);
void oitavoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void oitavoE(int x,int y);
void setimoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void setimoE(int x,int y);
void sextoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void sextoE(int x,int y);
void quintoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
void quintoE(int x,int y);
void quartoM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2]);
void quartoE(int x,int y);
void terceiroM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2]);
void terceiroE(int x,int y);
void segundoM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2]);
void segundoE(int x,int y);
void primeiroM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2]);
void primeiroE(int x,int y);
//---------------------------------------------------------------------------
#endif
