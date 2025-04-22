package p4tex.modelo;

import java.io.*;
import java.util.*;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class Dicionario extends Thread {

    private File ficheiro;
    private TabelaHashSondagemQuadratica2 anagramas;
    private TabelaHashSondagemQuadratica2 dicionario;

    public void carregarDicionario(File ficheiro) {
        this.ficheiro = ficheiro;
        start();
    }

    public void run() {
        int i, numLinhas = 0, linhaActual = 0;
        String linha, novaPalavra, assinaturaAnagramaToString;
        StringTokenizer st;
        Palavra palavraDicionario, sinonimo, anagrama;
        ComparacaoInfimoPalavra criterio = new ComparacaoInfimoPalavra();
        BufferedReader br = null;
        char[] assinaturaAnagrama;

        try {
            br = new BufferedReader(new FileReader(ficheiro));
            while (br.readLine() != null)
                numLinhas++;
            if (br != null)
                br.close();

            fireStartLoading(new DicionarioEvent(this, numLinhas, linhaActual));

            dicionario = new TabelaHashSondagemQuadratica2(numLinhas * 2, new HashingClassic());
            anagramas = new TabelaHashSondagemQuadratica2(numLinhas * 2, new HashingClassic());

            br = new BufferedReader(new FileReader(ficheiro));
            while ((linha = br.readLine()) != null) {
                if ((i = linha.indexOf(":")) != -1) {
                    novaPalavra = linha.substring(0, i).toLowerCase().trim();

                    if((palavraDicionario = (Palavra) dicionario.consultar(novaPalavra)) == null)
                        dicionario.inserir(novaPalavra, palavraDicionario = new Palavra(novaPalavra, criterio));

                    Arrays.sort(assinaturaAnagrama = novaPalavra.toCharArray());
                    assinaturaAnagramaToString = String.valueOf(assinaturaAnagrama);
                    if((anagrama = (Palavra)anagramas.consultar(assinaturaAnagramaToString)) == null)
                        anagramas.inserir(String.valueOf(assinaturaAnagrama), anagrama = new Palavra(assinaturaAnagramaToString, criterio));
                    anagrama.inserir(palavraDicionario);

                    st = new StringTokenizer(linha.substring(i + 1, linha.length()), ",");
                    while (st.hasMoreTokens()) {
                        novaPalavra = st.nextToken().toLowerCase().trim();
                        if((sinonimo = (Palavra)dicionario.consultar(novaPalavra)) == null) {
                            sinonimo = new Palavra(novaPalavra, criterio);
                            dicionario.inserir(novaPalavra, sinonimo);

                            Arrays.sort(assinaturaAnagrama = novaPalavra.toCharArray());
                            assinaturaAnagramaToString = String.valueOf(assinaturaAnagrama);
                            if((anagrama = (Palavra)anagramas.consultar(assinaturaAnagramaToString)) == null)
                                anagramas.inserir(String.valueOf(assinaturaAnagrama), anagrama = new Palavra(assinaturaAnagramaToString, criterio));
                            anagrama.inserir(sinonimo);
                        }
                        palavraDicionario.inserir(sinonimo);
                    }
                }
                if (++linhaActual % 100 == 0)
                    fireLoading(new DicionarioEvent(this, ++linhaActual));
            }
        }
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException ex) {}
            fireLoadFinished(new DicionarioEvent(this));
        }
    }

    public Iterador obterAnagramas(String palavra) {
        ListaSimplesCircularBaseFim listaAnagramas = new ListaSimplesCircularBaseFim();
        Iterador it;
        Palavra pTemp;
        char[] assinaturaAnagrama;
        Arrays.sort(assinaturaAnagrama = palavra.toLowerCase().toCharArray());
        if((pTemp = (Palavra)anagramas.consultar(String.valueOf(assinaturaAnagrama))) != null) {
            it = pTemp.getIteradorListaPalavras();
            while (it.podeAvancar())
                if (!((Palavra) it.avancar()).getPalavra().equals(palavra.toLowerCase()))
                    listaAnagramas.inserir(it.corrente());
        }
        return listaAnagramas.iteradorLista();
    }

    public Iterador obterSinonimos(String palavra) {
        Palavra pTemp = null;
        if(dicionario != null && (pTemp = (Palavra)dicionario.consultar(palavra.toLowerCase())) != null)
            return pTemp.getIteradorListaPalavras();
        return new ListaSimplesCircularBaseFim().iteradorLista();
    }

    public boolean palavraExiste(String palavra) {
        return dicionario.consultar(palavra.toLowerCase()) != null;
    }



    transient Vector dicionarioListeners;

    public synchronized void addDicionarioListener(DicionarioListener l) {
        Vector v = dicionarioListeners == null ? new Vector(2) :
            (Vector) dicionarioListeners.clone();
        if (!v.contains(l)) {
            v.addElement(l);
            dicionarioListeners = v;
        }
    }

    public synchronized void removeDicionarioListener(DicionarioListener l) {
        if (dicionarioListeners != null && dicionarioListeners.contains(l)) {
            Vector v = (Vector) dicionarioListeners.clone();
            v.removeElement(l);
            dicionarioListeners = v;
        }
    }

    protected void fireLoadFinished(DicionarioEvent event) {
        if (dicionarioListeners != null) {
            Vector listeners = dicionarioListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DicionarioListener) listeners.elementAt(i)).dicionarioLoadFinished(event);
            }
        }
    }

    protected void fireLoading(DicionarioEvent event) {
        if (dicionarioListeners != null) {
            Vector listeners = dicionarioListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DicionarioListener) listeners.elementAt(i)).dicionarioLoading(event);
            }
        }
    }

    protected void fireStartLoading(DicionarioEvent event) {
        if (dicionarioListeners != null) {
            Vector listeners = dicionarioListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((DicionarioListener) listeners.elementAt(i)).dicionarioStartLoading(event);
            }
        }
    }

}
