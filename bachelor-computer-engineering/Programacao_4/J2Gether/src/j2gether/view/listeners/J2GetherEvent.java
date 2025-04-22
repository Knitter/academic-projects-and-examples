package j2gether.view.listeners;

import j2gether.model.J2Gether;

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
public class J2GetherEvent {

    private J2Gether jogo;

    public J2GetherEvent(J2Gether jogo) {
        this.jogo = jogo;
    }

    public boolean perdeu() {
        return jogo.perdeu();
    }

    public boolean ganhou() {
        return jogo.ganhou();
    }

    public boolean isInvalida() {
        return jogo.isInvalida();
    }

    public boolean isDroped() {
        return jogo.isDroped();
    }

    public boolean hasPecasSelected() {
        return jogo.hasPecasSelected();
    }

}
