#pragma hdrstop
#include "Funcoes.h"
#pragma package(smart_init)
T_player *pesquisarOwner_nome(char *nome,T_player *p_vJogadores,int num_jogadores)
 {
 int z;
 for(z=0;z<num_jogadores;z++)
  if((stricmp(nome,p_vJogadores[z].nome))==0)
   return &p_vJogadores[z];
 free(nome);
 return NULL;
 }

void perguntarNomes(int x,int y,T_player **p_vJogadores,int num_jogadores)
 {
 int z,strlen_aux=0;
 char aloc_aux[30];
 for(z=1;z<num_jogadores+1;z++)
  {
  do
   {
   clrscr();
   tabela_nome(x,y,z);
   fflush(stdin);
   gotoxy(x+1,y+4);
   gets(aloc_aux);
   strlen_aux=strlen(aloc_aux)+1;
   }
  while(strlen_aux>MAXNOMES);
  (*p_vJogadores)[z].nome=strdup(aloc_aux);
  }
 }

T_batalhao *escolher_batalhao(int x,int y,T_noDC_batalhoes *lista_top)
 {
 int linha=1,linha_max=contarNos_ldBatalhoes(lista_top),pos_x=x+4,pos_y=y+4;
 char opc;
 T_noDC_batalhoes *no_actual=lista_top;
 tabela_batalhoes(x,y,lista_top);
 ponto(x+2,pos_y,CURSORTYPE,COR_GERAL);
 frases(pos_x,pos_y,no_actual->batalhao.p_unit->nome,COR_GERAL);
 do
  {
  switch((opc=ler_teclaMenu()))
   {
   case UP:
    if(linha>0)
     {
     ponto(x+2,pos_y,CURSOR_RESET,COR_RESET);
     frases(pos_x,pos_y,no_actual->batalhao.p_unit->nome,COR_RESET);
     no_actual=no_actual->ant;
     ponto(x+2,pos_y-=1,CURSORTYPE,COR_GERAL);
     frases(pos_x,pos_y,no_actual->batalhao.p_unit->nome,COR_TEXTO);
     }
    break;
   case DOWN:
    if(linha<linha_max)
     {
     ponto(x+2,pos_y,CURSOR_RESET,7);
     frases(pos_x,pos_y,no_actual->batalhao.p_unit->nome,COR_RESET);
     no_actual=no_actual->prox;
     ponto(x+2,pos_y+=1,CURSORTYPE,COR_GERAL);
     frases(pos_x,pos_y,no_actual->batalhao.p_unit->nome,COR_TEXTO);
     }
    break;
   }
  }
 while(opc!='\r');
 return &no_actual->batalhao;
 }

int vender_tropas(T_player *p_jogador,T_noD_planetas *lista_planetas)
 {
 int quantidade=0;
 T_noS_planetas *planeta_escolhido=NULL;
 T_batalhao *batalhao_venda;
 clrscr();
 if(p_jogador->lista_top)
  {
  planeta_escolhido=opcao_EscolherPlaneta(1,1,lista_planetas,TEXTO_ESCOLHER_P2);
  if(planeta_escolhido->planeta.lista_top)
   {
   clrscr();
   batalhao_venda=escolher_batalhao(1,1,p_jogador->lista_top->planeta.lista_top);
   clrscr();
   cprintf("indique quantidade de unidades do batalhao de %s que pretende vender ou zero para anular",batalhao_venda->p_unit->nome);
   quantidade=ler_valor(0,batalhao_venda->quantidade,"");
   if(quantidade)
    {
    p_jogador->saldo+=quantidade*batalhao_venda->p_unit->preco*VALOR_VENDA;
    batalhao_venda->quantidade-=quantidade;
    if(!batalhao_venda->quantidade)
     p_jogador->lista_top->planeta.lista_top=removerBatalhao_LDC(p_jogador->lista_top->planeta.lista_top,batalhao_venda);
    return 1;
    }
   return 0;
   }
  }
  return -1;
 }

void listar_posses(T_player *jogador)                                 /*(1)(2)*/
 {
 tabelaPosses();

 }

