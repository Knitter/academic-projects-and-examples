package p4tex.p4utils;

public abstract class TabelaHashSondagem2
    implements TabelaHashADT, java.io.Serializable {
    static RuntimeException SONDAGEM_CIRCULAR = new RuntimeException(
        "Sondagem circular de toda a tabela");

    protected Associacao[] tabela;
    protected Hashing hashing;
    protected int numElementos, inactivos;
    protected Associacao associacaoChaveLazyDelete;

    public TabelaHashSondagem2(int tamanho, Hashing hashing) {
        this.hashing = hashing;
        tabela = new Associacao[proximoPrimo(tamanho)];
        associacaoChaveLazyDelete = new Associacao(new Object() {
            public boolean equals(Object o) {
                return false;
            }
        }, null);
        numElementos = inactivos = 0;
    }

    public boolean inserir(Object chave, Object valor) {
        int i = posicaoTabela(chave);
        if (tabela[i] != null) {
            if (tabela[i].getChave().equals(chave)) {
                return false;
            }
            inactivos--;
        }
        tabela[i] = new Associacao(chave, valor);
        numElementos++;
        if (factorCarga() >= 0.5) {
            reHash();
        }
        return true;
    }

    public boolean remover(Object chave) {
        int i = posicaoTabela(chave);
        if (tabela[i] != null && tabela[i].getChave().equals(chave)) {
            tabela[i] = associacaoChaveLazyDelete;
            inactivos++;
            numElementos--;
            return true;
        }
        return false;
    }

    public boolean vazia() {
        return numElementos == 0;
    }

    // Devolve o valor correspondente à chave
    public Object consultar(Object chave) {
        int i = posicaoTabela(chave);
        if (tabela[i] != null && tabela[i].getChave().equals(chave)) {
            return tabela[i].getValor();
        }
        return null;
    }

    public int numElementos() {
        return numElementos;
    }

    public void removerTodos() {
        for (int i = 0; i < tabela.length; i++) {
            tabela[i] = null;
        }
        numElementos = inactivos = 0;
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Tabela de tamanho ");
        s.append(tabela.length);
        s.append(" = {\n");
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                s.append("Tabela[" + i + "]==> ");
                s.append(tabela[i]);
                s.append("\n");
            }
        }
        s.append("}\n");
        return s.toString();
    }

    public Iterador iterador() {
        return new IteradorTabelaHashSondagem2(this);
    }

    public Iterador iteradorChaves() {
        return new IteradorChavesTabelaHashSondagem2(this);
    }

    public Iterador iteradorValores() {
        return new IteradorValoresTabelaHashSondagem2(this);
    }

    // devolve a primeira posição livre ou a posição da chave
    protected abstract int posicaoTabela(Object chave);

    protected float factorCarga() {
        return (numElementos + inactivos) / (float) tabela.length;
    }

    protected void reHash() {
        int tam = proximoPrimo(tabela.length * 2);
        Associacao[] tabelaAntiga = tabela;
        tabela = new Associacao[tam];
        numElementos = inactivos = 0;
        for (int i = 0; i < tabelaAntiga.length; i++) {
            if (tabelaAntiga[i] != null &&
                tabelaAntiga[i] != associacaoChaveLazyDelete) {
                inserir(tabelaAntiga[i].getChave(),
                        tabelaAntiga[i].getValor());
            }
        }
    }

    public static int proximoPrimo(int n) {
        if (n < 2) {
            return 2;
        }
        if (n % 2 == 0) {
            ++n;
        }
        for (int i; ; n += 2) {
            for (i = 3; i * i <= n && n % i != 0; i += 2) {
                ;
            }
            if (i * i > n) {
                return n;
            }
        }
    }
}

/* ************** */
/* Classes Locais */
/* ************** */
// Implementação particular de uma lista circular com base e limite
// de referencias para objectos de critérios (todos) distintos

class IteradorTabelaHashSondagem2
    implements Iterador {
    protected TabelaHashSondagem2 tabelaHashSondagem;
    protected int corrente, proximo;

    IteradorTabelaHashSondagem2(TabelaHashSondagem2 tabelaHashSondagem) {
        this.tabelaHashSondagem = tabelaHashSondagem;
        reiniciar();
    }

    public boolean podeAvancar() {
        return proximo != tabelaHashSondagem.tabela.length;
    }

    public Object avancar() {
        if (podeAvancar()) {
            corrente = proximo;
            proximo = proximoActivo();
            return tabelaHashSondagem.tabela[corrente];
        }
        throw ELEMENTO_INVALIDO;
    }

    public Object corrente() {
        if (corrente == tabelaHashSondagem.tabela.length) {
            throw ELEMENTO_INVALIDO;
        }
        return tabelaHashSondagem.tabela[corrente];
    }

    public void reiniciar() {
        if (tabelaHashSondagem.vazia()) {
            corrente = proximo = tabelaHashSondagem.tabela.length;
        }
        else {
            corrente = tabelaHashSondagem.tabela.length;
            proximo = -1;
            proximo = proximoActivo();
        }
    }

    private int proximoActivo() {
        if (proximo == tabelaHashSondagem.tabela.length) {
            return proximo;
        }
        while (++proximo != tabelaHashSondagem.tabela.length &&
               (tabelaHashSondagem.tabela[proximo] == null ||
                tabelaHashSondagem.tabela[proximo] ==
                tabelaHashSondagem.associacaoChaveLazyDelete)) {
            ;
        }
        return proximo;
    }
}

class IteradorChavesTabelaHashSondagem2
    extends IteradorTabelaHashSondagem2 {
    IteradorChavesTabelaHashSondagem2(TabelaHashSondagem2
                                      tabelaHashSondagem) {
        super(tabelaHashSondagem);
    }

    public Object avancar() {
        return ( (Associacao)super.avancar()).getChave();
    }

    public Object corrente() {
        return ( (Associacao)super.corrente()).getChave();
    }
}

class IteradorValoresTabelaHashSondagem2
    extends IteradorTabelaHashSondagem2 {
    IteradorValoresTabelaHashSondagem2(TabelaHashSondagem2
                                       tabelaHashSondagem) {
        super(tabelaHashSondagem);
    }

    public Object avancar() {
        return ( (Associacao)super.avancar()).getValor();
    }

    public Object corrente() {
        return ( (Associacao)super.corrente()).getValor();
    }
}
