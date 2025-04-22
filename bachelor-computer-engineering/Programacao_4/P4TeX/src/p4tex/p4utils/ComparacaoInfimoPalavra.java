package p4tex.p4utils;

import p4tex.modelo.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class ComparacaoInfimoPalavra  extends ComparacaoPalavra implements ComparacaoInfimo {

    private static final Palavra INFIMO = new Palavra(new String(new char[] {Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE}));

    public Object infimo() {
        return INFIMO;
    }
}
