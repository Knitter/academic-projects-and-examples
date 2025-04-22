/**
* @file listas.c
* @brief Funções reposáveis pela manipulaçao de listas.
*
* @author Flávio Timóteo nr. 10580
* @author Sérgio Lopes nr. 10635
*
* @date 13.06.2004
* @version 1.0
*/
#include "listas.h"

/**
 * Função que permite libertar o espaço alocado em memória para a lista.
 *
 * @param lista Ponteiro para a lista a libertar.
 *
 * @return Ponteiro para a lista vazia.
 */
t_listaDC_prontos *libertar_ldc(t_listaDC_prontos *lista)
 {
 while(lista != NULL)
  remover_inicio_ldc(&lista);
 return lista;
 }

/**
 * 	Função que tem por objectivo determinar, caso exista, qual o processo que está usar o
 * 	processador no momento. Para fazer essa verificação percorre o espaço de memória onde
 * estão guardados os dados dos processos e testa o valor da variável "estado" para todos
 * os processos.
 *
 * @param lista Ponteiro para a lista de processos a verificar.
 *
 * @return Ponteiro para a zona de memória com os dados do processo que está a executar
 * 	ou NULL no caso de não existir nenhum.
 */
t_listaS_processos *verificar_execucao(t_listaS_processos *lista)
 {
 DEBUG("Procurar processo em execucao");
 while(lista)
  {
  if(lista->elemento.estado==Execucao)
   {
   DEBUG("Encontrou o processo: %d",lista->elemento.id);
   return lista;
   }
  lista=lista->prox;
  }
 DEBUG("Nao existem processos em execucao");
 return NULL;
 }

/**
 * 	Função que permite escrever no ecrã os dados guardados na lista de processos.
 * 	Utiliza a função "escrever_t_ps_info" do ficheiro "estruturas.c".
 * @param lista Ponteiro para a lista a mostrar.
 *
 * @return A função não tem valores de retorno
 */
void mostra_listaS_processos(t_listaS_processos *lista)
 {
 if(!lista)
  printf("\nLista vazia");
 else
  while(lista)
   {
   escrever_t_ps_info(&lista->elemento);
   lista=lista->prox;
   }
 }

/**
 * 	Função para inserir nós na lista simples de processos.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o elemento a inserir na lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaS_processos *inserir_listaS_processos(t_listaS_processos *lista,t_ps_inicial *elemento, int *contador)
 {
 t_listaS_processos *ult,*actual;
 if(!(*contador)){
	criar_no_lsP(&lista->elemento,elemento);
	lista->prox=NULL;
 }
 else{
	ult=devolve_ult_valido(lista);
	actual=(ult+1);
	actual->prox=NULL;
	criar_no_lsP(&actual->elemento,elemento);
	ult->prox=actual;
 }
 return lista;
 }

/**
 * 	Função que permite encontrar o último elemento válido que se encontra na zona
 * de memória partilhada.
 *
 * @param lista Ponteiro para o início da lista a pesquisar.
 *
 * @return Ponteiro para a zona de memória onde se encontra o último elemento válido.
 */
 t_listaS_processos *devolve_ult_valido(t_listaS_processos *lista){
	while(lista->prox)
		lista=lista->prox;
	return lista;
 }

/**
 * 	Função que cria nós a inserir na lista simples processos.
 *
 * @param elemento Ponteiro que vai integrar o nó.
 *
 * @return A função não tem valores de retorno.
 */
 void criar_no_lsP(t_ps_info *elem,t_ps_inicial *elemento){
	elem->id=1;
	elem->pID_proc=0;
	elem->tempo_entrada=elemento->tempo_entrada;
	elem->estado=Novo;
	elem->ja_executou=0;
	if(strlen(elemento->nome)>MAXNOME)
		strncpy(elem->nome,elemento->nome,MAXNOME*sizeof(char));
	else
		strcpy(elem->nome,elemento->nome);
	elem->tempo_servico=elemento->tempo_execucao;
	elem->tempo_usado=elem->tempo_resposta=elem->tempo_turnaround=0;
 }

/**
 * 	Função que permite escrever no ecrã os dados guardados na lista de processos.
 * 	Utiliza a função "escrever_t_ps_inicial" do ficheiro "estruturas.c".
 * @param lista Ponteiro para a lista a mostrar.
 *
 * @return A função não tem valores de retorno.
 */
void mostra_listaS_inicial(t_listaS_inicial *lista)
 {
 if(!lista)
  printf("\nLista vazia");
 else
  while(lista)
   {
   escrever_t_ps_inicial(&lista->elemento);
   lista=lista->prox;
   }
 }

/**
 * 	Função que permite libertar os recursos alocados para durante a criação da lista.
 *
 * @param lista Ponteiro para o início da lista a libertar.
 *
 * @return Ponteiro para o início da lista eliminada.
 */
t_listaS_inicial *libertar_ls(t_listaS_inicial *lista)
 {
 t_listaS_inicial *aux=lista;
 while(aux!=NULL)
  {
  lista=lista->prox;
  free(aux->elemento.nome);
  free(aux);
  aux=lista;
  }
 return lista;
 }

/**
 * 	Função que permite contar o número de nós de uma lista simples inicial.
 *
 * @param lista Ponteiro para o início da lista a contar.
 *
 * @return Inteiro, número de nós que compõem a lista.
 */
int contar_nos_ls(t_listaS_inicial *lista)
 {
 int z=0;
 while(lista)
  {
  z++;
  lista=lista->prox;
  }
 return z;
 }

/**
 * 	Função que permite comparar duas variáveis do tipo "t_ps_inicial" e determinar se são
 * iguais ou qual a maior.
 *
 * @param elemento_1 Ponteiro para o primeiro elemento a usar na comparação.
 * @param elemento_2 Ponteiro para o segundo elemento a usar na comparação.
 *
 * @return Inteiro, resultado da operação de subtracção.
 */
