package j2gether.model;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import j2gether.utilsp4.StackArray;
import j2gether.view.listeners.J2GetherEvent;
import j2gether.view.listeners.J2GetherListener;


/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class J2Gether implements Serializable {

    /**
     * Tabuleiro de peças do jogo
     */
    private Peca[][] tabuleiro;

    /**
     * Tabela de pontuações
     */
    private transient Score tabelaPontuacoes;

    /**
     * Pontuação actual
     */
    private double pontuacaoTotal;

    /**
     * Buffer Circular de Undos
     */
    private transient ByteArrayOutputStream[] undoList;

    /**
     * Índice actual do undo
     */
    private int undoIndice = -1;

    /**
     * Índice máximo do redo
     */
    private int redoMax = -1;

    /**
     * Índice maximo do redo
     */
    private int redoMin = -1;

    /**
     * Listeners activos do jogo
     */
    private transient LinkedList listeners;

    /**
     * Lista de peças candidatas
     */
    private transient LinkedList pecasCandidatas = new LinkedList();

    /**
     * Lista de peças existentes no tabuleiro
     */
    private LinkedList pecasNoTabuleiro;

    /**
     * Número de cores
     */
    private int numCores;

    /**
     * Modo actual (iterativo/recursivo)
     */
    private transient int modo;

    /**
     * Modos possíveis do jogo seleccionar peças candidatas
     * 0 - recursivo
     * 1 - iterativo
     */
    private transient ModoJ2Gether[] modos;

    /**
     * Flag que indica se o jogador não limpou o tabuleiro
     */
    private boolean perdeu;

    /**
     * Flag que indica se o jogador limpou o tabuleiro
     */
    private boolean ganhou;

    /**
     * Flag que indica uma jogada inválida
     */
    private boolean invalida;

    /**
     * Flag que indica que as peças cairam
     */
    private boolean droped;

    /**
     * Numero máximo de undos
     */
    private static final int MAX_UNDO = 6;
    private static final int DO_UNDO = -1;
    private static final int DO_REDO = 1;

    public static final int INITIAL_HEIGHT = 10;
    public static final int INITIAL_WIDTH = 10;
    public static final int INITIAL_NUM_COLORS = 5;
    public static final int INITIAL_MODE = ModoJ2Gether.RECURSIVO;

    public static final int INITIAL_SCORE_HEIGHT = 10;

    /**
     * @param altura   - Número de linhas para o tabuleiro
     * @param largura  - Número de colunas para o tabuleiro
     * @param numCores - Número de cores para o tabuleiro
     * @param modo     - Modo inicial do jogo (recursivo/iterativo)
     */
    public J2Gether(int altura, int largura, int numCores, int modo) {
        pecasNoTabuleiro = new LinkedList();
        tabuleiro = new Peca[altura][largura];

        int j;
        for (int i = 0; i < altura; i++)
            for (j = 0; j < largura; j++)
                pecasNoTabuleiro.add(tabuleiro[i][j] = new Peca(new Posicao(i, j), (int) (Math.random() * numCores)));
        this.numCores = numCores;
        this.modo = modo;

        createUndo();
        createModos();
        createScores();
    }



///////// Métodos Privados /////////////////////////////////////////////////////

    /**
     * Selecciona as peças candidatas
     */
    private void selectCandidatas() {
        Iterator it = pecasCandidatas.iterator();
        while (it.hasNext())
            ((Peca) it.next()).select();
    }

    /**
     * Desselecciona as peças candidatas
     */
    private void deSelect() {
        Iterator it = pecasCandidatas.iterator();
        while (it.hasNext())
            ((Peca) it.next()).deSelect();
        pecasCandidatas.clear();
    }

    /**
     * Desselecciona todas as peças existentes no tabuleiro
     */
    private void deSelectAll() {
        Iterator it = pecasNoTabuleiro.iterator();
        while (it.hasNext())
            ((Peca) it.next()).deSelect();
    }

    /**
     * Elimina as peças candidatas do tabuleiro
     */
    private void limparListaCandidatas() {
        Iterator it = pecasCandidatas.iterator();
        while (it.hasNext()) {
            Peca peca = (Peca) it.next();
            peca.ocultar();
            pecasNoTabuleiro.remove(peca);
        }
        pecasCandidatas.clear();
    }

    /**
     * Move para baixo todas as colunas que tenham peças candidatas
     *
     * @param boundries - Limites do conjunto de colunas a baixar
     */
    private void dropDown(J2GetherMinMax boundries) {
        int coluna, linha;
        for (coluna = boundries.min; coluna <= boundries.max; coluna++)
            for (linha = tabuleiro.length - 2; linha >= 0; linha--)
                if (!tabuleiro[linha][coluna].isIncolor())
                    moveDown(linha, coluna);
    }

    /**
     * Desloca as peças para baixo numa determinada coluna
     *
     * @param linha  - Linha inical onde se encontra a bola a descer
     * @param coluna - Coluna onde se encontra a bola a descer
     */
    private void moveDown(int linha, int coluna) {
        while (linha + 1 < tabuleiro.length && tabuleiro[linha + 1][coluna].isIncolor()) {
            tabuleiro[linha + 1][coluna] = tabuleiro[linha][coluna];
            tabuleiro[linha++][coluna] = new Peca(new Posicao(linha, coluna), Peca.INCOLOR);
            droped = true;
        }
        tabuleiro[linha][coluna].setPosicao(new Posicao(linha, coluna));
    }

    /**
     * Encontra uma coluna vazia, conta o número de colunas vazias ulteriores,
     * e manda deslocar todas as colunas subsquentes para a esquerda
     *
     * @param colunaInicial - Coluna a partir da qual começa a operação
     */
    private void moveLeft(int colunaInicial) {
        int numBuracos;
        for (int i = colunaInicial; i < tabuleiro[0].length; i++)
            if (tabuleiro[tabuleiro.length - 1][i].isIncolor()) {
                numBuracos = 1;
                while (i + numBuracos < tabuleiro[0].length && tabuleiro[tabuleiro.length - 1][i + numBuracos].isIncolor())
                    numBuracos++;
                moveLeft(i, numBuracos);
            }
    }

    /**
     * Desloca as colunas subsequentes à(s) coluna(s) vazia(s) para a esquerda
     *
     * @param coluna - Coluna inicial
     * @param numBuracos - Número de casas a deslocar à esquerda
     */
    private void moveLeft(int coluna, int numBuracos) {
        int linha;
        for (int i = coluna; i < tabuleiro[0].length; i++) {
            linha = tabuleiro.length - 1;
            while ((linha >= 0) && ((i + numBuracos) < tabuleiro[0].length) && !tabuleiro[linha][i + numBuracos].isIncolor()) {
                tabuleiro[linha][i] = tabuleiro[linha][i + numBuracos];
                tabuleiro[linha][i].setPosicao(new Posicao(linha, i));
                tabuleiro[linha][i + numBuracos] = new Peca(new Posicao(linha, i + numBuracos), Peca.INCOLOR);
                linha--;
                droped = true;
            }
        }
    }

    /**
     * Executa uma operação de undo ou redo
     *
     * @param direction - Direcção de operação [undo/redo]
     * -1 -- DO_UNDO
     * +1 -- DO_REDO
     */
    private void undoRedo(int direction) {
        undoIndice += 1 * direction;
        ObjectInputStream is = null;
        try {
            is = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(undoList[(undoIndice) % MAX_UNDO].toByteArray())));
            UndoMove udm = (UndoMove) is.readObject();
            tabuleiro = udm.savTabuleiro;
            pontuacaoTotal = udm.savPontuacao;
            pecasNoTabuleiro = udm.savPecasNoTabuleiro;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
        }
        resetEventFlags();
        fireJ2GetherChanged();
    }

    /**
     * Percorre as peças existentes no tabuleiro e verifica se existe alguma peça adjacente da mesma cor
     *
     * @return true caso encontre uma peça com pelo menos uma peça adjacente da mesma cor
     */
    private boolean podeContinuar() {
        Iterator it = pecasNoTabuleiro.iterator();
        while (it.hasNext()) {
            Peca peca = (Peca) it.next();
            if (hasAdajcentes(peca.getPosicao().getLinha(), peca.getPosicao().getColuna()))
                return true;
        }
        return false;
    }

    /**
     * Verifica se existe alguma peça adjacente a uma determinada peça da mesma cor
     *
     * @param linha  - Linha da peça a averiguar
     * @param coluna - Coluna da peça a averiguar
     * @return true  - Existe pelo menos uma peça adjacente da mesma cor
     *         false - Não existe nenhuma peça adjacente da mesma cor
     */
    private boolean hasAdajcentes(int linha, int coluna) {
        if ((linha < tabuleiro.length - 1 && tabuleiro[linha][coluna].sameColour(tabuleiro[linha + 1][coluna].getCor())) ||
            (linha > 0 && tabuleiro[linha][coluna].sameColour(tabuleiro[linha - 1][coluna].getCor())) ||
            (coluna < tabuleiro[0].length - 1 && tabuleiro[linha][coluna].sameColour(tabuleiro[linha][coluna + 1].getCor())) ||
            (coluna > 0 && tabuleiro[linha][coluna].sameColour(tabuleiro[linha][coluna - 1].getCor())))
            return true;

        return false;
    }

    /**
     * Recria todas as estruturas necessárias após um Load
     */
    private void recreate() {
        recreateListaCandidatas();
        createUndo();
        createModos();
        createScores();
    }

    /**
     * Percorre todo o tabuleiro à procura de peças seleccionadas e recria a lista de peças candidatas
     */
    private void recreateListaCandidatas() {
        pecasCandidatas = new LinkedList();
        for (int i = 0; i < tabuleiro.length; i++)
            for (int j = 0; j < tabuleiro[0].length; j++)
                if (tabuleiro[i][j].isCandidata())
                    pecasCandidatas.add(tabuleiro[i][j]);
    }

    /**
     * Cria a estrutura do Undo
     */
    private void createUndo() {
        undoList = new ByteArrayOutputStream[MAX_UNDO];
        for (int j = 0; j < MAX_UNDO; j++)
            undoList[j] = new ByteArrayOutputStream();
        undoIndice = redoMin = -1;
        addUndo();
    }

    /**
     * Cria os modos de jogo [Recursivo, Iterativo]
     */
    private void createModos() {
        modos = new ModoJ2Gether[] {new ModoJ2GetherRecursivo(), new ModoJ2GetherIterativo()};
    }

    /**
     * Cria a tabela de scores
     */
    private void createScores() {
        tabelaPontuacoes = new Score(INITIAL_SCORE_HEIGHT, new ScoreMode(tabuleiro.length, tabuleiro[0].length, numCores));
    }

    /**
     * Reinicia as flags do jogo
     */
    private void resetEventFlags() {
        perdeu = ganhou = invalida = droped = false;
    }



