/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.ia.sudokusolver.solver;

import java.util.Hashtable;

/**
 *
 * @author user
 */
public class Individuo implements Comparable {

    public static final int TAMANHOGENOMA = 9;
    private double fitness = -1;
    private double acumulado;
    private Gene[][] cromossoma;
    protected int[] intg;

    /**
     * 
     */
    public Individuo() {
        cromossoma = new Gene[TAMANHOGENOMA][TAMANHOGENOMA];
        intg = new int[TAMANHOGENOMA];
        for (int z = TAMANHOGENOMA; z-- > 0;) {
            intg[z] = 0;
        }

        int y;
        for (int z = 0; z < cromossoma.length; z++) {
            for (y = 0; y < cromossoma[z].length; y++) {
                this.cromossoma[z][y] = new Gene(this);
            }
        }
    }

    /**
     * 
     * @param cromossoma
     * @param fitness
     * @param acumulado
     */
    public Individuo(Gene[][] cromossoma, double fitness, double acumulado) {
        this.fitness = fitness;
        this.acumulado = acumulado;
        intg = new int[TAMANHOGENOMA];
        for (int z = TAMANHOGENOMA; z-- > 0;) {
            intg[z] = 0;
        }

        this.cromossoma = new Gene[cromossoma.length][cromossoma.length];
        int y;
        for (int z = 0; z < cromossoma.length; z++) {
            for (y = 0; y < cromossoma[z].length; y++) {
                if (cromossoma[z][y] != null) {
                    this.cromossoma[z][y] = new Gene(cromossoma[z][y].isLocked(), cromossoma[z][y].getAlelo());
                } else {
                    this.cromossoma[z][y] = new Gene(this);
                }
            }
        }
    }

    /**
     * 
     * @param cromossoma
     */
    public Individuo(Gene[][] cromossoma) {
        this(cromossoma, -1, 0);
    }

    /**
     * 
     * @param linha
     * @param coluna
     * @return
     */
    private int repeticaoPorCubos(int linha, int coluna) {
        Hashtable<Integer, Integer> cubos = new Hashtable<Integer, Integer>(9);
        int y;

        for (int z = linha; z < linha + 3; z++) {
            for (y = coluna; y < coluna + 3; y++) {
                cubos.put(cromossoma[z][y].getAlelo(), cromossoma[z][y].getAlelo());
            }
        }
        return 9 - cubos.size();
    }

    /**
     * 
     * @return
     */
    public double calculaFitness() {
        Hashtable<Integer, Integer> colunas = new Hashtable<Integer, Integer>(9);
        Hashtable<Integer, Integer> linhas = new Hashtable<Integer, Integer>(9);
        int y;
        int repLinhas = 0;
        int repColunas = 0;
        int repCubos = 0;
        //contar repeticoes por linha
        for (int z = TAMANHOGENOMA; z-- > 0;) {
            linhas.clear();
            for (y = TAMANHOGENOMA; y-- > 0;) {
                linhas.put(cromossoma[z][y].getAlelo(), cromossoma[z][y].getAlelo());
            }
            repLinhas += 9 - linhas.size();
        }

        //contar repeticoes por coluna
        for (int z = TAMANHOGENOMA; z-- > 0;) {
            colunas.clear();
            for (y = TAMANHOGENOMA; y-- > 0;) {
                colunas.put(cromossoma[y][z].getAlelo(), cromossoma[y][z].getAlelo());
            }
            repColunas += 9 - colunas.size();
        }

        //repeticao por cubos 3x3
        for (int z = 0; z < TAMANHOGENOMA; z += 3) {
            for (y = 0; y < TAMANHOGENOMA; y += 3) {
                repCubos += repeticaoPorCubos(z, y);
            }
        }

        return (fitness =  repColunas + repCubos + repLinhas);
    }

    /**
     * 
     * @return
     */
    public double getFitness() {
        if (fitness < 0) {
            fitness = calculaFitness();
        }
        return fitness;
    }

    /**
     * 
     * @param acumulado
     */
    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    /**
     * 
     * @return
     */
    public double getAcumulado() {
        return acumulado;
    }

    /**
     * 
     * @param l
     * @param c
     * @return
     */
    public Gene getGene(int l, int c) {
        return cromossoma[l][c];
    }

    /**
     * 
     * @param l
     * @param c
     * @param gene
     */
    public void setGene(int l, int c, Gene gene) {
        cromossoma[l][c] = gene;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Fitness: " + fitness + " | Acumulado: " + acumulado + "\n");

        int y;
        for (int z = 0; z < TAMANHOGENOMA; z++) {
            for (y = 0; y < TAMANHOGENOMA; y++) {
                sb.append(cromossoma[z][y]);
                if ((y + 1 != 9) && ((y + 1) % 3 == 0)) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }

            if ((z + 1 != 9) && ((z + 1) % 3 == 0)) {
                sb.append("\n-----+-----+-----");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String imprimirGenoma() {
        StringBuffer sb = new StringBuffer();

        int y;
        for (int z = 0; z < TAMANHOGENOMA; z++) {
            for (y = 0; y < TAMANHOGENOMA; y++) {
                sb.append(cromossoma[z][y]);
                if ((y + 1 != 9) && ((y + 1) % 3 == 0)) {
                    sb.append("|");
                } else {
                    sb.append(" ");
                }
            }

            if ((z + 1 != 9) && ((z + 1) % 3 == 0)) {
                sb.append("\n-----+-----+-----");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Object clone() {
        return new Individuo(cromossoma, fitness, acumulado);
    }

    public int compareTo(Object o) {
        return (int) (getFitness() - ((Individuo) o).getFitness());
    }
}
