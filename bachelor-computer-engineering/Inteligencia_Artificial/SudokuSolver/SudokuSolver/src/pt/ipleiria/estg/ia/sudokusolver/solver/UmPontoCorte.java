/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.ia.sudokusolver.solver;

/**
 *
 * @author knitter
 */
public class UmPontoCorte extends Recombinacao {

    public UmPontoCorte(double probabilidade) {
        super(probabilidade);
    }

    /**
     * 
     * @param individuo1
     * @param individuo2
     */
    @Override
    public void executar(Individuo individuo1, Individuo individuo2) {
        if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {
           corte(individuo1, individuo2);
        }
    }
    
    /**
     * 
     * @param individuo1
     * @param individuo2
     */
    private void corte(Individuo individuo1, Individuo individuo2) {
        int cuttingEdge = 3;
        Gene gtemp;
        Gene[][] cup = new Gene[Individuo.TAMANHOGENOMA][Individuo.TAMANHOGENOMA - cuttingEdge];
        int y;
        for(int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
            for(y = 0; y + cuttingEdge < Individuo.TAMANHOGENOMA; y++) {
                if(!(gtemp = individuo1.getGene(z, y + cuttingEdge)).isLocked()) {
                    cup[z][y] = individuo1.getGene(z, y + cuttingEdge);
                    individuo1.setGene(z, y + cuttingEdge, individuo2.getGene(z, y + cuttingEdge));
                    individuo2.setGene(z, y + cuttingEdge, cup[z][y]);
                }
            }
        }
    }
}