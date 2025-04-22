/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Requisicao;

/**
 *
 * @author offhegoes
 */
@Remote
public interface RequisicaoFacadeRemote {

    Requisicao create(Requisicao requisicao);

    void edit(Requisicao requisicao);

    void remove(Requisicao requisicao);

    Requisicao find(Object id);

    List<Requisicao> findAll();
    
    List<Requisicao> getRequisicoesPendentes();
    
    List<Requisicao> getRequisicoesPorServir();
    
    List<Requisicao> getMeusRascunhos(Long idColaborador);
    
    List<Requisicao> getTodasRequisicoesExceptoRascunhosOutrem(Long idColaborador);
    
    List<Requisicao> getProprias(Long idColaborador);
    
    

}
