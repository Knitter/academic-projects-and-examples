 #pragma hdrstop
#pragma argsused

#include "Arvores.h"
#include "Definicoes.h"
#include "Funcoes.h"
#include "Files.h"
#include "Listas.h"
#include "Visual.h"

int main(int argc, char* argv[])
 {
 int x_temp,z,num_linha_menu1=1,num_linha_menu2=1,num_jogadores=0,num_planetas=0,num_jogadorActual=1,exit_allowed=0;
 char *menu_jogo[MAXLINHAMENU]={"Mover Tropas","Comprar Tropas","Vender Tropas","Listar Posses","Gravar Jogo","Desistir","Passar Jogada","Menu anterior"};
 char *menu_inicial[MAXLINHAMENU]={"Novo Jogo","Continuar Jogo","Sair"};
 T_noS_planetas *planeta_temp=NULL;
 FILE *pF_planetas,*pF_unidades;
 Tarv_soldados *root_soldados=NULL,*soldados_temp=NULL;
 T_player *p_vJogadores;
 time_t clock_time;
 T_noD_soldados *listaDSoldados_top=NULL;
 T_noD_planetas *listaDPlanetas_top=NULL;
 /******************************************************************************/
 clock_time=time(NULL);
 srand(clock_time);
 _setcursortype(_NOCURSOR);
 if((pF_planetas=fopen("Planetas.ter","rt"))!=NULL && (pF_unidades=fopen("Unidades.ter","rt"))!=NULL)
  {
  do
   {
   clrscr();
   num_linha_menu1=menus(menu_inicial,POSX_MENU1,POSY_MENU1,3,VERTICAL_MENU1,HORIZONTAL_MENU1);
   switch(num_linha_menu1)
    {
    case 1:
     clrscr();
     root_soldados=iniciar_jogo(root_soldados,&p_vJogadores,&num_jogadores,&num_planetas,pF_unidades,pF_planetas);
     do
      {
      clrscr();
      p_vJogadores[num_jogadorActual].saldo=contar_Saldo(p_vJogadores[num_jogadorActual].lista_top);
      if(((p_vJogadores[num_jogadorActual].saldo)>0) && (conta_noPlanetas(p_vJogadores[num_jogadorActual].lista_top)>0));
      num_linha_menu2=menus(menu_jogo,POSX_MENU2,POSY_MENU2,8,VERTICAL_MENU2,HORIZONTAL_MENU2);
      fclose(pF_planetas);
      fclose(pF_unidades);
      switch(num_linha_menu2)
       {
       case 1:
        clrscr();
        if(p_vJogadores[num_jogadorActual].num_mov>0)
         {
         for(z=0;z<=num_jogadores;z++)
          listaDPlanetas_top=criarLD_planetas(p_vJogadores[z].lista_top,listaDPlanetas_top);
         mover_tropas(&p_vJogadores,listaDPlanetas_top,num_jogadorActual,num_jogadores);
         libertar_LD_planetas(listaDPlanetas_top);
         listaDPlanetas_top=NULL;
         p_vJogadores[num_jogadorActual].num_mov-=1;
         }
        break;
       case 2:
        if(p_vJogadores[num_jogadorActual].saldo>0)
         {
         clrscr();
         listaDSoldados_top=criarLD_soldadosRecursivo(root_soldados,listaDSoldados_top);
         listaDPlanetas_top=criarLD_planetas(p_vJogadores[num_jogadorActual].lista_top,listaDPlanetas_top);
         planeta_temp=opcao_EscolherPlaneta(5,1,listaDPlanetas_top,TEXTO_ESCOLHER_P1);
         clrscr();
         do
          {
          soldados_temp=opcao_EscolherSoldados(5,1,listaDSoldados_top,14);
          clrscr();
          x_temp=acrescentar_compras(planeta_temp,soldados_temp);
          clrscr();
          }
         while(!x_temp);
         text_box(20,5,1,40,CONFIRMACAO_COMPRA,COR_TEXTO);
         pause();
         libertar_LD_soldados(listaDSoldados_top);
         libertar_LD_planetas(listaDPlanetas_top);
         }
        break;
       case 3:/*Vender Tropas*/
        clrscr();
        listaDPlanetas_top=criarLD_planetas(p_vJogadores[num_jogadorActual].lista_top,listaDPlanetas_top);
        x_temp=vender_tropas(&p_vJogadores[num_jogadorActual],listaDPlanetas_top);
        if(!x_temp)
         text_box(23,7,1,28,CANCEL,COR_GERAL);
        else
         if(x_temp==1)
          text_box(23,7,1,40,VENDAOK,COR_GERAL);
        pause();
        libertar_LD_planetas(listaDPlanetas_top);
        break;
       case 4:/*Listar Posses*/
        clrscr();
        listar_posses(&p_vJogadores[num_jogadorActual]);
        pause();
        break;
       case 5:
        opcao_gravar(num_jogadores,p_vJogadores);
        break;
       case 6:
        p_vJogadores=eliminar_jogador(&p_vJogadores,&num_jogadores,num_jogadorActual);
        if(num_jogadores==0)
         exit_allowed+=1;
        break;
       case 7:
        clrscr();
        passar_jogada(&num_jogadorActual,num_jogadores,&p_vJogadores);
        pause();
        break;
       }
      }
     while(num_linha_menu2!=8);
     break;
    case 2:/*Continuar Jogo*/
     clrscr();
     //continuar_jogo(&p_vJogadores,&num_jogadores);

     pause();
     break;
    }
   }
  while(num_linha_menu1!=3/*!exit_allowed*/);
  }
  else
  {
  text_box(14,10,2,52,ERRO_ABERTURA_FILE,COR_ERRO);
  getchar();
  }
 root_soldados=libertar_arvoreSoldados(root_soldados);
 fclose(pF_planetas);
 fclose(pF_unidades);
 return 0;
 }
