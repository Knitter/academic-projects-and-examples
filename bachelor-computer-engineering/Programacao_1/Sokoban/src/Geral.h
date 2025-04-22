//---------------------------------------------------------------------------

#ifndef GeralH
#define GeralH
#define MAXCOLUNAS 20//7
#define MAXPLAYERS 10
#define MAXCAIXAS 6
/**
* \brief Apresenta os creditos
*
* Recebe a posicao onde inicia a apresentacao
*/
void creditos(int x,int y);
/**
* \brief Conta  numero de destinos vagos
*
* Recebe a matriz de jogo, a matriz dos destinos e o numero de caixas
*/
int contaDestinos(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int correctos);
/**
* \brief Esta funcao serviria para verificar a posicao da classificacao onde
* se colocaria o novo nome de jogador
*
* Recebe a matriz com as classificacoes, o nivel atingido pelo jogador
* actual e o total de jogadas desse mesmo jogador
*
* A funcao nao se encontra a funcionar
*/
int verificarScore(int score[MAXPLAYERS][2],int nivel, int jogadas);
/**
* \brief Permite seleccionar o nivel seguinte
*
* Recebe a matriz com os niveis, a matriz com os detinos, o nivel a iniciar e um
* ponteiro para o numero de caixas existentes
*/
void selecionar(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int nivel,int *correctos,int posM[2]);
/**
* \brief Apresenta o ecra que informa o jogador do facto de ter conseguido terminar o nivel
*
* Recebe a posicao onde será apresentada a caixa como texto, o nivel atingido até
* então e o total de jogadas
*/
char parabens(int x,int y,int nivel,int jogadas);
/**
* \brief Apresenta o nome do autor
*
* Recebe a posicao de apresentacao e um estring com o nome
*/
void autor(int x,int y,char eu[]);
/**
* \brief Responsavel por todo o ecrã de classificaçoes
*
*  Recebe as matrizes a apresntar, e a posicao no ecrã.
*/
void tabelaClassificacoes(int x,int y,char players[MAXPLAYERS][MAXCOLUNAS],int score[MAXPLAYERS][2]);
/**
* \brief Permite descer os nomes na tabela de classificacoes de modo a nao apagar nomes
*
* Recebe a matriz com os nomes dos jogadores e a posicao a partir da qual
* serão descidos os nomes
*/
void reposicionar(char players[][MAXCOLUNAS],int lugar);
/**
* \brief Permite voltar a escrever os destinos de modo a que não sejam apagados
* quando o boneco ou caixas passam por cima
*
* Recebe a matriz de jogo, os destinos e o numero de caixas
*/
void destinosActuais(char matriz[][MAXCOLUNAS],int destinos[MAXCAIXAS][2],int correctos);
/**
* \brief  Permite fazer a correcçao entre a posição do boneco no ecrã e na matriz de jogo
*
* Recebe as posicoes do boneco ne ecrã e na matriz de jogo
*/
void corrige(int posE[2],int posM[2]);
/**
* \brief Responsavel pelas acoes iniciais do jogo
*
* Recebe uma matriz com o primeiro nivel os destinos, a quantidade de caixas e a posicao do boneco
*/
void iniciar(char matriz[][MAXCOLUNAS],int destinos[MAXPLAYERS][2],int *correctos,int posM[2]);
//---------------------------------------------------------------------------
#endif
