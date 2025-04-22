package genx.modelo;

import java.io.*;
import java.util.*;
import java.util.regex.*;

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
public class ArvoreGeneologica implements Serializable, PessoaListener, RelacionamentoListener {

    /**
     * Lista de pessoas ordenadas por nome.
     */
    private ListaSimplesCircularBaseLimite listaPessoasNome;

    /**
     * Lista de pessoas ordenadas por data de nascimento.
     */
    private ListaSimplesCircularBaseLimite listaPessoasData;

    /**
     * Lista de relacionamentos ordenados por data de início.
     */
    private ListaSimplesCircularBaseLimite listaRelacionamentosDataInicio;

    public ArvoreGeneologica() {
        listaPessoasNome = new ListaSimplesCircularBaseLimite(new ComparacaoInfimoPessoasNome());
        listaPessoasData = new ListaSimplesCircularBaseLimite(new ComparacaoInfimoPessoasData());
        listaRelacionamentosDataInicio = new ListaSimplesCircularBaseLimite(new ComparacaoInfimoRelacionamentoData());
    }



    /**
     * Adiciona uma pessoa à árvore genealógica.
     *
     * @param p - Pessoa a adicionar.
     */
    public void addPessoa(Pessoa p) {
        p.addPessoaListener(this);
        listaPessoasNome.inserir(p);
        listaPessoasData.inserir(p);
        firePessoaAdded(new ArvoreGeneologicaEvent(this, p, p, null));
    }

    /**
     * Remove uma pessoa da árvore.
     *
     * @param pessoa - Pessoa a remover da árvore.
     */
    public void removerPessoa(Pessoa pessoa) {
        pessoa.removerRelacionamentoAsc();

        Iterador it = pessoa.iteradorRelacionamentosDesc();
        while (it.podeAvancar())
            //if(((Relacionamento)it.avancar()).consultarProgenitor(pessoa.getSexoOposto()) == null)
                removerRelacionamento((Relacionamento)it.avancar());

        pessoa.removerTodosRelacionamentosDesc();
        listaPessoasData.remover(pessoa);
        listaPessoasNome.remover(pessoa);

        firePessoaRemoved(new ArvoreGeneologicaEvent(this, pessoa, pessoa, null));
    }

    /**
     * Remove um relacionamento da lista de relacionamentos da árvore.
     *
     * @param relacionamento relacionamento a remover.
     */
    public void removerRelacionamento(Relacionamento relacionamento) {
        Pessoa p1 = relacionamento.consultarProgenitor(Pessoa.SEXO_MASCULINO);
        Pessoa p2 = relacionamento.consultarProgenitor(Pessoa.SEXO_FEMININO);
        if (p1 != null)
            p1.removerRelacionamentoDesc(relacionamento);
        if (p2 != null)
            p2.removerRelacionamentoDesc(relacionamento);

        Iterador it = relacionamento.iteradorDescendentes();
        while (it.podeAvancar())
            ((Pessoa)it.avancar()).removerRelacionamentoAsc();

        listaRelacionamentosDataInicio.remover(relacionamento);
        fireRelacionamentoRemoved(new ArvoreGeneologicaEvent(this, p1, p2, relacionamento));
    }

    /**
     * Método que permite relacionar duas pessoas de sexo oposto.
     *
     * @param pessoa1 - Uma das pessoa a relacionar.
     * @param pessoa2 - Uma das pessoa a relacionar.
     * @throws GenXSexosIguaisException - Lançada caso as pessoas a relacionar sejam de sexos iguais
     * @throws GenXRelacionamentoNecrofilosException - Lançada caso uma pessoa morta com uma pessoa viva
     */
    public void criarRelacionamento(Pessoa pessoa1, Pessoa pessoa2) throws GenXSexosIguaisException, GenXRelacionamentoNecrofilosException {
        if (pessoa1.getSexo() == pessoa2.getSexo())
            throw new GenXSexosIguaisException("Pessoas de sexos iguais nao podem relacionar-se!");
        if (pessoa1.getDataNasc().after(pessoa2.getDataObito()) || pessoa2.getDataNasc().after(pessoa1.getDataObito()))
            throw new GenXRelacionamentoNecrofilosException("Pessoas nascidas numa determinada data não se podem relacionar com pessoas já falecidas!");
        Relacionamento relacionamento = new Relacionamento(pessoa1, pessoa2);
        relacionamento.addRelacionamentoListener(this);
        listaRelacionamentosDataInicio.inserir(relacionamento);
        pessoa1.adicionarRelacionamentoDesc(relacionamento);
        pessoa2.adicionarRelacionamentoDesc(relacionamento);
        fireRelacionamentoParentAdded(new ArvoreGeneologicaEvent(this, pessoa1, pessoa2, relacionamento));
    }

