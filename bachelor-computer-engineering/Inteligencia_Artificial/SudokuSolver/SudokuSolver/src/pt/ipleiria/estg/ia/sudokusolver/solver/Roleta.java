package pt.ipleiria.estg.ia.sudokusolver.solver;

public class Roleta extends MetodoSeleccao {

    /**
     * 
     * @param populacaoOrigem
     * @return
     */
    public Populacao executar(Populacao populacaoOrigem) {
        double acumulado = 0.0;
        Populacao resultante = new Populacao(populacaoOrigem.getTamanho());

        for (int z = populacaoOrigem.getTamanho(); z-- > 0;) {
            acumulado += populacaoOrigem.getIndividuo(z).getFitness();
            populacaoOrigem.getIndividuo(z).setAcumulado(acumulado);
        }

        for (int z = populacaoOrigem.getTamanho(); z-- > 0;) {
            populacaoOrigem.getIndividuo(z).setAcumulado(populacaoOrigem.getIndividuo(z).getAcumulado() / (double) acumulado);
        }
         
        for (int z = populacaoOrigem.getTamanho(); z-- > 0;) {
            resultante.setIndividuo(roleta(populacaoOrigem), z);
        }
        return resultante;
    }

    /**
     * 
     * @param populacao
     * @return
     */
    @SuppressWarnings("empty-statement")
    private Individuo roleta(Populacao populacao) {
        double probabilidade = AlgoritmoGenetico.aleatorio.nextDouble();
        int z = 0;
        for(; probabilidade > populacao.getIndividuo(z).getAcumulado(); z++);
        return (Individuo) populacao.getIndividuo(z).clone();
    }
    
    @Override
    public String toString() {
        return "Roleta";
    }    
}