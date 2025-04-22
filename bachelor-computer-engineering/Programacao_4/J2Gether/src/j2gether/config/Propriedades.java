package j2gether.config;

import java.util.ResourceBundle;

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
public class Propriedades {

    // Main GUI
    public static String EXIT_DLG_MESSAGE = "Deseja mesmo sair?";
    public static String LABEL_ACTUAL_SCORE = "Pontuação total:";
    public static String LABEL_PLAY_SCORE = "Pontuação jogada actual:";
    public static String WIN_MESSAGE = "Parabéns! Limpou o tabuleiro!\n\nPONTUAÇÃO FINAL: ";
    public static String LOSE_MESSAGE = "Game over man!\n\nPONTUAÇÃO FINAL: ";
    public static String INVALID_MOVE_MESSAGE = "Jogada inválida!";
    public static String BUTTON_OK = "OK";
    public static String BUTTON_CANCEL = "Cancelar";
    public static String MODE = "Modo";

    // Scores GUI
    public static String SCORES_WINDOW_TITLE = "Pontuações";
    public static String INSERT_NAME_MESSAGE = "Insira o nome";
    public static String BUTTON_CLEAR = "Limpar";
    public static String SCORES_NO_NAME = "<sem nome>";

    // Custom GUI
    public static String CUSTOM_WINDOW_TITLE = "Personalizar";
    public static String CUSTOM_HEIGHT = "Altura";
    public static String CUSTOM_WIDTH = "Largura";

    // About GUI
    public static String ABOUT_COMMENT = "Primeiro Trabalho Prático P4";

    // Menu
    public static String FILE = "Ficheiro";
    public static String OPTION = "Opções";
    public static String HELP = "Ajuda";
    public static String NEW_GAME = "Novo Jogo";
    public static String LOAD = "Abrir";
    public static String SAVE = "Guardar";
    public static String SCORES = "Pontuaçõo";
    public static String EXIT = "Sair";
    public static String DIMENSION = "Dimensão";
    public static String COLORS = "Cores";
    public static String ALGORITHM = "Algoritmo";
    public static String AUDIO = "Audio";
    public static String EASY = "Fácil";
    public static String NORMAL = "Normal";
    public static String EXPERT = "Experiente";
    public static String COSTUM = "Personalizado";
    public static String COLORS_3 = "3 Cores";
    public static String COLORS_4 = "4 Cores";
    public static String COLORS_5 = "5 Cores";
    public static String RECURSIVE = "Recursivo";
    public static String ITERATIVE = "Iterativo";
    public static String SOUNDS = "Sons";
    public static String MUSIC = "Música";
    public static String RULES = "Regras";
    public static String ABOUT = "Sobre";

    //Regras
    public static String RULES_WINDOW_TITLE = "Regras J2Gether";
    public static String RULES_TEXT = "\nClique numa bola para seleccionar.\nClique novamente para remover as bolas.\nSó é possivel eliminar conjuntos de peças da mesma cor.\nO jogo acaba quando não existirem mais jogadas\nválidas ou quando o tabuleiro estiver vazio.\n";

    static {
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("j2gether.config.I18N");
        } catch (Exception ex) {
        }

