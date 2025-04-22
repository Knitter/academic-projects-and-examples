package j2gether.utilsp4;

/**
 * Programa��o IV (C) 2001
 * Interface que representa uma pilha.
 *
 * @author Vitor Carreira
 * @version 1.0
 */

import java.util.EmptyStackException;

public interface Stack {
    /**
     * Coloca um objecto no topo da pilha.
     * @param o objecto a colocar no topo
     */
    public void push(Object o);

    /**
     * Retira o objecto que está no topo da pilha e devolve-o.
     * @return o objecto retirado do topo da pilha
     * @throws EmptyStackException se a pilha está vazia
     */
    public Object pop() throws EmptyStackException;

    /**
     * Devolve objecto que está no topo da pilha sem o retirar.
     * @return o objecto que está no topo da pilha
     * @throws EmptyStackException se a pilha está vazia
     */
    public Object top() throws EmptyStackException;

    /**
     * Verifica se a pilha está vazia.
     * @return true caso a pilha se encontre vazia; false caso contr�rio
     */
    public boolean isEmpty();
}