void mover_tropas(T_player **p_vJogadores,T_noD_planetas *listaDPlanetas_top,int num_jogadorActual,int num_jogadores)
 {
 int z,vencedor;
 T_noS_planetas *origem=NULL,*destino=NULL;
 T_batalhao *batalhao_movel=NULL;
 T_noD_planetas *planetasD_temp=NULL;
 planetasD_temp=criarLD_planetas((*p_vJogadores)[num_jogadorActual].lista_top,planetasD_temp);
 origem=opcao_EscolherPlaneta(1,1,planetasD_temp,TEXTO_ESCOLHER_P2);
 clrscr();
 batalhao_movel=escolher_batalhao(7,5,origem->planeta.lista_top);
 clrscr();
 destino=opcao_EscolherPlaneta(1,1,listaDPlanetas_top,TEXTO_ESCOLHER_P1);
 if((stricmp(destino->planeta.p_owner->nome,(*p_vJogadores)[0].nome)==0))
  {
  (*p_vJogadores)[num_jogadorActual].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[num_jogadorActual].lista_top,&destino->planeta);
  (*p_vJogadores)[0].lista_top=removerPlanetas_meio((*p_vJogadores)[0].lista_top,&destino->planeta);
  (*p_vJogadores)[num_jogadorActual].lista_top->planeta.p_owner=&(*p_vJogadores)[num_jogadorActual];
  acresentarBatalhao_movel(destino,batalhao_movel);
  clrscr();
  text_box(15,7,1,44,"Batalhoes movidos sem problemas de maior",COR_TEXTO);
  pause();
  }
 else
  {
  if((stricmp(destino->planeta.p_owner->nome,(*p_vJogadores)[num_jogadorActual].nome)==0))
   acresentarBatalhao_movel(destino,batalhao_movel);
  else
   for(z=1;z<=num_jogadores;z++)
    if(z!=num_jogadorActual)
     if(stricmp((*p_vJogadores)[z].lista_top->planeta.p_owner->nome,destino->planeta.p_owner->nome)==0);
      {
      vencedor=batalha(batalhao_movel,destino->planeta.lista_top);
      if(vencedor)
       {
       clrscr();
       text_box(15,7,3,44,BATALHA_PAUSE,COR_TEXTO);
       pause();
       (*p_vJogadores)[num_jogadorActual].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[num_jogadorActual].lista_top,&destino->planeta);
       destino->planeta.p_owner->lista_top=removerPlanetas_meio(destino->planeta.p_owner->lista_top,&destino->planeta);
       destino->planeta.p_owner=&(*p_vJogadores)[num_jogadorActual];
       acresentarBatalhao_movel(destino,batalhao_movel);
       text_box(13,7,6,49,BATALHA_GANHA,COR_TEXTO);
       pause();
       }
      else
       {
       text_box(10,7,5,60,BATALHA_PERDIDA,COR_TEXTO);
       pause();
       }
      }
  }
 libertar_LD_planetas(planetasD_temp);
 }

void acresentarBatalhao_movel(T_noS_planetas *destino,T_batalhao *batalhao)
 {
 destino->planeta.lista_top=inserirBatalhoes_ordenadamenteLDC(destino->planeta.lista_top,*batalhao);
 free(batalhao);
 }

int acrescentar_compras(T_noS_planetas *destino,Tarv_soldados *compras)
 {
 int quantidade=0;
 T_batalhao batalhao_temp;
 textcolor(COR_TEXTO);
 cprintf("Indique a quantidade de %s que deseja comprar ou introduza zero para anular)\n\n\r: ",compras->soldado.nome);
 quantidade=ler_valor(0,MAXUNIDADES_BATALHAO,"");
 if(quantidade)
  {
  if((destino->planeta.p_owner->saldo)<(compras->soldado.preco*quantidade))
   return 0;
  destino->planeta.p_owner->saldo-=compras->soldado.preco*quantidade;
  batalhao_temp.p_unit=&compras->soldado;
  batalhao_temp.quantidade=quantidade;
  destino->planeta.lista_top=inserirBatalhoes_ordenadamenteLDC(destino->planeta.lista_top,batalhao_temp);
  }
 return 1;
 }

