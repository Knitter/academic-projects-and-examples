package genx.listas;

public interface Comparacao {

    IllegalArgumentException ERRO_COMPARACAO = new IllegalArgumentException();

    int comparar(Object o1, Object o2);

}
