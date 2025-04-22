package genx.modelo.eventos;

import java.util.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class PessoaEvent extends EventObject {

    private String nomeAntigo;
    private String novoNome;
    private GregorianCalendar dataNascAntiga;
    private GregorianCalendar novaDataNasc;
    private GregorianCalendar dataObitoAntiga;
    private GregorianCalendar novaDataObito;
    private int sexoAnterior;
    private int novoSexo;
    private String fotografiaVelha;
    private String novaFotografia;

    public PessoaEvent(Object source, String nomeAntigo, String novoNome,
                       GregorianCalendar dataNascAntiga, GregorianCalendar novaDataNasc,
                       GregorianCalendar dataObitoAntiga, GregorianCalendar novaDataObito, int sexoAnterior, int novoSexo,
                       String fotografiaVelha, String novaFotografia) {
        super(source);
        this.nomeAntigo = nomeAntigo;
        this.novoNome = novoNome;
        this.dataNascAntiga = dataNascAntiga;
        this.novaDataNasc = novaDataNasc;
        this.dataObitoAntiga = dataObitoAntiga;
        this.novaDataObito = novaDataObito;
        this.sexoAnterior = sexoAnterior;
        this.novoSexo = novoSexo;
        this.fotografiaVelha = fotografiaVelha;
        this.novaFotografia = novaFotografia;
    }

    public String getNovoNome() {
        return novoNome;
    }

    public String getNomeAntigo() {
        return nomeAntigo;
    }

    public int getSexoAnterior() {
        return sexoAnterior;
    }

    public int getNovoSexo() {
        return novoSexo;
    }

    public String getNovaFotografia() {
        return novaFotografia;
    }

    public GregorianCalendar getNovaDataObito() {
        return novaDataObito;
    }

    public GregorianCalendar getNovaDataNasc() {
        return novaDataNasc;
    }

    public String getFotografiaVelha() {
        return fotografiaVelha;
    }

    public GregorianCalendar getDataObitoAntiga() {
        return dataObitoAntiga;
    }

    public GregorianCalendar getDataNascAntiga() {
        return dataNascAntiga;
    }
}
