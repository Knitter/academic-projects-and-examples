package pt.ipleiria.estg.ia.sudokusolver.solver;

import java.util.ArrayList;
import java.util.Collections;

public class Torneio extends MetodoSeleccao {

    private int tamanho;

    /**
     * Cria um torneio onde, por omissao, serao seleccionados dois individuos 
     * de cada vez para as competicoes
     */
    public Torneio() {
        this(2);
    }

    /**
     * Criacao de um torneio com tamanho especificado
     * 
     * @param tamanho Tamanho da amostra de individuos a submeter a competicao.
     */
    public Torneio(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Para todas as posicoes da populacao e' aplicado o algoritmo de seleccao 
     * por torneio, criando assim uma nova populacao onde podem existir individuos 
     * repetidos.
     *  
     * @param populacaoOrigem Populacao a alterar
     * @return Populacao alterada com os novos individuos
     */
    public Populacao executar(Populacao populacaoOrigem) {
        Populacao resultante = new Populacao(populacaoOrigem.getTamanho());
        for (int z = populacaoOrigem.getTamanho(); z-- > 0;) {
            resultante.setIndividuo(torneio1(populacaoOrigem), z);
        }
        return resultante;
    }

    /**
     * O algoritmo escolhe, aleatoriamente, um conjunto de individuos de entre a
     * populacao. O conjunto tem um tamanho igual ao indicado na criacao do 
     * torneio.
     * Ordena-os por ordem de fitness e devolve o individuo com valor de fitness 
     * mais elevado.
     * 
     * @param populacao Populacao de entre a qual se obtem os inviduos
     * @return Individuo escolhido
     */
    private Individuo torneio1(Populacao populacao) {
        ArrayList<Individuo> seleccionados = new ArrayList<Individuo>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            seleccionados.add(populacao.getIndividuo((int) (AlgoritmoGenetico.aleatorio.nextDouble() * populacao.getTamanho())));
        }
        
        Collections.sort(seleccionados);
        return (Individuo) seleccionados.get(0).clone();
    }
    
    private Individuo torneio2(Populacao populacao) {
        ArrayList<Individuo> seleccionados = new ArrayList<Individuo>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            seleccionados.add(populacao.getIndividuo((int) (AlgoritmoGenetico.aleatorio.nextDouble() * populacao.getTamanho())));
        }

        if (AlgoritmoGenetico.aleatorio.nextDouble() > 0.5) {
            return (Individuo) seleccionados.get(0).clone();
        }
        Collections.sort(seleccionados);
        if (AlgoritmoGenetico.aleatorio.nextDouble() < 0.3) {
            return (Individuo) seleccionados.get(seleccionados.size() - 1).clone();
        }
        
        return (Individuo) seleccionados.get(0).clone();
    }
    
    @Override
    public String toString() {
        return "Torneio";
    }
}