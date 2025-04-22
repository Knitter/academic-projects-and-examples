package config;

import java.util.ResourceBundle;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public final class Languages {

  public static final String WINDOW_TITLE;
  public static final String MENU_FILE;
  public static final String MENU_PERSEVERANCE;
  public static final String MENU_CHANGE_PUZZLE_IMAGE;
  public static final String OPTION_ORIGINAL;
  public static final String OPTION_B3N;
  public static final String OPTION_X1C0;
  public static final String OPTION_IMAGE1;
  public static final String OPTION_IMAGE2;
  public static final String OPTION_IMAGE3;
  public static final String OPTION_MORE;
  public static final String OPTION_SAVE;
  public static final String OPTION_LOAD;
  public static final String OPTION_RULES;
  public static final String OPTION_ADD_IMAGES;
  public static final String OPTION_EXIT;
  public static final String OPTION_SCORE;
  public static final String LBL_LINE;
  public static final String LBL_COLUMN;
  public static final String LBL_MOVE;
  public static final String MENU_HELP;
  public static final String OPTION_ABOUT;
  public static final String OPTION_SCRAMBLE;
  public static final int WINDOW_WIDTH;
  public static final int WINDOW_HEIGHT;
  public static final int IMAGE_SIZE;
  public static final String RULES;
  public static final String HOW_TO;
  public static final String LBL_RULES;
  public static final String LBL_HOW_TO;
  public static final String TXT_INSERT;
  public static final String TXT_NUMBER_ERROR;


  static {
    ResourceBundle resource = ResourceBundle.getBundle("config/languages/language");
    WINDOW_TITLE = resource.getString("WINDOW_TITLE");
    MENU_FILE = resource.getString("MENU_FILE");
    MENU_PERSEVERANCE = resource.getString("MENU_PERSEVERANCE");
    MENU_CHANGE_PUZZLE_IMAGE = resource.getString("MENU_CHANGE_PUZZLE_IMAGE");
    OPTION_ORIGINAL = resource.getString("OPTION_ORIGINAL");
    OPTION_B3N = resource.getString("OPTION_B3N");
    OPTION_X1C0 = resource.getString("OPTION_X1C0");
    OPTION_IMAGE1 = resource.getString("OPTION_IMAGE1");
    OPTION_IMAGE2 = resource.getString("OPTION_IMAGE2");
    OPTION_IMAGE3 = resource.getString("OPTION_IMAGE3");
    OPTION_MORE = resource.getString("OPTION_MORE");
    OPTION_SAVE = resource.getString("OPTION_SAVE");
    OPTION_LOAD = resource.getString("OPTION_LOAD");
    OPTION_RULES = resource.getString("OPTION_RULES");
    OPTION_ADD_IMAGES = resource.getString("OPTION_ADD_IMAGES");
    OPTION_EXIT = resource.getString("OPTION_EXIT");
    OPTION_SCORE = resource.getString("OPTION_SCORE");
    LBL_LINE = resource.getString("LBL_LINE");
    LBL_COLUMN = resource.getString("LBL_COLUMN");
    LBL_MOVE = resource.getString("LBL_MOVE");
    MENU_HELP = resource.getString("MENU_HELP");
    OPTION_ABOUT = resource.getString("OPTION_ABOUT");
    OPTION_SCRAMBLE = resource.getString("OPTION_SCRAMBLE");
    WINDOW_WIDTH = Integer.parseInt(resource.getString("WINDOW_WIDTH"));
    WINDOW_HEIGHT = Integer.parseInt(resource.getString("WINDOW_HEIGHT"));
    IMAGE_SIZE = Integer.parseInt(resource.getString("IMAGE_SIZE"));
    LBL_RULES = resource.getString("LBL_RULES");
    LBL_HOW_TO = resource.getString("LBL_HOW_TO");
    RULES = resource.getString("RULES");
    HOW_TO = resource.getString("HOW_TO");
    TXT_INSERT = resource.getString("TXT_INSERT");
    TXT_NUMBER_ERROR = resource.getString("TXT_NUMBER_ERROR");
  }

  public Languages() {
  }

}
