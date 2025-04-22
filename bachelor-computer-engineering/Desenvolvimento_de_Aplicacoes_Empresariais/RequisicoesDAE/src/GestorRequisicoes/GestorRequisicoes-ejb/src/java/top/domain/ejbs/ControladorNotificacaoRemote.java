/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import top.domain.entities.Notificacao;
import top.domain.entities.Requisicao;

/**
 *
 * @author Knitter and some other dudes...
 */
@Remote
public interface ControladorNotificacaoRemote {
    
    /**
     * Permite notificar o criador da requisicao e o aprovador de que o estado 
     * de que a requisicao deu origem a uma encomenda e que se encontra por 
     * satisfazer.
     * 
     * @param id ID da requisicao
     */
    @RolesAllowed("responsavel")
    void requisicaoEncomendada(Integer id);

    /**
     * Notifica o criador da requisicao e o aprovador de que a requisicao se 
     * encontra satisfeita e esta pronta a levantar.
     * 
     * @param id ID da requisicao
     */
    @RolesAllowed("responsavel")
    void requisicaoSatisfeita(Integer id);
    
    /**
     * Permite notificar o criador e aprovador da requisicao de que a mesma se 
     * encontra parcialmente satisfeita e que deu origem a uma encomenda.
     * 
     * @param id ID da requisicao
     */
    @RolesAllowed("responsavel")
    void requisicaoParcialmenteSatisfeita(Integer id);
    
    /**
     * Notifica o criador da requisicao de que esta foi aprovada.
     */
    @RolesAllowed("aprovador")
    void requisicaoAprovada(Integer id);

    /**
     * Notifica o criador da requisicao de que esta foi reaprovada.
     */
    @RolesAllowed("aprovador")
    void requisicaoReprovada(Integer id);
    
    @RolesAllowed("aprovador")
    void requisicaoApagada(Requisicao requisicao);
    
    @RolesAllowed("empregado")
    void apagar(Long id);

}
