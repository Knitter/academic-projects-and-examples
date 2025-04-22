package genx.modelo.eventos;

import java.util.*;

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
public interface RelacionamentoListener extends EventListener {
    void dataInicioChanged(RelacionamentoEvent event);
    void dataFimChanged(RelacionamentoEvent event);
    void filhoAdded(RelacionamentoEvent event);
    void filhoRemoved(RelacionamentoEvent event);
    void progenitorAdded(RelacionamentoEvent event);
    void progenitorRemoved(RelacionamentoEvent event);
    void progenitorChanged(RelacionamentoEvent event);
}