    /**
     * Método que permite adicionar um filho ao conjunto de filhos de um relacionamento.
     *
     * @param filho - Filho a adicionar
     * @param relacionamento - Relacionamento ao qual se adicionará a pessoa
     * @throws GenXDataInvalidaException - Uma pessoa não pode nascer antes do inicio nem depois do termo de um relacionamento
     */
    public void adicionarFilho(Pessoa filho, Relacionamento relacionamento) throws GenXDataInvalidaException {
        if (filho.getDataNasc().before(relacionamento.getDataInicio()) ||
            (relacionamento.getDataFim() != null && filho.getDataNasc().after(relacionamento.getDataFim())))
            throw new GenXDataInvalidaException("Uma pessoa não pode nascer antes do inicio nem depois do termo de um relacionamento!");

        if (relacionamento.consultarProgenitor(filho.getSexo()) == filho) {
            filho.removerRelacionamentoDesc(relacionamento);
            relacionamento.removerProgenitor(filho.getSexo());
        }
        if (relacionamento.temPeloMenosUmProgenitor()) {
            filho.removerRelacionamentoAsc();
            filho.alterarRelacionamentoAsc(relacionamento);
            relacionamento.adicionarFilho(filho);
            filho.adicionarProgenitor(relacionamento.consultarProgenitor(Pessoa.SEXO_MASCULINO));
            filho.adicionarProgenitor(relacionamento.consultarProgenitor(Pessoa.SEXO_FEMININO));
            fireRelacionamentoChildAdded(new ArvoreGeneologicaEvent(this, filho, filho, relacionamento));
        }
        else
            removerRelacionamento(relacionamento);
    }

    /**
     * Método que altera os progenitores de um relacionamento.
     *
     * @param relacionamento - Relacionamento a alterar
     * @param novaPessoa - Progenitor a colocar
     * @throws GenXDataInvalidaException - Uma pessoa não pode nascer depois do início do seu relacionamento
     * @throws GenXRelacionamentoNecrofilosException - Uma pessoa morta não consegue relacionar-se com ninguém
     */
    public void alterarProgenitoresRelacionamento(Relacionamento relacionamento, Pessoa novaPessoa) throws GenXDataInvalidaException, GenXRelacionamentoNecrofilosException {
        if (novaPessoa.getDataNasc().after(relacionamento.getDataInicio()))
            throw new GenXDataInvalidaException("Uma pessoa não pode nascer depois do início do seu relacionamento!");
        if (novaPessoa.getDataObito() != null && novaPessoa.getDataObito().getTime().compareTo(relacionamento.getDataInicio().getTime()) <= 0)
            throw new GenXRelacionamentoNecrofilosException("Uma pessoa morta não consegue relacionar-se com ninguém!");

        if (relacionamento == novaPessoa.getRelacionamentoAsc())
            relacionamento.removerFilho(novaPessoa);

        relacionamento.alterarProgenitor(novaPessoa);
        novaPessoa.adicionarRelacionamentoDesc(relacionamento);
        fireRelacionamentoChanged(new ArvoreGeneologicaEvent(this, novaPessoa, novaPessoa, relacionamento));
    }

    /**
     * Método utilzado para verificar se a existem pessoas ou relacionamentos que tornem a informação da árvore incoerente.
     *
     * @return true caso a árvore representada seja válida, false caso contrário.
     */
    public boolean validarArvore() {
        Iterador it = listaPessoasNome.iteradorLista();
        while (it.podeAvancar())
            if (!(((Pessoa)it.avancar()).temRelacionamentosDesc() || ((Pessoa)it.corrente()).existeRelacionamentoAsc()))
                return false;
        it = listaRelacionamentosDataInicio.iteradorLista();
        while (it.podeAvancar())
            if (((Relacionamento)it.avancar()).naoTemPeloMenosUmProgenitor())
                return false;

        return true;
    }



///////// Consultas & Pesquisas ////////////////////////////////////////////////

