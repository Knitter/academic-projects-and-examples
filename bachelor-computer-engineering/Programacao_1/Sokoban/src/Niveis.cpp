//---------------------------------------------------------------------------

#pragma hdrstop

#include "Niveis.h"
#include "Geral.h"
#include "Matrizes.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
void primeiroE(int x,int y)
 {
 linhaH(x+6,y+2,18,(char)205); left(x+6,y+6); linhaH(x+3,y+11,2,(char)205);
 linhaH(x+3,y+18,9,(char)205); linhaH(x+12,y+21,6,(char)205);
 linhaH(x+19,y+18,7,(char)205); linhaH(x+27,y+21,3,(char)205);
 linhaH(x+25,y+8,5,(char)205); linhaV(x+5,y+3,3,(char)186);
 linhaV(x+5,y+9,2,(char)186); linhaV(x+2,y+12,6,(char)186);
 linhaV(x+11,y+19,2,(char)186); cubo(x+12,y+6); right(x+9,y+12);
 left(x+12,y+12); linhaV(x+18,y+19,2,(char)186); linhaV(x+26,y+19,2,(char)186);
 linhaV(x+30,y+9,12,(char)186); linhaV(x+24,y+3,6,(char)186);
 ponto(x+5,y+2,(char)201); ponto(x+5,y+6,(char)200); ponto(x+5,y+8,(char)201);
 ponto(x+5,y+11,(char)188); ponto(x+2,y+11,(char)201);
 ponto(x+2,y+18,(char)200); ponto(x+11,y+18,(char)187);
 ponto(x+11,y+21,(char)200); ponto(x+18,y+21,(char)188);
 ponto(x+18,y+18,(char)201); ponto(x+26,y+18,(char)187);
 ponto(x+26,y+21,(char)200); ponto(x+30,y+21,(char)188);
 ponto(x+30,y+8,(char)187); ponto(x+24,y+8,(char)200);
 ponto(x+24,y+2,(char)187); escreveB(x+15,y+6); escreveB(x+15,y+9);
 escreveB(x+15,y+15); escreveD(x+27,y+12); escreveD(x+27,y+15);
 escreveD(x+27,y+18); escreveMe(x+3,y+15);
 }

void primeiroM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2])
 {
 *correctos=3;
 zeroMatriz(matriz,8,MAXCOLUNAS,'\0');
 posM[0]=5;posM[1]=1;
 destinos[0][0]=4; destinos[0][1]=9; destinos[1][0]=5; destinos[1][1]=9;
 destinos[2][0]=6; destinos[2][1]=9;
 matriz[2][5]='c'; matriz[3][5]='c'; matriz[5][5]='c'; matriz[5][1]='b';
 escreveLinhasH(matriz,0,0,11,'w'); escreveLinhasH(matriz,7,0,11,'w');
 escreveLinhasH(matriz,1,0,2,'w'); escreveLinhasH(matriz,2,0,3,'w');
 escreveLinhasH(matriz,3,0,2,'w'); escreveLinhasH(matriz,1,8,11,'w');
 escreveLinhasH(matriz,2,8,11,'w'); escreveLinhasV(matriz,0,10,7,'w');
 escreveLinhasH(matriz,4,3,5,'w'); matriz[2][2]='w'; matriz[2][4]='w';
 escreveLinhasH(matriz,6,0,4,'w'); escreveLinhasH(matriz,6,6,9,'w');
 escreveLinhasV(matriz,4,0,6,'w');
 }

