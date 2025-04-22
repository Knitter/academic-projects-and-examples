package p4tex.modelo;

import java.io.*;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class ListaDuplaCircularBaseFim
    implements Serializable {

    protected NoListaDuplaCircularBaseFim noInicial;
    protected NoListaDuplaCircularBaseFim noFinal;

    public ListaDuplaCircularBaseFim() {
        noFinal = noInicial = new NoListaDuplaCircularBaseFim(null);
    }

    public void inserir(Object elem) {
        noFinal.seguinte = new NoListaDuplaCircularBaseFim(elem, noInicial);
        noFinal = noFinal.seguinte;
    }

    public Object removerUltimo() {
        NoListaDuplaCircularBaseFim aux = noFinal;
        noFinal.anterior.seguinte = noFinal.seguinte;
        noFinal.seguinte.anterior = noFinal.anterior;
        noFinal = noInicial.anterior;
        return aux.elemento;
    }

    public Object consultarUltimo() {
        return noFinal.elemento;
    }

    public boolean vazia() {
        return noInicial.seguinte == noInicial;
    }

    public Object consultar(int indice) {
        NoListaDuplaCircularBaseFim aux = noInicial.seguinte;
        while (aux != noInicial) {
            if (indice-- == 0)
                return aux.elemento;
            aux = aux.seguinte;
        }
        return null;
    }

    public int numElementos() {
        int i = 0;
        NoListaDuplaCircularBaseFim aux = noInicial.seguinte;
        while (aux != noInicial) {
            i++;
            aux = aux.seguinte;
        }
        return i;
    }

    public void removerTodos() {
        if (noInicial.seguinte != noInicial) {
            NoListaDuplaCircularBaseFim p = noInicial.seguinte, aux;
            do {
                aux = p;
                p = p.seguinte;
                aux.elemento = aux.anterior = aux.seguinte = null;
            }
            while (p != noInicial);
            noFinal = noInicial.anterior = noInicial.seguinte = noInicial;
        }
    }

    public IteradorListaDupla iteradorLista() {
        return new IteradorListaDuplaCircularBaseFim(noInicial);
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("Lista DCBLim = {\n");
        NoListaDuplaCircularBaseFim aux = noInicial.seguinte;
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
class NoListaDuplaCircularBaseFim
    implements java.io.Serializable {
    Object elemento;
    NoListaDuplaCircularBaseFim anterior, seguinte;

    NoListaDuplaCircularBaseFim(Object e) {
        elemento = e;
        anterior = seguinte = this;
    }

    NoListaDuplaCircularBaseFim(Object e, NoListaDuplaCircularBaseFim prox) {
        elemento = e;
        anterior = prox.anterior;
        seguinte = prox;
        prox.anterior = anterior.seguinte = this;
    }

    protected void finalize() {
        elemento = anterior = seguinte = null;
    }
}

class IteradorListaDuplaCircularBaseFim implements IteradorListaDupla {
    private NoListaDuplaCircularBaseFim noInicial;
    private NoListaDuplaCircularBaseFim corrente;

    IteradorListaDuplaCircularBaseFim(NoListaDuplaCircularBaseFim noInicial) {
        this.noInicial = corrente = noInicial;
    }

    public boolean podeAvancar() {
        return corrente.seguinte != noInicial;
    }

    public boolean podeRecuar() {
        return corrente.anterior != noInicial;
    }

    public Object avancar() {
        if (podeAvancar()) {
            corrente = corrente.seguinte;
            return corrente.elemento;
        }
        throw ELEMENTO_INVALIDO;
    }

    public Object recuar() {
        if (podeRecuar()) {
            corrente = corrente.anterior;
            return corrente.elemento;
        }
        throw ELEMENTO_INVALIDO;
    }

    public Object corrente() {
        if (corrente == noInicial)
            throw ELEMENTO_INVALIDO;
        return corrente.elemento;
    }

    public void reiniciar() {
        corrente = noInicial;
    }
}