    /**
     * Consulta pessoas que contenham todos os nomes introduzidos por parâmetro na respectiva ordem
     *
     * @param nome - Nome(s) a pesquisar
     * @return devolve um iterador da lista de resultados
     */
    public Iterador consultarPorNome(String nome) {
        Pattern pattern;
        Matcher matcher;

        Iterador it = listaPessoasNome.iteradorLista();
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();
        while (it.podeAvancar()) {
            pattern = Pattern.compile("\\b" + nome.replaceAll(" ", "\\\\b.*\\\\b") + "\\b", Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(((Pessoa) it.avancar()).getNome());
            if (matcher.find())
                lista.inserir(((Pessoa) it.corrente()).getNome());
        }

        return lista.iteradorLista();
    }

    /**
     * Função que permite pesquisar incrementalmente um nome
     *
     * @param nome - Nome ou parte do nome a pesquisar
     * @param listaEntrada - Lista com os últimos resultados sobre a qual vai realizar a pesquisa seguinte
     * @return devolve um iterador da lista de resultados
     */
    public Iterador consultarPorNomeOnTheFly(String nome, ListaSimplesCircularBaseFim listaEntrada) {
        Iterador it;
        ListaSimplesCircularBaseFim listaResultados = new ListaSimplesCircularBaseFim();

        if (listaEntrada.vazia())
            it = listaPessoasNome.iteradorLista();
        else
            it = listaEntrada.iteradorLista();

        while (it.podeAvancar())
            if (((Pessoa) it.avancar()).getNome().toLowerCase().indexOf(nome.toLowerCase()) == 0) {
                listaResultados.inserir(it.corrente());
                break;
            }
        while (it.podeAvancar() && ((Pessoa) it.avancar()).getNome().toLowerCase().indexOf(nome.toLowerCase()) == 0)
            listaResultados.inserir(it.corrente());

        return listaResultados.iteradorLista();
    }

    public Iterador consultarPessoasVivasEm(GregorianCalendar data) {
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();
        Iterador it = listaPessoasData.iteradorLista();

        while(it.podeAvancar())
            if(data.getTime().compareTo(((Pessoa)it.avancar()).getDataNasc().getTime()) >= 0 && (((Pessoa)it.corrente()).getDataObito() == null || data.getTime().compareTo(((Pessoa)it.corrente()).getDataObito().getTime()) <= 0))
                lista.inserir(it.corrente());
        return lista.iteradorLista();
    }


    public Iterador consultarAscendentesGrauN(Pessoa pessoa, int grau) {
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();
        lista = consultarAscendentesGrauN(grau - 1, lista, pessoa.getRelacionamentoAsc());
        return lista.iteradorLista();
    }

    private ListaSimplesCircularBaseFim consultarAscendentesGrauN(int grau, ListaSimplesCircularBaseFim lista, Relacionamento rel) {
        if (rel != null) {
            if (grau == 0) {
                if (rel.consultarProgenitor(Pessoa.SEXO_MASCULINO) != null && !lista.contem(rel.consultarProgenitor(Pessoa.SEXO_MASCULINO)))
                    lista.inserir(rel.consultarProgenitor(Pessoa.SEXO_MASCULINO));
                if (rel.consultarProgenitor(Pessoa.SEXO_FEMININO) != null && !lista.contem(rel.consultarProgenitor(Pessoa.SEXO_FEMININO)))
                    lista.inserir(rel.consultarProgenitor(Pessoa.SEXO_FEMININO));
            }
            else {
                if (rel.consultarProgenitor(Pessoa.SEXO_MASCULINO) != null)
                    lista = consultarAscendentesGrauN(grau - 1, lista, rel.consultarProgenitor(Pessoa.SEXO_MASCULINO).getRelacionamentoAsc());
                if (rel.consultarProgenitor(Pessoa.SEXO_FEMININO) != null)
                    lista = consultarAscendentesGrauN(grau - 1, lista, rel.consultarProgenitor(Pessoa.SEXO_FEMININO).getRelacionamentoAsc());
            }
        }
        return lista;
    }

    public Iterador consultarFilhos(Pessoa progenitor) {
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();
        Iterador it = progenitor.iteradorRelacionamentosDesc();
        Iterador itFilhos;
        while (it.podeAvancar()) {
            itFilhos = ((Relacionamento) it.avancar()).iteradorDescendentes();
            while (itFilhos.podeAvancar())
                lista.inserir(itFilhos.avancar());
        }
        return lista.iteradorLista();
    }

    public Iterador consultarIrmaos(Pessoa pessoa) {
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();

        Pessoa pai = pessoa.getProgenitor(Pessoa.SEXO_MASCULINO);
        Pessoa mae = pessoa.getProgenitor(Pessoa.SEXO_FEMININO);

        if (pai != null && mae != null) {
            Iterador itFilhos, itRelacionamentos = mae.iteradorRelacionamentosDesc();

            while (itRelacionamentos.podeAvancar()) {
                if (((Relacionamento) itRelacionamentos.avancar()).consultarProgenitor(Pessoa.SEXO_MASCULINO) == pai &&
                    ((Relacionamento) itRelacionamentos.corrente()).consultarProgenitor(Pessoa.SEXO_FEMININO) == mae) {
                    itFilhos = ((Relacionamento) itRelacionamentos.corrente()).iteradorDescendentes();
                    while (itFilhos.podeAvancar())
                        if ((Pessoa) itFilhos.avancar() != pessoa)
                            lista.inserir(itFilhos.corrente());
                }
            }
        }
        return lista.iteradorLista();
    }

    public Iterador consultarMeiosIrmaos(Pessoa pessoa) {
        Iterador itRelacionamentos, itFilhos;
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();

        Pessoa pai = pessoa.getProgenitor(Pessoa.SEXO_MASCULINO);
        Pessoa mae = pessoa.getProgenitor(Pessoa.SEXO_FEMININO);

        if (pai != null) {
            itRelacionamentos = pai.iteradorRelacionamentosDesc();

            while (itRelacionamentos.podeAvancar())
                if (((Relacionamento) itRelacionamentos.avancar()).consultarProgenitor(Pessoa.SEXO_FEMININO) != mae) {
                    itFilhos = ((Relacionamento) itRelacionamentos.corrente()).iteradorDescendentes();
                    while (itFilhos.podeAvancar())
                        lista.inserir(itFilhos.avancar());
                }
        }

        if (mae != null) {
            itRelacionamentos = mae.iteradorRelacionamentosDesc();

            while (itRelacionamentos.podeAvancar())
                if (((Relacionamento) itRelacionamentos.avancar()).consultarProgenitor(Pessoa.SEXO_MASCULINO) != pai) {
                    itFilhos = ((Relacionamento) itRelacionamentos.corrente()).iteradorDescendentes();
                    while (itFilhos.podeAvancar())
                        lista.inserir(itFilhos.avancar());
                }
        }
        return lista.iteradorLista();
    }

    private ListaSimplesCircularBaseFim pesquisarTios(ListaSimplesCircularBaseFim lista, Iterador it) {
        while (it.podeAvancar())
            if (!lista.contem(it.avancar()))
                lista.inserir(it.corrente());
        return lista;
    }

    public Iterador consultarTios(Pessoa pessoa) {
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();

        Pessoa pai = pessoa.getProgenitor(Pessoa.SEXO_MASCULINO);
        Pessoa mae = pessoa.getProgenitor(Pessoa.SEXO_FEMININO);

        if (pai != null) {
            lista = pesquisarTios(lista, consultarIrmaos(pai));
            lista = pesquisarTios(lista, consultarMeiosIrmaos(pai));
        }
        if (mae != null) {
            lista = pesquisarTios(lista, consultarIrmaos(mae));
            lista = pesquisarTios(lista, consultarMeiosIrmaos(mae));
        }

        return lista.iteradorLista();
    }

    public Iterador consultarPrimos(Pessoa pessoa) {
        Iterador itTios, itFilhos;
        ListaSimplesCircularBaseFim lista = new ListaSimplesCircularBaseFim();

        itTios = consultarTios(pessoa);
        while (itTios.podeAvancar()) {
            itFilhos = consultarFilhos((Pessoa) itTios.avancar());
            while (itFilhos.podeAvancar())
                if (!lista.contem(itFilhos.avancar()))
                    lista.inserir(itFilhos.corrente());
        }
        return lista.iteradorLista();
    }

    public Iterador iteradorListaRelacionamentos() {
        return listaRelacionamentosDataInicio.iteradorLista();
    }

    public Iterador iteradorListaPessoaSNome() {
        return listaPessoasNome.iteradorLista();
    }

    public Iterador iteradorListaPessoasData() {
        return listaPessoasData.iteradorLista();
    }

    public int numeroPessoas() {
        return listaPessoasNome.numElementos();
    }

    public int numeroRelacionamentos() {
        return listaRelacionamentosDataInicio.numElementos();
    }

    public void nomeChanged(PessoaEvent event) {
        listaPessoasNome.reordenarElemento(event.getSource());
    }

    public void dataNascChanged(PessoaEvent event) {
        listaPessoasData.reordenarElemento(event.getSource());
    }

    public void dataInicioChanged(RelacionamentoEvent event) {
        listaRelacionamentosDataInicio.reordenarElemento(event.getSource());
    }

    public void fotoChanged(PessoaEvent event) {
    }

    public void relacionamentoAscendenteRemoved(PessoaEvent event) {
    }

    public void dataFimChanged(RelacionamentoEvent event) {
    }

    public void sexoChanged(PessoaEvent event) {
    }

    public void dataObitoChanged(PessoaEvent event) {
    }

    public void filhoAdded(RelacionamentoEvent event) {
    }

    public void filhoRemoved(RelacionamentoEvent event) {
    }

    public void progenitorAdded(RelacionamentoEvent event) {
    }

    public void progenitorRemoved(RelacionamentoEvent event) {
    }

    public void progenitorChanged(RelacionamentoEvent event) {
    }

    public String toString() {
        String s = "\nLista Pessoas:: ";
        Iterador it = listaPessoasNome.iteradorLista();
        while (it.podeAvancar())
            s = s.concat("\n\n" + it.avancar());
        s = s.concat("\n\nLista Relacionamentos::");
        it = listaRelacionamentosDataInicio.iteradorLista();
        while (it.podeAvancar())
            s = s.concat("\n\n" + it.avancar());
        return s;
    }



///////// Fire Events //////////////////////////////////////////////////////////

    transient Vector arvoreGeneologicaListeners;

    public synchronized void addArvoreGeneologicaListener(ArvoreGeneologicaListener l) {
        Vector v = arvoreGeneologicaListeners != null ?
            (Vector) arvoreGeneologicaListeners.clone() : new Vector(2);
        if (!v.contains(l))
            v.add(l);
        arvoreGeneologicaListeners = v;
    }

    public synchronized void removeArvoreGeneologicaListener(ArvoreGeneologicaListener l) {
        Vector v = arvoreGeneologicaListeners != null ?
            (Vector) arvoreGeneologicaListeners.clone() : new Vector(2);
        if (v.contains(l))
            v.remove(l);
        arvoreGeneologicaListeners = v;
    }

    protected void firePessoaAdded(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).pessoaAdded(event);
            }
        }
    }

    protected void firePessoaRemoved(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).pessoaRemoved(event);
            }
        }
    }

    protected void fireRelacionamentoParentAdded(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).relacionamentoParentAdded(event);
            }
        }
    }

    protected void fireRelacionamentoRemoved(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).relacionamentoRemoved(event);
            }
        }
    }

    protected void fireRelacionamentoChildAdded(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).relacionamentoChildAdded(event);
            }
        }
    }

    protected void fireRelacionamentoChanged(ArvoreGeneologicaEvent event) {
        if (arvoreGeneologicaListeners != null) {
            Vector listeners = arvoreGeneologicaListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((ArvoreGeneologicaListener) listeners.elementAt(i)).relacionamentoChanged(event);
            }
        }
    }

}
