package pt.ipleiria.estg.ia.sudokusolver.solver;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgoritmoGenetico {

    public static Random aleatorio;
    private static final String OUTPUT_FILE = "output.txt";
    private int tamanhoPopulacao;
    private int maximoGeracoes;
    private Populacao populacaoActual;
    private Recombinacao operador;
    private Mutacao mutacao;
    private MetodoSeleccao seleccao;
    private double probRecombinacao;
    private double probMutacao;
    private Individuo melhorIndividuoGeracao;
    private double mediaGeracao;
    private Individuo melhorIndividuoRun;
    private int geracaoDoMelhorIndividuoRun;
    private int geracao;
    private int geracaoMelhorIndividuoRun;
    private Populacao proxima;
    private boolean running = true;
    //
    private Vector<AlgoritmoGeneticoListener> listeners;
    PrintStream ps;
    //
    private Individuo piorIndividuoGeracao;
    private double relacaoMelhorPior;

    public AlgoritmoGenetico(long seed) {
        aleatorio = new Random(seed);
    }

    /**
     * 
     * @param seed
     * @param tamanhoPopulacao
     * @param maximoGeracoes
     * @param seleccao
     * @param probRecombinacao
     * @param probMutacao
     * @param operador
     * @param genoma
     * @param tipoMutacao
     */
    public AlgoritmoGenetico(long seed, int tamanhoPopulacao, int maximoGeracoes, MetodoSeleccao seleccao,
            double probRecombinacao, double probMutacao, Recombinacao operador,
            Gene[][] genoma, int tipoMutacao) {

        listeners = new Vector<AlgoritmoGeneticoListener>();
        aleatorio = (seed == 0 ? new Random() : new Random(seed));
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.maximoGeracoes = maximoGeracoes;
        this.seleccao = seleccao;
        this.probMutacao = probMutacao;
        this.probRecombinacao = probRecombinacao;
        this.operador = operador;
        mutacao = new Mutacao(probMutacao, tipoMutacao);

        populacaoActual = new Populacao(tamanhoPopulacao, genoma);
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(OUTPUT_FILE)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlgoritmoGenetico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executar() {
        // t = 0
        // gerar_população_inicial (P(t))
        // avaliar (P(t))
        // enquanto critério de paragem não satisfeito
        //     P'(t) = seleccionar(P(t))
        //     P''(t) = aplicar_operadores_genéticos(P'(t))
        //     P(t + 1) = criar_população_seguinte(P(t), P''(t))
        //     avaliar(P(t + 1))
        //     t= t+ 1
        // fim
        //     devolver melhor indivíduo
        new Thread(new Runnable() {

            public void run() {
                imprimirCabecalho(ps);

                avaliar(populacaoActual);
                for (geracao = 0; running && !criterioParagem(populacaoActual, geracao); geracao++) {
                    fireCurrentGeneration(geracao);
                    proxima = seleccao(populacaoActual);
                    proxima = recombinacao(proxima);
                    proxima = mutacao(proxima);
                    populacaoActual = criarNovaPopulacao(populacaoActual, proxima);
                    avaliar(populacaoActual);
                }
                ps.close();
                fireRunFinished();
            }
        }).start();
    }

    /**
     * 
     */
    public void parar() {
        running = false;
    }

    /**
     * 
     * @param populacaoActual
     * @return
     */
    private Populacao seleccao(Populacao populacaoActual) {
        return seleccao.executar(populacaoActual);
    }

    /**
     * 
     * @param populacao
     * @return
     */
    private Populacao recombinacao(Populacao populacao) {
        for (int z = 0; z < populacao.getTamanho(); z += 2) {
            operador.executar(populacao.getIndividuo(z), populacao.getIndividuo(z + 1));
        }

        return populacao;
    }

    /**
     * 
     * @param populacao
     * @return
     */
    private Populacao mutacao(Populacao populacao) {
        for (int z = populacao.getTamanho(); z-- > 0;) {
            mutacao.executar(populacao.getIndividuo(z));
        }

        return populacao;
    }

    /**
     * 
     * @param populacao
     */
    private void avaliar(Populacao populacao) {
        double somaFitness = 0.0;

        melhorIndividuoGeracao = (Individuo) populacao.getIndividuo(0).clone();
        piorIndividuoGeracao = (Individuo) populacao.getIndividuo(0).clone();
        melhorIndividuoGeracao.calculaFitness();
        piorIndividuoGeracao.calculaFitness();

        for (int i = 0; i < tamanhoPopulacao; i++) {
            somaFitness += populacao.getIndividuo(i).calculaFitness();
            if (melhorIndividuoGeracao.getFitness() > populacao.getIndividuo(i).getFitness()) {
                melhorIndividuoGeracao = (Individuo) populacao.getIndividuo(i).clone();
            }

            if (piorIndividuoGeracao.getFitness() < populacao.getIndividuo(i).getFitness()) {
                piorIndividuoGeracao = (Individuo) populacao.getIndividuo(i).clone();
            }
        }

        relacaoMelhorPior = melhorIndividuoGeracao.getFitness() - piorIndividuoGeracao.getFitness();

        mediaGeracao = somaFitness / (double) tamanhoPopulacao;

        if (geracao == 0 || melhorIndividuoRun.getFitness() > melhorIndividuoGeracao.getFitness()) {
            melhorIndividuoRun = (Individuo) melhorIndividuoGeracao.clone();
            geracaoMelhorIndividuoRun = geracao;
        }

        if (geracao == 0 || (geracao + 1) % 10 == 0) {
            imprimirIteracao2(ps);
        }
    }

    /**
     * 
     * @param populacao
     * @param geracaoActual
     * @return
     */
    private boolean criterioParagem(Populacao populacao, int geracaoActual) {
        if (geracaoActual == maximoGeracoes || melhorIndividuoGeracao.getFitness() == 0 || relacaoMelhorPior == 0) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param populacaoActual
     * @param proximaPopulacao
     * @return
     */
    public Populacao criarNovaPopulacao(Populacao populacaoActual, Populacao proximaPopulacao) {
        return proximaPopulacao;//TODO: verificar o que fazer neste ponto
    }

    /**
     * 
     * @param ps
     */
    private void imprimirIteracao(PrintStream ps) {
        //new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
        ps.println("<============ Geracao Actual " + geracao + " ============>\n");
        ps.println("## Media: " + mediaGeracao);
        ps.println("## Melhor individuo: \n");
        ps.println(melhorIndividuoGeracao);
        ps.println("## Pior individuo: \n");
        ps.println(piorIndividuoGeracao);
        ps.println("## Relacao entre melhor/pior individuos: " + relacaoMelhorPior + "\n");
        ps.println("\n## Melhor da Execucao:\n");
        ps.println(melhorIndividuoRun);
        ps.println("\n<Populacao>\n");
        ps.println(populacaoActual);
        ps.flush();
    }

    private void imprimirIteracao2(PrintStream ps) {
        //geracao;media;fitness do melhor;fitness do pior;relacao;fitness da run;
        ps.println(geracao + ";" + mediaGeracao + ";" + melhorIndividuoGeracao.getFitness() + ";" +
                piorIndividuoGeracao.getFitness() + ";" + relacaoMelhorPior + ";" +
                melhorIndividuoRun.getFitness());
        ps.flush();
    }

    private void imprimirCabecalho(PrintStream ps) {
        ps.println("geracao;media da geracao;fitness do melhor da geracao;fitness do pior da geracao;" +
                "relacao entre melhor e pior;fitness do melhor da run");

        ps.println("Probabilidade Recombinação: " + probRecombinacao);
        ps.println("Probabilidade Mutação: " + probMutacao);
        ps.println("Tipo de Selecção: " + seleccao);
        ps.println("Tipo de Mutação: " + mutacao);
        ps.println("Tamanho População: " + tamanhoPopulacao);
        ps.println("Máximo de Gerações: " + maximoGeracoes);
        ps.flush();
    }

    /**
     * 
     * @return
     */
    public int getGeracaoDoMelhorIndividuoRun() {
        return geracaoDoMelhorIndividuoRun;
    }

    /**
     * 
     * @return
     */
    public int getGeracaoMelhorIndividuoRun() {
        return geracaoMelhorIndividuoRun;
    }

    /**
     * 
     * @return
     */
    public double getMediaGeracao() {
        return mediaGeracao;
    }

    /**
     * 
     * @return
     */
    public int getGeracao() {
        return geracao;
    }

    /**
     * 
     * @return
     */
    public int getMaximoGeracoes() {
        return maximoGeracoes;
    }

    /**
     * 
     * @return
     */
    public Individuo getMelhorIndividuoGeracao() {
        return melhorIndividuoGeracao;
    }

    /**
     * 
     * @return
     */
    public Individuo getMelhorIndividuoRun() {
        return melhorIndividuoRun;
    }

    /**
     * 
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    public double getRelacaoMelhorPior() {
        return relacaoMelhorPior;
    }

    /**
     * 
     * @param l
     */
    public void addListener(AlgoritmoGeneticoListener l) {
        if (listeners == null) {
            listeners = new Vector<AlgoritmoGeneticoListener>();
        }

        listeners.add(l);
    }

    /**
     * 
     * @param l
     */
    public void removeListener(AlgoritmoGeneticoListener l) {
        if (listeners != null) {
            listeners.remove(l);
        }
    }

    /**
     * 
     */
    private void fireRunFinished() {
        if (listeners != null) {
            for (AlgoritmoGeneticoListener l : listeners) {
                l.runFinished(this);
            }
        }
    }

    /**
     * 
     * @param gen
     */
    private void fireCurrentGeneration(int gen) {
        if (listeners != null) {
            for (AlgoritmoGeneticoListener l : listeners) {
                l.currentGeneration(gen);
            }
        }
    }
}
