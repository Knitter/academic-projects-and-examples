#pragma hdrstop
#include "Listas.h"
#pragma package(smart_init)

int contarDespesas(T_noS_planetas *lista_top)
 {
 int despesa=0;
 T_noDC_batalhoes *aux;
 if(lista_top && lista_top->planeta.lista_top)
  {
  aux=lista_top->planeta.lista_top;  /*(?)*/
  while(lista_top!=NULL)
   {
   do
    {
    despesa+=(lista_top->planeta.lista_top->batalhao.quantidade*(lista_top->planeta.lista_top->batalhao.p_unit->preco*VALOR_VENDA));
    lista_top->planeta.lista_top=lista_top->planeta.lista_top->prox;
    }
   while(lista_top->planeta.lista_top!=aux);
   lista_top=lista_top->prox;
   }
  }
 return despesa;
 }

/*******************************Listas Simples**********************************/
T_noS_planetas *inserir_planetasOrdenadamente(T_noS_planetas *lista_top,T_planeta *planeta)
 {
 T_noS_planetas *anterior=pesquisar_Planetas(lista_top,planeta),*novo;
 if(anterior)
  {
  novo=criar_noPlanetas(planeta);
  novo->prox=anterior->prox;
  anterior->prox=novo;
  }
 else
  lista_top=inserirPlanetas_inicio(lista_top,planeta);
 return lista_top;
 }

T_noS_planetas *percorrer_lsPlanetasAte(T_noS_planetas *lista_top,int stop)
 {
 int flag=1;
 if(lista_top)
  {
  while(stop!=flag && lista_top)
   {
   lista_top=lista_top->prox;
   flag+=1;
   }
  }
 return lista_top;
 }

int contarRentabilidade_lsPlanetas(T_noS_planetas *lista_top)
 {
 int rentabilidade=0;
 if(lista_top)
  while(lista_top!=NULL)
   {
   rentabilidade+=lista_top->planeta.rentabilidade;
   lista_top=lista_top->prox;
   }
 return rentabilidade;
 }

T_noS_planetas *criar_noPlanetas(T_planeta *planeta)
 {
 T_noS_planetas *novo=(T_noS_planetas *)malloc(sizeof(T_noS_planetas));
 novo->planeta.nome=strdup(planeta->nome);
 novo->planeta.rentabilidade=planeta->rentabilidade;
 novo->planeta.lista_top=NULL;
 novo->planeta.p_owner=NULL;
 novo->prox=NULL;
 return novo;
 }

T_noS_planetas *inserirPlanetas_inicio(T_noS_planetas *lista_top,T_planeta *planeta)
 {
 T_noS_planetas *a_inserir;
 a_inserir=criar_noPlanetas(planeta);
 a_inserir->prox=lista_top;
 lista_top=a_inserir;
 return lista_top;
 }

T_noS_planetas *inserirPlanetas_fim(T_noS_planetas *lista_top,T_planeta *planeta)
 {
 T_noS_planetas *ultimo=lista_top,*a_inserir;
 if(lista_top==NULL)
  {
  lista_top=inserirPlanetas_inicio(lista_top,planeta);
  return lista_top;
  }
 while(ultimo->prox!=NULL)
  ultimo=ultimo->prox;
 a_inserir=criar_noPlanetas(planeta);
 ultimo->prox=a_inserir;
 return lista_top;
 }

T_noS_planetas *removerPlanetas_inicio(T_noS_planetas *lista_top)
 {
 T_noS_planetas *aux=lista_top;
 if(lista_top!=NULL)
  {
  lista_top=lista_top->prox;
  free(aux->planeta.nome);
  free(aux);
  }
 return lista_top;
 }

T_noS_planetas *removerPlanetas_fim(T_noS_planetas *lista_top)
 {
 T_noS_planetas *penultimo;
 if(lista_top==NULL)
  return lista_top;
 if(lista_top->prox==NULL)
  {
  lista_top=removerPlanetas_inicio(lista_top);
  return lista_top;
  }
 penultimo=lista_top;
 while(penultimo->prox->prox!=NULL)
  penultimo=penultimo->prox;
 free(penultimo->prox->planeta.nome);
 free(penultimo->prox);
 penultimo->prox=NULL;
 return lista_top;
 }