////////// Serviços ////////////////////////////////////////////////////////////

    /**
     * Executa uma jogada numa determinada posição do tabuleiro (linha, coluna)
     *
     * @param linha  - Linha da jogada
     * @param coluna - Coluna da jogada
     */
    public void jogar(int linha, int coluna) {
        resetEventFlags();
        if (tabuleiro[linha][coluna].isCandidata()) {
            pontuacaoTotal += Math.pow(pecasCandidatas.size() - 2, 2.0);
            J2GetherMinMax boundriesCandidatas = new J2GetherMinMax(tabuleiro[0].length - 1, 0);
            limparListaCandidatas();
            dropDown(boundriesCandidatas);
            moveLeft(boundriesCandidatas.min);
            addUndo();
            if (pecasNoTabuleiro.isEmpty())
                ganhou = true;
            else
            if (!podeContinuar())
                perdeu = true;
        } else {
            deSelect();
            modos[modo].select(linha, coluna, tabuleiro[linha][coluna].getCor());
            if (pecasCandidatas.isEmpty())
                invalida = true;
        }
        fireJ2GetherChanged();
    }

    /**
     * Procura a melhor jogada
     */
    public void wizard() {
        resetEventFlags();
        LinkedList l = new LinkedList();
        deSelect();
        int n = 0;
        for (int i = 0; i < tabuleiro.length; i++)
            for (int j = 0; j < tabuleiro[0].length; j++) {
                modos[modo].select(i, j, tabuleiro[i][j].getCor());
                if (pecasCandidatas.size() >= n) {
                    n = pecasCandidatas.size();
                    l = (LinkedList) pecasCandidatas.clone();
                }
                pecasCandidatas.clear();
            }
        pecasCandidatas = l;
        deSelectAll();
        selectCandidatas();
        fireJ2GetherChanged();
    }

    /**
     * Grava o jogo actual num ficheiro
     *
     * @param saveFile - Ficheiro a gravar o jogo
     */
    public void save(File saveFile) {
        FileOutputStream f = null;
        try {
            ObjectOutputStream o = new ObjectOutputStream(f = new FileOutputStream(saveFile));
            o.writeObject(this);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (f != null)
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
        }
    }

    /**
     * Carrega o jogo a partir de um ficheiro
     *
     * @param openFile - Ficheiro a carregar
     *
     * @return Devolve uma instância do jogo gravado
     */
    public static J2Gether load(File openFile) {
        J2Gether jogo = null;
        FileInputStream f = null;
        try {
            ObjectInputStream i = new ObjectInputStream(f = new FileInputStream(openFile));
            jogo = (J2Gether) i.readObject();
            jogo.recreate();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (f != null)
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            return jogo;
        }
    }

    /**
     * Adiciona uma jogada de undo
     */
    public void addUndo() {
        ObjectOutputStream os = null;
        try {
            undoList[(++undoIndice) % MAX_UNDO].reset();
            os = new ObjectOutputStream(new BufferedOutputStream(undoList[(undoIndice) % MAX_UNDO]));
            os.writeObject(new UndoMove());
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (os != null)
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
        }
        redoMax = undoIndice;
        if (undoIndice > redoMin)
            redoMin = undoIndice;
    }

    /**
     * Executa um undo
     */
    public void undo() {
        if (undoAllowed())
            undoRedo(DO_UNDO);
    }

    /**
     * Executa um redo
     */
    public void redo() {
        if (redoAllowed())
            undoRedo(DO_REDO);
    }

    /**
     * Verifica se pode ser feito um undo
     *
     * @return true  - É permitido fazer undo
     *         false - Não é permitido fazer undo
     */
    public boolean undoAllowed() {
        return undoIndice > 0 && undoIndice % MAX_UNDO - 1 - redoMin % MAX_UNDO != 0;
    }

    /**
     * Verifica se pode ser feito um redo
     *
     * @return true  - É permitido fazer redo
     *         false - Não é permitido fazer redo
     */
    public boolean redoAllowed() {
        return undoIndice % MAX_UNDO != redoMin % MAX_UNDO && undoIndice % MAX_UNDO != redoMax % MAX_UNDO;
    }

    public void addJ2GetherListener(J2GetherListener l) {
        if (listeners == null)
            listeners = new LinkedList();
        listeners.add(l);
    }

    public void removeJ2GetherListener(J2GetherListener l) {
        if (listeners != null)
            listeners.remove(l);
    }

    public void fireJ2GetherChanged() {
        if (listeners != null) {
            Iterator it = listeners.iterator();
            while (it.hasNext())
                ((J2GetherListener) it.next()).j2getherChanged(new J2GetherEvent(this));
        }
    }

    /**
     * Verifica se existem peças candidatas
     *
     * @return true  - Existem peças candidatas
     *         false - Não existem peças candidatas
     */
    public boolean hasPecasSelected() {
        return !pecasCandidatas.isEmpty();
    }

    /**
     * Calcula e devolve a pontuação final do jogo
     *
     * @return Pontuação final do jogo
     */
    public double getPontuacaoFinal() {
        return pecasNoTabuleiro.isEmpty() ? pontuacaoTotal : pontuacaoTotal - pecasNoTabuleiro.size();
    }

    /**
     * Calcula e devolve a pontuação do conjunto de peças candidatas actual
     *
     * @return Pontuação do conjunto de peças candidatas actual
     */
    public double getPontuacaoJogada() {
        return pecasCandidatas.isEmpty() ? 0.0 : Math.pow(pecasCandidatas.size() - 2, 2);
    }

    /**
     * Devolve a peça que se encontra na posição (linha, coluna)
     *
     * @param linha  - Linha da peça pretendida
     * @param coluna - Coluna da peça pretendida
     * @return Peça pretendida
     */
    public Peca getValueAt(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public void alterarModo(int modo) {
        this.modo = modo;
    }

    public String getNomeModo() {
        return modos[modo].toString();
    }

    public int getHeight() {
        return tabuleiro.length;
    }

    public int getWidth() {
        return tabuleiro[0].length;
    }

    public Score getScores() {
        return tabelaPontuacoes;
    }

    public double getPontuacao() {
        return pontuacaoTotal;
    }

    public int getNumCores() {
        return numCores;
    }

    public int getModoActual() {
        return modo;
    }

    public boolean perdeu() {
        return perdeu;
    }

    public boolean ganhou() {
        return ganhou;
    }

    public boolean isInvalida() {
        return invalida;
    }

    public boolean isDroped() {
        return droped;
    }



////////// Inner Classes ///////////////////////////////////////////////////////

    /**
     * Classe que encapsula os atributos necessários à realização da operação de undo e redo
     */
    private class UndoMove implements Serializable {

        private Peca[][] savTabuleiro;
        private double savPontuacao;
        private LinkedList savPecasNoTabuleiro;

        /**
         * Constrói um UndoMove para o tabuleiro dado.
         */
        private UndoMove() {
            savTabuleiro = tabuleiro;
            savPontuacao = pontuacaoTotal;
            savPecasNoTabuleiro = pecasNoTabuleiro;
        }

    }


    /**
     * Classe que encapsula os extremos do conjunto de colunas com peças candidatas
     */
    private class J2GetherMinMax {

        private int min;
        private int max;

        private J2GetherMinMax(int min, int max) {
            this.min = min;
            this.max = max;
            int col = -1;
            Iterator it = pecasCandidatas.iterator();
            while (it.hasNext()) {
                col = ((Peca) it.next()).getPosicao().getColuna();
                if (col > this.max)
                    this.max = col;
                if (col < this.min)
                    this.min = col;
            }
        }
    }


    /**
     * Modo genérico do J2Gether
     */
    public abstract class ModoJ2Gether implements Serializable {

        public static final int RECURSIVO = 0;
        public static final int ITERATIVO = 1;

        public abstract void select(int linha, int coluna, int cor);
        public abstract String toString();
    }


    /**
     * Modo recursivo do J2Gether
     */
    private class ModoJ2GetherRecursivo extends ModoJ2Gether implements Serializable {

        /**
         * Método recursivo que permite seleccionar peças candidatas
         *
         * @param linha  - Linha do tabuleiro onde se encontra a peça inicial
         * @param coluna - Coluna do tabuleiro onde se encontra a peça inicial
         * @param cor    - Cor das peças a seleccionar
         */
        public void select(int linha, int coluna, int cor) {

            if (tabuleiro[linha][coluna].isIncolor() ||
                !hasAdajcentes(linha, coluna) ||
                tabuleiro[linha][coluna].isCandidata() ||
                !tabuleiro[linha][coluna].sameColour(cor))
                return;

            tabuleiro[linha][coluna].select();
            pecasCandidatas.add(tabuleiro[linha][coluna]);

            if (linha < tabuleiro.length - 1)
                select(linha + 1, coluna, cor);

            if (linha > 0)
                select(linha - 1, coluna, cor);

            if (coluna < tabuleiro[0].length - 1)
                select(linha, coluna + 1, cor);

            if (coluna > 0)
                select(linha, coluna - 1, cor);
        }

        public String toString() {
            return "Recursivo";
        }
    }


    /**
     * Modo iterativo do J2Gether
     */
    private class ModoJ2GetherIterativo extends ModoJ2Gether implements Serializable {

        /**
         * Pilha a ser utilizada pelo método select
         */
        private StackArray stack = new StackArray(80);

        /**
         * Método iterativo que permite seleccionar peças candidatas
         *
         * @param linha  - Linha do tabuleiro onde se encontra a peça inicial
         * @param coluna - Coluna do tabuleiro onde se encontra a peça inicial
         * @param cor    - Cor das peças a seleccionar
         */
        public void select(int linha, int coluna, int cor) {
            int lin, col;
            Peca peca = tabuleiro[linha][coluna];

            if(!hasAdajcentes(linha, coluna))
                return;

            while (true) {
                if (peca.isIncolor() || peca.isCandidata() || !peca.sameColour(cor)) {
                    if (stack.isEmpty())
                        return;
                    peca = (Peca) stack.pop();

                } else {
                    peca.select();
                    pecasCandidatas.add(peca);

                    lin = peca.getPosicao().getLinha();
                    col = peca.getPosicao().getColuna();
                    if (lin < tabuleiro.length - 1)
                        stack.push(tabuleiro[lin + 1][col]);

                    if (lin > 0)
                        stack.push(tabuleiro[lin - 1][col]);

                    if (col < tabuleiro[0].length - 1)
                        stack.push(tabuleiro[lin][col + 1]);

                    if (col > 0)
                        peca = tabuleiro[lin][col - 1];
                }
            }
        }


        public String toString() {
            return "Iterativo";
        }
    }

}