void segundoE(int x,int y)
 {
 linhaV(x+14,y+3,8,(char)186); linhaV(x+8,y+12,5,(char)186);
 linhaV(x+2,y+18,6,(char)186); linhaV(x+14,y+25,5,(char)186);
 linhaV(x+30,y+27,3,(char)186); linhaV(x+36,y+25,2,(char)186);
 linhaV(x+41,y+25,2,(char)186); linhaV(x+54,y+18,9,(char)186);
 linhaV(x+41,y+18,2,(char)186); linhaV(x+27,y+12,8,(char)186);
 linhaV(x+24,y+3,8,(char)186); down(x+30,y+24); linhaH(x+15,y+2,9,(char)205);
 linhaH(x+9,y+11,5,(char)205); linhaH(x+3,y+17,5,(char)205);
 linhaH(x+3,y+24,11,(char)205); linhaH(x+15,y+30,15,(char)205);
 linhaH(x+33,y+27,3,(char)205); linhaH(x+37,y+24,4,(char)205);
 linhaH(x+42,y+27,12,(char)205); linhaH(x+42,y+17,12,(char)205);
 linhaH(x+25,y+11,2,(char)205); linhaH(x+28,y+20,13,(char)205);
 right(x+18,y+24); linhaH(x+21,y+24,3,(char)205); linhaH(x+21,y+26,3,(char)205);
 left(x+24,y+24); down(x+12,y+15); up(x+12,y+18); ponto(x+18,y+15,(char)201);
 ponto(x+23,y+15,(char)187); ponto(x+23,y+20,(char)188);
 ponto(x+18,y+20,(char)200); linhaH(x+19,y+15,4,(char)205);
 linhaH(x+19,y+20,4,(char)205); linhaV(x+18,y+16,4,(char)186);
 linhaV(x+23,y+16,4,(char)186); ponto(x+14,y+2,(char)201);
 ponto(x+14,y+11,(char)188); ponto(x+8,y+11,(char)201);
 ponto(x+8,y+17,(char)188); ponto(x+2,y+17,(char)201);
 ponto(x+2,y+24,(char)200); ponto(x+14,y+24,(char)187);
 ponto(x+14,y+30,(char)200); ponto(x+30,y+30,(char)188);
 ponto(x+32,y+27,(char)200); ponto(x+36,y+27,(char)188);
 ponto(x+36,y+24,(char)201); ponto(x+41,y+24,(char)187);
 ponto(x+41,y+27,(char)200); ponto(x+54,y+27,(char)188);
 ponto(x+54,y+17,(char)187); ponto(x+41,y+17,(char)201);
 ponto(x+41,y+20,(char)188); ponto(x+27,y+20,(char)200);
 ponto(x+27,y+11,(char)187); ponto(x+24,y+11,(char)200);
 ponto(x+24,y+2,(char)187); escreveMe(x+33,y+24); escreveB(x+15,y+6);
 escreveB(x+15,y+12); escreveB(x+15,y+21); escreveB(x+6,y+21);
 escreveB(x+21,y+9); escreveB(x+21,y+12); escreveD(x+48,y+18);
 escreveD(x+48,y+21); escreveD(x+48,y+24); escreveD(x+51,y+18);
 escreveD(x+51,y+21); escreveD(x+51,y+24);
 }

void segundoM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2])
 {
 int z;
 *correctos=6;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 posM[0]=8;posM[1]=11;
 destinos[0][0]=6; destinos[0][1]=16; destinos[1][0]=6; destinos[1][1]=17;
 destinos[2][0]=7; destinos[2][1]=16; destinos[3][0]=7; destinos[3][1]=17;
 destinos[4][0]=8; destinos[4][1]=16; destinos[5][0]=8; destinos[5][1]=17;
 matriz[2][5]='c'; matriz[4][5]='c'; matriz[3][7]='c'; matriz[4][7]='c';
 matriz[7][2]='c'; matriz[7][5]='c'; matriz[8][11]='b';
 escreveLinhasH(matriz,0,0,19,'w'); escreveLinhasH(matriz,10,0,19,'w');
 for(z=1;z<4;z++)
  escreveLinhasH(matriz,z,0,5,'w');
 for(z=1;z<6;z++)
  escreveLinhasH(matriz,z,9,19,'w');
 escreveLinhasH(matriz,8,0,5,'w'); escreveLinhasH(matriz,9,0,5,'w');
 escreveLinhasH(matriz,4,0,3,'w'); escreveLinhasH(matriz,5,0,3,'w');
 escreveLinhasV(matriz,6,0,8,'w'); escreveLinhasV(matriz,0,18,11,'w');
 escreveLinhasH(matriz,8,6,9,'w'); escreveLinhasH(matriz,8,12,14,'w');
 matriz[8][10]='w';
 escreveLinhasH(matriz,5,6,8,'w'); escreveLinhasH(matriz,6,6,8,'w');
 escreveLinhasV(matriz,5,4,7,'w'); escreveLinhasH(matriz,9,10,19,'w');
 escreveLinhasH(matriz,6,9,14,'w'); escreveLinhasV(matriz,0,8,4,'w');
 }

