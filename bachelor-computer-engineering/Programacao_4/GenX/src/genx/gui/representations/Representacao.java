package genx.gui.representations;

import java.util.*;

import componenteGeneologia.*;
import genx.gui.eventos.*;
import genx.gui.save.*;
import genx.modelo.*;

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
public abstract class Representacao extends Componente {

    private ArvoreGeneologica arvore;

    public Representacao(Object owner, ArvoreGeneologica arvore) {
        setOwner(owner);
        this.arvore = arvore;
    }

    public ArvoreGeneologica getArvore() {
        return arvore;
    }

    public abstract void remover();
    public abstract SaveRepresentacaoPessoa saveRepresentacaoPessoa();
    public abstract SaveRepresentacaoRelacionamento saveRepresentacaoRelacionamento();



///////// Fire Events //////////////////////////////////////////////////////////

    transient Vector representacaoListeners;

    public synchronized void addRepresentacaoListener(RepresentacaoListener l) {
        Vector v = representacaoListeners != null ?
            (Vector) representacaoListeners.clone() : new Vector(2);
        if (!v.contains(l))
            v.add(l);
        representacaoListeners = v;
    }

    public synchronized void removeRepresentacaoListener(RepresentacaoListener l) {
        Vector v = representacaoListeners != null ?
            (Vector) representacaoListeners.clone() : new Vector(2);
        if (v.contains(l))
            v.remove(l);
        representacaoListeners = v;
    }

    protected void fireDataChanged(RepresentacaoEvent event) {
        if (representacaoListeners != null) {
            Vector listeners = representacaoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RepresentacaoListener) listeners.elementAt(i)).dataChanged(event);
            }
        }
    }

    protected void firePessoaSelected(RepresentacaoEvent event) {
        if (representacaoListeners != null) {
            Vector listeners = representacaoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RepresentacaoListener) listeners.elementAt(i)).pessoaSelected(event);
            }
        }
    }

    protected void fireRelacionamentoSelected(RepresentacaoEvent event) {
        if (representacaoListeners != null) {
            Vector listeners = representacaoListeners;
            int count = listeners.size();
            for (int i = 0; i < count; i++) {
                ( (RepresentacaoListener) listeners.elementAt(i)).relacionamentoSelected(event);
            }
        }
    }

}
