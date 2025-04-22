package j2gether.audio;

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
public class MusicLoader extends SoundLoader {
    public MusicLoader(SoundList soundList, URL baseURL, String relativeURL) {
        super(soundList, baseURL, relativeURL);
    }

    public void run() {
        super.run();
        getAudioClip().loop();
    }

}
