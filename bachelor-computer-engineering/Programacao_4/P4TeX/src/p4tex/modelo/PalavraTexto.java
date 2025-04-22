package p4tex.modelo;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class PalavraTexto {

    private String palavra;
    private Estilo estilo;
    private boolean wrongWord;

    public PalavraTexto(String palavra, Estilo estilo) {
        this.palavra = palavra;
        this.estilo = estilo;
    }

    public PalavraTexto(String palavra, Estilo estilo, boolean wrongWord) {
        this.palavra = palavra;
        this.estilo = estilo;
        this.wrongWord = wrongWord;
    }

    public String getPalavra() {
        return palavra;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public boolean isWrongWord() {
        return wrongWord;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public void setWrongWord(boolean wrongWord) {
        this.wrongWord = wrongWord;
    }

}
