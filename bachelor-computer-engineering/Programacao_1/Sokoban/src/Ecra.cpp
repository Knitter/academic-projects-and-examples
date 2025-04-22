//---------------------------------------------------------------------------

#pragma hdrstop

#include "Ecra.h"
#include "Geral.h"
#include "Matrizes.h"
#include <stdio.h>
#include <conio.h>
//---------------------------------------------------------------------------
#pragma package(smart_init)
void rescreveD(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2])
 {
 int z;
 for(z=0;destinos[z][0];z++)
  if(verificarEspaco(matriz,destinos[z][0],destinos[z][1]-1,2,'\0'))
   escreveD(1+3*destinos[z][1],1+3*destinos[z][0]);
 }

void cubo(int x,int y)
 {
 gotoxy(x,y);
 printf("%c%c%c",(char)201,(char)205,(char)187);
 gotoxy(x,y+1);
 printf("%c %c",(char)186,(char)186);
 gotoxy(x,y+2);
 printf("%c%c%c",(char)200,(char)205,(char)188);
 }

void escreveD(int x,int y)
 {
 gotoxy(x,y);
 printf("...");
 gotoxy(x,y+1);
 printf("...");
 gotoxy(x,y+2);
 printf("...");
 }

void escreveB(int x,int y)
 {
 gotoxy(x,y);
 printf("###");
 gotoxy(x,y+1);
 printf("###");
 gotoxy(x,y+2);
 printf("###");
 }


void up(int x,int y)
 {
 gotoxy(x,y);
 printf("%c%c%c",(char)186,' ',(char)186);
 gotoxy(x,y+1);
 printf("%c%c%c",(char)186,' ',(char)186);
 gotoxy(x,y+2);
 printf("%c%c%c",(char)200,(char)205,(char)188);
 }

void down(int x,int y)
{
 gotoxy(x,y);
 printf("%c%c%c",(char)201,(char)205,(char)187);
 gotoxy(x,y+1);
 printf("%c%c%c",(char)186,' ',(char)186);
 gotoxy(x,y+2);
 printf("%c%c%c",(char)186,' ',(char)186);
 }

void left(int x,int y)
{
 gotoxy(x,y);
 printf("%c%c%c",(char)205,(char)205,(char)187);
 gotoxy(x,y+1);
 printf("  %c",(char)186);
 gotoxy(x,y+2);
 printf("%c%c%c",(char)205,(char)205,(char)188);
 }

void right(int x,int y)
 {
 gotoxy(x,y);
 printf("%c%c%c",(char)201,(char)205,(char)205);
 gotoxy(x,y+1);
 printf("%c",(char)186);
 gotoxy(x,y+2);
 printf("%c%c%c",(char)200,(char)205,(char)205);
 }

void numeros(int x,int y)
 {
 int z,w;
 for(z=3,w=1;w<11;z+=2,w++)
  {
  gotoxy(x+1,y+z);
  printf("%d",w);
  }
 }

void mostrarJogadas(int score[MAXPLAYERS][2],int x,int y)
 {
 int z,w;
 for(z=3,w=0;w<MAXPLAYERS;z+=2,w++)
  {
  gotoxy(x+32,y+z);
  printf("%7d",score[w][1]);
  }
 }

void mostrarNivel(int score[MAXPLAYERS][2],int x,int y)
 {
 int z,w;
 for(z=3,w=0;w<MAXPLAYERS;z+=2,w++)
  {
  gotoxy(x+26,y+z);
  printf("%5d",score[w][0]);
  }
 }

void mostrarPlayers(char players[MAXPLAYERS][MAXCOLUNAS],int x,int y)
 {
 int z,w;
 for(z=3,w=0;w<MAXPLAYERS;z+=2,w++)
  {
  gotoxy(x+5,y+z);
  puts(players[w]);
  }
 }

void Tclassificacoes(int x, int y)
 {
 int z;
 gotoxy(x+1,y+1);
 printf("Nr.");
 gotoxy(x+13,y+1);
 printf("Nome");
 gotoxy(x+26,y+1);
 printf("Nivel");
 gotoxy(x+32,y+1);
 printf("Jogadas");
 for(z=y;z<29;z+=2)
  linhaH(x,z,40,(char)205);
 linhaV(x,y,23,(char)186);
 linhaV(x+4,y,23,(char)186);
 linhaV(x+25,y,23,(char)186);
 linhaV(x+31,y,23,(char)186);
 linhaV(x+39,y,23,(char)186);
 for(z=y;z<27;z+=2)
  ponto(x,z,(char)204);
 for(z=y;z<27;z+=2)
  ponto(x+39,z+2,(char)185);
 for(z=y;z<27;z+=2)
  ponto(x+4,z,(char)206);
 for(z=y;z<27;z+=2)
  ponto(x+25,z,(char)206);
 for(z=y;z<27;z+=2)
  ponto(x+31,z,(char)206);
 ponto(x,y,(char)201);
 ponto(x+39,y,(char)187);
 ponto(x,y+22,(char)200);
 ponto(x+4,y,(char)203);
 ponto(x+25,y,(char)203);
 ponto(x+31,y,(char)203);
 ponto(x+4,y+22,(char)202);
 ponto(x+25,y+22,(char)202);
 ponto(x+31,y+22,(char)202);
 ponto(x+39,y,(char)187);
 ponto(x+39,y+22,(char)188);
 gotoxy(79,43);
 }

void apaga(int x,int y)
 {
 gotoxy(x,y);
 printf("   ");
 gotoxy(x,y+1);
 printf("   ");
 gotoxy(x,y+2);
 printf("   ");
 }

void escreveMe(int x,int y)
 {
 gotoxy(x,y);
 printf(" %c ",(char)2);
 gotoxy(x,y+1);
 printf("-%c-",(char)3);
 gotoxy(x,y+2);
 printf("/ \\");
 }

void ponto(int x,int y,char caract)
 {
 gotoxy(x,y);
 printf("%c",caract);
 }

void linhaV(int x,int y,int fim,char caract)
 {
 int z;
 for(z=0;z<fim;z++)
  {
  gotoxy(x,y+z);
  printf("%c",caract);
  }
 }

void linhaH(int x,int y,int fim,char caract)
 {
 int z;
 gotoxy(x,y);
 for(z=0;z<fim;z++)
  printf("%c",caract);
 }
