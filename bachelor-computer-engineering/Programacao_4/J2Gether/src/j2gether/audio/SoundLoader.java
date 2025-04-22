package j2gether.audio;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

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
class SoundLoader extends Thread {
    private SoundList soundList;
    private URL completeURL;
    private String relativeURL;
    private AudioClip audioClip;

    public SoundLoader(SoundList soundList, URL baseURL, String relativeURL) {
        this.soundList = soundList;
        try {
            completeURL = new URL(baseURL, relativeURL);
        } catch (MalformedURLException ex){
            System.err.println(ex.getMessage());
        }
        this.relativeURL = relativeURL;
        setPriority(MIN_PRIORITY);
        if (completeURL != null)
            start();
    }

    public void run() {
        audioClip = Applet.newAudioClip(completeURL);
        soundList.putClip(audioClip, relativeURL);
    }

    public AudioClip getAudioClip() {
        return audioClip;
    }
}
