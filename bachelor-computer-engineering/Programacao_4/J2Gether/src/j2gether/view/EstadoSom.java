package j2gether.view;

import j2gether.audio.PlaySounds;

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
public abstract class EstadoSom {

    private PlaySounds sounds;
    public static final String MUSIC_NAME = "shamlock.mid";
    public static final String SND_START = "start.wav";
    public static final String SND_FOOT = "pe.wav";
    public static final String SND_UNDO_REDO = "undoRedo.wav";
    public static final String SND_PLOP = "plop.wav";
    public static final String SND_DROP = "drop.wav";
    public static final String SND_WRONG = "errada.wav";
    public static final String SND_LOSE = "perdeu.wav";
    public static final String SND_WIN = "tada.wav";

    public EstadoSom(String baseName) {
        sounds = new PlaySounds(baseName);
        sounds.loadSound(SND_START);
        sounds.loadSound(SND_FOOT);
        sounds.loadSound(SND_UNDO_REDO);
        sounds.loadSound(SND_PLOP);
        sounds.loadSound(SND_DROP);
        sounds.loadSound(SND_WRONG);
        sounds.loadSound(SND_LOSE);
        sounds.loadSound(SND_WIN);
    }

    public abstract void play(String nome);
    public abstract void stop(String nome);
    public abstract void loop(String nome);

    public PlaySounds getSounds() {
        return sounds;
    }
}