void terceiroE(int x,int y)
 {
 linhaH(x+3,y+2,15,(char)205); linhaH(x+3,y+18,15,(char)205);
 linhaV(x+2,y+3,15,(char)186); linhaV(x+18,y+3,15,(char)186);
 ponto(x+2,y+2,(char)201); ponto(x+2,y+18,(char)200);
 ponto(x+18,y+2,(char)187); ponto(x+18,y+18,(char)188);
 cubo(x+6,y+6); cubo(x+12,y+6); cubo(x+6,y+12);
 escreveB(x+6,y+9);escreveB(x+9,y+6); escreveB(x+12,y+9);escreveB(x+9,y+12);
 escreveD(x+3,y+3);escreveD(x+15,y+3); escreveD(x+3,y+15);escreveD(x+15,y+15);
 escreveMe(x+9,y+9);
 }

void terceiroM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2])
 {
 *correctos=4;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 posM[0]=3;posM[1]=3;
 destinos[0][0]=1; destinos[0][1]=1; destinos[1][0]=1; destinos[1][1]=5;
 destinos[2][0]=5; destinos[2][1]=1; destinos[3][0]=5; destinos[3][1]=5;
 matriz[2][3]='c'; matriz[3][2]='c'; matriz[3][4]='c'; matriz[4][3]='c';
 matriz[3][3]='b';
 escreveLinhasH(matriz,0,0,7,'w'); escreveLinhasH(matriz,6,0,7,'w');
 escreveLinhasV(matriz,0,0,7,'w'); escreveLinhasV(matriz,0,6,7,'w');
 matriz[2][2]='w'; matriz[2][4]='w'; matriz[4][2]='w';
 }

void quartoE(int x,int y)
 {
 linhaV(x+8,y+3,5,(char)186); linhaV(x+2,y+9,6,(char)186);
 linhaV(x+11,y+16,2,(char)186); linhaV(x+14,y+19,2,(char)186);
 linhaV(x+30,y+12,9,(char)186); linhaV(x+24,y+9,2,(char)186);
 linhaV(x+18,y+6,2,(char)186); linhaV(x+15,y+3,2,(char)186);
 linhaH(x+9,y+2,6,(char)205); linhaH(x+3,y+8,5,(char)205);
 linhaH(x+3,y+15,8,(char)205); linhaH(x+12,y+18,2,(char)205);
 linhaH(x+15,y+21,15,(char)205); linhaH(x+25,y+11,5,(char)205);
 linhaH(x+19,y+8,5,(char)205); linhaH(x+16,y+5,2,(char)205); cubo(x+18,y+12);
 cubo(x+21,y+15); ponto(x+8,y+2,(char)201); ponto(x+8,y+8,(char)188);
 ponto(x+2,y+8,(char)201); ponto(x+2,y+15,(char)200);
 ponto(x+11,y+15,(char)187); ponto(x+11,y+18,(char)200);
 ponto(x+14,y+18,(char)187); ponto(x+14,y+21,(char)200);
 ponto(x+30,y+21,(char)188); ponto(x+30,y+11,(char)187);
 ponto(x+24,y+11,(char)200); ponto(x+24,y+8,(char)187);
 ponto(x+18,y+8,(char)200); ponto(x+18,y+5,(char)187);
 ponto(x+15,y+5,(char)200); ponto(x+15,y+2,(char)187);
 escreveMe(x+9,y+3); escreveB(x+9,y+9); escreveB(x+9,y+12); escreveB(x+12,y+12);
 escreveB(x+15,y+9); escreveB(x+24,y+15); escreveD(x+15,y+6);
 escreveD(x+15,y+12); escreveD(x+12,y+15); escreveD(x+18,y+15);
 escreveD(x+18,y+18);
 }

