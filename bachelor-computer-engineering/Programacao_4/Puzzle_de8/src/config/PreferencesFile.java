package config;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;
import java.io.File;
import java.util.StringTokenizer;
import java.net.URI;
import java.net.*;
import java.net.*;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public class PreferencesFile {

  /**
   * Nomes das imagens?!
   *
   * */
  public static String LBL_GRAVAR = "Gravar";
  public static String LBL_REPOR = "Repor";
  public static String LBL_PERSISENTENCIA = "Persistencia";
  public static String LBL_TITULO = "Puzzle";
  public static String LBL_REGRAS = "Regras";
  public static String LBL_SAIR = "Sair";
  public static String LBL_FICHEIRO = "Ficheiro";
  public static String LBL_LINHA = "Linha";
  public static String LBL_COLUNA = "Coluna";
  public static String LBL_MOVER = "Mover";
  public static String LBL_AJUDA = "Ajuda";
  public static String LBL_ABOUT = "Sobre";
  public static String LBL_BARALHAR = "Baralhar";
  public static int LAGURA_JANELA = 400;
  public static int ALTURA_JANELA = 500;
  public static int DIMENSAO_IMAGEM = 94;



  public PreferencesFile() {
    Hashtable tk = new Hashtable();

    try {
      Class cl = this.getClass();
      BufferedReader str = null;
      StringBuffer buffer = new StringBuffer();
      String string = new String();
      str = new BufferedReader(new FileReader(new File(new URI(cl.getResource("/config/config.txt").toString()))));
      while ( (string = str.readLine()) != null) {
        buffer.append(string + '\n');
      }
      StringTokenizer st = new StringTokenizer(buffer.toString(), "=\n");
      while (st.hasMoreTokens()) {
        tk.put(st.nextToken().trim().toLowerCase(), st.nextToken().trim());

        /**
         * Iniciação
         * */
        if (tk.get("about") != null) {
          LBL_ABOUT = (String) tk.get("about");
        }
        if (tk.get("help") != null) {
          LBL_AJUDA = (String) tk.get("help");
        }
        if (tk.get("save") != null) {
          LBL_GRAVAR = (String) tk.get("save");
        }
        if (tk.get("open") != null) {
          LBL_REPOR = (String) tk.get("open");
        }
        if (tk.get("perseverance") != null) {
          LBL_PERSISENTENCIA = (String) tk.get("perseverance");
        }
        if (tk.get("title") != null) {
          LBL_TITULO = (String) tk.get("title");
        }
        if (tk.get("rules") != null) {
          LBL_REGRAS = (String) tk.get("rules");
        }
        if (tk.get("exit") != null) {
          LBL_SAIR = (String) tk.get("exit");
        }
        if (tk.get("file") != null) {
          LBL_FICHEIRO = (String) tk.get("file");
        }
        if (tk.get("line") != null) {
          LBL_LINHA = (String) tk.get("line");
        }
        if (tk.get("column") != null) {
          LBL_COLUNA = (String) tk.get("column");
        }
        if (tk.get("move") != null) {
          LBL_MOVER = (String) tk.get("move");
        }
        if (tk.get("scramble") != null) {
          LBL_BARALHAR = (String) tk.get("scramble");
        }
        try {
          if (tk.get("width") != null) {
            LAGURA_JANELA = Integer.parseInt( (String) tk.get("width"));
          }
          if (tk.get("hight") != null) {
            ALTURA_JANELA = Integer.parseInt( (String) tk.get("hight"));
          }
          if (tk.get("picture_size") != null) {
            DIMENSAO_IMAGEM = Integer.parseInt( (String) tk.get("picture_size"));
          }
        }
        catch (NumberFormatException ex) {
          System.out.println(ex.getMessage() + " NumberFormatException");
        }
      }
    }
    catch (IOException ex) {
      System.out.println(ex.getMessage() + " IOException");
    }
    catch (URISyntaxException ex) {
      System.out.println(ex.getMessage() + " URISyntaxException");
    }
  }
}
