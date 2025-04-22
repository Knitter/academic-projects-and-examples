package p4tex.modelo;

import java.awt.*;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class Estilo implements Cloneable{

    private String tipoDeFonte;
    private int tamanhoDaFonte;
    private Color cor;
    private boolean negrito;
    private boolean italico;
    private boolean sublinhado;

    private String closeOutput = "";

    private static TabelaHashSondagemQuadratica2 cores;
    private static TabelaHashSondagemQuadratica2 coresToString;

    static {
        cores = new TabelaHashSondagemQuadratica2(23, new HashingClassic());
        cores.inserir("preto", Color.BLACK);
        cores.inserir("azul", Color.BLUE);
        cores.inserir("ciano", Color.CYAN);
        cores.inserir("cinza", Color.GRAY);
        cores.inserir("verde", Color.GREEN);
        cores.inserir("magenta", Color.MAGENTA);
        cores.inserir("laranja", Color.ORANGE);
        cores.inserir("rosa", Color.PINK);
        cores.inserir("vermelho", Color.RED);
        cores.inserir("branco", Color.WHITE);
        cores.inserir("amarelo", Color.YELLOW);

        coresToString = new TabelaHashSondagemQuadratica2(23, new HashingClassic());
        coresToString.inserir(Color.BLACK, "preto");
        coresToString.inserir(Color.BLUE, "azul");
        coresToString.inserir(Color.CYAN, "ciano");
        coresToString.inserir(Color.GRAY, "cinza");
        coresToString.inserir(Color.GREEN, "verde");
        coresToString.inserir(Color.MAGENTA, "magenta");
        coresToString.inserir(Color.ORANGE, "laranja");
        coresToString.inserir(Color.PINK, "rosa");
        coresToString.inserir(Color.RED, "vermelho");
        coresToString.inserir(Color.WHITE, "branco");
        coresToString.inserir(Color.YELLOW, "amarelo");
    }

    public Estilo(Estilo estilo) {
        tipoDeFonte = estilo.tipoDeFonte;
        tamanhoDaFonte = estilo.tamanhoDaFonte;
        cor = estilo.cor;
        negrito = estilo.negrito;
        italico = estilo.italico;
        sublinhado = estilo.sublinhado;
    }

    public Estilo(String tipoDeFonte, String tamanhoDaFonte, String negrito, String italico, String sublinhado, String cor) throws FormatacaoException {
        String estilo;

        this.tipoDeFonte = tipoDeFonte.replaceAll("\"", "");

        try {
            this.tamanhoDaFonte = Integer.parseInt(tamanhoDaFonte);

            estilo = negrito.toLowerCase();
            if (estilo.equals("verdadeiro") || estilo.equals("true"))
                this.negrito = true;
            else if (estilo.equals("falso") || estilo.equals("false"))
                this.negrito = false;
            else
                throw new FormatacaoException("Formatação negrito inválida!");

            estilo = italico.toLowerCase();
            if (estilo.equals("verdadeiro") || estilo.equals("true"))
                this.italico = true;
            else if (estilo.equals("falso") || estilo.equals("false"))
                this.italico = false;
            else
                throw new FormatacaoException("Formatação itálico inválida!");

            estilo = sublinhado.toLowerCase();
            if (estilo.equals("verdadeiro") || estilo.equals("true"))
                this.sublinhado = true;
            else if (estilo.equals("falso") || estilo.equals("false"))
                this.sublinhado = false;
            else
                throw new FormatacaoException("Formatação sublinhado inválida!");

            this.cor = (Color) cores.consultar(cor.toLowerCase());

        }
        catch (NumberFormatException ex) {
            throw new FormatacaoException("Tamanho de fonte inválido!");
        }
        catch (NullPointerException ex) {
            throw new FormatacaoException("Cor não existe!");
        }
    }

    public Object clone() {
        Object obj = null;

        try {
            obj = super.clone();
        }
        catch (CloneNotSupportedException ex) {
        }
        return obj;
    }

    public String getTipoDeFonte() {
        return tipoDeFonte;
    }

    public int getTamanhoDaFonte() {
        return tamanhoDaFonte;
    }

    public Color getCor() {
        return cor;
    }

    public boolean isNegrito() {
        return negrito;
    }

    public boolean isItalico() {
        return italico;
    }

    public boolean isSublinhado() {
        return sublinhado;
    }

    public void setTamanhoDaFonte(int tamanhoDaFonte) {
        this.tamanhoDaFonte = tamanhoDaFonte;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setNegrito(boolean negrito) {
        this.negrito = negrito;
    }

    public void setItalico(boolean italico) {
        this.italico = italico;
    }

    public void setSublinhado(boolean sublinhado) {
        this.sublinhado = sublinhado;
    }

    public void setTipoDeFonte(String tipoDeFonte) {
        this.tipoDeFonte = tipoDeFonte.replaceAll("\"", "");
    }

    public void setTamanhoDaFonte(String tamanhoDaFonte) throws FormatacaoException {
        this.tamanhoDaFonte = Integer.parseInt(tamanhoDaFonte);
    }

    public void setCor(String cor) throws FormatacaoException {
        if ((this.cor = (Color) cores.consultar(cor.toLowerCase())) == null)
            throw new FormatacaoException("Cor não existe!");
    }

    public void setNegrito(String negrito) throws FormatacaoException {
        negrito = negrito.toLowerCase();
        if (negrito.equals("verdadeiro") || negrito.equals("true"))
            this.negrito = true;
        else if (negrito.equals("falso") || negrito.equals("false"))
            this.negrito = false;
        else
            throw new FormatacaoException("Formatação negrito inválida!");
    }

    public void setItalico(String italico) throws FormatacaoException {
        italico = italico.toLowerCase();
        if (italico.equals("verdadeiro") || italico.equals("true"))
            this.italico = true;
        else if (italico.equals("falso") || italico.equals("false"))
            this.italico = false;
        else
            throw new FormatacaoException("Formatação itálico inválida!");
    }

    public void setSublinhado(String sublinhado) throws FormatacaoException {
        sublinhado = sublinhado.toLowerCase();
        if (sublinhado.equals("verdadeiro") || sublinhado.equals("true"))
            this.sublinhado = true;
        else if (sublinhado.equals("falso") || sublinhado.equals("false"))
            this.sublinhado = false;
        else
            throw new FormatacaoException("Formatação sublinhado inválida!");
    }

    public String getCloseOutput() {
        return closeOutput;
    }

    public void setCloseOutput(String closeOutput) {
        this.closeOutput = closeOutput;
    }

    private String putPontoVirgula(int flag) {
        return flag != 0 ? ";" : "";
    }

    public String estiloAsString(Estilo estiloAnterior) {
        if(estiloAnterior != null) {
            int flag = 0;
            StringBuffer estilo = new StringBuffer();
            if (estiloAnterior.cor != cor) {
                estilo.append("c=" + coresToString.consultar(cor));
                flag++;
            }
            if (estiloAnterior.italico ^ italico)
                estilo.append(putPontoVirgula(flag++) + "i=" + (italico ? "verdadeiro" : "falso"));
            if (estiloAnterior.sublinhado ^ sublinhado)
                estilo.append(putPontoVirgula(flag++) + "s=" + (sublinhado ? "verdadeiro" : "falso"));
            if (estiloAnterior.negrito ^ negrito)
                estilo.append(putPontoVirgula(flag++) + "n=" + (negrito ? "verdadeiro" : "falso"));
            if (estiloAnterior.tamanhoDaFonte != tamanhoDaFonte)
                estilo.append(putPontoVirgula(flag++) + "t=" + String.valueOf(tamanhoDaFonte));
            return "[" + estilo + "]";
        }
        return "";
    }

    public boolean isSameStyleThan(Estilo teste) {
        if(this == teste)
            return true;

        if(((Estilo)teste).cor != cor)
            return false;
        if(((Estilo)teste).italico != italico)
            return false;
        if(((Estilo)teste).negrito != negrito)
            return false;
        if(((Estilo)teste).sublinhado != sublinhado)
            return false;
        if(((Estilo)teste).tamanhoDaFonte != tamanhoDaFonte)
            return false;
        if(!((Estilo)teste).tipoDeFonte.equals(tipoDeFonte))
            return false;

        return true;
    }

}