void quartoM(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int *correctos,int posM[2])
 {
 *correctos=5;
 zeroMatriz(matriz,8,MAXCOLUNAS,'\0');
 posM[0]=1;posM[1]=3;
 destinos[0][0]=2; destinos[0][1]=5; destinos[1][0]=4; destinos[1][1]=5;
 destinos[2][0]=5; destinos[2][1]=4; destinos[3][0]=5; destinos[3][1]=6;
 destinos[4][0]=6; destinos[4][1]=6; matriz[3][3]='c'; matriz[4][3]='c';
 matriz[3][5]='c'; matriz[4][4]='c'; matriz[5][8]='c'; matriz[1][3]='b';
 escreveLinhasH(matriz,0,0,11,'w'); escreveLinhasH(matriz,7,0,11,'w');
 escreveLinhasH(matriz,5,0,4,'w'); escreveLinhasH(matriz,6,0,5,'w');
 escreveLinhasH(matriz,1,0,3,'w'); escreveLinhasH(matriz,2,0,3,'w');
 escreveLinhasH(matriz,1,5,11,'w'); escreveLinhasH(matriz,2,6,11,'w');
 escreveLinhasH(matriz,3,8,11,'w'); escreveLinhasV(matriz,0,10,8,'w');
 escreveLinhasV(matriz,3,0,5,'w'); matriz[4][6]='w'; matriz[5][7]='w';
 }

void quintoE(int x,int y)
 {
 linhaV(x+2,y+3,9,(char)186); linhaV(x+8,y+13,4,(char)186);
 linhaV(x+5,y+18,6,(char)186); linhaV(x+18,y+21,3,(char)186);
 linhaV(x+27,y+9,12,(char)186); linhaV(x+23,y+9,5,(char)186);
 linhaV(x+12,y+3,11,(char)186); down(x+18,y+18); linhaH(x+3,y+2,9,(char)205);
 linhaH(x+3,y+12,5,(char)205); linhaH(x+6,y+17,2,(char)205);
 linhaH(x+6,y+24,12,(char)205); linhaH(x+21,y+21,6,(char)205);
 linhaH(x+24,y+8,3,(char)205); linhaH(x+13,y+14,10,(char)205);
 ponto(x+2,y+2,(char)201); ponto(x+2,y+12,(char)200);
 ponto(x+8,y+12,(char)187); ponto(x+8,y+17,(char)188);
 ponto(x+5,y+17,(char)201); ponto(x+5,y+24,(char)200);
 ponto(x+18,y+24,(char)188); ponto(x+20,y+21,(char)200);
 ponto(x+27,y+21,(char)188); ponto(x+27,y+8,(char)187);
 ponto(x+23,y+8,(char)201); ponto(x+23,y+14,(char)188);
 ponto(x+12,y+14,(char)200); ponto(x+12,y+2,(char)187);
 escreveMe(x+3,y+6); escreveB(x+6,y+6); escreveB(x+6,y+9); escreveB(x+9,y+6);
 escreveD(x+24,y+9); escreveD(x+24,y+12); escreveD(x+24,y+15);
 }

void quintoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 int z;
 *correctos=3;
 zeroMatriz(matriz,9,MAXCOLUNAS,'\0');
 posM[0]=2;posM[1]=1;
 destinos[0][0]=3; destinos[0][1]=8; destinos[1][0]=4; destinos[1][1]=8;
 destinos[2][0]=5; destinos[2][1]=8; matriz[2][2]='c'; matriz[2][3]='c';
 matriz[3][2]='c'; matriz[2][1]='b'; escreveLinhasH(matriz,0,0,10,'w');
 escreveLinhasH(matriz,8,0,10,'w'); escreveLinhasH(matriz,7,6,9,'w');
 escreveLinhasH(matriz,8,6,9,'w');
 for(z=4;z<8;z++)
  escreveLinhasV(matriz,0,z,5,'w');
 escreveLinhasV(matriz,0,0,9,'w'); escreveLinhasV(matriz,0,9,9,'w');
 escreveLinhasV(matriz,0,8,3,'w'); escreveLinhasV(matriz,4,1,6,'w');
 escreveLinhasV(matriz,4,2,6,'w'); matriz[6][6]='w';
 }

void sextoE(int x,int y)
 {
 linhaH(x+6,y+2,15,(char)205); linhaH(x+6,y+18,6,(char)205);
 linhaH(x+15,y+18,9,(char)205); linhaH(x+22,y+5,5,(char)205);
 linhaH(x+5,y+2,6,(char)205); linhaH(x+3,y+8,2,(char)205);
 linhaH(x+3,y+15,2,(char)205); linhaH(x+25,y+12,2,(char)205);
 linhaH(x+12,y+6,3,(char)205); linhaH(x+12,y+8,3,(char)205);
 right(x+9,y+6); left(x+15,y+6); down(x+12,y+12);
 linhaV(x+5,y+3,5,(char)186); linhaV(x+2,y+9,6,(char)186);
 linhaV(x+5,y+16,2,(char)186); linhaV(x+12,y+15,3,(char)186);
 linhaV(x+14,y+15,3,(char)186); linhaV(x+24,y+13,5,(char)186);
 linhaV(x+27,y+6,6,(char)186); linhaV(x+21,y+3,2,(char)186);
 ponto(x+5,y+2,(char)201); ponto(x+5,y+8,(char)188); ponto(x+2,y+8,(char)201);
 ponto(x+2,y+15,(char)200); ponto(x+5,y+15,(char)187);
 ponto(x+5,y+18,(char)200); ponto(x+12,y+18,(char)188);
 ponto(x+14,y+18,(char)200); ponto(x+24,y+18,(char)188);
 ponto(x+24,y+12,(char)201); ponto(x+27,y+12,(char)188);
 ponto(x+27,y+5,(char)187); ponto(x+21,y+5,(char)200);
 ponto(x+21,y+2,(char)187); escreveMe(x+9,y+9); escreveB(x+12,y+9);
 escreveB(x+6,y+6); escreveB(x+18,y+12); escreveB(x+21,y+9); escreveD(x+6,y+12);
 escreveD(x+6,y+15); escreveD(x+9,y+12); escreveD(x+9,y+15);
 }

void sextoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 *correctos=4;
 zeroMatriz(matriz,7,MAXCOLUNAS,'\0');
 posM[0]=3;posM[1]=3;
 destinos[0][0]=4; destinos[0][1]=2; destinos[1][0]=4; destinos[1][1]=3;
 destinos[2][0]=5; destinos[2][1]=2; destinos[3][0]=5; destinos[3][1]=3;
 matriz[2][2]='c'; matriz[3][4]='c'; matriz[3][7]='c'; matriz[4][6]='c';
 matriz[3][3]='b';
 escreveLinhasH(matriz,0,0,10,'w'); escreveLinhasH(matriz,2,3,6,'w');
 escreveLinhasH(matriz,7,1,10,'w'); escreveLinhasH(matriz,6,0,10,'w');
 escreveLinhasV(matriz,0,0,7,'w'); escreveLinhasV(matriz,0,9,7,'w');
 escreveLinhasV(matriz,4,4,7,'w'); escreveLinhasV(matriz,4,8,7,'w');
 escreveLinhasH(matriz,1,7,10,'w'); escreveLinhasV(matriz,0,1,3,'w');
 matriz[5][1]='w';
 }

