package p4tex.modelo;

import java.io.*;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class P4TeX {

    private Dicionario dicionario = new Dicionario();
    private Texto documento = new Texto();

    public void abrirFDE(File ficheiro) throws FormatacaoException, DocumentoException, IOException {
        documento.carregarFDE(ficheiro);
    }

    public void abrirDocumento(File ficheiro) throws DocumentoException, FormatacaoException, IOException {
        this.documento.carregarDocumento(ficheiro);
    }

    public void abrirDicionario(File ficheiro) {
        dicionario = new Dicionario();
        dicionario.addDicionarioListener(documento);
        dicionario.carregarDicionario(ficheiro);
    }

    public void gravar() {
        documento.gravarDocumento();
    }

    public void gravarComo(File ficheiro) {
        documento.gravarDocumento(ficheiro);
    }

    public Iterador procurarSinonimos(String palavra) {
        return dicionario.obterSinonimos(palavra);
    }

    public Iterador procurarAnagramas(String palavra) {
        return dicionario.obterAnagramas(palavra);
    }

    public boolean isSelectedWordWrong(String palavra) {
        return documento.isSelectedWordWrong(palavra);
    }

    public void substituirTodasPalavras(String palavrasAntigas, String novaPalavra) throws SubstituicaoException, FormatacaoException {
        documento.substituirTodasPalavras(palavrasAntigas, novaPalavra);
    }

    public Texto getDocumento() {
        return documento;
    }

    public Dicionario getDicionario() {
        return dicionario;
    }

}
