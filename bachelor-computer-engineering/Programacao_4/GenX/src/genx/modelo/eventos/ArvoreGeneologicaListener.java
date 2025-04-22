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
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public interface ArvoreGeneologicaListener extends EventListener {
    void pessoaAdded(ArvoreGeneologicaEvent event);
    void pessoaRemoved(ArvoreGeneologicaEvent event);
    void relacionamentoParentAdded(ArvoreGeneologicaEvent event);
    void relacionamentoChildAdded(ArvoreGeneologicaEvent event);
    void relacionamentoRemoved(ArvoreGeneologicaEvent event);
    void relacionamentoChanged(ArvoreGeneologicaEvent event);
}
