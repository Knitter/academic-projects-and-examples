#pragma hdrstop
#pragma argsused
#include <stdio.h>
#include <conio.h>
#include "Geral.h"
#include "Niveis.h"
#include "Fteste.h"
#include "Matrizes.h"
#include "Ecra.h"
int main(void)
 {
 char opc,mov,v_menu[]={"(N)ovo Jogo\n(C)lassificacoes\n(S)air"},matriz[11][MAXCOLUNAS],
 players[MAXPLAYERS][MAXCOLUNAS];
 int z,posM[2]={3,5},posE[2]={0},jogadas,destinos[MAXCAIXAS][2]={0},nivel=1,correctos,
 score[MAXPLAYERS][2]={0},lugar=-1,c;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 zeroMatriz(players,MAXPLAYERS,MAXCOLUNAS,'\0');
 textmode(C4350);
 do
  {
  clrscr();
  autor(70,43,"Kniter");
  puts(v_menu);
  opc=(char)getch();
  switch(opc)
   {
   case 'n':
   case 'N':
    iniciar(matriz,destinos,&correctos,posM);
    nivel=1;
    jogadas=0;
    do
    {
    corrige(posE,posM);
    mov=(char)getch();
    switch(mov)
     {
     case (char)75:
      if(verificarEspaco(matriz,posM[0],posM[1],1,'\0'))
       {
       esquerda(matriz,posM,posE,1);
       escreveMe(posE[0],posE[1]);
       jogadas++;
       }
      else
       if(verificarEspaco(matriz,posM[0],posM[1],1,'c'))
        if(verificarEspaco(matriz,posM[0],posM[1]-1,1,'\0'))
         {
         esquerda(matriz,posM,posE,-1);
         escreveMe(posE[0],posE[1]);
         escreveB(posE[0]-3,posE[1]);
         jogadas++;
         }
      break;
     case (char)77:
      if(verificarEspaco(matriz,posM[0],posM[1],2,'\0'))
       {
       direita(matriz,posM,posE,1);
       escreveMe(posE[0],posE[1]);
       jogadas++;
       }
      else
       if(verificarEspaco(matriz,posM[0],posM[1],2,'c'))
        if(verificarEspaco(matriz,posM[0],posM[1]+1,2,'\0'))
         {
         direita(matriz,posM,posE,-1);
         escreveMe(posE[0],posE[1]);
         escreveB(posE[0]+3,posE[1]);
         jogadas++;
         }
      break;
     case (char)72:
      if(verificarEspaco(matriz,posM[0],posM[1],3,'\0'))
       {
       subir(matriz,posM,posE,1);
       escreveMe(posE[0],posE[1]);
       jogadas++;
       }
      else
       if(verificarEspaco(matriz,posM[0],posM[1],3,'c'))
        if(verificarEspaco(matriz,posM[0]-1,posM[1],3,'\0'))
         {
         subir(matriz,posM,posE,-1);
         escreveMe(posE[0],posE[1]);
         escreveB(posE[0],posE[1]-3);
         jogadas++;
         }
      break;
     case (char)80:
      if(verificarEspaco(matriz,posM[0],posM[1],4,'\0'))
       {
       descer(matriz,posM,posE,1);
       escreveMe(posE[0],posE[1]);
       jogadas++;
       }
      else
       if(verificarEspaco(matriz,posM[0],posM[1],4,'c'))
        if(verificarEspaco(matriz,posM[0]+1,posM[1],4,'\0'))
         {
         descer(matriz,posM,posE,-1);
         escreveMe(posE[0],posE[1]);
         escreveB(posE[0],posE[1]+3);
         jogadas++;
         }
      break;
     }
    c=contaDestinos(matriz,destinos,correctos);
    if(c==0)
     {
     clrscr(),
     nivel++;
     if(nivel==10)
      break;
     mov=parabens(11,5,nivel,jogadas);
     if(mov==(char)27)
      break;
     clrscr();
     selecionar(matriz,destinos,nivel,&correctos,posM);
     }
    else
     destinosActuais(matriz,destinos,correctos);
    }
   while(mov!=(char)27);
    lugar=verificarScore(score,nivel,jogadas);
    clrscr();
    if(lugar>=0 && nivel>1)
     {
     score[lugar][0]=nivel;
     score[lugar][1]=jogadas;
     if(matriz[lugar][0]!='\0')
      reposicionar(matriz,lugar);
     nome(players,lugar);
     }
    clrscr();
    break;
   case 'c':
   case 'C':
    tabelaClassificacoes(11,5,players,score);
    break;
   }
  }
 while(opc!='s' && opc!= 'S');
 //creditos();
 return 0;
 }
