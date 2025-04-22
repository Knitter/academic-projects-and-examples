//---------------------------------------------------------------------------

#pragma hdrstop

#include "Geral.h"
#include "Niveis.h"
#include "Ecra.h"
#include "Matrizes.h"
#include <stdio.h>
#include <conio.h>
#include <string.h>
//---------------------------------------------------------------------------
#pragma package(smart_init)
void iniciar(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 primeiroM(matriz,destinos,correctos,posM);
 clrscr();
 primeiroE(1,1);
 }

void corrige(int posE[2],int posM[2])
 {
 posE[0]=1+3*posM[1];
 posE[1]=1+3*posM[0];
 }

void destinosActuais(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int correctos)
 {
 int z;
 for(z=0;z<correctos;z++)
  if(verificarEspaco(matriz,destinos[z][0],destinos[z][1]-1,2,'\0'))
   escreveD(1+3*destinos[z][1],1+3*destinos[z][0]);
 }

void reposicionar(char players[MAXPLAYERS][MAXCOLUNAS],int lugar)
 {
 int z;
 for(z=9;z>lugar;z--)
  strcpy(players[z],players[z-1]);
 }

void tabelaClassificacoes(int x,int y,char players[MAXPLAYERS][MAXCOLUNAS],int score[MAXPLAYERS][2])
 {
 clrscr();
 gotoxy(x+9,y-3);
 printf("Cassifica%c%ces",(char)135,(char)228);
 Tclassificacoes(x,y);
 mostrarPlayers(players,x,y);
 mostrarNivel(score,x,y);
 mostrarJogadas(score,x,y);
 numeros(x,y);
 getch();
 clrscr();
 }

void autor(int x,int y,char eu[])
 {
 gotoxy(x,y);
 printf("by %s",eu);
 gotoxy(1,1);
 }

char parabens(int x,int y,int nivel,int jogadas)
 {
 linhaH(x,y,50,(char)205);
 linhaV(x,y,8,(char)186);
 linhaV(x+50,y,8,(char)186);
 linhaH(x,y+8,50,(char)205);
 ponto(x,y,(char)201);
 ponto(x+50,y,(char)187);
 ponto(x+50,y+8,(char)188);
 ponto(x,y+8,(char)200);
 gotoxy(x+2,y+2);
 printf("Completo o %d%c n%cvel com %d jogadas totais",nivel-1,(char)167,(char)161,jogadas);
 gotoxy(x+2,y+4);
 printf("Pressione \"Esc\" para sair ou outra tecla");
 gotoxy(x+2,y+6);
 printf("para continuar para continuar para o %d%c n%cvel",nivel,(char)167,(char)161);
 return getch();
 }

void selecionar(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int nivel,int *correctos,int posM[2])
 {
 switch(nivel)
  {
  case 2:
   segundoM(matriz,destinos,correctos,posM);
   segundoE(1,1);
   break;
  case 3:
   terceiroM(matriz,destinos,correctos,posM);
   terceiroE(1,1);
   break;
  case 4:
   quartoM(matriz,destinos,correctos,posM);
   quartoE(1,1);
   break;
  case 5:
   quintoM(matriz,destinos,correctos,posM);
   quintoE(1,1);
   break;
  case 6:
   sextoM(matriz,destinos,correctos,posM);
   sextoE(1,1);
   break;
  case 7:
   setimoM(matriz,destinos,correctos,posM);
   setimoE(1,1);
   break;
  case 8:
   oitavoM(matriz,destinos,correctos,posM);
   oitavoE(1,1);
   break;
  case 9:
   nonoM(matriz,destinos,correctos,posM);
   nonoE(1,1);
   break;
  case 10:
   decimoM(matriz,destinos,correctos,posM);
   decimoE(1,1);
   break;
  }
 }

int verificarScore(int score[MAXPLAYERS][2],int nivel,int jogadas)
 {
 int z,lugar=-1;
 for(z=0;z<MAXPLAYERS;z++)
  if(score[0][0]!=0)
  {
  if(nivel>score[z][0])
   {
   lugar=z;
   break;
   }
  if(nivel==score[z][0])
   {
   if(jogadas>=score[z][1])
    {
    lugar=z+1;
    break;
    }
   lugar=z;
   break;
   }
  }
 else
  lugar=0;
 return lugar;
 }

int contaDestinos(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int correctos)
 {
 int z,controlo=correctos;
 for(z=0;z<controlo;z++)
  if(matriz[destinos[z][0]][destinos[z][1]]=='c')
   correctos--;
 return correctos;
 }

void creditos(int x,int y)
 {
 clrscr();
 gotoxy(x,y);
 printf(" v0.01 beta");
 gotoxy(x,y+1);
 printf("(C)opyright, (C)opyleft, (C)opymidle 2003 Knitter Inc.");
 getch();
 }
