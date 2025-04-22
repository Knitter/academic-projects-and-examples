package p4tex.modelo;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import p4tex.p4utils.*;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class Texto extends Thread implements DicionarioListener {

    private File ficheiro;
    private Dicionario dicionario;
    private TabelaHashSondagemQuadratica2 fde = new TabelaHashSondagemQuadratica2(11, new HashingClassic());
    public ListaDuplaCircularBaseFim texto = new ListaDuplaCircularBaseFim();
    private TabelaHashSondagemQuadratica2 index = new TabelaHashSondagemQuadratica2(1001, new HashingClassic());

    public void carregarFDE(File ficheiro) throws FormatacaoException, DocumentoException, IOException {
        String linha;
        Pattern pattern;
        Matcher matcher;
        BufferedReader br = null;

        try {
            fde.removerTodos();

            br = new BufferedReader(new FileReader(ficheiro));
            pattern = Pattern.compile("(^\\w+)\\s+((\"(.+)\")|(\\w+))\\s+(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\w+)\\s+(\\w+)$");
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.indexOf('#', 0) != 0) {
                    matcher = pattern.matcher(linha);
                    matcher.find();
                    fde.inserir(matcher.group(1).toLowerCase(),
                                new EstiloFDE(matcher.group(1), matcher.group(2), matcher.group(6), matcher.group(7),
                                              matcher.group(8), matcher.group(9), matcher.group(10)));
                }
            }
            if (this.ficheiro != null)
                carregarDocumento(this.ficheiro);
        }
        catch (IllegalStateException ex) {
            throw new FormatacaoException("FDE inválido!");
        }
    }

    public void carregarDocumento(File ficheiro) throws DocumentoException, FormatacaoException, IOException {
        char ch;
        boolean novoFDE = false, novaExcepcao = false;
        StringBuffer backStyle = new StringBuffer();
        BufferedReader br = null;
        String linha, palavra1, palavra2;
        StringTokenizer st1;
        Estilo estilo = null;
        Estilo estiloExcepcao = null;
        Pattern pattern1 = Pattern.compile("<\\w+>|<|[^<]*");
        Pattern pattern2 = Pattern.compile("\\[\\]|\\[[^\\]]+\\]|[^\\[]+");
        Pattern pattern3 = Pattern.compile("\\[[fdnisc]=(\\w+|\"[^\"]+\")(;[fdnisc]=(\\w+|\"[^\"]+\"))*\\]");
        Pattern pattern4 = Pattern.compile("\\d+|[\\u0041-\\u005A\\u0061-\\u007A\\u00AA\\u00BA\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u01F5\\u01FA-\\u0217\\u0250-\\u02A8\\u1E00-\\u1E9B\\u1EA0-\\u1EF9\\uFB01\\uFB02]+|\\W");
        Matcher matcher1, matcher2, matcher3;
        StackArray stackExcepcoes = new StackArray(50);

        PalavraIndex barraNIndexado = new PalavraIndex();
        index.inserir("\r", barraNIndexado);
        index.inserir("\n", barraNIndexado);

        try {
            br = new BufferedReader(new FileReader(ficheiro));

            limparTodoTexto();
            this.ficheiro = ficheiro;

            while ((linha = br.readLine().trim()).equals(""));

            do {
                matcher1 = pattern1.matcher(linha);
                while (matcher1.find()) {
                    palavra1 = matcher1.group();
                    if (!palavra1.equals("")) {
                        if (palavra1.startsWith("<") && palavra1.endsWith(">")) {
                            if (!stackExcepcoes.isEmpty())
                                throw new FormatacaoException("Erro no documento: existem excepções mal fechadas!");
                            if ((estilo = (EstiloFDE) fde.consultar(palavra1.substring(1, palavra1.length() - 1).toLowerCase())) == null)
                                throw new FormatacaoException("O documento contém um estilo inexistente!");
                            novoFDE = true;
                        }
                        else {
                            matcher2 = pattern2.matcher(palavra1);
                            while (matcher2.find()) {
                                if (matcher2.group().startsWith("[") && matcher2.group().endsWith("]")) {
                                    matcher3 = pattern3.matcher(matcher2.group());
                                    if (matcher3.find()) {
                                        matcher3.reset();
                                        while (matcher3.find()) {
                                            if (novaExcepcao)
                                                throw new FormatacaoException("Duas excepções adjacentes!");
                                            if (stackExcepcoes.isEmpty())
                                                estiloExcepcao = new Estilo(estilo);
                                            else
                                                estiloExcepcao = new Estilo((Estilo) stackExcepcoes.top());
                                            st1 = new StringTokenizer(matcher3.group().substring(1, matcher3.group().length() - 1), ";");
                                            while (st1.hasMoreTokens()) {
                                                palavra2 = st1.nextToken();
                                                if (palavra2.indexOf("=") == 1) {
                                                    ch = Character.toLowerCase(palavra2.charAt(0));
                                                    palavra2 = palavra2.substring(2, palavra2.length());
                                                    if (ch == 'f') estiloExcepcao.setTipoDeFonte(palavra2);
                                                    if (ch == 't') estiloExcepcao.setTamanhoDaFonte(palavra2);
                                                    if (ch == 'n') estiloExcepcao.setNegrito(palavra2);
                                                    if (ch == 'i') estiloExcepcao.setItalico(palavra2);
                                                    if (ch == 's') estiloExcepcao.setSublinhado(palavra2);
                                                    if (ch == 'c') estiloExcepcao.setCor(palavra2);
                                                }
                                            }
                                        }
                                        stackExcepcoes.push(estiloExcepcao);
                                        novaExcepcao = true;
                                        if (novoFDE)
                                            backStyle.append(estilo.estiloAsString(estilo));
                                    }
                                    else {
                                        if (matcher2.group().equals("[/]")) {
                                            stackExcepcoes.pop();
                                            if (!novaExcepcao)
                                                backStyle.append("[/]");
                                        }
                                        else {
                                            createPalavra(pattern4.matcher(matcher2.group()), stackExcepcoes, estilo, backStyle);
                                            novoFDE = novaExcepcao = false;
                                        }
                                    }
                                }
                                else {
                                    createPalavra(pattern4.matcher(matcher2.group()), stackExcepcoes, estilo, backStyle);
                                    novoFDE = novaExcepcao = false;
                                }
                            }
                        }
                    }
                }
                texto.inserir(new PalavraTexto("\r", estilo));
                barraNIndexado.inserirReferencia(texto.noFinal);
                texto.inserir(new PalavraTexto("\n", estilo));
                barraNIndexado.inserirReferencia(texto.noFinal);
            } while ((linha = br.readLine()) != null);
            corrigirErros();
            escreverTexto();
        }
        catch (EmptyStackException ex) {
            throw new FormatacaoException("Erro nas excepções!");
        }
        catch (IllegalStateException ex) {
            throw new DocumentoException("Erro ao carregar o documento!");
        }
        catch (NullPointerException ex) {
            throw new DocumentoException("Erro ao carregar o documento: o documento não pode começar sem um estilo!");
        }
    }

    private void createPalavra(Matcher matcher, StackArray stackExcepcoes, Estilo estilo, StringBuffer backStyle) {
        String palavra;
        PalavraTexto palavraTexto;
        PalavraIndex palavraIndex;

        while (matcher.find()) {
            palavra = matcher.group();
            if (stackExcepcoes.isEmpty())
                texto.inserir(palavraTexto = new PalavraTexto(palavra, estilo));
            else
                texto.inserir(palavraTexto = new PalavraTexto(palavra, (Estilo) stackExcepcoes.top()));

            if (backStyle.length() > 0) {
                palavraTexto.setEstilo((Estilo)palavraTexto.getEstilo().clone());
                palavraTexto.getEstilo().setCloseOutput(backStyle.toString());
                backStyle.delete(0, backStyle.length());
            }

            if ((palavraIndex = (PalavraIndex) index.consultar(palavra.toLowerCase())) == null)
                index.inserir(palavra.toLowerCase(), palavraIndex = new PalavraIndex());
            palavraIndex.inserirReferencia(texto.noFinal);
        }
    }

    public void gravarDocumento(File ficheiro) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(ficheiro));

            int k;
            PalavraTexto palavra;
            Estilo estiloAnterior;
            String backStyle;
            Matcher matcher;
            Pattern pattern = Pattern.compile(("([/])+"));
            StackArray stack = new StackArray(50);
            StringBuffer sb = new StringBuffer(texto.numElementos());

            Iterador it = texto.iteradorLista();
            if (it.podeAvancar()){
                palavra = (PalavraTexto) it.avancar();

                if (!(estiloAnterior = palavra.getEstilo()).getCloseOutput().equals(""))
                    stack.push(estiloAnterior = (Estilo) fde.consultar(estiloAnterior.getCloseOutput().toLowerCase().substring(1, estiloAnterior.getCloseOutput().length() - 1)));
                stack.push(palavra.getEstilo());
                sb.append(palavra.getEstilo().getCloseOutput()).append(palavra.getEstilo().estiloAsString(estiloAnterior)).append(palavra.getPalavra());
                estiloAnterior = palavra.getEstilo();

                while (it.podeAvancar()) {
                    if (!estiloAnterior.isSameStyleThan((palavra = (PalavraTexto)it.avancar()).getEstilo())) {
                        backStyle = palavra.getEstilo().getCloseOutput();
                        if (backStyle.startsWith("[") && backStyle.endsWith("]")) {
                            matcher = pattern.matcher(backStyle);
                            for (k = 0; matcher.find(); k++);
                            for (int i = 0; i < k; i++)
                                stack.pop();
                            sb.append(backStyle);
                        }

                        if (!((Estilo) stack.top()).isSameStyleThan(palavra.getEstilo())) {
                            stack.push(palavra.getEstilo());
                            sb.append(palavra.getEstilo().estiloAsString(estiloAnterior));
                        }
                        estiloAnterior = palavra.getEstilo();
                    }
                    sb.append(palavra.getPalavra());
                }
            }
            bw.write(sb.toString());
            bw.flush();
        }
        catch (IOException ex) {}
        finally {
            try {
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {}
        }
    }

    public void gravarDocumento() {
        gravarDocumento(ficheiro);
    }

    private void limparTodoTexto() {
        texto.removerTodos();
        index.removerTodos();
        fireRemoveAllText(null);
    }

    private void escreverTexto() throws FormatacaoException {
        StringBuffer sb;
        PalavraTexto palavraTexto;
        Estilo estilo = null;
        Iterador it = texto.iteradorLista();

        fireRemoveAllText(null);

        if (it.podeAvancar())
            it.avancar();
        while (it.podeAvancar()) {
            sb = new StringBuffer(512);
            palavraTexto = (PalavraTexto) it.corrente();
            estilo = palavraTexto.getEstilo();
            sb.append(palavraTexto.getPalavra());
            while (it.podeAvancar() && estilo == ((PalavraTexto) it.avancar()).getEstilo() && palavraTexto.isWrongWord() == ((PalavraTexto) it.corrente()).isWrongWord())
                sb.append(((PalavraTexto) it.corrente()).getPalavra());
            fireWriteText(new TextoEvent(this, sb.toString(), estilo, palavraTexto.isWrongWord()));
        }
    }

    private NoListaDuplaCircularBaseFim checkConjuntoContiguoPalavras(String[] s, NoListaDuplaCircularBaseFim no) {
        for (int i = 1; i < s.length; i++) {
            if (!(((PalavraTexto) no.seguinte.elemento).getPalavra().toLowerCase().matches("\\s") ||
                  ((PalavraTexto) no.seguinte.elemento).getPalavra().toLowerCase().equals(s[i])))
                return null;
            no = no.seguinte;
        }
        return no;
    }

    public void substituirTodasPalavras(String palavraAntiga, String novaPalavra) throws FormatacaoException, SubstituicaoException {
        try {
            if (!(palavraAntiga.equals("") || novaPalavra.equals(""))) {
                NoListaDuplaCircularBaseFim noAux = null;
                ListaDuplaCircularBaseFim listaAux;
                ListaSimplesCircularBaseFim listaDeOcorrencias = new ListaSimplesCircularBaseFim();
                Pattern pattern = Pattern.compile("\\d+|[\\u0041-\\u005A\\u0061-\\u007A\\u00AA\\u00BA\\u00C0-\\u00D6\\u00D8-\\u00F6\\u00F8-\\u01F5\\u01FA-\\u0217\\u0250-\\u02A8\\u1E00-\\u1E9B\\u1EA0-\\u1EF9\\uFB01\\uFB02]+|\\W");
                Matcher matcher;
                PalavraTexto palavraTexto;
                PalavraIndex palavraIndex;
                Iterador it;
                int i = 0;
                String[] palavrasAntigas;
                ParDeNos parCorrente;

                matcher = pattern.matcher(palavraAntiga);
                while (matcher.find())
                    i++;
                palavrasAntigas = new String[i];
                matcher.reset();
                i = 0;
                while (matcher.find())
                    palavrasAntigas[i++] = matcher.group().toLowerCase();

                it = ((PalavraIndex) index.consultar(palavrasAntigas[0])).getIteradorReferencias();
                while (it.podeAvancar())
                    if ((noAux = checkConjuntoContiguoPalavras(palavrasAntigas, (NoListaDuplaCircularBaseFim) it.avancar())) != null)
                        listaDeOcorrencias.inserir(new ParDeNos((NoListaDuplaCircularBaseFim) it.corrente(), noAux));

                for (i = 0; i < palavrasAntigas.length; i++)
                    index.remover(palavrasAntigas[i]);

                matcher = pattern.matcher(novaPalavra);
                it = listaDeOcorrencias.iteradorLista();
                while (it.podeAvancar()) {
                    parCorrente = (ParDeNos) it.avancar();
                    palavraTexto = (PalavraTexto) parCorrente.noInicial.elemento;
                    listaAux = new ListaDuplaCircularBaseFim();
                    while (matcher.find()) {
                        if (dicionario != null && !dicionario.palavraExiste(matcher.group()) && !matcher.group().toLowerCase().matches("\\d+|\\W+"))
                            listaAux.inserir(new PalavraTexto(matcher.group(), palavraTexto.getEstilo(), true));
                        else
                            listaAux.inserir(new PalavraTexto(matcher.group(), palavraTexto.getEstilo()));

                        if ((palavraIndex = (PalavraIndex) index.consultar(matcher.group().toLowerCase())) == null)
                            index.inserir(matcher.group().toLowerCase(), palavraIndex = new PalavraIndex());
                        palavraIndex.inserirReferencia(listaAux.noFinal);

                    }
                    listaAux.noInicial.seguinte.anterior = parCorrente.noInicial.anterior;
                    parCorrente.noInicial.anterior.seguinte = listaAux.noInicial.seguinte;
                    listaAux.noFinal.seguinte = parCorrente.noFinal.seguinte;
                    parCorrente.noFinal.seguinte.anterior = listaAux.noFinal;
                }
                escreverTexto();
            }
        }
        catch (NullPointerException ex) {
            throw new SubstituicaoException("Palavra(s) não encontrada(s)");
        }
    }

    private void corrigirErros() {
        if (dicionario != null) {
            boolean wrongWord;
            String palavra;
            Iterador itRefPalavrasTexto;
            Iterador iteradorChaves = index.iteradorChaves();

            while (iteradorChaves.podeAvancar()) {
                wrongWord = true;
                palavra = (String) iteradorChaves.avancar();
                itRefPalavrasTexto = ((PalavraIndex) index.consultar(palavra)).getIteradorReferencias();
                if (dicionario.palavraExiste(palavra) || palavra.matches("\\d+|\\W+"))
                    wrongWord = false;
                while (itRefPalavrasTexto.podeAvancar())
                    ((PalavraTexto) ((NoListaDuplaCircularBaseFim) itRefPalavrasTexto.avancar()).elemento).setWrongWord(wrongWord);
            }
        }
    }

    public boolean isSelectedWordWrong(String palavra) {
        PalavraIndex palavraIndex;
        if ((palavraIndex = (PalavraIndex)index.consultar(palavra.toLowerCase())) != null) {
            Iterador it = palavraIndex.getIteradorReferencias();
            if (it.podeAvancar())
                return ((PalavraTexto) ((NoListaDuplaCircularBaseFim) it.avancar()).elemento).isWrongWord();
        }
        return false;
    }

    public void dicionarioLoadFinished(DicionarioEvent event) {
        dicionario = (Dicionario)event.getSource();
        try {
            corrigirErros();
            escreverTexto();
        }
        catch (FormatacaoException ex) {}
    }

    public void dicionarioLoading(DicionarioEvent event) {
    }

    public void dicionarioStartLoading(DicionarioEvent event) {
    }



    private transient Vector textoListeners;

    public synchronized void addTextoListener(TextoListener l) {
        Vector v = textoListeners == null ? new Vector(2) :
            (Vector) textoListeners.clone();
        if (!v.contains(l)) {
            v.addElement(l);
            textoListeners = v;
        }
    }

    public synchronized void removeTextoListener(TextoListener l) {
        if (textoListeners != null && textoListeners.contains(l)) {
            Vector v = (Vector) textoListeners.clone();
            v.removeElement(l);
            textoListeners = v;
        }
    }

    protected void fireWriteText(TextoEvent event) {
        if (textoListeners != null) {
            Vector listeners = textoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((TextoListener) listeners.elementAt(i)).writeText(event);
            }
        }
    }

    protected void fireRemoveAllText(TextoEvent event) {
        if (textoListeners != null) {
            Vector listeners = textoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ((TextoListener) listeners.elementAt(i)).removeAllText(event);
            }
        }
    }

    private class ParDeNos {

        private NoListaDuplaCircularBaseFim noInicial;
        private NoListaDuplaCircularBaseFim noFinal;

        private ParDeNos(NoListaDuplaCircularBaseFim noInicial, NoListaDuplaCircularBaseFim noFinal) {
            this.noInicial = noInicial;
            this.noFinal = noFinal;
        }
    }
}