T_noS_planetas *opcao_EscolherPlaneta(int x,int y,T_noD_planetas *lista_top,char *texto)
 {
 char opc;
 int linha_actual=1,pos_x=x+5,pos_y=y+4,max=20,min=1,n_nos=contar_nosLDPlanetas(lista_top);
 int max1=20,max2=40,max3=60,max4=80;
 T_noD_planetas *no_actual=lista_top;
 tabela_escolherPlaneta(x,y,lista_top,texto);
 ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
 if(n_nos<80)
  (n_nos<20)?max1=n_nos:(n_nos<40?max2=n_nos:(n_nos<60?max3=n_nos:max4=n_nos));
 do
  {
  switch((opc=ler_teclaMenu()))
   {
   case UP:
    if(linha_actual>1)
     {
     if(linha_actual>min)
      {
      ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
      ponto(pos_x,pos_y-=1,CURSORTYPE,COR_GERAL);
      }
     linha_actual-=1;
     switch(linha_actual)
      {
      case 20:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=pos_x-17;pos_y=pos_y+19;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       min=1;
       max=max1;
       break;
      case 40:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=pos_x-17;pos_y=pos_y+19;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       min=21;
       max=max2;
       break;
      case 60:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=pos_x-17;pos_y=pos_y+19;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       min=41;
       max=max3;
       break;
      }
     }
     break;
   case DOWN:
    if(linha_actual<80)
     {
     if(linha_actual<max)
      {
      ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
      ponto(pos_x,pos_y+=1,CURSORTYPE,COR_GERAL);
      }
     linha_actual+=1;
     switch(linha_actual)
      {
      case 21:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=x+22;pos_y=y+4;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       max=max2;
       min=21;
       break;
      case 41:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=x+39;pos_y=y+4;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       max=max3;
       min=41;
       break;
      case 61:
       ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
       pos_x=x+56;pos_y=y+4;
       ponto(pos_x,pos_y,CURSORTYPE,COR_GERAL);
       max=max4;
       min=61;
      }
     }
    break;
   }
  }
 while(opc!='\r');
 return no_actual->p_lPlanetas;
 }

void passar_jogada(int *num_jogadorActual,int num_jogadores,T_player **p_vJogadores)
 {
 tabela_passarJogada();
 (*p_vJogadores)[(*num_jogadorActual)].num_mov+=1;
 (*num_jogadorActual)+=1;
 if((*num_jogadorActual)>num_jogadores)
  (*num_jogadorActual)=1;
 frases(16,14,(*p_vJogadores)[(*num_jogadorActual)].nome,COR_TEXTO);
 }

Tarv_soldados *opcao_EscolherSoldados(int x,int y,T_noD_soldados *lista_top,int num_unidades)
 {
 char opc;
 T_noD_soldados *no_actual=lista_top;
 int pos_x=x+4,pos_y=y+4;
 tabela_comprar(x,y,num_unidades,lista_top);
 ponto(x+2,pos_y,CURSORTYPE,COR_GERAL);
 frases(pos_x,pos_y,no_actual->p_rSoldados->soldado.nome,COR_GERAL);
 do
  {
  switch((opc=ler_teclaMenu()))
   {
   case UP:
    if(no_actual->ant)
     {
     ponto(x+2,pos_y,CURSOR_RESET,COR_RESET);
     frases(pos_x,pos_y,no_actual->p_rSoldados->soldado.nome,COR_RESET);
     ponto(x+2,pos_y-=1,CURSORTYPE,COR_GERAL);
     no_actual=no_actual->ant;
     frases(pos_x,pos_y,no_actual->p_rSoldados->soldado.nome,COR_TEXTO);
     }
     break;
   case DOWN:
    if(no_actual->prox)
     {
     ponto(x+2,pos_y,CURSOR_RESET,7);
     frases(pos_x,pos_y,no_actual->p_rSoldados->soldado.nome,COR_RESET);
     ponto(x+2,pos_y+=1,CURSORTYPE,COR_GERAL);
     no_actual=no_actual->prox;
     frases(pos_x,pos_y,no_actual->p_rSoldados->soldado.nome,COR_TEXTO);
     }
    break;
   }
  }
 while(opc!='\r');
 return no_actual->p_rSoldados;
 }

char ler_teclaMenu(void)
 {
 char opc;
 fflush(stdin);
 opc=getch();
  if(opc==0)
   opc=getch();
 return opc;
 }

