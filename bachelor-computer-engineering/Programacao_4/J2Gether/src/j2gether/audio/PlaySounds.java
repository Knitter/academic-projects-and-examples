package j2gether.audio;

import java.net.URL;

/**
 *
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class PlaySounds {

    private SoundList soundList;
    private URL pathBase;

    public PlaySounds(String pathBase) {
        Class c = this.getClass();
        this.pathBase = c.getResource(pathBase);
    }

    /**
     * Carrega para a lista o ficheiro de som especificado
     *
     * @param som nome do ficheiro a caregar
     */
    public void loadSound(String som) {
        if (pathBase != null) {
            if (soundList == null)
                soundList = new SoundList(pathBase);
            soundList.startLoading(som);
        }
    }

    /**
     * Carrega para a lista o ficheiro de música especificado
     *
     * @param som nome do ficheiro de música a carregar
     */
    public void loadMusic(String som) {
        if (pathBase != null) {
            if (soundList == null)
                soundList = new SoundList(pathBase);
            soundList.loadMusic(som);
        }
    }

    /**
     * Inicia o toque de um ficheiro de som
     *
     * @param som nome do ficheiro a tocar
     */
    public void play(String som) {
        try {
            soundList.getClip(som).play();
        } catch (Exception ex) {
        }
    }

    /**
     * Termina o toque de um ficheiro de som
     *
     * @param som nome do ficheiro a terminar
     */
    public void stop(String som) {
        try {
            soundList.getClip(som).stop();
        } catch (Exception ex) {
        }
    }


    /**
     * Inicia o toque de um ficheiro de som em ciclo
     *
     * @param som nome do ficheiro a tocar
     */
    public void loop(String som) {
        try {
            soundList.getClip(som).loop();
        } catch (Exception ex) {
        }
    }

}
