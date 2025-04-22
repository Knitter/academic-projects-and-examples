package genx.modelo;

import java.io.*;
import java.util.*;

import genx.listas.*;
import genx.modelo.eventos.*;
import genx.modelo.exceptions.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class Relacionamento implements Serializable {

    /**
     * Data de início de um relacionamento.
     */
    private GregorianCalendar dataInicio;

    /**
     * Data de fim de um relacionamento.
     */
    private GregorianCalendar dataFim;

    /**
     * Pessoas que originaram o relacionamento.
     */
    private Pessoa[] progenitores = new Pessoa[2];

    /**
     * Lista de filhos que este relacionamento originou.
     */
    private ListaSimplesCircularBaseLimite listaFilhosNome = new ListaSimplesCircularBaseLimite(new ComparacaoInfimoPessoasNome());



    public Relacionamento(GregorianCalendar inicio) {
        this.dataInicio = new GregorianCalendar(inicio.get(GregorianCalendar.YEAR), inicio.get(GregorianCalendar.MONTH), inicio.get(GregorianCalendar.DATE));
    }

    public Relacionamento() {
        this(new GregorianCalendar());
    }

    public Relacionamento(Pessoa p1, Pessoa p2) {
        this(new GregorianCalendar());
        adicionarProgenitores(p1, p2);
    }

    /**
     * Método que permite adicionar os dois progenitores que criaram o relacionamento. A ordem dos progenitores nao importa.
     * Se se tentar adicionar dois progenitores do mesmo sexo apenas o progenitor2 ficará guardado e a referência para o progenitor
     * de sexo oposto ficará a null.
     *
     * @param progenitor1 - Um dos progenitor do relacionamento.
     * @param progenitor2 - Um dos progenitores do relacionmento.
     */
    public void adicionarProgenitores(Pessoa progenitor1, Pessoa progenitor2) {
        Pessoa p[] = new Pessoa[2];
        p[progenitor1.getSexo()] = progenitores[progenitor1.getSexo()];
        p[progenitor2.getSexo()] = progenitores[progenitor2.getSexo()];

        progenitores[progenitor1.getSexo()] = progenitor1;
        progenitores[progenitor2.getSexo()] = progenitor2;
        fireProgenitorAdded(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFim, dataFim, null,
                                                    p[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                    p[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    /**
     * Adiciona um filho à lista de filhos.
     *
     * @param filho - Filho a ser adicionado.
     */
    public void adicionarFilho(Pessoa filho) {
        listaFilhosNome.inserir(filho);
        fireFilhoAdded(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFim, dataFim, filho,
                                               progenitores[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                               progenitores[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    /**
     * Remove uma pessoa da lista de filhos do relacionamento.
     *
     * @param filho - Filho a ser removido.
     */
    public void removerFilho(Pessoa filho) {
        if (listaFilhosNome.remover(filho))
            fireFilhoRemoved(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFim, dataFim, filho,
                                                     progenitores[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                     progenitores[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    /**
     * Remove um dos progenitores através do seu sexo.
     *
     * @param sexo - Sexo do progenitor a remover.
     */
    public void removerProgenitor(int sexo) {
        Pessoa p[] = new Pessoa[2];
        p[Pessoa.SEXO_MASCULINO] = progenitores[Pessoa.SEXO_MASCULINO];
        p[Pessoa.SEXO_FEMININO] = progenitores[Pessoa.SEXO_FEMININO];

        progenitores[sexo] = null;

        Iterador it = listaFilhosNome.iteradorLista();
        while (it.podeAvancar())
            ((Pessoa)it.avancar()).removerProgenitor(sexo);

        fireProgenitorRemoved(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFim, dataFim, null,
                                                      p[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                      p[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    /**
     * Método que permite alterar um dos progenitores do relacionamento.
     *
     * @param progenitor - Novo progenitor.
     */
    public void alterarProgenitor(Pessoa progenitor) {
        Pessoa p[] = new Pessoa[2];
        p[Pessoa.SEXO_MASCULINO] = progenitores[Pessoa.SEXO_MASCULINO];
        p[Pessoa.SEXO_FEMININO] = progenitores[Pessoa.SEXO_FEMININO];

        if (progenitores[progenitor.getSexo()] != null)
            progenitores[progenitor.getSexo()].removerRelacionamentoDesc(this);
        progenitores[progenitor.getSexo()] = progenitor;

        fireProgenitorChanged(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFim, dataFim, null,
                                                      p[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                      p[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    /**
     * Consulta um progenitor através do seu sexo.
     *
     * @param sexo - Sexo do progenitor a consultar
     * @return progenitor obtido.
     */
    public Pessoa consultarProgenitor(int sexo) {
        return progenitores[sexo];
    }

    /**
     * Verifica se o relacionamento possui pelo menos um dos progenitores.
     *
     * @return true caso exista pelo menos um progenitor, false caso contrário.
     */
    public boolean temPeloMenosUmProgenitor() {
        return progenitores[Pessoa.SEXO_MASCULINO] != null || progenitores[Pessoa.SEXO_FEMININO] != null;
    }

    /**
     * Método que verifica se pelo menos um dos progenitores está em falta no relacionamento.
     *
     * @return true caso falte pelo menos um progenitor, false caso contrário.
     */
    public boolean naoTemPeloMenosUmProgenitor() {
        return progenitores[Pessoa.SEXO_MASCULINO] == null || progenitores[Pessoa.SEXO_FEMININO] == null;
    }

    /**
     * Obtém um iterador para a lista de filhos que este relacionamento originou.
     *
     * @return iterador para a lista de filhos do relacionamento.
     */
    public Iterador iteradorDescendentes() {
        return listaFilhosNome.iteradorLista();
    }

    /**
     * Verifica se existe algum filho que tenha nascido antes da nova data de início.
     *
     * @param dataInicio - Data de início de um relacionamento
     * @return false caso exista algum filho que tenha nascido antes do relacionamento
     */
    private boolean dataNascFilhosValida(GregorianCalendar dataInicio) {
        Iterador it = listaFilhosNome.iteradorLista();

        while (it.podeAvancar())
            if (dataInicio.after(((Pessoa) it.avancar()).getDataNasc()))
                return false;

        return true;
    }

    public String toString() {
        String s = "\nData Inicio: " + dataInicio;
        s = s.concat("\nData Fim: " + dataFim);
        s = s.concat("\nProgenitor Macho : " + progenitores[0] + "Progenitor Fêmea: " + progenitores[1] + "\nLista Filhos:");
        Iterador it = listaFilhosNome.iteradorLista();
        while (it.podeAvancar())
            s = s.concat("\n\n" + it.avancar());
        return s;
    }



///////// Getters e Setters ////////////////////////////////////////////////////

    public GregorianCalendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(GregorianCalendar inicio) throws GenXDataInvalidaException {
        if (dataFim != null && dataFim.before(inicio))
            throw new GenXDataInvalidaException("Um relacionamento não pode iniciar depois do termo");
        if (progenitores[Pessoa.SEXO_MASCULINO].getDataNasc().after(inicio) &&
            progenitores[Pessoa.SEXO_FEMININO].getDataNasc().after(inicio))
            throw new GenXDataInvalidaException("Data de início do relacionamento anterior à data de nascimento de um dos cônjuges");
        if (!dataNascFilhosValida(inicio))
            throw new GenXDataInvalidaException("Existe pelo menos um filho que nasceu antes da data de início do relacionamento!");

        GregorianCalendar dataInicioAntiga = dataInicio;
        dataInicio = inicio;
        fireDataInicioChanged(new RelacionamentoEvent(this, dataInicioAntiga, dataInicio, dataFim, dataFim, null,
                                                      progenitores[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                      progenitores[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }

    public GregorianCalendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(GregorianCalendar fim) throws GenXDataInvalidaException {
        if (fim != null && dataInicio != null && dataInicio.after(fim))
            throw new GenXDataInvalidaException("Um relacionamento não pode terminar antes de ter começado");

        GregorianCalendar dataFimAntiga = dataFim;
        this.dataFim = fim;
        fireDataFimChanged(new RelacionamentoEvent(this, dataInicio, dataInicio, dataFimAntiga, dataFim, null,
                                                   progenitores[Pessoa.SEXO_MASCULINO], progenitores[Pessoa.SEXO_MASCULINO],
                                                   progenitores[Pessoa.SEXO_FEMININO], progenitores[Pessoa.SEXO_FEMININO]));
    }



///////// Fire Events //////////////////////////////////////////////////////////

    transient Vector relacionamentoListeners;

    public synchronized void addRelacionamentoListener(RelacionamentoListener l) {
        Vector v = relacionamentoListeners != null ?
            (Vector) relacionamentoListeners.clone() : new Vector(2);
        if (!v.contains(l))
            v.add(l);
        relacionamentoListeners = v;
    }

    public synchronized void removeRelacionamentoListener(RelacionamentoListener l) {
        Vector v = relacionamentoListeners != null ?
            (Vector) relacionamentoListeners.clone() : new Vector(2);
        if (v.contains(l))
            v.remove(l);
        relacionamentoListeners = v;
    }

    protected void fireDataInicioChanged(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).dataInicioChanged(event);
            }
        }
    }

    protected void fireDataFimChanged(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).dataFimChanged(event);
            }
        }
    }

    protected void fireFilhoAdded(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).filhoAdded(event);
            }
        }
    }

    protected void fireFilhoRemoved(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).filhoRemoved(event);
            }
        }
    }

    protected void fireProgenitorAdded(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).progenitorAdded(event);
            }
        }
    }

    protected void fireProgenitorRemoved(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).progenitorRemoved(event);
            }
        }
    }

    protected void fireProgenitorChanged(RelacionamentoEvent event) {
        if (relacionamentoListeners != null) {
            Vector listeners = relacionamentoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RelacionamentoListener) listeners.elementAt(i)).progenitorChanged(event);
            }
        }
    }

}