void libertar_lsPlanetas(T_noS_planetas *lista_top)
 {
 T_noS_planetas *aux;
 while(lista_top!=NULL)
  {
  aux=lista_top;
  lista_top=lista_top->prox;
  free(aux->planeta.nome);
  libertar_ldBatalhoes(aux->planeta.lista_top);
  aux->planeta.p_owner=NULL;
  free(aux);
  }
 }

void percorrer_lsPlanetas(T_noS_planetas *lista_top,int cor)
 {
 if(lista_top==NULL)
  printf("\nLista vazia");
 else
  while(lista_top!=NULL)
   {
   cprintf("%s\n\r",lista_top->planeta.nome);
   lista_top=lista_top->prox;
   }
 }

int conta_noPlanetas(T_noS_planetas *lista_top)
 {
 int conta=0;
 while(lista_top!=NULL)
  {
  conta++;
  lista_top=lista_top->prox;
  }
 return conta;
 }

T_noS_planetas *pesquisar_Planetas(T_noS_planetas *lista_top,T_planeta *planeta)
 {
 T_noS_planetas *no_anterior=lista_top;
 if((lista_top==NULL) || ((stricmp(planeta->nome,lista_top->planeta.nome))<=0))
  return NULL;
 while((no_anterior->prox!=NULL) && ((stricmp(planeta->nome,no_anterior->prox->planeta.nome))>0))
  no_anterior=no_anterior->prox;
 return no_anterior;
 }

T_noS_planetas *consultar_lsPlanetas(T_noS_planetas *lista_top,char *nome)
 {
 T_noS_planetas *aux=lista_top;
 if(lista_top==NULL)
  return lista_top;
 while(aux!=NULL && stricmp(aux->planeta.nome,nome)!=0)
  aux=aux->prox;
 return aux;
 }

T_noS_planetas *removerPlanetas_meio(T_noS_planetas *lista_top,T_planeta *planeta)
 {
 T_noS_planetas *no_anterior=pesquisar_Planetas(lista_top,planeta),*aux;
 if(lista_top!=NULL)
  {
  if(no_anterior==NULL)
   {
   if(stricmp(planeta->nome,lista_top->planeta.nome)==0)
    lista_top=removerPlanetas_inicio(lista_top);
   }
  else
   if(stricmp(planeta->nome,no_anterior->prox->planeta.nome)==0)
    {
    aux=no_anterior->prox;
    no_anterior->prox=aux->prox;
    free(aux->planeta.nome);
    free(aux);
    }
  }
 return lista_top;
 }
/*******************************Listas Duplas**********************************/
int contar_nosLDPlanetas(T_noD_planetas *lista_top)
 {
 int conta=0;
 while(lista_top)
  {
  conta+=1;
  lista_top=lista_top->prox;
  }
 return conta;
 }

T_noD_planetas *criarLD_planetas(T_noS_planetas *lista_aInserir,T_noD_planetas *lista_top)
 {
 if(lista_aInserir)
  {
  while(lista_aInserir)
   {
   lista_top=inserirFim_ldPlanetas(lista_top,lista_aInserir);
   lista_aInserir=lista_aInserir->prox;
   }
  }
 return lista_top;
 }

void libertar_LD_planetas(T_noD_planetas *lista_top)
 {
 T_noD_planetas *aux;
 while(lista_top!=NULL)
  {
  aux=lista_top;
  lista_top=lista_top->prox;
  free(aux);
  }
 }

T_noD_planetas *criar_noD_planetas(T_noS_planetas *no)
 {
 T_noD_planetas *novo=(T_noD_planetas *)malloc(sizeof(T_noD_planetas));
 novo->p_lPlanetas=no;
 novo->ant=NULL;
 novo->prox=NULL;
 return novo;
 }

