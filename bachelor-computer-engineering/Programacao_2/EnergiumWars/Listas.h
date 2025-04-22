#ifndef ListasH
#define ListasH

#include "Definicoes.h"
#include "Estruturas.h"

/*********************************Listas Simples*******************************/
T_noS_planetas *removerPlanetas_meio(T_noS_planetas *lista_top,T_planeta *planeta);
/** @brief */
T_noS_planetas *consultar_lsPlanetas(T_noS_planetas *lista_top,char *nome);
/** @brief */
T_noS_planetas *pesquisar_Planetas(T_noS_planetas *lista_top,T_planeta *planeta);
/** @brief */
int conta_noPlanetas(T_noS_planetas *lista_top);
/** @brief */
void percorrer_lsPlanetas(T_noS_planetas *lista_top,int cor);
/** @brief */
void libertar_lsPlanetas(T_noS_planetas *lista_top);
/** @brief */
T_noS_planetas *removerPlanetas_fim(T_noS_planetas *lista_top);
/** @brief */
T_noS_planetas *removerPlanetas_inicio(T_noS_planetas *lista_top);
/** @brief */
T_noS_planetas *inserirPlanetas_fim(T_noS_planetas *lista_top,T_planeta *planeta);
/** @brief */
T_noS_planetas *inserirPlanetas_inicio(T_noS_planetas *lista_top,T_planeta *planeta);
/** @brief */
T_noS_planetas *criar_noPlanetas(T_planeta *planeta);
/** @brief */
int contarRentabilidade_lsPlanetas(T_noS_planetas *lista_top);
/** @brief */
T_noS_planetas *percorrer_lsPlanetasAte(T_noS_planetas *lista_top,int stop);
/** @brief */
T_noS_planetas *inserir_planetasOrdenadamente(T_noS_planetas *lista_top,T_planeta *planeta);
/**********************************Listas Duplas*******************************/
/** @brief */
T_noD_soldados *inserirFim_ldSoldados(T_noD_soldados *lista_top,Tarv_soldados *ramo);
/** @brief */
T_noD_soldados *inserirInicio_ldSoldados(T_noD_soldados *lista_top,Tarv_soldados *ramo);
/** @brief */
T_noD_soldados *criar_noD_soldados(Tarv_soldados *ramo);
/** @brief */
T_noD_soldados *criarLD_soldadosRecursivo(Tarv_soldados *root,T_noD_soldados *lista_top);
/** @brief */
void libertar_LD_soldados(T_noD_soldados *lista_top);
/** @brief */
T_noD_planetas *inserirFim_ldPlanetas(T_noD_planetas *lista_top,T_noS_planetas *no);
/** @brief */
T_noD_planetas *inserirInicio_ldPlanetas(T_noD_planetas *lista_top,T_noS_planetas *no);
/** @brief */
T_noD_planetas *criar_noD_planetas(T_noS_planetas *lista_top);
/** @brief */
void libertar_LD_planetas(T_noD_planetas *lista_top);
/** @brief */
T_noD_planetas *criarLD_planetas(T_noS_planetas *lista_aInserir,T_noD_planetas *lista_top);
/** @brief */
int contar_nosLDPlanetas(T_noD_planetas *lista_top);
/*********************************Listas Duplas Circulares********************************/
/** @brief */
T_noDC_batalhoes *removerBatalhao_LDC(T_noDC_batalhoes *lista_top,T_batalhao *batalhao);
/** @brief */
T_noDC_batalhoes  *pesquisarBatalhoes_LDC(T_noDC_batalhoes  *lista_top,T_batalhao *batalhao);
/** @brief */
void libertar_ldBatalhoes(T_noDC_batalhoes *lista_top);
/** @brief */
T_noDC_batalhoes *inserirBatalhoes_fim(T_noDC_batalhoes *lista_top,T_batalhao *batalhao);
/** @brief */
T_noDC_batalhoes *removerBatalhoes_inicioLDC(T_noDC_batalhoes *lista_top);
/** @brief */
T_noDC_batalhoes *criar_noBatalhoes(T_batalhao *batalhao);
/** @brief */
int contarNos_ldBatalhoes(T_noDC_batalhoes *lista_top);
/** @brief */
T_noDC_batalhoes *inserirBatalhoes_inicio(T_noDC_batalhoes *lista_top,T_batalhao *batalhao);
/** @brief */
T_noDC_batalhoes *inserirBatalhoes_ordenadamenteLDC(T_noDC_batalhoes *lista_top,T_batalhao batalhao);
/** @brief */
T_noDC_batalhoes *pesquisarBatalhoes_forcaDefesa(T_noDC_batalhoes *lista_top,T_batalhao *batalhao);
/** @brief */
/*****************************************************************************************/
/** @brief */
int contarDespesas(T_noS_planetas *lista_top);

#endif

