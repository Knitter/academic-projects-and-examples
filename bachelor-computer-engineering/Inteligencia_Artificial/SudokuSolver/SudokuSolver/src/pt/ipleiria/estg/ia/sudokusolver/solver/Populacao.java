package pt.ipleiria.estg.ia.sudokusolver.solver;

public class Populacao {

    private Individuo[] individuos;

    /**
     * 
     * @param tamanhoPopulacao
     */
    public Populacao(int tamanhoPopulacao) {
        individuos = new Individuo[tamanhoPopulacao];
    }
    
    /**
     * 
     * @param tamanho
     * @param genomaInicial
     */
    public Populacao(int tamanho, Gene[][] genomaInicial) {
        this(tamanho);
        for(int z = tamanho; z-- > 0;) {
            individuos[z] = new Individuo(genomaInicial);
        }
    }

    /**
     * 
     * @param individuo
     * @param indice
     */
    public void setIndividuo(Individuo individuo, int indice) {
        individuos[indice] = individuo;
    }

    /**
     * 
     * @param indice
     * @return
     */
    public Individuo getIndividuo(int indice) {
        return individuos[indice];
    }

    /**
     * 
     * @return
     */
    public int getTamanho() {
        return individuos.length;
    }

    /**
     * 
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int g = 0; g < individuos.length; g++) {
            //sb.append(individuos[g] + "\n");
            sb.append("Fitness: " + individuos[g].getFitness() + "\n");
        }
        return sb.toString();
    }   
}