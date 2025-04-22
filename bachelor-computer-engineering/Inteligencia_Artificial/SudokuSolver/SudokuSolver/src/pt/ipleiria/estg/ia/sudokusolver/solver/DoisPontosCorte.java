/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.ia.sudokusolver.solver;

/**
 *
 * @author knitter
 */
public class DoisPontosCorte extends Recombinacao {

    public DoisPontosCorte(double probabilidade) {
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
        Gene[][] cup = new Gene[Individuo.TAMANHOGENOMA][3];
        int y;
        for (int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
            for (y = 0; y < 3; y++) {
                if (!individuo1.getGene(z, y).isLocked()) {
                    cup[z][y] = individuo1.getGene(z, y);
                    individuo1.setGene(z, y, individuo2.getGene(z, y));
                    individuo2.setGene(z, y, cup[z][y]);
                }
            }

            for (y = 6; y < 9; y++) {
                if (!individuo1.getGene(z, y).isLocked()) {
                    cup[z][y - 6] = individuo2.getGene(z, y);
                    individuo2.setGene(z, y, individuo1.getGene(z, y));
                    individuo1.setGene(z, y, cup[z][y - 6]);
                }
            }
        }
    }
}
