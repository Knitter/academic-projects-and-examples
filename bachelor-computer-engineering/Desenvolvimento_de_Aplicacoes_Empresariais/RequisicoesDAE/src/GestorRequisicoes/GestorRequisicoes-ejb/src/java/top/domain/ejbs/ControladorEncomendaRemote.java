/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import javax.ejb.Remote;

/**
 *
 * @author offhegoes
 */
@Remote
public interface ControladorEncomendaRemote {

    public boolean criarEncomenda(top.domain.entities.Requisicao requisicao, java.util.List linhasDeEncomenda);

    public boolean apagarEncomenda(top.domain.entities.Encomenda encomenda);

    public void submeterEncomenda(java.lang.Long id);

    public void receberEncomenda(java.lang.Long id);
    
}
