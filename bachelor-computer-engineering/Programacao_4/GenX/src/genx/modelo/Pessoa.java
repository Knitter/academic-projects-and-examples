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
public class Pessoa implements Serializable {

    /**
     * Nome da pessoa.
     */
    private String nome;

    /**
     * Data de nascimento da pessoa.
     */
    private GregorianCalendar dataNasc;

    /**
     * Data de óbito da pessoa.
     */
    private GregorianCalendar dataObito;

    /**
     * Sexo da pessoa.
     */
    private int sexo;

    /**
     * Pais da pesssoa.
     */
    private Pessoa progenitores[] = new Pessoa[2];

    /**
     * Relacionamento onde teve origem a pessoa.
     */
    private Relacionamento relacionamentoAsc;

    /**
     * Lista de relacionamentos que a pessoa tem com outras pessoas de sexo oposto.
     */
    private ListaSimplesCircularBaseLimite relacionamentoDesc;

    /**
     * Ficheiros que representam as fotografias da pessoa consoante o sexo.
     */
    private String[] fotografia = {"/genx/imagens/pessoaMale.png", "/genx/imagens/pessoaFemale.png"};

    /**
     * Constante que representa uma pessoa do sexo masculino.
     */
    public static final int SEXO_MASCULINO = 0;

    /**
     * Constante que representa uma pessoa do sexo feminino.
     */
    public static final int SEXO_FEMININO = 1;

    /**
     * Número de pessoa já criadas.
     */
    private static int numPessoas = -1;

    public Pessoa(String nome, GregorianCalendar dataNasc, int sexo) {
        this.nome = nome;
        this.dataNasc = new GregorianCalendar(dataNasc.get(GregorianCalendar.YEAR), dataNasc.get(GregorianCalendar.MONTH), dataNasc.get(GregorianCalendar.DATE));
        this.sexo = sexo;
        numPessoas++;
        relacionamentoDesc = new ListaSimplesCircularBaseLimite(new ComparacaoInfimoRelacionamentoData());
    }

    public Pessoa() {
        this("Pessoa" + numPessoas, new GregorianCalendar(), Pessoa.SEXO_MASCULINO);
    }

    public Pessoa(int sexo) {
        this("Pessoa" + numPessoas, new GregorianCalendar(), sexo);
    }

    /**
     * Método que permite recomeçar a contagem do número de pessoas.
     */
    public static void resetNumeroPessoas() {
        numPessoas = 1;
    }

    /**
     * Método que permite adicionar um progenitor. A sua posição no vector de progenitores é dada pelo sexo.
     *
     * @param progenitor - Pessoa que é pai ou mãe desta pessoa.
     */
    public void adicionarProgenitor(Pessoa progenitor) {
        if (progenitor != null)
            progenitores[progenitor.sexo] = progenitor;
    }

    /**
     * Método que permite remover um dos progenitores.
     *
     * @param sexo - Sexo do progenitor a remover.
     */
    public void removerProgenitor(int sexo) {
        progenitores[sexo] = null;
    }

    /**
     * Indica se uma pessoa possui relacionamentos com pessoas de sexo oposto.
     *
     * @return true caso existam relacionamentos com pessoas de sexo oposto ou false caso contrário.
     */
    public boolean temRelacionamentosDesc() {
        return !relacionamentoDesc.vazia();
    }

    /**
     * Método que remove ambos os progenitores da pessoa.
     */
    public void removerAmbosProgenitores() {
        progenitores = new Pessoa[2];
    }

    /**
     * Adiciona à pessoa um relacionamento com uma pessoa do sexo oposto.
     *
     * @param relacionamento - Relacionamento a inserir.
     */
    public void adicionarRelacionamentoDesc(Relacionamento relacionamento) {
        relacionamentoDesc.inserir(relacionamento);
    }

    /**
     * Remove um relacionamento do conjunto de relacionamentos que a pessoa tem com pessoas de sexo oposto.
     *
     * @param relacionamento - Relacionamento a remver.
     */
    public void removerRelacionamentoDesc(Relacionamento relacionamento) {
        relacionamentoDesc.remover(relacionamento);
    }

    /**
     * Altera o relacionamento ascendente de onde uma pessoa provém.
     *
     * @param relacionamento - Novo relacionamento ascendente que irá substituir o actual.
     */
    public void alterarRelacionamentoAsc(Relacionamento relacionamento) {
        relacionamentoAsc = relacionamento;
    }

    /**
     * Obtém um iterador para a lista de relacionamentos com pessoas de sexo oposto.
     *
     * @return iterador para a lista.
     */
    public Iterador iteradorRelacionamentosDesc() {
        return relacionamentoDesc.iteradorLista();
    }

    /**
     * Remove todos os relacionamentos que a pessoa tem com pessoas de sexo oposto.
     */
    public void removerTodosRelacionamentosDesc() {
        Iterador it = relacionamentoDesc.iteradorLista();
        while(it.podeAvancar())
            ((Relacionamento)it.avancar()).removerProgenitor(sexo);
        relacionamentoDesc.removerTodos();
    }

    /**
     * Verifica se a pessoa possui o relacionamento que a origina, isto é, se a pessoa tem progenitores.
     *
     * @return true caso exista relacionamento ascendente, false caso contrário.
     */
    public boolean existeRelacionamentoAsc() {
        return relacionamentoAsc != null;
    }

    /**
     * Remove o relacionamento ascendente da pessoa, relacionamento este que originou a pessoa.
     */
    public void removerRelacionamentoAsc() {
        if (existeRelacionamentoAsc()) {
            relacionamentoAsc.removerFilho(this);
            relacionamentoAsc = null;
            fireRelacionamentoAscendenteRemoved(new PessoaEvent(this, nome, nome,
                dataNasc, dataNasc, dataObito, dataObito, sexo, sexo, fotografia[sexo], fotografia[sexo]));
        }
    }

