package j2gether.view;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class EstadoSomLigado extends EstadoSom {

    public EstadoSomLigado(String baseName) {
        super(baseName);
    }

    public void play(String nome) {
        getSounds().play(nome);
    }

    public void stop(String nome) {
        getSounds().stop(nome);
    }

    public void loop(String nome) {
        getSounds().loop(nome);
    }
}
