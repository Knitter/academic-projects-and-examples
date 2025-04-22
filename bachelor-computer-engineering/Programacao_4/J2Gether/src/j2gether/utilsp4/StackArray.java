package j2gether.utilsp4;

import java.util.EmptyStackException;

public class StackArray implements Stack {
    private int numElementos;
    private Object lifo[];

    public StackArray(int capacidade) {
        lifo = new Object[capacidade];
        numElementos = 0;
    }

    public void push(Object o) {
        if (lifo.length == numElementos)
            throw new RuntimeException("Stack Overflow");
        lifo[numElementos++] = o;
    }

    public Object pop() {
        if (numElementos == 0)
            throw new EmptyStackException();
        Object aux = lifo[--numElementos];
        lifo[numElementos] = null;
        return aux;
    }

    public Object top() {
        if (numElementos == 0)
            throw new EmptyStackException();
        return lifo[numElementos - 1];
    }

    public boolean isEmpty() {
        return numElementos == 0;
    }

    /**
     * Remove todos os elementos da pilha.
     */
    public void clear() {
        while (!isEmpty())
            pop();
    }

    /**
     * Lista todos os elementos da pilha desde o seu topo.
     */
    public String toString() {
        StringBuffer lista = new StringBuffer();
        lista.append("StackArray={");
        for (int i = numElementos - 1; i > 0; i--) {
            lista.append(lifo[i]);
            lista.append(", ");
        }
        if (numElementos > 0)
            lista.append(lifo[0]);
        lista.append("};");
        return lista.toString();
    }
}