    public String toString() {
        return nome;
    }

    /**
     * Verifica se a data de nascimento da pessoa é anterior à data de início dos seus relacionamentos descendentes.
     *
     * @param dataNasc - Data de nascimento da pessoa
     * @return false caso exista algum relacionamento com data de início anterior à data de nascimento
     */
    private boolean dataInicioRelacionamentosDescValida(GregorianCalendar dataNasc) {
        Iterador it = relacionamentoDesc.iteradorLista();
        while (it.podeAvancar())
            if (dataNasc.after(((Relacionamento)it.avancar()).getDataInicio()))
                return false;

        return true;
    }



///////// Getters & Setters ////////////////////////////////////////////////////

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String nomeAntigo = this.nome;
        this.nome = nome;
        fireNomeChanged(new PessoaEvent(this, nomeAntigo, nome,
                                        dataNasc, dataNasc,
                                        dataObito, dataObito, sexo, sexo,
                                        fotografia[sexo], fotografia[sexo]));
    }

    public int getSexo() {
        return sexo;
    }

    public int getSexoOposto() {
        return (sexo + 1) % 2;
    }

    public void setSexo(int sexo) {
        int sexoAnterior = this.sexo;
        setFotografia(fotografia[sexo]);
        this.sexo = sexo;
        fireNomeChanged(new PessoaEvent(this, nome, nome,
                                        dataNasc, dataNasc,
                                        dataObito, dataObito, sexoAnterior, sexo,
                                        fotografia[sexo], fotografia[sexo]));
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(GregorianCalendar dataNasc) throws GenXDataInvalidaException {
        if (dataObito != null && dataNasc.after(dataObito))
            throw new GenXDataInvalidaException("Uma pessoa não pode nascer depois de morrer!");
        if (relacionamentoAsc != null && (dataNasc.before(relacionamentoAsc.getDataInicio()) || (relacionamentoAsc.getDataFim() != null && dataNasc.after(relacionamentoAsc.getDataFim()))))
            throw new GenXDataInvalidaException("Uma pessoa não pode nascer antes do inicio do relacionamento de onde provém!");
        if (!dataInicioRelacionamentosDescValida(dataNasc))
            throw new GenXDataInvalidaException("Uma pessoa não pode nascer depois do inicio do seu relacionamento!");

        GregorianCalendar dataNascAntiga = this.dataNasc;
        this.dataNasc = dataNasc;
        fireDataNascChanged(new PessoaEvent(this, nome, nome,
                                        dataNascAntiga, dataNasc,
                                        dataObito, dataObito, sexo, sexo,
                                        fotografia[sexo], fotografia[sexo]));
    }

    public GregorianCalendar getDataObito() {
        return dataObito;
    }

    public void setDataObito(GregorianCalendar dataObito) throws GenXDataInvalidaException {
        if (dataObito != null && dataNasc.getTime().after(dataObito.getTime()))
            throw new GenXDataInvalidaException("Uma pessoa não pode morrer antes de nascer!");

        GregorianCalendar dataObitoAntiga = this.dataObito;
        this.dataObito = dataObito;
        fireDataNascChanged(new PessoaEvent(this, nome, nome,
                                        dataNasc, dataNasc,
                                        dataObitoAntiga, dataObito, sexo, sexo,
                                        fotografia[sexo], fotografia[sexo]));
    }

    public String getFotografia() {
        return fotografia[sexo];
    }

    public String getFotografia(int sexo) {
        return fotografia[sexo];
    }

    public void setFotografia(String fotografia) {
        String fotografiaAntiga = this.fotografia[sexo];
        this.fotografia[sexo] = fotografia;
        fireFotoChanged(new PessoaEvent(this, nome, nome,
                                        dataNasc, dataNasc,
                                        dataObito, dataObito, sexo, sexo,
                                        fotografiaAntiga, this.fotografia[sexo]));
    }

    public Pessoa getProgenitor(int sexo) {
        return progenitores[sexo];
    }

    public Relacionamento getRelacionamentoAsc() {
        return relacionamentoAsc;
    }



///////// Fire Events //////////////////////////////////////////////////////////

    transient Vector pessoaListeners;

    public synchronized void addPessoaListener(PessoaListener l) {
        Vector v = pessoaListeners != null ?
            (Vector) pessoaListeners.clone() : new Vector(2);
        if (!v.contains(l))
            v.add(l);
        pessoaListeners = v;
    }

    public synchronized void removePessoaListener(PessoaListener l) {
        Vector v = pessoaListeners != null ?
            (Vector) pessoaListeners.clone() : new Vector(2);
        if (v.contains(l))
            v.remove(l);
        pessoaListeners = v;
    }

    protected void fireNomeChanged(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).nomeChanged(event);
            }
        }
    }

    protected void fireSexoChanged(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).sexoChanged(event);
            }
        }
    }

    protected void fireFotoChanged(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).fotoChanged(event);
            }
        }
    }

    protected void fireDataNascChanged(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).dataNascChanged(event);
            }
        }
    }

    protected void fireDataObitoChanged(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).dataObitoChanged(event);
            }
        }
    }

    protected void fireRelacionamentoAscendenteRemoved(PessoaEvent event) {
        if (pessoaListeners != null) {
            Vector listeners = pessoaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (PessoaListener) listeners.elementAt(i)).relacionamentoAscendenteRemoved(event);
            }
        }
    }

}