int comparar_ls(t_ps_inicial *elemento_1,t_ps_inicial *elemento_2)
 {
 return elemento_1->tempo_entrada-elemento_2->tempo_entrada;
 }

/**
 * 	Função para pesquisar nós na lista simples inicial.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o nó a pesquisar.
 *
 * @return Ponteiro para o nó encontrado.
 */
t_listaS_inicial *pesquisar_anterior_ls(t_listaS_inicial *lista,t_ps_inicial *elemento)
 {
 t_listaS_inicial *ant=lista;
 if(lista == NULL || comparar_ls(elemento,&lista->elemento) <= 0)
  return NULL;
 while(ant->prox != NULL && comparar_ls(elemento, &ant->prox->elemento) > 0)
  ant=ant->prox;
 return ant;
}

/**
 * 	Função para inserir nós ordenados na lista simples inicial.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o elemento a inserir na lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaS_inicial *inserir_ord_ls(t_listaS_inicial *lista,t_ps_inicial *elemento)
 {
 t_listaS_inicial *novo, *anterior = pesquisar_anterior_ls(lista,elemento);
 if(anterior == NULL)
 lista = inserir_inicio_ls(lista,elemento);
 else
  {
  novo = criar_no_ls(elemento);
  novo->prox = anterior->prox;
  anterior->prox = novo;
  }
 return lista;
 }

/**
 * 	Função para remover nós do início  da lista dupla e circular.
 *
 * @param lista Ponteiro para o início da lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
int remover_inicio_ldc(t_listaDC_prontos **lista)
 {
 int wanted;
 t_listaDC_prontos *aux=(*lista);
 if(!aux)
  return 0;
 if(aux->prox==aux)
  {
  (*lista)=NULL;
  wanted=aux->id;
  free(aux);
  return wanted;
  }
 (*lista)=(*lista)->prox;
 (*lista)->ant=aux->ant;
 aux->ant->prox=(*lista);
 wanted=aux->id;
 free(aux);
 return wanted;
 }

/**
 * 	Função para inserir nós no início da lista dupla e circular.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o elemento a inserir na lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaDC_prontos *inserir_inicio_ldc(t_listaDC_prontos *lista,int *elemento)
 {
 t_listaDC_prontos *novo = criar_no_ldc(elemento);
 if (lista == NULL)
  {
  novo->ant = novo->prox = novo;
  lista = novo;
  }
 else
  {
  novo->prox = lista;
  novo->ant = lista->ant;
  lista->ant->prox = novo;
  lista->ant = novo;
  lista = novo;
  }
 DEBUG("lista: %d",lista->id);
 return lista;
 }

/**
 * 	Função para inserir nós no fim  da lista dupla e circular.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o elemento a inserir na lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaDC_prontos *inserir_fim_ldc(t_listaDC_prontos *lista,int *elemento)
 {
 t_listaDC_prontos *novo,*ultimo;
 if(lista == NULL)
  {
  DEBUG("A inserir no fim da lista dc vazia");
  lista=inserir_inicio_ldc(lista,elemento);
  DEBUG("lista: %d",lista->id);
  return lista;
  }
 DEBUG("A inserir no fim da lista dc");
 novo=criar_no_ldc(elemento);
 DEBUG("!!!!depois de criar no em ldc novo: %d",novo->id);
 ultimo=lista->ant;
 ultimo->prox=novo;
 novo->ant=ultimo;
 novo->prox=lista;
 lista->ant=novo;
 DEBUG("novo: %d\tlista: %d",novo->id,lista->id);
 return lista;
 }

/**
 * 	Função para criar nós da lista dupla e circular.
 *
 * @param elemento Ponteiro para o elemento a incorporar o nó.
 *
 * @return Ponteiro para o nó criado.
 */
t_listaDC_prontos *criar_no_ldc(int *elemento)
 {
 t_listaDC_prontos *novo = (t_listaDC_prontos *) malloc(sizeof(t_listaDC_prontos));
 DEBUG("A criar no lista dc");
 novo->id = *elemento;
 novo->prox = NULL;
 novo->ant=NULL;
 DEBUG("elemento: %d\tnovo: %d",(*elemento),novo->id);
 return novo;
 }

 /**
 * 	Função para remover nós no início da lista simples de inicial.
 *
 * @param lista Ponteiro para o início da lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaS_inicial *remover_inicio_ls(t_listaS_inicial *lista)
 {
 t_listaS_inicial *aux=lista;
 if(aux != NULL)
  {
  lista = lista->prox;
  free(aux->elemento.nome);
  free(aux);
  }
 return lista;
 }

/**
 * 	Função para inserir nós na lista simples inicial.
 *
 * @param lista Ponteiro para o início da lista.
 * @param elemento Ponteiro para o elemento a inserir na lista.
 *
 * @return Ponteiro para o início da lista alterada.
 */
t_listaS_inicial *inserir_inicio_ls(t_listaS_inicial *lista,t_ps_inicial *elemento)
 {
 t_listaS_inicial *novo = criar_no_ls(elemento);
 novo->prox=lista;
 lista = novo;
 return lista;
 }

/**
 * 	Função que cria nós a inserir na lista simples inicial.
 *
 * @param elemento Ponteiro que vai integrar o nó.
 *
 * @return Ponteiro para o nó criado.
 */
t_listaS_inicial *criar_no_ls(t_ps_inicial *elemento)
 {
 t_listaS_inicial *novo=(t_listaS_inicial *) malloc(sizeof(t_listaS_inicial));
 novo->elemento = *elemento;
 novo->prox = NULL;
 return novo;
 }