        try {
            MODE = bundle.getString("MODE");
        } catch (Exception ex) {
        }
        try {
            FILE = bundle.getString("FILE");
        } catch (Exception ex) {
        }
        try {
            OPTION = bundle.getString("OPTION");
        } catch (Exception ex) {
        }
        try {
            HELP = bundle.getString("HELP");
        } catch (Exception ex) {
        }
        try {
            NEW_GAME = bundle.getString("NEW_GAME");
        } catch (Exception ex) {
        }
        try {
            SCORES = bundle.getString("SCORES");
        } catch (Exception ex) {
        }
        try {
            SAVE = bundle.getString("SAVE");
        } catch (Exception ex) {
        }
        try {
            LOAD = bundle.getString("LOAD");
        } catch (Exception ex) {
        }
        try {
            EXIT = bundle.getString("EXIT");
        } catch (Exception ex) {
        }
        try {
            DIMENSION = bundle.getString("DIMENSION");
        } catch (Exception ex) {
        }
        try {
            COLORS = bundle.getString("COLORS");
        } catch (Exception ex) {
        }
        try {
            ALGORITHM = bundle.getString("ALGORITHM");
        } catch (Exception ex) {
        }
        try {
            AUDIO = bundle.getString("AUDIO");
        } catch (Exception ex) {
        }
        try {
            EASY = bundle.getString("EASY");
        } catch (Exception ex) {
        }
        try {
            NORMAL = bundle.getString("NORMAL");
        } catch (Exception ex) {
        }
        try {
            EXPERT = bundle.getString("EXPERT");
        } catch (Exception ex) {
        }
        try {
            COSTUM = bundle.getString("COSTUM");
        } catch (Exception ex) {
        }
        try {
            COLORS_3 = bundle.getString("COLORS_3");
        } catch (Exception ex) {
        }
        try {
            COLORS_4 = bundle.getString("COLORS_4");
        } catch (Exception ex) {
        }
        try {
            COLORS_5 = bundle.getString("COLORS_5");
        } catch (Exception ex) {
        }
        try {
            RECURSIVE = bundle.getString("RECURSIVE");
        } catch (Exception ex) {
        }
        try {
            ITERATIVE = bundle.getString("ITERATIVE");
        } catch (Exception ex) {
        }
        try {
            SOUNDS = bundle.getString("SOUNDS");
        } catch (Exception ex) {
        }
        try {
            MUSIC = bundle.getString("MUSIC");
        } catch (Exception ex) {
        }
        try {
            RULES = bundle.getString("RULES");
        } catch (Exception ex) {
        }
        try {
            ABOUT = bundle.getString("ABOUT");
        } catch (Exception ex) {
        }
        try {
            WIN_MESSAGE = bundle.getString("WIN_MESSAGE");
        } catch (Exception ex) {
        }
        try {
            LOSE_MESSAGE = bundle.getString("LOSE_MESSAGE");
        } catch (Exception ex) {
        }
        try {
            INVALID_MOVE_MESSAGE = bundle.getString("INVALID_MOVE_MESSAGE");
        } catch (Exception ex) {
        }
        try {
            SCORES_WINDOW_TITLE = bundle.getString("SCORES_WINDOW_TITLE");
        } catch (Exception ex) {
        }
        try {
            INSERT_NAME_MESSAGE = bundle.getString("INSERT_NAME_MESSAGE");
        } catch (Exception ex) {
        }
        try {
            CUSTOM_WINDOW_TITLE = bundle.getString("CUSTOM_WINDOW_TITLE");
        } catch (Exception ex) {
        }
        try {
            CUSTOM_HEIGHT = bundle.getString("CUSTOM_HEIGHT");
        } catch (Exception ex) {
        }
        try {
            CUSTOM_WIDTH = bundle.getString("CUSTOM_WIDTH");
        } catch (Exception ex) {
        }
        try {
            ABOUT_COMMENT = bundle.getString("ABOUT_COMMENT");
        } catch (Exception ex) {
        }
        try {
            BUTTON_OK = bundle.getString("BUTTON_OK");
        } catch (Exception ex) {
        }
        try {
            BUTTON_CANCEL = bundle.getString("BUTTON_CANCEL");
        } catch (Exception ex) {
        }
        try {
            EXIT_DLG_MESSAGE = bundle.getString("EXIT_DLG_MESSAGE");
        } catch (Exception ex) {
        }
        try {
            LABEL_ACTUAL_SCORE = bundle.getString("LABEL_ACTUAL_SCORE");
        } catch (Exception ex) {
        }
        try {
            LABEL_PLAY_SCORE = bundle.getString("LABEL_PLAY_SCORE");
        } catch (Exception ex) {
        }
        try {
            BUTTON_CLEAR = bundle.getString("BUTTON_CLEAR");
        } catch (Exception ex) {
        }
        try {
            RULES_WINDOW_TITLE = bundle.getString("RULES_WINDOW_TITLE");
        } catch (Exception ex) {
        }
        try {
            RULES_TEXT = bundle.getString("RULES_TEXT");
        } catch (Exception ex) {
        }

    }
}
