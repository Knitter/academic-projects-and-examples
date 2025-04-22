
import pt.ipleiria.estg.ia.sudokusolver.solver.AlgoritmoGenetico;
import pt.ipleiria.estg.ia.sudokusolver.solver.Gene;
import pt.ipleiria.estg.ia.sudokusolver.solver.Individuo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Knitter
 */
public class RunningTests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gene[][] base = new Gene[][]{
            {new Gene(true, 5), new Gene(true, 3), null, null, new Gene(true, 7), null, null, null, null},
            {new Gene(true, 6), null, null, new Gene(true, 1), new Gene(true, 9), new Gene(true, 5), null, null, null},
            {null, new Gene(true, 9), new Gene(true, 8), null, null, null, null, new Gene(true, 6), null},
            {new Gene(true, 8), null, null, null, new Gene(true, 6), null, null, null, new Gene(true, 3)},
            {new Gene(true, 4), null, null, new Gene(true, 8), null, new Gene(true, 3), null, null, new Gene(true, 1)},
            {new Gene(true, 7), null, null, null, new Gene(true, 2), null, null, null, new Gene(true, 6)},
            {null, new Gene(true, 6), null, null, null, null, new Gene(true, 2), new Gene(true, 8), null},
            {null, null, null, new Gene(true, 4), new Gene(true, 1), new Gene(true, 9), null, null, new Gene(true, 5)},
            {null, null, null, null, new Gene(true, 8), null, null, new Gene(true, 7), new Gene(true, 9)}
        };

        Gene[][] correcto = new Gene[][]{
            {new Gene(true, 7), new Gene(true, 8), new Gene(true, 3), new Gene(true, 6), new Gene(true, 5), new Gene(true, 1), new Gene(true, 9), new Gene(true, 2), new Gene(true, 4)},
            {new Gene(true, 5), new Gene(true, 9), new Gene(true, 6), new Gene(true, 8), new Gene(true, 2), new Gene(true, 4), new Gene(true, 1), new Gene(true, 3), new Gene(true, 7)},
            {new Gene(true, 4), new Gene(true, 1), new Gene(true, 2), new Gene(true, 9), new Gene(true, 7), new Gene(true, 3), new Gene(true, 8), new Gene(true, 5), new Gene(true, 6)},
            {new Gene(true, 2), new Gene(true, 5), new Gene(true, 8), new Gene(true, 3), new Gene(true, 6), new Gene(true, 9), new Gene(true, 7), new Gene(true, 4), new Gene(true, 1)},
            {new Gene(true, 6), new Gene(true, 7), new Gene(true, 4), new Gene(true, 5), new Gene(true, 1), new Gene(true, 8), new Gene(true, 3), new Gene(true, 9), new Gene(true, 2)},
            {new Gene(true, 1), new Gene(true, 3), new Gene(true, 9), new Gene(true, 7), new Gene(true, 4), new Gene(true, 2), new Gene(true, 6), new Gene(true, 8), new Gene(true, 5)},
            {new Gene(true, 8), new Gene(true, 2), new Gene(true, 1), new Gene(true, 4), new Gene(true, 9), new Gene(true, 7), new Gene(true, 5), new Gene(true, 6), new Gene(true, 3)},
            {new Gene(true, 3), new Gene(true, 6), new Gene(true, 7), new Gene(true, 2), new Gene(true, 8), new Gene(true, 5), new Gene(true, 4), new Gene(true, 1), new Gene(true, 9)},
            {new Gene(true, 9), new Gene(true, 4), new Gene(true, 5), new Gene(true, 1), new Gene(true, 3), new Gene(true, 6), new Gene(true, 2), new Gene(true, 7), new Gene(true, 8)}
        };

        Gene[][] zero = new Gene[][]{
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)},
            {new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2), new Gene(false, 2)}
        };

        Gene[][] um = new Gene[][]{
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)},
            {new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1), new Gene(false, 1)}
        };

        Individuo indZero = new Individuo(zero);
        Individuo indUm = new Individuo(um);
        uniformcross(indZero, indUm);
        System.out.println(indZero);
        System.out.println("========================================");
        System.out.println(indUm);
    }

    private static void uniformcross(Individuo individuo1, Individuo individuo2) {
        Gene g1, g2;
        int y, alelo;
        for (int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
            for (y = 0; y < Individuo.TAMANHOGENOMA; y++) {
                g1 = individuo1.getGene(z, y);
                g2 = individuo2.getGene(z, y);
                if (!g1.isLocked() && !g2.isLocked() &&
                        g1.getAlelo() != g2.getAlelo() &&
                        Math.random() >= 0.5) {

                    alelo = g1.getAlelo();
                    g1.setAlelo(g2.getAlelo());
                    g2.setAlelo(alelo);
                }
            }
        }
    }

    private static void testeTroca(Individuo individuo1) {
        Individuo temp = (Individuo) individuo1.clone();
        temp.setGene(5, 5, new Gene(false, 5));
        //individuo1 = temp;
        for (int z = 0; z < 9; z++) {
            for (int y = 0; y < 9; y++) {
                individuo1.setGene(z, y, temp.getGene(z, y));
            }
        }
        System.out.println(temp);
    }

    private static void mutacaoComRestricao(Individuo individuo1) {
        Individuo temp = (Individuo) individuo1.clone();

        while (temp.getFitness() >= individuo1.getFitness()) {
            //mutacao simples    
        }
        individuo1 = temp;
    }

    private static void cut2(Individuo individuo1, Individuo individuo2) {
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

    private static void cut(Individuo individuo1, Individuo individuo2) {
        int cuttingEdge = 3;
        int x = 0;
        Gene gtemp;
        Gene[][] cup = new Gene[Individuo.TAMANHOGENOMA][Individuo.TAMANHOGENOMA - cuttingEdge];
        int y;
        for (int z = 0; z < Individuo.TAMANHOGENOMA; z++) {
            for (y = 0; y + cuttingEdge < Individuo.TAMANHOGENOMA; y++) {
                if (!(gtemp = individuo1.getGene(z, y + cuttingEdge)).isLocked()) {
                    System.out.println("hey!" + ++x);
                    cup[z][y] = individuo1.getGene(z, y + cuttingEdge);
                    individuo1.setGene(z, y + cuttingEdge, individuo2.getGene(z, y + cuttingEdge));
                    individuo2.setGene(z, y + cuttingEdge, cup[z][y]);
                }
            }
        }
    }
}
