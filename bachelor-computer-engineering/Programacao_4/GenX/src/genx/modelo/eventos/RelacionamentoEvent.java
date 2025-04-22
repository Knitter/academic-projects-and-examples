package genx.modelo.eventos;

import java.util.*;

import genx.modelo.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class RelacionamentoEvent
    extends EventObject {
    private GregorianCalendar novaDataInicio;
    private GregorianCalendar dataInicioAntiga;
    private GregorianCalendar novaDataFim;
    private GregorianCalendar dataFimAntiga;
    private Pessoa filho;
    private Pessoa progenitorMasculinoAnterior;
    private Pessoa novoProgenitorMasculino;
    private Pessoa progenitorFemininoAnterior;
    private Pessoa novoProgenitorFeminino;

    public RelacionamentoEvent(Object source, GregorianCalendar dataInicioAntiga, GregorianCalendar novaDataInicio,
                               GregorianCalendar dataFimAntiga, GregorianCalendar novaDataFim,
                               Pessoa filho, Pessoa progenitorMasculinoAnterior, Pessoa novoProgenitorMasculino, Pessoa progenitorFemininoAnterior,
                               Pessoa novoProgenitorFeminino) {
        super(source);
        this.novaDataInicio = novaDataInicio;
        this.dataInicioAntiga = dataInicioAntiga;
        this.novaDataFim = novaDataFim;
        this.dataFimAntiga = dataFimAntiga;
        this.filho = filho;
        this.progenitorMasculinoAnterior = progenitorMasculinoAnterior;
        this.novoProgenitorMasculino = novoProgenitorMasculino;
        this.progenitorFemininoAnterior = progenitorFemininoAnterior;
        this.novoProgenitorFeminino = novoProgenitorFeminino;
    }

    public Pessoa getProgenitorMasculinoAnterior() {
        return progenitorMasculinoAnterior;
    }

    public Pessoa getProgenitorFemininoAnterior() {
        return progenitorFemininoAnterior;
    }

    public Pessoa getNovoProgenitorMasculino() {
        return novoProgenitorMasculino;
    }

    public Pessoa getNovoProgenitorFeminino() {
        return novoProgenitorFeminino;
    }

    public GregorianCalendar getNovaDataInicio() {
        return novaDataInicio;
    }

    public GregorianCalendar getNovaDataFim() {
        return novaDataFim;
    }

    public Pessoa getFilho() {
        return filho;
    }

    public GregorianCalendar getDataInicioAntiga() {
        return dataInicioAntiga;
    }

    public GregorianCalendar getDataFimAntiga() {
        return dataFimAntiga;
    }
}
