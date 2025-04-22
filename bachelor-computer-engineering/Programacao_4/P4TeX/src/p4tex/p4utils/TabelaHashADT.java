package p4tex.p4utils;

public interface TabelaHashADT {
    /** Insere uma associação (chave, valor) na tabela */
    boolean inserir(Object chave, Object valor);

    /** Remove a associação correspondente à chave */
    boolean remover(Object chave);

    /** Devolve o valor correspondente à chave ou null */
    Object consultar(Object chave);

    /** Verifica se a tabela está sem elementos */
    boolean vazia();

    /** Devolve o número de elementos da tabela */
    int numElementos();

    /** Remove todos os elementos da tabela */
    void removerTodos();

    /** Devolve um iterador das associacões da tabela */
    Iterador iterador();

    /** Devolve um iterador das chaves da tabela */
    Iterador iteradorChaves();

    /** Devolve um iterador dos valores da tabela */
    Iterador iteradorValores();
}