int contar_Saldo(T_noS_planetas *lista_top)
 {
 return contarRentabilidade_lsPlanetas(lista_top)-contarDespesas(lista_top);
 }

int batalha(T_batalhao *atacante,T_noDC_batalhoes *lista_defensora)
 {
 int z,F_atacante=0,F_embate=0,F_destruida=0;
 F_atacante=atacante->quantidade*atacante->p_unit->ataque;
 while(atacante && lista_defensora)
  {
  for(z=0;z<lista_defensora->batalhao.quantidade;z++)
   {
   if(lista_defensora)
    {
    F_embate=F_atacante-lista_defensora->batalhao.p_unit->defesa;
    if(F_embate>=0)
     lista_defensora->batalhao.quantidade-=1;
    }
   }
  if(lista_defensora->batalhao.quantidade==0)
   lista_defensora=removerBatalhoes_inicioLDC(lista_defensora);
  if(F_embate<=0)
   {
   free(atacante);
   atacante=NULL;
   return 0;
   }
  else
   {
   F_destruida=F_atacante-F_embate;
   while(F_destruida>=F_atacante)
    {
    F_destruida=F_destruida-atacante->p_unit->ataque;
    atacante->quantidade-=1;
    }
   }
  if(!lista_defensora)
   break;
  lista_defensora=lista_defensora->prox;
  }
 return 1;
 }

void anular_listaPlanetas(T_player **p_vJogadores,int num_jogadores)
 {
 int z;
 for(z=1;z<num_jogadores;z++)
  (*p_vJogadores)[z].lista_top=NULL;
 }


void continuar_jogo(T_player **p_vJogadores,int *num_jogadores)          /*(2)*/
 {
 int error;
 char nomeGameLoaded[255]={'\0'},lixo;
 FILE *pF_load;
 do
  {
  error=0;
  clrscr();
  molduras(13,9,1,50,COR_MOLDURAS);
  frases(14,10,"Indique o nome do ficheiro a carregar...",COR_TEXTO);
  molduras(13,13,1,50,COR_MOLDURAS);
  frases(14,14,": ",COR_TEXTO);
  fflush(stdin);
  gotoxy(16,14);
  gets(nomeGameLoaded);
  if((strlen(nomeGameLoaded)+1)>NOMEMAX_FILE || (validar_nomeSaveGame(nomeGameLoaded))==0)
   {
   clrscr();
   text_box(15,11,3,49,ERRO_NOME_FILE,COR_ERRO);
   fflush(stdin);
   getch();
   error+=1;
   }
  else
   {
   strcpy(nomeGameLoaded,strcat(nomeGameLoaded,EXTENCAO_BINARIA));
   if((pF_load=fopen(nomeGameLoaded,"rb"))!=NULL)
    carregar_jogo(p_vJogadores,num_jogadores,pF_load);
   else
    {
    clrscr();
    text_box(15,11,1,49,ERRO_CARREGAR2,COR_ERRO);
    error+=1;
    fflush(stdin);
    getchar();
    clrscr();
    molduras(10,11,1,58,COR_MOLDURAS);
    frases(11,12,TEXTO_NOVA_TENTATIVA,COR_TEXTO);
    fflush(stdin);
    if('s'==(char)tolower(getch()))
     error=0;
    }
   }
  }
 while(error);
 fclose(pF_load);
 }

void opcao_gravar(int num_jogadores,T_player *p_vJogadores)
 {
 int error;
 char nomeGameSaved[255]={'\0'};
 FILE *pF_save;
 do
  {
  clrscr();
  error=0;
  molduras(5,10,1,70,COR_MOLDURAS);
  frases(25,11,"Guardar o ficheiro como?",COR_TEXTO);
  molduras(5,13,1,70,COR_MOLDURAS);
  frases(6,14,":",COR_TEXTO);
  fflush(stdin);
  gotoxy(8,14);
  gets(nomeGameSaved);
  clrscr();
  if((strlen(nomeGameSaved)+1)>NOMEMAX_FILE || (validar_nomeSaveGame(nomeGameSaved))==0)
   {
   clrscr();
   text_box(15,11,3,49,ERRO_NOME_FILE,COR_ERRO);
   fflush(stdin);
   getchar();
   error+=1;
   }
  else
   {
   strcpy(nomeGameSaved,strcat(nomeGameSaved,EXTENCAO_BINARIA));
   if((pF_save=fopen(nomeGameSaved,"wb"))!=NULL)
    {
    gravar_jogo(num_jogadores,p_vJogadores,pF_save);
    text_box(20,13,1,25,NOERRO_GUARDAR,COR_OK);
    getchar();
    }
   else
    {
    text_box(23,13,1,30,ERRO_GUARDAR,COR_ERRO);
    getchar();
    exit(1);
    }
   }
  }
 while(error);
 fclose(pF_save);
 exit(0);
 }

