package furyPackage;

import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os objectos com representa��o gr�fica do jogo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class ObjectoDoNivel {

    private String nome;
    private Ponto posicao;
    private Nivel nivel;
    private Sprite sprite;

    public ObjectoDoNivel() {
    }

    /**
     * @param nome - Nome do objecto do n�vel
     * @param posicao - Posi��o do objecto no n�vel
     * @param nivel - N�vel ao qual pertence o objecto
     */
    public ObjectoDoNivel(String nome, Ponto posicao, Nivel nivel) {
        this.nome = nome;
        this.posicao = posicao;
        this.nivel = nivel;
    }

    public String toString() {
        return sprite.getNome();
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Nivel getNivel() {
        return nivel;
    }

    public Ponto getPosicao() {
        return posicao;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public String getNome() {
        return nome;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

}
