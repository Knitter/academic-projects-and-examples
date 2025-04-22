package genx.gui.eventos;

import java.util.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplica��o que permite gerir �rvores geneal�gicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author S�rgio Lopes, Ruben Pedro
 * @version 1.0
 */
public interface RepresentacaoListener extends EventListener {
    void dataChanged(RepresentacaoEvent event);
    void pessoaSelected(RepresentacaoEvent event);
    void relacionamentoSelected(RepresentacaoEvent event);
}
