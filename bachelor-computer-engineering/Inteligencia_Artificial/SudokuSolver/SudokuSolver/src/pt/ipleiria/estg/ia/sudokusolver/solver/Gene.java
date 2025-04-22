/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.ia.sudokusolver.solver;

/**
 *
 * @author user
 */
public class Gene {

    private boolean locked;
    private int alelo;

    /**
     * 
     */
    public Gene() {
        this(false, ((int) (AlgoritmoGenetico.aleatorio.nextDouble() * 9)) + 1);
    }

    /**
     * 
     * @param individuo
     */
    @SuppressWarnings("empty-statement")
    public Gene(Individuo individuo) {
        //int x;
        //while (individuo.intg[(x = (int) (Math.random() * 9))] >= 9);
        //individuo.intg[x]++;
        //this.locked = false;
        //setAlelo(x + 1);
        this();
    }

    /**
     * 
     * @param locked
     * @param alelo
     */
    public Gene(boolean locked, int alelo) {
        this.locked = locked;
        setAlelo(alelo);
    }

    /**
     * Identifica um gene como estando bloqueado, um gene bloqueado nao pode 
     * ver o seu alelo ser alterado.
     * @return
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Devolve o alelo de um gene. Um alelo de um gene e' o valor que o gene 
     * representa, variando entre 1 e 9
     * @return int representando o valor do gene
     */
    public int getAlelo() {
        return alelo;
    }

    /**
     * 
     * @param alelo
     */
    public void setAlelo(int alelo) {
        if (alelo < 1 || alelo > 9) {
            throw new IllegalArgumentException("Valor inv\u00e1lido para o alelo! Valores v\u00e1lidos: [1, 9]");
        }
        this.alelo = alelo;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        return "" + alelo;
    }
}
