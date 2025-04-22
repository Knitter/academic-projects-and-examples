package p4tex.p4utils;

public class Associacao
    implements java.io.Serializable {
    private Object chave, valor;

    public Associacao(Object chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public Object getChave() {
        return chave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Chave: " + chave + " Valor: " + valor;
    }
}
