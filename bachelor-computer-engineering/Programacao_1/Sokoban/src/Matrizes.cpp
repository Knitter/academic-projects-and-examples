//---------------------------------------------------------------------------

#pragma hdrstop

#include "Matrizes.h"
#include "Ecra.h"
#include "Niveis.h"
#include <stdio.h>
#include <conio.h>
#include <string.h>

//---------------------------------------------------------------------------
#pragma package(smart_init)

void escreveLinhasV(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter)
 {
 int z;
 for(z=linha;z<tamanho;z++)
  matriz[z][coluna]=caracter;
 }

void escreveLinhasH(char matriz[][MAXCOLUNAS],int linha,int coluna,int tamanho,char caracter)
 {
 int z;
 for(z=coluna;z<tamanho;z++)
  matriz[linha][z]=caracter;
 }

void nome(char players[MAXPLAYERS][MAXCOLUNAS],int lugar)
 {
 char temp[50];
 int flag;
 do
  {
  flag=0;
  printf("Introduza o nome (max de 19 letras)\n\n: ");
  fflush(stdin);
  gets(temp);
  if(strlen(temp)>19)
   flag++;
  else
   strcpy(players[lugar],temp);
  }
 while(flag);
 }

void descer(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info)
 {
 switch(info)
  {
  case 1:
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]+1][posM[1]]='b';
   apaga(posE[0],posE[1]);
   break;
  case -1:
   matriz[posM[0]+1][posM[1]]='\0';
   matriz[posM[0]+2][posM[1]]='c';
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]+1][posM[1]]='b';
   apaga(posE[0],posE[1]);
   apaga(posE[0],posE[1]+3);
   break;
  }
 posM[0]=posM[0]+1;
 posE[1]=1+3*posM[0];
 }

void subir(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info)
 {
 switch(info)
  {
  case 1:
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]-1][posM[1]]='b';
   apaga(posE[0],posE[1]);
   break;
  case -1:
   matriz[posM[0]-1][posM[1]]='\0';
   matriz[posM[0]-2][posM[1]]='c';
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]-1][posM[1]]='b';
   apaga(posE[0],posE[1]);
   apaga(posE[0],posE[1]-3);
   break;
  }
 posM[0]=posM[0]-1;
 posE[1]=1+3*posM[0];
 }

void direita(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info)
 {
 switch(info)
  {
  case 1:
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]][posM[1]+1]='b';
   apaga(posE[0],posE[1]);
   break;
  case -1:
   matriz[posM[0]][posM[1]+1]='\0';
   matriz[posM[0]][posM[1]+2]='c';
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]][posM[1]+1]='b';
   apaga(posE[0],posE[1]);
   //apaga(posE[0],posE[1]+3);//BUG
   break;
  }
 posM[1]=posM[1]+1;
 posE[0]=1+3*posM[1];
 }

void esquerda(char matriz[][MAXCOLUNAS],int posM[],int posE[],int info)
 {
 switch(info)
  {
  case 1:
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]][posM[1]-1]='b';
   apaga(posE[0],posE[1]);
   break;
  case -1:
   matriz[posM[0]][posM[1]-1]='\0';
   matriz[posM[0]][posM[1]-2]='c';
   matriz[posM[0]][posM[1]]='\0';
   matriz[posM[0]][posM[1]-1]='b';
   apaga(posE[0],posE[1]);
   apaga(posE[0]-3,posE[1]);
   break;
  }
 posM[1]=posM[1]-1;
 posE[0]=1+3*posM[1];
 }

int verificarEspaco(char matriz[][MAXCOLUNAS],int linha,int coluna,int info,char caract)
 {
 int i=0;
 switch(info)
  {
  case 1:
   if(matriz[linha][coluna-1]==caract)
    i=1;
   break;
  case 2:
   if(matriz[linha][coluna+1]==caract)
    i=1;
   break;
  case 3:
   if(matriz[linha-1][coluna]==caract)
    i=1;
   break;
  case 4:
   if(matriz[linha+1][coluna]==caract)
    i=1;
   break;
  }
 return i;
 }

void zeroMatriz(char matriz[][MAXCOLUNAS],int linhas, int colunas,char caract)
 {
 int z,y;
 for(z=0;z<linhas;z++)
  for(y=0;y<colunas;y++)
   matriz[z][y]=caract;
 }