Tarv_soldados *iniciar_jogo(Tarv_soldados *root_soldados,T_player **p_vJogadores,int *num_jogadores,int *num_planetas,FILE *pF_unidades,FILE *pF_planetas)
 {
 int z,sorte,num_planetasAux;
 T_batalhao batalhao_inicial;
 T_planeta *p_vPlanetas;
 T_noS_planetas *planeta_sorteado=NULL;
 Tarv_soldados *menor;
 T_noS_planetas *aux;
 batalhao_inicial.quantidade=1;
 root_soldados=criarArvore_ficheiroSoldados(root_soldados,pF_unidades);
 menor=root_soldados;
 pesquisarForcaMenor_arvoreSoldados(root_soldados,&menor);
 batalhao_inicial.quantidade=1;
 batalhao_inicial.p_unit=&menor->soldado;
 num_planetasAux=(*num_planetas)=ler_FilePlanetas(&p_vPlanetas,pF_planetas);
 if((*num_planetas))
  {
  text_box(1,1,2,25,"Qual o nr. de jogadores?\n\r",COR_TEXTO);
  gotoxy(3,3);
  (*num_jogadores)=ler_valor(MINPLAYERS,MAXPLAYERS,": ");
  (*p_vJogadores)=alocar_jogadores((*num_jogadores)+1);
  perguntarNomes(1,1,p_vJogadores,(*num_jogadores));
  (*p_vJogadores)[0].nome=strdup("Natureza");
  anular_listaPlanetas(p_vJogadores,(*num_jogadores)+1);
  for(z=0;z<(*num_planetas);z++)
   (*p_vJogadores)[0].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[0].lista_top,&(p_vPlanetas[z]));
  aux=(*p_vJogadores)[0].lista_top;
  while(aux)
   {
   aux->planeta.p_owner=&(*p_vJogadores)[0];
   aux=aux->prox;
   }
  for(z=1;z<=(*num_jogadores);z++)
   {
   sorte=aleatorio(num_planetasAux);
   planeta_sorteado=percorrer_lsPlanetasAte((*p_vJogadores)[0].lista_top,sorte+1);
   (*p_vJogadores)[z].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[z].lista_top,&planeta_sorteado->planeta);
   (*p_vJogadores)[0].lista_top=removerPlanetas_meio((*p_vJogadores)[0].lista_top,&planeta_sorteado->planeta);
   (*p_vJogadores)[z].lista_top->planeta.p_owner=&(*p_vJogadores)[z];
   (*p_vJogadores)[z].lista_top->planeta.lista_top=inserirBatalhoes_ordenadamenteLDC((*p_vJogadores)[z].lista_top->planeta.lista_top,batalhao_inicial);
   (*p_vJogadores)[z].num_mov=1;
   (*p_vJogadores)[z].saldo=contar_Saldo((*p_vJogadores)[z].lista_top);
   num_planetasAux-=1;

   }
  for(z=0;z<(*num_planetas);z++)
   free(p_vPlanetas[z].nome);
  free(p_vPlanetas);
  }
 else
  {
  text_box(10,10,5,52,ERRO_DESCONHECIDO,COR_ERRO);
  getchar();
  exit(0);
  }
 return root_soldados;
 }

int validar_nomeSaveGame(char *nome_validar)
 {
 return strpbrk(nome_validar,CARCTERES_INVALIDOS)==NULL;
 }

