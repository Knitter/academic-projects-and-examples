#include <alloc.h>
#include <conio.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

/** @brief mensagem que informa o jogador que que ganhou a batalha com outro jogador */
#define BATALHA_GANHA "Pura sorte digo. Mas que sei eu?\n\rFui apenas o gajo que fez isto...\n\rPrima \"Enter\" para poder ir para a janela gritar:\n\n\r       \"I'm the king of the world!\""
/** @brief mensagem que informa o jogador que o planeta destino pertence a outro jogador */
#define BATALHA_PAUSE "Encontrou um adversario no planeta destino.\n\rIniciou-se uma batalha...\n\rPrima \"Enter\" quando achar que ja ganhou..."
/** @brief mensagem que informa o jogador que que perdeu a batalha com outro jogador */
#define BATALHA_PERDIDA "Os seus Homens lutaram com coragem e eles nem eram melhores,eram apenas mais.\n\rSe e nisso que quer acreditar muito bem...\n\rPrima \"Enter\" para despedir o navegador que o levou a este\n\rplaneta"
/** @brief mensagem que informa o jogador que a operacao nao foi efectuada por pedido deste */
#define CANCEL "Operacao cancelada a pedido."
/** @brief indica��o de todos os caracteres invalidos para o nome de um ficheiro */
#define CARCTERES_INVALIDOS "\\|.*/?><:"
/** @brief mensagem que indica ao jogador que a compra de unidades foi efectuada com sucesso */
#define CONFIRMACAO_COMPRA "Novas unidades adicionadas com sucesso."
/** @brief indica�ao da cor usada em mensagens de erro a serem apresentadas ao jogador */
#define COR_ERRO 4
/** @brief indica��o da cor usada no texto e outros aspectos gerais da apresenta��o gr�fica */
#define COR_GERAL 2
/** @brief indica��o da cor usdada em mensagens de confirma��o de sucessos */
#define COR_OK 1
/** @brief indica��o da cor usada nas molduras */
#define COR_MOLDURAS 5
/** @brief indica��o da cor usada como base */
#define COR_RESET 7
/** @brief indica��o da cor usada na apresenta��o do cursor */
#define CURSOR_RESET ' '
/** @brief indica��o da cor usado no texto em geral */
#define COR_TEXTO 2
/** @brief indica��o da forma do cursor apresentado */
#define CURSORTYPE (char)16
/** @brief definicao da tecla que efectua o movimento descendente do cursor */
#define DOWN 80
/** @brief mensagem que informa o jogador da ocurrencia de erro na abertura dos ficheiros de informa��o */
#define ERRO_ABERTURA_FILE "Erro na abertura dos ficheiros de informacao. Prima \"Enter\" para terminar."
/** @brief mensagem que informa o jogador da n�o existencia de ficheiro pretendido */
#define ERRO_CARREGAR2 "Impossivel carregar o jogo. Ficheiro nao existe."
/** @brief mensagem que informa o jogador da ocurrencia de erro desconhecido */
#define ERRO_DESCONHECIDO "Ocorreu um erro nao conhecido.\r\nPrima \"Enter\" para enviar um relatorio de erros.\n\rEntraremos em contacto depois de espancarmos o prof de P2\n\rTenha um bom dia."
/** @brief mensagem que informa o jogador da ocurrencia ao tentar gravar o ficheiro */
#define ERRO_GUARDAR "Impossivel guardar o ficheiro."
/** @brief mensagem que informa o jogador que o nome do ficheiro na�o � v�lido */
#define ERRO_NOME_FILE "Nome de ficheiro invalido. Nao sao permitidos os caracteres \"\\|.*/?><:\" nem nomes com mais de 250 caracteres."
/** @brief mensagem que indica que se trata da lista de planetas de destino */
#define TEXTO_ESCOLHER_P1 "Escolha o Planeta Destino"
/** @brief mensagem que indica que se trata da lista de planetas de origem */
#define TEXTO_ESCOLHER_P2 "Escolha o Planeta Origem"
/** @brief exten��o a ser acrescentada ao nome dos ficheiros salvos */
#define EXTENCAO_BINARIA ".knt"
/** @brief indica��o dos caracteres usados nas linhas horizontais das molduras do 1�menu */
#define HORIZONTAL_MENU1 16
/** @brief indica��o dos caracteres usados nas linhas horizontais das molduras do 2�menu */
#define HORIZONTAL_MENU2 16
/** @brief  */
#define MAXLINHAMENU 15
/** @brief define o m�ximo de caracteres possiveis para um nome de jogador */
#define MAXNOMES 16
/** @brief define o m�ximo de jogadores possiveis por jogo */
#define MAXPLAYERS 8
/** @brief define o m�ximo de tipos de unidades existentes num unidade militar */
#define MAXUNIDADES_BATALHAO 1000
/** @brief define o m�nimo de jogadores por jogo */
#define MINPLAYERS 2
/** @brief mensagem que indica ao jogador que o jogo foi correctamente guardado */
#define NOERRO_GUARDAR "Jogo salvo com sucesso."
/** @brief define o m�ximo de caracteres para o nome de um ficheiro */
#define NOMEMAX_FILE 250
/** @brief  */
#define POSX_MENU1 1
/** @brief  */
#define POSX_MENU2 1
/** @brief  */
#define POSY_MENU1 1
/** @brief  */
#define POSY_MENU2 1
/** @brief  */
#define TEXTO_NOVA_TENTATIVA "Prima qualquer tela para tentar novamente ou \"s\" para sair"
/** @brief definicao da tecla que efectua o movimento ascendente do cursor */
#define UP 72
/** @brief define a percentagem do preco original pela qual ser�o vendidas as unidades */
#define VALOR_VENDA 0.80
/** @brief  */
#define VENDAOK "Venda de unidades efectuada com sucesso."
/** @brief define o n�mero m�ximo de linhas do 1�menu */
#define VERTICAL_MENU1 3
/** @brief define o n�mero m�ximo de linhas do 2�menu */
#define VERTICAL_MENU2 8
/** @brief define o n�mero de colunas para o modo de video correcto */
#define VIDEO_COLUNAS 80
/** @brief define o n�mero de linhas para o modo de video correcto */
#define VIDEO_LINHAS 25
