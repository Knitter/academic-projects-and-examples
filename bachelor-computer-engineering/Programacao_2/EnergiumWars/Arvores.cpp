#pragma hdrstop
#include "Arvores.h"
#pragma package(smart_init)

int contar_noArvoresSoldados(Tarv_soldados *root)
 {
 if(root)
  {
  return (1+contar_noArvoresSoldados(root->esq)+contar_noArvoresSoldados(root->drt));
  }
 return 0;
 }

void listarNomeSoldados_InOrdem(Tarv_soldados *root)
 {
 if(root!=NULL)
  {
  listarNomeSoldados_InOrdem(root->esq);
  cprintf("%s\n\r",root->soldado.nome);
  listarNomeSoldados_InOrdem(root->drt);
  }
 }

Tarv_soldados *libertar_arvoreSoldados(Tarv_soldados *root)
 {
 if(root!=NULL)
  {
  root->esq=libertar_arvoreSoldados(root->esq);
  root->drt=libertar_arvoreSoldados(root->drt);
  free(root->soldado.nome);
  free(root);
  root=NULL;
  }
 return root;
 }

Tarv_soldados *pesquisarForcaMenor_arvoreSoldados(Tarv_soldados *root,Tarv_soldados **menor)
 {
 if(root!=NULL)
  {
  pesquisarForcaMenor_arvoreSoldados(root->esq,menor);
  if((*menor)->soldado.ataque>root->soldado.ataque)
   (*menor)=root;
  pesquisarForcaMenor_arvoreSoldados(root->drt,menor);
  }
 return NULL;
 }

Tarv_soldados *criarArvore_ficheiroSoldados(Tarv_soldados *root,FILE *pF)
 {
 T_soldado *p_vSoldados=NULL;
 int num_soldados,z;
 num_soldados=ler_FileUnidades(&p_vSoldados,pF);
 for(z=0;z<num_soldados;z++)
  root=inserirNo_arvSoldados(root,criarNo_arvSoldados(&p_vSoldados[z]));
 return root;
 }

Tarv_soldados *inserirNo_arvSoldados(Tarv_soldados *root,Tarv_soldados *a_inserir)
 {
 int stricmp_aux;
 if(root==NULL)
  return a_inserir;
 stricmp_aux=stricmp(a_inserir->soldado.nome,root->soldado.nome);
 if(stricmp_aux<0)
   root->esq=inserirNo_arvSoldados(root->esq,a_inserir);
 else
  if(stricmp_aux>0)
   root->drt=inserirNo_arvSoldados(root->drt,a_inserir);
 return root;
 }

Tarv_soldados *criarNo_arvSoldados(T_soldado *soldado)
 {
 Tarv_soldados *novo=alocar_arvSoldados(1);
 novo->soldado=*soldado;
 novo->esq=novo->drt=NULL;
 return novo;
 }