void copiar_jogador(T_player **p_vJogadores,int origem,int destino)
 {
 (*p_vJogadores)[destino].saldo=(*p_vJogadores)[origem].saldo;
 (*p_vJogadores)[destino].num_mov=(*p_vJogadores)[origem].num_mov;
 (*p_vJogadores)[destino].lista_top=(*p_vJogadores)[origem].lista_top;
 }

void libertar_jogador(T_player *jogador)
 {
 free(jogador->nome);
 libertar_lsPlanetas(jogador->lista_top);
 free(jogador);
 }

T_player *eliminar_jogador(T_player **p_vJogadores,int *num_jogadores,int jogador_eliminar)
 {
 T_noS_planetas *aux;
 if(strcmp((*p_vJogadores)[jogador_eliminar].nome,(*p_vJogadores)[(*num_jogadores)].nome)==0)
  { /*é ultimo*/
  while(aux!=NULL)
  {
  (*p_vJogadores)[0].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[0].lista_top,&aux->planeta);
   aux=aux->prox;
  }
  libertar_jogador(&(*p_vJogadores)[jogador_eliminar]);
  }
 else
  {/*nao é ultimo*/
  copiar_jogador(p_vJogadores,(*num_jogadores),jogador_eliminar);
  aux=(*p_vJogadores)[(*num_jogadores)].lista_top;
  while(aux!=NULL)
   {
   (*p_vJogadores)[0].lista_top=inserir_planetasOrdenadamente((*p_vJogadores)[0].lista_top,&aux->planeta);
   aux=aux->prox;
   }
  libertar_jogador(&(*p_vJogadores)[(*num_jogadores)]);
  }
 (*num_jogadores)-=1;
 return (T_player *)realloc((*p_vJogadores),(*num_jogadores));
 }

T_player *alocar_jogadores(int tamanho)
 {
 return (T_player *)malloc(sizeof(T_player)*tamanho);
 }

Tarv_soldados *alocar_arvSoldados(int tamanho)
 {
 return (Tarv_soldados *)malloc(sizeof(Tarv_soldados)*tamanho);
 }

int menus(char *menu[],int x,int y,int linha_max,int vertical,int horizontal)
 {
 char opc;
 int linha_actual=1,pos_x=x+1,pos_y=y+1;
 molduras(x,y,vertical,horizontal,COR_MOLDURAS);
 ponto(x+1,y+1,CURSORTYPE,COR_GERAL);
 apresentar_menus(menu,x+3,y+1,linha_max,COR_RESET);
 frases(x+3,y+1,menu[0],2);
 do
  {
  switch((opc=ler_teclaMenu()))
   {
   case UP:
    if(linha_actual>1)
     {
     ponto(pos_x,pos_y,CURSOR_RESET,COR_RESET);
     ponto(pos_x,pos_y-=1,CURSORTYPE,COR_GERAL);
     linha_actual-=1;
     frases(pos_x+2,pos_y,menu[linha_actual-1],COR_GERAL);
     frases(pos_x+2,pos_y+1,menu[linha_actual],COR_RESET);
     }
    break;
   case DOWN:
    if(linha_actual<linha_max)
     {
     ponto(pos_x,pos_y,CURSOR_RESET,7);
     ponto(pos_x,pos_y+=1,CURSORTYPE,COR_GERAL);
     linha_actual+=1;
     frases(pos_x+2,pos_y,menu[linha_actual-1],COR_GERAL);
     frases(pos_x+2,pos_y-1,menu[linha_actual-2],COR_RESET);
     }
    break;
   }
  }
 while(opc!='\r');
 return linha_actual;
 }

T_planeta *alocar_planeta(int tamanho)
 {
 return (T_planeta *)malloc(tamanho*sizeof(T_planeta));
 }

T_soldado *alocar_soldado(int tamanho)
 {
 return (T_soldado *)malloc(tamanho*sizeof(T_soldado));
 }

char *alocar_nome(int tamanho)
 {
 return (char *)malloc(tamanho*sizeof(char));
 }

int aleatorio(int max)
 {
 return rand()%max;
 }

void pause(void)
 {
 fflush(stdin);
 getch();
 }

int ler_valor(int min,int max,char *text)
 {
 int temp;
 do
  {
  printf("%s",text);
  fflush(stdin);
  scanf("%d",&temp);
  }
 while(temp<min || temp>max);
 return temp;
 }


