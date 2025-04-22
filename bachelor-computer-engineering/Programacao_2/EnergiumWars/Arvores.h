#ifndef ArvoresH
#define ArvoresH

#include "Definicoes.h"
#include "Files.h"
#include "Funcoes.h"

/** @brief */
Tarv_soldados *criarNo_arvSoldados(T_soldado *soldado);
/** @brief */
Tarv_soldados *inserirNo_arvSoldados(Tarv_soldados *root,Tarv_soldados *a_inserir);
/** @brief */
Tarv_soldados *criarArvore_ficheiroSoldados(Tarv_soldados *root,FILE *pF);
/** @brief */
Tarv_soldados *pesquisarForcaMenor_arvoreSoldados(Tarv_soldados *root,Tarv_soldados **menor);
/** @brief */
Tarv_soldados *libertar_arvoreSoldados(Tarv_soldados *root);
/** @brief */
void listarNomeSoldados_InOrdem(Tarv_soldados *root);
/** @brief */
int contar_noArvoresSoldados(Tarv_soldados *root);

#endif
