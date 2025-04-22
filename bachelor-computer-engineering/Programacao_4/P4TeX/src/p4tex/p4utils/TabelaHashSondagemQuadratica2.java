package p4tex.p4utils;

public class TabelaHashSondagemQuadratica2 extends TabelaHashSondagem2 {
    public TabelaHashSondagemQuadratica2(int tamanho, Hashing hashing) {
        super(tamanho, hashing);
    }

    // devolve a primeira posição livre ou a posição da chave
    protected int posicaoTabela(Object chave) {
        int i = hashing.posicaoTabela(chave, tabela.length), pos = -1,
            inicial = i, inc = 1;
        while (tabela[i] != null && !tabela[i].getChave().equals(chave)) {
            if (tabela[i] == associacaoChaveLazyDelete) {
                pos = i;
                break;
            }
            i = (i + inc) % tabela.length;
            inc += 2;
            if (i == inicial) {
                throw SONDAGEM_CIRCULAR;
            }
        }
        if (pos != -1) {
            do {
                i = (i + inc) % tabela.length;
                inc += 2;
                if (i == inicial) {
                    throw SONDAGEM_CIRCULAR;
                }
            }
            while (tabela[i] != null && !tabela[i].getChave().equals(chave));
        }
        if (tabela[i] == null && pos != -1) {
            return pos;
        }
        return i;
    }
}
