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
public interface PessoaListener extends EventListener {
    void nomeChanged(PessoaEvent event);
    void sexoChanged(PessoaEvent event);
    void fotoChanged(PessoaEvent event);
    void dataNascChanged(PessoaEvent event);
    void dataObitoChanged(PessoaEvent event);
    void relacionamentoAscendenteRemoved(PessoaEvent event);
}
