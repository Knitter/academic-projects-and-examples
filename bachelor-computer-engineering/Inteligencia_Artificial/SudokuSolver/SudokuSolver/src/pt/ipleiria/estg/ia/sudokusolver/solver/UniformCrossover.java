/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.ia.sudokusolver.solver;

/**
 *
 * @author Knitter
 */
public class UniformCrossover extends Recombinacao {

    public UniformCrossover(double probabilidade) {
        super(probabilidade);
    }

    @Override
    public void executar(Individuo individuo1, Individuo individuo2) {
        uniformCrossover(individuo1, individuo2);
    }

    private void uniformCrossover(Individuo individuo1, Individuo individuo2) {
        if (getProbabilidade() >= AlgoritmoGenetico.aleatorio.nextDouble()) {

            Gene g1, g2;
            int y, alelo;
            for (int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
                for (y = 0; y < Individuo.TAMANHOGENOMA; y++) {
                    g1 = individuo1.getGene(z, y);
                    g2 = individuo2.getGene(z, y);
                    if (!g1.isLocked() && !g2.isLocked() &&
                            g1.getAlelo() != g2.getAlelo() &&
                            AlgoritmoGenetico.aleatorio.nextDouble() >= 0.5) {
                       
                        alelo = g1.getAlelo();
                        g1.setAlelo(g2.getAlelo());
                        g2.setAlelo(alelo);
                    }
                }
            }
        }
    }
}
