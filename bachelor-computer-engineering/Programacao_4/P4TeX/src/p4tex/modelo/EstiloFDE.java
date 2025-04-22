package p4tex.modelo;

/**
 * <p>Title: P4TeX</p>
 * <p>Description: 3º Trabalho Prático de P4</p>
 * <p>Copyright: Copyright (c) 4thFloor 2005</p>
 * <p>Company: 4thFloor</p>
 * @author Ruben Pedro, Sérgio Lopes
 * @version 1.0
 */
public class EstiloFDE extends Estilo implements Cloneable {

    private String nomeDoEstilo;

    public EstiloFDE(String nome, String tipoDeFonte, String tamanhoDaFonte, String negrito, String italico, String sublinhado, String cor) throws FormatacaoException{
        super(tipoDeFonte, tamanhoDaFonte, negrito, italico, sublinhado, cor);
        nomeDoEstilo = nome;
    }

    public void setNomeDoEstilo(String nomeDoEstilo) {
        this.nomeDoEstilo = nomeDoEstilo;
    }

    public String getNomeDoEstilo() {
        return nomeDoEstilo;
    }

    public String estiloAsString(Estilo estiloAnterior) {
        return "<" + nomeDoEstilo + ">";
    }

    public boolean isSameStyleThan(Estilo teste) {
       return teste instanceof EstiloFDE && ((EstiloFDE)teste).nomeDoEstilo.equals(nomeDoEstilo);
    }

}
