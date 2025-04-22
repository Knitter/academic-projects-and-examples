package genx.listas;

import java.io.*;

public class ListaSimplesCircularBaseFim
    implements Serializable {

    private NoListaSimplesCircularBase noInicial;
    private NoListaSimplesCircularBase noFinal;

    public ListaSimplesCircularBaseFim() {
        noFinal = noInicial = new NoListaSimplesCircularBase();
    }

    public void inserir(Object elem) {
        noFinal.seguinte = new NoListaSimplesCircularBase(elem, noInicial);
        noFinal = noFinal.seguinte;
    }

    public boolean contem(Object elem) {
        NoListaSimplesCircularBase aux = noInicial.seguinte;
        while (aux != noInicial) {
            if (aux.elemento == elem)
                return true;
            aux = aux.seguinte;
        }
        return false;
    }

    public boolean vazia() {
        return noInicial.seguinte == noInicial;
    }

    public Object consultar(int indice) {
        NoListaSimplesCircularBase aux = noInicial.seguinte;
        while (aux != noInicial) {
            if (indice-- == 0) {
                return aux.elemento;
            }
            aux = aux.seguinte;
        }
        return null;
    }

    public int numElementos() {
        int i = 0;
        NoListaSimplesCircularBase aux = noInicial.seguinte;
        while (aux != noInicial) {
            i++;
            aux = aux.seguinte;
        }
        return i;
    }

    public Iterador iteradorLista() {
        return new IteradorListaSimplesCircularBase(noInicial);
    }

    public void removerTodos() {
        if (noInicial.seguinte != noInicial) {
            NoListaSimplesCircularBase p = noInicial.seguinte, aux;
            do {
                aux = p;
                p = p.seguinte;
                aux.elemento = aux.seguinte = null;
            }
            while (p != noInicial);
            noInicial.seguinte = noFinal = noInicial;
        }
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Lista SCBase = {\n");
        NoListaSimplesCircularBase aux = noInicial.seguinte;
        while (aux != noInicial) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }
}

/* ************** */
/* Classes Locais */
/* ************** */
class NoListaSimplesCircularBase
    implements Serializable {
    Object elemento;
    NoListaSimplesCircularBase seguinte;

    // Criação do no base
    NoListaSimplesCircularBase() {
        elemento = null;
        seguinte = this;
    }

    NoListaSimplesCircularBase(Object elem, NoListaSimplesCircularBase seg) {
        elemento = elem;
        seguinte = seg;
    }

    protected void finalize() {
        elemento = seguinte = null;
    }
}

class IteradorListaSimplesCircularBase implements Iterador {

    private NoListaSimplesCircularBase noInicial, corrente;

    IteradorListaSimplesCircularBase(NoListaSimplesCircularBase noInicial) {
        this.noInicial = corrente = noInicial;
    }

    public boolean podeAvancar() {
        return corrente.seguinte != noInicial;
    }

    public Object avancar() {
        if (podeAvancar()) {
            corrente = corrente.seguinte;
            return corrente.elemento;
        }
        throw ELEMENTO_INVALIDO;
    }

    public Object corrente() {
        if (corrente == noInicial) {
            throw ELEMENTO_INVALIDO;
        }
        return corrente.elemento;
    }

    public void reiniciar() {
        corrente = noInicial;
    }
}
