package pt.ipleiria.estg.ia.sudokusolver.solver;

public class Mutacao extends OperadorGenetico {

    public static final int BLOCK_SIZE = 3;
    public static final int SIMPLES = 0;
    public static final int TROCA_BLOCOS = 1;
    public static final int QUANTIDADE = 2;
    public static final int RESTRICOES = 3;
    public static final int SIMPLES_ALEATORIA = 4;
    public static final int TROCA_GENES = 5;
    private int selected;

    public Mutacao(double probabilidade, int tipo) {
        super(probabilidade);
        selected = tipo;
    }

    /**
     * 
     * @param individuo
     */
    public void executar(Individuo individuo) {
        switch (selected) {
            case TROCA_BLOCOS:
                mutacaoPorTrocaDeBlocos(individuo);
                break;
            case QUANTIDADE:
                mutacaoEmQuantidade(individuo);
                break;
            case RESTRICOES:
                mutacaoComRestricoes(individuo);
                break;
            case SIMPLES_ALEATORIA:
                mutacaoSimplesAleatoria(individuo);
                break;
            case TROCA_GENES:
                mutacaoPorTrocaDeGenes(individuo);
                break;
            default:
                mutacaoSimples(individuo);
        }
    }

    /**
     * 
     * @param individuo
     */
    @SuppressWarnings("empty-statement")
    private void mutacaoSimplesAleatoria(Individuo individuo) {
        Gene g;
        while ((g = individuo.getGene((int) (Math.random() * 9), (int) (Math.random() * 9))).isLocked());
        if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {
            g.setAlelo((int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9) + 1);
        }
    }

    /**
     * 
     * @param individuo
     */
    private void mutacaoSimples(Individuo individuo) {
        int c;
        for (int l = 0; l < Individuo.TAMANHOGENOMA; l++) {
            for (c = 0; c < Individuo.TAMANHOGENOMA; c++) {
                if (!individuo.getGene(l, c).isLocked()) {
                    if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {
                        individuo.getGene(l, c).setAlelo((int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9) + 1);
                    }
                }
            }
        }
    }

    /**
     * 
     * @param individuo
     */
    @SuppressWarnings("empty-statement")
    private void mutacaoPorTrocaDeGenes(Individuo individuo) {
        Gene g1, g2, cup;
        int x1, y1;
        int x2, y2;
        for (int z = 5; z-- > 0;) {
            while ((g1 = individuo.getGene((x1 = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9)), (y1 = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9)))).isLocked());
            while ((g2 = individuo.getGene((x2 = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9)), (y2 = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9)))).isLocked());
            if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {
                cup = g1;
                individuo.setGene(x1, y1, g2);
                individuo.setGene(x2, y2, cup);
            }
        }
    }

    /**
     * 
     * @param individuo
     */
    @SuppressWarnings("empty-statement")
    private void mutacaoPorTrocaDeBlocos(Individuo individuo) {
        if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {//NOTA: Probabilidade?!
            Gene[][] cup = new Gene[3][3];

            int linhaA = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 6), colunaA = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 6);
            int linhaB, colunaB;
            //Poderao existir sobreposicoes.
            while ((linhaB = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 6)) == linhaA);
            while ((colunaB = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 6)) == colunaA);

            int y;
            for (int z = 0; z < 3; z++) {
                for (y = 0; y < 3; y++) {
                    if (!individuo.getGene(linhaA + z, colunaA + y).isLocked()) {
                        cup[z][y] = individuo.getGene(linhaA + z, colunaA + y);
                        individuo.setGene(linhaA + z, colunaA + y, individuo.getGene(linhaB + z, colunaB + y));
                        individuo.setGene(linhaB + z, colunaB + y, cup[z][y]);
                    }
                }
            }
        }
    }

    /**
     * 
     * @param individuo
     */
    private void mutacaoEmQuantidade(Individuo individuo) {
        if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {
            //Valores poderiam ser alterados
            for (int size = (int) (AlgoritmoGenetico.aleatorio.nextDouble() * 41) + 5; size-- > 0;) {
                mutacaoSimplesAleatoria(individuo);
            }
        }
    }

    /**
     * 
     * @param individuo
     */
    private void mutacaoComRestricoes(Individuo individuo) {
        Individuo temp = (Individuo) individuo.clone();
        int tentativa = 0;
        while (temp.calculaFitness() >= individuo.getFitness() && tentativa++ < 100) {
            temp = (Individuo) individuo.clone();
            mutacaoSimples(temp);
        }

        int y;
        for (int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
            for (y = 0; y < Individuo.TAMANHOGENOMA; y++) {
                individuo.setGene(z, y, temp.getGene(z, y));
            }
        }
    }

    @Override
    public String toString() {
        switch (selected) {
            case TROCA_BLOCOS:
                return "Troca De Blocos";
            case QUANTIDADE:
                return "Em Quantidade";
            case RESTRICOES:
                return "Com Restricoes";
            case SIMPLES_ALEATORIA:
                return "Simples Al.";
            case TROCA_GENES:
                return "Troca de Genes";
            default:
                return "Simples";
        }
    }
}