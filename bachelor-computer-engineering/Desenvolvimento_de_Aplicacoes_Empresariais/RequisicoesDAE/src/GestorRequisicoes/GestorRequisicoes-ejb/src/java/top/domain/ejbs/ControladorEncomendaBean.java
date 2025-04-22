/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import top.domain.entities.Encomenda;
import top.domain.entities.Requisicao;
import top.domain.facades.EncomendaFacadeRemote;
import top.domain.facades.NotificacaoFacadeRemote;
import top.domain.utils.EstadoEncomenda;

/**
 *
 * @author offhegoes
 */
@Stateful
public class ControladorEncomendaBean implements ControladorEncomendaRemote {

    @EJB EncomendaFacadeRemote fc;
    //@EJB NotificacaoFacadeRemote enot;
    
    private LinkedList<Encomenda> encomendas = new LinkedList<Encomenda>();
    
    public boolean criarEncomenda(Requisicao requisicao, List linhasDeEncomenda) {
        //throw new UnsupportedOperationException("Not supported yet.");
        try{
            Encomenda nova = new Encomenda(requisicao, linhasDeEncomenda);
            encomendas.add(nova);
            nova.setEstado(EstadoEncomenda.ESTADO_PENDENTE);
            fc.create(nova);
        }
        catch(Exception ex){
            System.out.print("Caught this: "+ex.toString());
            return false;
        }
        return true;
    }
    
    public void submeterEncomenda(Long id) {
        Encomenda e = fc.find(id);
        if (e != null) {
            e.setEstado(EstadoEncomenda.ESTADO_SUBMETIDA);
            fc.edit(e);
        }
    }

    public void receberEncomenda(Long id) {
        Encomenda e = fc.find(id);
        if (e != null) {
            e.setEstado(EstadoEncomenda.ESTADO_RECEBIDA);
            fc.edit(e);
            //enot.encomendaRecebida(e);
        }
    }
    
    public boolean apagarEncomenda(Encomenda encomenda){
        try{
            fc.remove(encomenda);
        }catch(Exception ex){
            System.out.print("Caught this: "+ex.toString());
            return false;
        }
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
