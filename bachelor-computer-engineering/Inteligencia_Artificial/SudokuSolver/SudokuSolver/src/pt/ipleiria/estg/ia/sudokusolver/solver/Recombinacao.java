package pt.ipleiria.estg.ia.sudokusolver.solver;

public abstract class Recombinacao extends OperadorGenetico {

    public Recombinacao(double probabilidade) {
        super(probabilidade);
    }

    public abstract void executar(Individuo individuo1, Individuo individuo2);
}