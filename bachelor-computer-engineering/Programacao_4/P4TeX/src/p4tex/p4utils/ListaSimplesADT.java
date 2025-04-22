package p4tex.p4utils;

public interface ListaSimplesADT {
    void inserir(Object elem);

    boolean remover(Object elem);

    boolean vazia();

    Iterador consultar(Object elem);

    Object consultar(int indice);

    int numElementos();

    void removerTodos();

    Iterador iteradorLista();
}
