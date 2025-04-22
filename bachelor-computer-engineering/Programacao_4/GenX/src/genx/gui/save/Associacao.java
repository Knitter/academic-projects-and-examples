package genx.gui.save;

import java.io.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Associacao implements Serializable {
    private Object begin;
    private Object end;

    public Associacao(Object begin, Object end) {
        this.begin = begin;
        this.end = end;
    }

    public Object getEnd() {
        return end;
    }

    public Object getBegin() {
        return begin;
    }
}
