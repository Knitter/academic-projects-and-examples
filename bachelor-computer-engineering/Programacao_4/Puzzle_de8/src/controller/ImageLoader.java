package controller;

import java.util.Hashtable;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.MediaTracker;
import java.awt.Component;

/**
 * <p>Title: ImageLoader</p>
 * <p>Description: Apenas é possivel criar um objecto deste tipo.</p>
 * <p>Esse objecto será responsável pela criação de imagens.
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ImageLoader {

  /**
   * Hashtable que conterá todas as imagens lidas do disco.
   */
  private Hashtable imagens;

  /**
   * Único objecto do tipo ImageLoader que é criado (Reparem que é criado dentro da classe).
   */
  private static final ImageLoader loader=new ImageLoader();

  /**
   * Construtor privado de modo a que ninguém possa criar objectos deste tipo.
   */
  private ImageLoader() {
    imagens=new Hashtable();
  }

  /**
   * Método que cria uma imagem a partir do nome do ficheiro em que está armazenada.
   * @param nome String: nome da imagem
   * @return Image: devolve a imagem criada
   */
  public Image getImage(String nome) {
    if (nome.equals(""))
      return null;
    Image img=(Image)imagens.get(nome);
    if (img!=null)
      return img;

    Toolkit t = Toolkit.getDefaultToolkit();
    Class cl = this.getClass();
    MediaTracker media = new MediaTracker(new Component() {});
    try {
      img = t.createImage(cl.getResource("/config/imagens/"+nome));
      if (img == null)
        throw new Throwable("Bitmap não encontrado: " + nome);
      media.addImage(img, 0);
      imagens.put(nome, img);
      media.waitForID(0);
      if (media.isErrorAny())
        throw new Exception("Media ERROR");
    }
    catch (Throwable e) {
      System.err.println("Bitmap não encontrado: " + nome);
      throw new RuntimeException(e.toString());
    }

    return img;
  }


  /**
   * Método que cria um ícone a partir do nome do ficheiro em que está armazenada a imagem correspondente.
   * @param nome String: nome da imagem
   * @return Image: devolve o ícone criado
   */
  public ImageIcon getIcon(String nome) {
    Image img=(Image)getImage(nome);
    if (img!=null)
      return new ImageIcon(img);
    return null;
  }

  /**
   * Devolve o único objecto deste tipo que foi criado.
   * @return ImageLoader
   */
  public static ImageLoader getLoader() {
    return loader;
  }

}
