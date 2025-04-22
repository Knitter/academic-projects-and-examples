package genx.utils;

import java.net.*;
import java.util.*;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Title: ImageLoader</p>
 * <p>Description: Apenas � possivel criar um objecto deste tipo.</p>
 * <p>Esse objecto ser� respons�vel pela cria��o de imagens.
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ImageLoader {

  /**
   * Hashtable que conter� todas as imagens lidas do disco.
   */
  private Hashtable imagens;

  /**
   * �nico objecto do tipo ImageLoader que � criado (Reparem que � criado dentro da classe).
   */
  private static final ImageLoader loader=new ImageLoader();

  /**
   * Construtor privado de modo a que ningu�m possa criar objectos deste tipo.
   */
  private ImageLoader() {
    imagens=new Hashtable();
  }

  /**
   * M�todo que cria uma imagem a partir do nome do ficheiro em que est� armazenada.
   * @param nome String: nome da imagem
   * @return Image: devolve a imagem criada
   */
  public Image getImage(String nome) {
//System.out.println("Nome da Imagem: " + nome);
    if (nome.equals(""))
      return null;
    Image img=(Image)imagens.get(nome);
    if (img!=null)
      return img;

    Toolkit t = Toolkit.getDefaultToolkit();
    Class cl = this.getClass();
    MediaTracker media = new MediaTracker(new Component() {});
    try {
      URL url=null;
      // 1� Tentar obter a partir de endere�o relativo
      url=cl.getResource(nome);
      if (url==null) // Se n�o encontrar o ficheiro, tenta com endere�o absoluto
          url=new URL("file:///"+nome);
      img = t.createImage(url);
      if (img == null)
        throw new Throwable("Bitmap n�o encontrado: " + nome);
      media.addImage(img, 0);
      imagens.put(nome, img);
       media.waitForID(0);
      if (media.isErrorAny())
        throw new Exception("Media ERROR");
    }
    catch (Throwable e) {
      System.err.println("Bitmap n�o encontrado: " + nome);
      throw new RuntimeException(e.toString());
    }

    return img;
  }


  /**
   * M�todo que cria um �cone a partir do nome do ficheiro em que est� armazenada a imagem correspondente.
   * @param nome String: nome da imagem
   * @return Image: devolve o �cone criado
   */
  public ImageIcon getIcon(String nome) {
    Image img=(Image)getImage(nome);
    if (img!=null)
      return new ImageIcon(img);
    return null;
  }

  /**
   * M�todo que cria um �cone a partir do nome do ficheiro em que est� armazenada a imagem correspondente.
   * @param nome String: nome da imagem
   * @return Image: devolve o �cone criado
   */
  public ImageIcon getScaledIcon(String nome, int width, int height) {
    if (imagens.get(nome + width + ":" + height)!= null)
      return new ImageIcon((Image)imagens.get(nome + width + ":" + height));

    Image img=(Image)getImage(nome);
    if (img!=null){
      img = img.getScaledInstance(width, height,
                                                 Image.SCALE_SMOOTH);
      imagens.put(nome + width + ":" + height, img);
      return new ImageIcon(img);
    }
    return null;
  }

  /**
   * Devolve o �nico objecto deste tipo que foi criado.
   * @return ImageLoader
   */
  public static ImageLoader getLoader() {
    return loader;
  }


}
