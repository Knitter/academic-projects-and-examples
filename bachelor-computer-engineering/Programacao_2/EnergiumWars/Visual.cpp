#pragma hdrstop
#include "Visual.h"
#pragma package(smart_init)
void tabela_nome(int x,int y,int posicao)
 {
 molduras(x,y,1,35,COR_MOLDURAS);
 textcolor(COR_TEXTO);
 gotoxy(x+1,y+1);
 cprintf("Nome do %d%c jogador (max 15 letras)",posicao,(char)167);
 molduras(x,y+3,1,35,COR_MOLDURAS);
 }

void tabela_batalhoes(int x,int y,T_noDC_batalhoes *lista_top)     
 {
 int num_batalhoes=contarNos_ldBatalhoes(lista_top);
 molduras(x,y,1,30,COR_MOLDURAS);
 frases(x+13,y+1,"Batalhoes",COR_TEXTO);
 molduras(x+32,y,1,10,COR_MOLDURAS);
 frases(x+33,y+1,"Quantidade",COR_TEXTO);
 molduras(x,y+3,num_batalhoes,30,COR_MOLDURAS);
 molduras(x+32,y+3,num_batalhoes,10,COR_MOLDURAS);
 }

void listar_unidades(T_noDC_batalhoes *lista_top)
 {
 T_noDC_batalhoes *aux=lista_top;
 window(38,4,67,24);
 while(aux)
  {
  cprintf("%s",aux->batalhao.p_unit->nome);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 aux=lista_top;
 window(70,5,79,19);
 while(aux)
  {
  cprintf("%d",aux->batalhao.quantidade);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 }

void tabelaPosses(void)
 {
 molduras(1,1,23,3,COR_MOLDURAS);
 window(3,10,3,20);
 frases(2,1,"Posses",COR_TEXTO);
 window(1,1,80,25);
 molduras(69,1,1,10,COR_MOLDURAS);
 frases(70,2,"Quantidade",COR_TEXTO);
 molduras(37,1,1,30,COR_MOLDURAS);
 frases(40,2,"Unidades",COR_TEXTO);
 molduras(6,1,1,29,COR_MOLDURAS);
 frases(10,2,"Planetas",COR_TEXTO);
 molduras(6,4,20,29,COR_MOLDURAS);
 molduras(37,4,20,30,COR_MOLDURAS);
 molduras(69,4,20,10,COR_MOLDURAS);
 }

void tabela_escolherPlaneta(int x,int y,T_noD_planetas *lista_top,char *texto)
 {
 int flag=0;
 molduras(x+4,1,1,66,COR_MOLDURAS);
 frases(x+24,2,texto,COR_TEXTO);
 molduras(x+4,4,20,15,COR_MOLDURAS);
 molduras(x+21,4,20,15,COR_MOLDURAS);
 molduras(x+38,4,20,15,COR_MOLDURAS);
 molduras(x+55,4,20,15,COR_MOLDURAS);
 window(x+7,y+4,x+15,y+24);
 while(flag!=20 && lista_top)
  {
  if(lista_top)
   {
   cprintf("%s\r\n",lista_top->p_lPlanetas->planeta.nome);
   lista_top=lista_top->prox;
   }
  flag+=1;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 window(x+24,y+4,x+39,y+24);
 while(flag!=40 && lista_top)
  {
  if(lista_top)
   {
   cprintf("%s\r\n",lista_top->p_lPlanetas->planeta.nome);
   lista_top=lista_top->prox;
   }
  flag+=1;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 window(x+41,y+4,x+54,y+24);
 while(flag!=60 && lista_top)
  {
  if(lista_top)
   {
   cprintf("%s\r\n",lista_top->p_lPlanetas->planeta.nome);
   lista_top=lista_top->prox;
   }
  flag+=1;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 window(x+58,y+4,x+69,y+24);
 while(flag!=80 && lista_top)
  {
  if(lista_top)
   {
   cprintf("%s\r\n",lista_top->p_lPlanetas->planeta.nome);
   lista_top=lista_top->prox;
   }
  flag+=1;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 }

void tabela_passarJogada(void)
 {
 molduras(14,10,1,50,COR_MOLDURAS);
 frases(31,11,"Proximo Jogador",COR_TEXTO);
 molduras(14,13,1,50,COR_MOLDURAS);
 }

void tabela_comprar(int x,int y,int max,T_noD_soldados *lista_top)
 {
 T_noD_soldados *aux=lista_top;
 molduras(x,y,1,y+39,COR_MOLDURAS);
 frases(x+10,y+1,"Unidades",COR_GERAL),
 molduras(x+42,y,1,6,COR_MOLDURAS);
 frases(x+43,y+1,"Ataque",COR_GERAL),
 molduras(x+50,y,1,6,COR_MOLDURAS);
 frases(x+51,y+1,"Defesa",COR_GERAL);
 molduras(x+58,y,1,5,COR_MOLDURAS);
 frases(x+59,y+1,"Preco",COR_GERAL);
 window(x+4,y+4,x+49,y+4+max);
 textcolor(COR_RESET);
 while(aux)
  {
  cprintf("%s\r\n",aux->p_rSoldados->soldado.nome);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 aux=lista_top;
 window(x+43,y+4,x+48,y+4+max);
 while(aux)
  {
  cprintf("%5d\n\r",aux->p_rSoldados->soldado.ataque);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 aux=lista_top;
 window(x+51,y+4,x+56,y+4+max);
 while(aux)
  {
  cprintf("%5d\n\r",aux->p_rSoldados->soldado.defesa);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 aux=lista_top;
 window(x+58,y+4,x+63,y+4+max);
 while(aux)
  {
  cprintf("%5d\n\r",aux->p_rSoldados->soldado.preco);
  aux=aux->prox;
  }
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 molduras(x,y+3,max,40,COR_MOLDURAS);
 molduras(x+42,y+3,max,6,COR_MOLDURAS);
 molduras(x+50,y+3,max,6,COR_MOLDURAS);
 molduras(x+58,y+3,max,5,COR_MOLDURAS);
 }

void apresentar_menus(char *menus[],int x,int y,int num_linhas,int cor)
 {
 int z;
 for(z=0;z<num_linhas;z++)
  frases(x,y+z,menus[z],cor);
 }

void frases(int x,int y,char *texto,int cor)
 {
 textcolor(cor);
 gotoxy(x,y);
 cprintf("%s",texto);
 }

void molduras(int x,int y,int vertical,int horizontal,int cor)
 {
 ponto(x,y,(char)201,cor);
 linhaH(x+1,y,horizontal,(char)205,cor);
 ponto(x+horizontal+1,y,(char)187,cor);
 linhaV(x,y+1,vertical,(char)186,cor);
 linhaV(x+horizontal+1,y+1,vertical,(char)186,cor);
 ponto(x,y+vertical+1,(char)200,cor);
 linhaH(x+1,y+vertical+1,horizontal,(char)205,cor);
 ponto(x+horizontal+1,y+vertical+1,(char)188,cor);
 }

void text_box(int x,int y,int vertical,int horizontal,char *texto,int cor)
 {
 molduras(x,y,vertical,horizontal,cor);
 window(x+1,y+1,x+horizontal,y+vertical);
 textcolor(7);
 cprintf("%s",texto);
 window(1,1,VIDEO_COLUNAS,VIDEO_LINHAS);
 }

void ponto(int x,int y,char caract,int cor)
 {
 textcolor(cor);
 gotoxy(x,y);
 cprintf("%c",caract);
 }

void linhaV(int x,int y,int fim,char caract,int cor)
 {
 int z;
 textcolor(cor);
 for(z=0;z<fim;z++)
  {
  gotoxy(x,y+z);
  cprintf("%c",caract);
  }
 }

void linhaH(int x,int y,int fim,char caract,int cor)
 {
 int z;
 textcolor(cor);
 gotoxy(x,y);
 for(z=0;z<fim;z++)
  cprintf("%c",caract);
 }

void creditos(int x,int y,char versao[])
 {
 clrscr();
 gotoxy(x,y);
 printf("Versao %s",versao);
 gotoxy(x,y+1);
 printf("(C)opyright, (C)opyleft, (C)opymidle 2003 Knitter Inc.");
 getchar();
 }
