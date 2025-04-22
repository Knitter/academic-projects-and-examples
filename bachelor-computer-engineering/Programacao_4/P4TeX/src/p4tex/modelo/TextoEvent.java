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
public class TextoEvent extends EventObject {

    private String texto;
    private Estilo estilo;
    private boolean wrongWord;

    public TextoEvent(Object source, String texto, Estilo estilo, boolean wrongWord) {
        super(source);
        this.texto = texto;
        this.estilo = estilo;
        this.wrongWord = wrongWord;
    }

    public String getTexto() {
        return texto;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public boolean isWrongWord() {
        return wrongWord;
    }
}