T_noD_planetas *inserirInicio_ldPlanetas(T_noD_planetas *lista_top,T_noS_planetas *no)
 {
 T_noD_planetas *a_inserir;
 a_inserir=criar_noD_planetas(no);
 if(!lista_top)
  return a_inserir;
 a_inserir->prox=lista_top;
 a_inserir->ant=lista_top->ant;
 lista_top=a_inserir;
 return lista_top;
 }


T_noD_planetas *inserirFim_ldPlanetas(T_noD_planetas *lista_top,T_noS_planetas *no)
 {
 T_noD_planetas *ultimo=lista_top,*a_inserir;
 if(lista_top==NULL)
  {
  lista_top=inserirInicio_ldPlanetas(lista_top,no);
  return lista_top;
  }
 while(ultimo->prox!=NULL)                                         
  ultimo=ultimo->prox;
 a_inserir=criar_noD_planetas(no);
 a_inserir->prox=ultimo->prox;
 ultimo->prox=a_inserir;
 a_inserir->ant=ultimo;
 return lista_top;
 }

void libertar_LD_soldados(T_noD_soldados *lista_top)
 {
 T_noD_soldados *aux;
 while(lista_top!=NULL)
  {
  aux=lista_top;
  lista_top=lista_top->prox;
  free(aux);
  }
 }

T_noD_soldados *criarLD_soldadosRecursivo(Tarv_soldados *root,T_noD_soldados *lista_top)
 {
 if(root!=NULL)
  {
  lista_top=criarLD_soldadosRecursivo(root->esq,lista_top);
  lista_top=inserirFim_ldSoldados(lista_top,root);
  lista_top=criarLD_soldadosRecursivo(root->drt,lista_top);
  }
 return lista_top;
 }

T_noD_soldados *criar_noD_soldados(Tarv_soldados *ramo)
 {
 T_noD_soldados *novo=(T_noD_soldados *)malloc(sizeof(T_noD_soldados));
 novo->p_rSoldados=ramo;
 novo->ant=NULL;
 novo->prox=NULL;
 return novo;
 }

T_noD_soldados *inserirInicio_ldSoldados(T_noD_soldados *lista_top,Tarv_soldados *ramo)
 {
 T_noD_soldados *a_inserir;
 a_inserir=criar_noD_soldados(ramo);
 if(!lista_top)
  return a_inserir;
 a_inserir->prox=lista_top;
 a_inserir->ant=lista_top->ant;
 lista_top=a_inserir;
 return lista_top;
 }

T_noD_soldados *inserirFim_ldSoldados(T_noD_soldados *lista_top,Tarv_soldados *ramo)
 {
 T_noD_soldados *ultimo=lista_top,*a_inserir;
 if(lista_top==NULL)
  {
  lista_top=inserirInicio_ldSoldados(lista_top,ramo);
  return lista_top;
  }
 while(ultimo->prox!=NULL)
  ultimo=ultimo->prox;
 a_inserir=criar_noD_soldados(ramo);
 a_inserir->prox=ultimo->prox;
 ultimo->prox=a_inserir;
 a_inserir->ant=ultimo;
 return lista_top;
 }
/*******************************Listas Duplas Circulares***********************/
T_noDC_batalhoes *pesquisarBatalhoes_forcaDefesa(T_noDC_batalhoes *lista_top,T_batalhao *batalhao)
 {
 T_noDC_batalhoes *aux=lista_top;
 if(lista_top)
  {
  do
   {
   if(batalhao->p_unit->defesa>=aux->prox->batalhao.p_unit->defesa)
    return aux;
   aux=aux->prox;
   }
  while(aux!=lista_top);
  }
 return NULL;
 }

T_noDC_batalhoes *inserirBatalhoes_ordenadamenteLDC(T_noDC_batalhoes *lista_top,T_batalhao batalhao)
 {
 T_noDC_batalhoes *aux_anterior=pesquisarBatalhoes_forcaDefesa(lista_top,&batalhao),*novo=NULL;
 if(!lista_top)
  return inserirBatalhoes_inicio(lista_top,&batalhao);
 novo=criar_noBatalhoes(&batalhao);
 novo->prox=aux_anterior->prox;
 novo->ant=novo->prox->ant;
 novo->prox->ant=novo;
 aux_anterior->prox=novo;
 return lista_top;
 }