void setimoE(int x,int y)
 {
 linhaH(x+6,y+2,6,(char)205); linhaH(x+3,y+21,12,(char)205);
 linhaH(x+3,y+5,2,(char)205); linhaH(x+3,y+9,2,(char)205);
 linhaV(x+5,y+10,4,(char)186); linhaV(x+2,y+15,6,(char)186);
 linhaV(x+12,y+3,8,(char)186); linhaV(x+15,y+12,9,(char)186);
 linhaV(x+2,y+6,3,(char)186); ponto(x+5,y+2,(char)201);
 linhaV(x+5,y+3,2,(char)186); ponto(x+5,y+5,(char)188);
 ponto(x+5,y+9,(char)187); ponto(x+2,y+5,(char)201);
 ponto(x+2,y+9,(char)200); ponto(x+5,y+14,(char)188);
 linhaH(x+3,y+14,2,(char)205); ponto(x+2,y+14,(char)201);
 linhaH(x+13,y+11,2,(char)205); ponto(x+2,y+21,(char)200);
 ponto(x+15,y+21,(char)188); ponto(x+15,y+11,(char)187);
 ponto(x+12,y+11,(char)200); ponto(x+12,y+2,(char)187);
 escreveB(x+6,y+6);escreveB(x+6,y+9); escreveB(x+6,y+15);escreveB(x+9,y+12);
 escreveB(x+9,y+18); escreveD(x+3,y+15);escreveD(x+3,y+18);escreveD(x+6,y+18);
 escreveD(x+12,y+18); escreveMe(x+3,y+6);
 }

void setimoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 *correctos=5;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 posM[0]=2;posM[1]=1;
 destinos[0][0]=5;destinos[0][1]=1; destinos[1][0]=6;destinos[1][1]=1;
 destinos[2][0]=6;destinos[2][1]=2; destinos[3][0]=6;destinos[3][1]=3;
 destinos[4][0]=6;destinos[4][1]=4; matriz[2][2]='c';matriz[3][2]='c';
 matriz[4][3]='c';matriz[5][2]='c'; matriz[6][3]='c';matriz[2][1]='b';
 escreveLinhasH(matriz,0,0,6,'w'); escreveLinhasH(matriz,7,0,6,'w');
 escreveLinhasV(matriz,0,0,8,'w'); escreveLinhasV(matriz,0,5,8,'w');
 escreveLinhasV(matriz,3,1,5,'w'); escreveLinhasV(matriz,0,4,4,'w');
 matriz[1][1]='w';
 }

void oitavoE(int x,int y)
 {
 linhaV(x+11,y+3,2,(char)186); linhaV(x+21,y+28,2,(char)186);
 linhaV(x+26,y+28,2,(char)186); linhaV(x+2,y+6,15,(char)186);
 linhaV(x+5,y+22,8,(char)186); linhaV(x+36,y+24,6,(char)186);
 linhaV(x+30,y+12,11,(char)186); linhaV(x+27,y+3,8,(char)186);
 cubo(x+12,y+9); cubo(x+21,y+12); cubo(x+9,y+18); cubo(x+18,y+21);
 down(x+6,y+9); linhaV(x+6,y+12,3,(char)186); linhaV(x+8,y+12,3,(char)186);
 up(x+6,y+15); down(x+24,y+15); linhaV(x+24,y+18,3,(char)186);
 linhaV(x+26,y+18,3,(char)186); up(x+24,y+21); right(x+15,y+6);
 linhaH(x+18,y+6,3,(char)205); linhaH(x+18,y+8,3,(char)205); left(x+21,y+6);
 right(x+9,y+24); linhaH(x+12,y+24,3,(char)205); linhaH(x+12,y+26,3,(char)205);
 left(x+15,y+24); linhaH(x+12,y+2,15,(char)205); linhaH(x+3,y+5,8,(char)205);
 linhaH(x+3,y+21,2,(char)205); linhaH(x+6,y+30,15,(char)205);
 linhaH(x+22,y+27,4,(char)205); linhaH(x+27,y+30,9,(char)205);
 linhaH(x+31,y+23,5,(char)205); linhaH(x+28,y+11,2,(char)205);
 ponto(x+11,y+2,(char)201); ponto(x+11,y+5,(char)188); ponto(x+2,y+5,(char)201);
 ponto(x+2,y+21,(char)200); ponto(x+5,y+21,(char)187);
 ponto(x+5,y+30,(char)200); ponto(x+21,y+30,(char)188);
 ponto(x+21,y+27,(char)201); ponto(x+26,y+27,(char)187);
 ponto(x+26,y+30,(char)200); ponto(x+36,y+30,(char)188);
 ponto(x+36,y+23,(char)187); ponto(x+30,y+23,(char)200);
 ponto(x+30,y+11,(char)187); ponto(x+27,y+11,(char)200);
 ponto(x+27,y+2,(char)187); escreveMe(x+33,y+24); escreveB(x+12,y+12);
 escreveB(x+12,y+18); escreveB(x+18,y+12); escreveB(x+18,y+18);
 escreveB(x+15,y+15); escreveD(x+12,y+6); escreveD(x+6,y+18);
 escreveD(x+18,y+24); escreveD(x+24,y+12);
 }

void oitavoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 int z;
 *correctos=5;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 posM[0]=8;posM[1]=11;
 destinos[0][0]=2; destinos[0][1]=4; destinos[1][0]=6; destinos[1][1]=2;
 destinos[2][0]=8; destinos[2][1]=6; destinos[3][0]=4; destinos[3][1]=8;
 destinos[4][0]=5; destinos[4][1]=5; matriz[4][4]='c'; matriz[4][6]='c';
 matriz[6][4]='c'; matriz[5][5]='c'; matriz[6][6]='c'; matriz[8][11]='b';
 escreveLinhasH(matriz,0,0,13,'w'); escreveLinhasH(matriz,10,0,13,'w');
 escreveLinhasV(matriz,0,0,11,'w'); escreveLinhasV(matriz,0,12,11,'w');
 for(z=0;z<8;z++)
  escreveLinhasH(matriz,z,10,13,'w');
 escreveLinhasV(matriz,0,9,4,'w'); escreveLinhasH(matriz,2,5,8,'w');
 escreveLinhasH(matriz,8,3,6,'w'); escreveLinhasV(matriz,3,2,6,'w');
 escreveLinhasV(matriz,5,8,8,'w'); escreveLinhasH(matriz,1,1,4,'w');
 escreveLinhasH(matriz,9,7,9,'w'); escreveLinhasV(matriz,7,1,10,'w');
 matriz[3][4]='w'; matriz[4][7]='w'; matriz[6][3]='w'; matriz[7][6]='w';
 }

void nonoE(int x,int y)
 {
 linhaV(x+8,y+3,5,(char)186); linhaV(x+15,y+3,5,(char)186);
 linhaV(x+5,y+9,5,(char)186); linhaV(x+18,y+9,5,(char)186);
 linhaV(x+2,y+15,6,(char)186); linhaV(x+21,y+15,6,(char)186);
 cubo(x+9,y+15); linhaH(x+9,y+2,6,(char)205); linhaH(x+3,y+21,18,(char)205);
 linhaH(x+6,y+8,2,(char)205); linhaH(x+16,y+8,2,(char)205);
 linhaH(x+3,y+14,2,(char)205); linhaH(x+19,y+14,2,(char)205);
 ponto(x+8,y+2,(char)201); ponto(x+8,y+8,(char)188); ponto(x+5,y+8,(char)201);
 ponto(x+5,y+14,(char)188); ponto(x+2,y+14,(char)201);
 ponto(x+2,y+21,(char)200); ponto(x+21,y+21,(char)188);
 ponto(x+21,y+14,(char)187); ponto(x+18,y+14,(char)200);
 ponto(x+18,y+8,(char)187); ponto(x+15,y+8,(char)200);
 ponto(x+15,y+2,(char)187); escreveMe(x+9,y+18); escreveB(x+9,y+12);
 escreveB(x+12,y+9); escreveB(x+12,y+15); escreveB(x+15,y+15);
 escreveD(x+9,y+3); escreveD(x+12,y+3); escreveD(x+12,y+6); escreveD(x+15,y+9);
 }

void nonoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 *correctos=4;
 zeroMatriz(matriz,8,MAXCOLUNAS,'\0');
 posM[0]=6;posM[1]=3;
 destinos[0][0]=1; destinos[0][1]=3; destinos[1][0]=1; destinos[1][1]=4;
 destinos[2][0]=2; destinos[2][1]=4; destinos[3][0]=3; destinos[3][1]=5;
 matriz[3][4]='c'; matriz[4][3]='c'; matriz[5][4]='c'; matriz[5][5]='c';
 matriz[3][6]='b';
 escreveLinhasH(matriz,0,0,8,'w'); escreveLinhasH(matriz,7,0,8,'w');
 escreveLinhasV(matriz,0,0,8,'w'); escreveLinhasV(matriz,0,1,5,'w');
 escreveLinhasV(matriz,0,2,3,'w'); escreveLinhasV(matriz,0,5,3,'w');
 escreveLinhasV(matriz,0,6,5,'w'); escreveLinhasV(matriz,0,7,8,'w');
 matriz[5][3]='w';
 }

void decimoE(int x,int y)
 {
 linhaH(x+2,y+2,20,(char)205); linhaH(x+2,y+18,20,(char)205);
 linhaV(x+2,y+2,17,(char)186); linhaV(x+21,y+2,17,(char)186);
 ponto(x+2,y+2,(char)201); ponto(x+2,y+18,(char)200);
 ponto(x+21,y+18,(char)188); ponto(x+21,y+2,(char)187);
 down(x+9,y+15); ponto(x+9,y+18,(char)188); ponto(x+11,y+18,(char)200);
 ponto(x+10,y+18,' '); up(x+9,y+3); ponto(x+9,y+2,(char)187);
 ponto(x+11,y+2,(char)201); ponto(x+10,y+2,' '); right(x+18,y+9);
 ponto(x+21,y+9,(char)188); ponto(x+21,y+11,(char)187); ponto(x+21,y+10,' ');
 escreveMe(x+3,y+9); escreveB(x+6,y+6);escreveB(x+12,y+9);
 escreveB(x+6,y+9);escreveB(x+15,y+6); escreveB(x+6,y+12);escreveB(x+15,y+12);
 escreveD(x+9,y+6);escreveD(x+12,y+6); escreveD(x+9,y+9);escreveD(x+12,y+12);
 escreveD(x+9,y+12);
 }

void decimoM(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2])
 {
 *correctos=6;
 posM[0]=3;posM[1]=1;
 zeroMatriz(matriz,11,MAXCOLUNAS,'\0');
 destinos[0][0]=2; destinos[0][1]=3; destinos[1][0]=3; destinos[1][1]=3;
 destinos[2][0]=4; destinos[2][1]=3; destinos[3][0]=2; destinos[3][1]=4;
 destinos[4][0]=3; destinos[4][1]=4; destinos[5][0]=4; destinos[5][1]=4;
 matriz[2][2]='c'; matriz[3][2]='c'; matriz[4][2]='c'; matriz[3][4]='c';
 matriz[2][5]='c'; matriz[4][5]='c'; matriz[3][1]='b';
 escreveLinhasH(matriz,0,0,8,'w'); escreveLinhasH(matriz,6,0,8,'w');
 escreveLinhasV(matriz,0,0,7,'w'); escreveLinhasV(matriz,0,7,7,'w');
 matriz[1][3]='w'; matriz[3][6]='w'; matriz[5][3]='w';
 }