package p4tex.p4utils;

public interface TabelaHashADT {
    /** Insere uma associa��o (chave, valor) na tabela */
    boolean inserir(Object chave, Object valor);

    /** Remove a associa��o correspondente � chave */
    boolean remover(Object chave);

    /** Devolve o valor correspondente � chave ou null */
    Object consultar(Object chave);

    /** Verifica se a tabela est� sem elementos */
    boolean vazia();

    /** Devolve o n�mero de elementos da tabela */
    int numElementos();

    /** Remove todos os elementos da tabela */
    void removerTodos();

    /** Devolve um iterador das associac�es da tabela */
    Iterador iterador();

    /** Devolve um iterador das chaves da tabela */
    Iterador iteradorChaves();

    /** Devolve um iterador dos valores da tabela */
    Iterador iteradorValores();
}
