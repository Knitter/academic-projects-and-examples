package p4tex.p4utils;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3� Trabalho Pr�tico de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, S�rgio Lopes
 * @version 1.0
 */
public class HashingClassic
    implements Hashing {

    public int posicaoTabela(Object chave, int tamanhoTabela) {
        return chave.hashCode() & 0x0FFFFFFF % tamanhoTabela;
    }
}
