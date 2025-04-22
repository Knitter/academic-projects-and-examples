package p4tex.p4utils;

public interface Hashing {
    IllegalArgumentException TIPO_INCORRECTO = new IllegalArgumentException();
    int posicaoTabela(Object chave, int tamanhoTabela);
}
