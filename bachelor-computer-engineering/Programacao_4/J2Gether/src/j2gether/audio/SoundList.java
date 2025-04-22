package j2gether.audio;

import java.applet.AudioClip;
import java.net.URL;
import java.util.Hashtable;
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
class SoundList extends java.util.Hashtable {
    private URL baseURL;

    public SoundList(URL baseURL) {
        super();
        this.baseURL = baseURL;
    }

    public void startLoading(String relativeURL) {
        new SoundLoader(this, baseURL, relativeURL);
    }

    public void loadMusic(String relativeURL) {
        new MusicLoader(this, baseURL, relativeURL);
    }

    public AudioClip getClip(String relativeURL) {
        return (AudioClip)get(relativeURL);
    }

    public void putClip(AudioClip clip, String relativeURL) {
        put(relativeURL, clip);
    }
}