T_noDC_batalhoes *inserirBatalhoes_inicio(T_noDC_batalhoes *lista_top,T_batalhao *batalhao)
 {
 T_noDC_batalhoes *novo=criar_noBatalhoes(batalhao);
 if(lista_top)
  {
  novo->ant=lista_top->ant;
  novo->prox=lista_top;
  novo->prox->ant=novo->ant->prox=novo;
  }
 else
  {
  novo->prox=novo;
  novo->ant=novo;
  }
 return novo;
 }

int contarNos_ldBatalhoes(T_noDC_batalhoes *lista_top)
 {
 int conta=1;
 if(lista_top==NULL)
  return 0;
 while(lista_top->prox!=lista_top->ant)
  {
  conta+=1;
  lista_top=lista_top->prox;
  }
 return conta;
 }

T_noDC_batalhoes *criar_noBatalhoes(T_batalhao *batalhao)
 {
 T_noDC_batalhoes *novo=(T_noDC_batalhoes *)malloc(sizeof(T_noDC_batalhoes));
 novo->batalhao.p_unit=batalhao->p_unit;
 novo->batalhao.quantidade=batalhao->quantidade;
 novo->prox=novo->ant=novo;
 return novo;
 }

T_noDC_batalhoes *removerBatalhoes_inicioLDC(T_noDC_batalhoes *lista_top)
 {
 T_noDC_batalhoes *aux=lista_top;
 if(lista_top!=NULL)
  {
  if(lista_top->prox==lista_top)
   {
   free(aux);
   return NULL;
   }
  lista_top=lista_top->prox;
  lista_top->ant=aux->ant;
  aux->ant->prox=lista_top;
  free(aux);
  }
 return lista_top;
 }

T_noDC_batalhoes *inserirBatalhoes_fim(T_noDC_batalhoes *lista_top,T_batalhao *batalhao)
 {
 T_noDC_batalhoes *novo,*ultimo=lista_top;
 if(lista_top==NULL)
  return inserirBatalhoes_inicio(lista_top,batalhao);
 while(ultimo->prox!=NULL)
  ultimo=ultimo->prox;
 novo=criar_noBatalhoes(batalhao);
 ultimo->prox=novo;
 novo->ant=ultimo;
 return lista_top;;
 }

void libertar_ldBatalhoes(T_noDC_batalhoes *lista_top)
 {
 while(lista_top!=NULL)
  {
  lista_top=removerBatalhoes_inicioLDC(lista_top);
  }
 }

T_noDC_batalhoes  *pesquisarBatalhoes_LDC(T_noDC_batalhoes  *lista_top,T_batalhao *batalhao)
 {
 T_noDC_batalhoes  *aux=lista_top;
 if((!lista_top) || (stricmp(batalhao->p_unit->nome,lista_top->batalhao.p_unit->nome)<=0))
  return NULL;
 while((aux->prox!=lista_top) && (stricmp(batalhao->p_unit->nome,aux->prox->batalhao.p_unit->nome)>0))
  {
  aux=aux->prox;
  }
 return aux;
 }

T_noDC_batalhoes *removerBatalhao_LDC(T_noDC_batalhoes *lista_top,T_batalhao *batalhao)
 {
 T_noDC_batalhoes *anterior=NULL,*aux=NULL;
 if(lista_top)
  {
  if(lista_top->prox==lista_top)
   {
   return removerBatalhoes_inicioLDC(lista_top);
   }
  anterior=pesquisarBatalhoes_LDC(lista_top,batalhao);
  aux=anterior->prox;
  anterior->prox->prox->ant=anterior;
  anterior->prox=anterior->prox->prox;
  free(aux);
  }
 return lista_top;
 }
