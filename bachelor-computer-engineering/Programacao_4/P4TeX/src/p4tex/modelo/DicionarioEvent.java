package p4tex.modelo;

import java.util.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class DicionarioEvent extends EventObject {

    private int numLinhas;
    private int linhaCorrente;

    public DicionarioEvent(Object source) {
        super(source);
    }

    public DicionarioEvent(Object source, int linhaCorrente) {
        super(source);
        this.linhaCorrente = linhaCorrente;
    }

    public DicionarioEvent(Object source, int numLinhas, int linhaCorrente) {
        super(source);
        this.numLinhas = numLinhas;
        this.linhaCorrente = linhaCorrente;
    }

    public int getNumLinhas() {
        return numLinhas;
    }

    public int getLinhaCorrente() {
        return linhaCorrente;
    }
}
