package pt.ipleiria.estg.ia.sudokusolver.solver;

public class OperadorGenetico {

    protected double probabilidade;

    public OperadorGenetico(double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public double getProbabilidade() {
        return probabilidade;
    }
}