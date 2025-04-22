#pragma hdrstop
#include "Files.h"
#pragma package(smart_init)

/****************************Ler em ficheiro binario**************************/
char *ler_nomesFileB(FILE *pF)
 {
 char nome_aux[61];
 int strlen_aux=0;
 fread(&strlen_aux,sizeof(int),1,pF);
 fread(nome_aux,strlen_aux,1,pF);
 return strdup(nome_aux);
 }

T_batalhao ler_batalhaoFilesB(FILE *pF)
 {
 T_batalhao batalhao;
 batalhao.p_unit->nome=ler_nomesFileB(pF);
 fread(&batalhao.quantidade,sizeof(int),1,pF);
 return batalhao;
 }

T_noDC_batalhoes *ler_ldBatalhoesFileB(FILE *pF)
 {
 int z,num_batalhoes=0;
 T_noDC_batalhoes *lista_top=NULL;
 fread(&num_batalhoes,sizeof(int),1,pF);
 for(z=0;z<num_batalhoes;z++)
  lista_top=inserirBatalhoes_ordenadamenteLDC(lista_top,ler_batalhaoFilesB(pF));
 return lista_top;
 }

T_planeta ler_planetaFileB(FILE *pF,T_player *p_vJogadores,int num_jogadores)     /*(1)*/
 {
 T_planeta planeta;
 planeta.nome=ler_nomesFileB(pF);
 fread(&planeta.rentabilidade,sizeof(int),1,pF);
 planeta.lista_top=ler_ldBatalhoesFileB(pF);
 planeta.p_owner=pesquisarOwner_nome(ler_nomesFileB(pF),p_vJogadores,num_jogadores);
 return planeta;
 }

void ler_playerFileB(FILE *pF,T_player **p_vJogadores,int num_jogadorActual,int num_jogadores)
 {
 (*p_vJogadores)[num_jogadorActual].nome=ler_nomesFileB(pF);
 fread(&(*p_vJogadores)[num_jogadorActual].saldo,sizeof(int),1,pF);
 fread(&(*p_vJogadores)[num_jogadorActual].num_mov,sizeof(int),1,pF);
 (*p_vJogadores)[num_jogadorActual].lista_top=ler_lsPlanetasFileB(pF,(*p_vJogadores),num_jogadores);
 }

T_noS_planetas *ler_lsPlanetasFileB(FILE *pF,T_player *p_vJogadores,int num_jogadores)
 {
 T_noS_planetas *lista_top=NULL;
 int z,num_planetas=0;
 fread(&num_planetas,sizeof(int),1,pF);
 for(z=0;z<num_planetas;z++)
  lista_top=inserir_planetasOrdenadamente(lista_top,&(ler_planetaFileB(pF,p_vJogadores,num_jogadores)));
 return lista_top;
 }

void carregar_jogo(T_player **p_vJogadores,int *num_jogadores,FILE *pF)
 {
 int z;
 fread(num_jogadores,sizeof(int),1,pF);
 (*p_vJogadores)=alocar_jogadores((*num_jogadores));
 for(z=0;z<(*num_jogadores);z++)
  ler_playerFileB(pF,p_vJogadores,z,(*num_jogadores));
 }
/****************************Escrever em ficheiro binario*********************/
void escrever_playerFileB(T_player *jogador,FILE *pF)
 {
 escrever_nomesFileB(jogador->nome,pF);
 fwrite(&jogador->saldo,sizeof(int),1,pF);
 fwrite(&jogador->num_mov,sizeof(int),1,pF);
 escrever_lsPlanetasFileB(jogador->lista_top,pF);
 }

void escrever_nomesFileB(char *nome,FILE *pF)
 {
 int strlen_aux;
 strlen_aux=(strlen(nome)+1);
 fwrite(&strlen_aux,sizeof(int),1,pF);
 fwrite(nome,sizeof(char),strlen_aux,pF);
 }

void gravar_jogo(int num_jogadores,T_player *p_vJogadores,FILE *pF)
 {
 int z;
 fwrite(&num_jogadores,sizeof(int),1,pF);
 for(z=0;z<num_jogadores;z++)
  escrever_playerFileB(&p_vJogadores[z],pF);
 }

void escrever_batalhaoFilesB(T_batalhao *batalhao,FILE *pF)
 {
 escrever_nomesFileB(batalhao->p_unit->nome,pF);
 fwrite(&batalhao->quantidade,sizeof(int),1,pF);
 }

void escrever_ldBatalhoesFileB(T_noDC_batalhoes *lista_top,FILE *pF)
 {
 int z,num_batalhoes=contarNos_ldBatalhoes(lista_top);
 fwrite(&num_batalhoes,sizeof(int),1,pF);
 for(z=0;z<num_batalhoes;z++)
  escrever_batalhaoFilesB(&lista_top->batalhao,pF);
 }

 void escrever_planetaFileB(T_planeta *planeta,FILE *pF)
 {
 escrever_nomesFileB(planeta->nome,pF);
 fwrite(&planeta->rentabilidade,sizeof(int),1,pF);
 escrever_ldBatalhoesFileB(planeta->lista_top,pF);
 escrever_nomesFileB(planeta->p_owner->nome,pF);              
 }
 
void escrever_lsPlanetasFileB(T_noS_planetas *lista_top,FILE *pF)
 {
 int num_planetas=conta_noPlanetas(lista_top);
 fwrite(&num_planetas,sizeof(int),1,pF);
 while(lista_top!=NULL)
  {
  escrever_planetaFileB(&lista_top->planeta,pF);
  lista_top=lista_top->prox;
  }
 }

int ler_FileUnidades(T_soldado **p_vSoldados,FILE *pF)
 {
 int z,num_unidades=0;
 char lixo[61];
 fscanf(pF,"%[^:]: %d",lixo,&num_unidades);
 (*p_vSoldados)=alocar_soldado(num_unidades);
 for(z=0;z<num_unidades;z++)
  ler_soldadoFileT(&(*p_vSoldados)[z],pF);
 return num_unidades;
 }

int ler_FilePlanetas(T_planeta **p_vPlanetas,FILE *pF)
 {
 int z,num_planetas=0;
 char lixo[61];
 fscanf(pF,"%[^:]: %d",lixo,&num_planetas);
 (*p_vPlanetas)=alocar_planeta(num_planetas);
 for(z=0;z<num_planetas;z++)
  ler_planetaFileT(&(*p_vPlanetas)[z],pF);
 return num_planetas;
 }

void ler_planetaFileT(T_planeta *temp,FILE *pF)
 {
 char aloc_aux[61],lixo[61];
 fscanf(pF,"%[^:]: %[^\n]\n",lixo,aloc_aux);
 temp->nome=alocar_nome(strlen(aloc_aux)+1);
 strcpy(temp->nome,aloc_aux);
 fscanf(pF,"%[^:]: %d",lixo,&temp->rentabilidade);
 }

void ler_soldadoFileT(T_soldado *temp,FILE *pF)
 {
 char aloc_aux[61],lixo[61];
 fscanf(pF,"%[^:]: %[^\n]\n",lixo,aloc_aux);
 temp->nome=alocar_nome(strlen(aloc_aux)+1);
 strcpy(temp->nome,aloc_aux);
 fscanf(pF,"%[^:]: %d",lixo,&temp->preco);
 fscanf(pF,"%[^:]: %d",lixo,&temp->ataque);
 fscanf(pF,"%[^:]: %d",lixo,&temp->defesa);
 }
