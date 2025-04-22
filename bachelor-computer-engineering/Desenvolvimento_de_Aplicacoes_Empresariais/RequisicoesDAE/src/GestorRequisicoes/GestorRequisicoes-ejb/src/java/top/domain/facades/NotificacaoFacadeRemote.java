/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Notificacao;

/**
 *
 * @author offhegoes
 */
@Remote
public interface NotificacaoFacadeRemote {

    void create(Notificacao notificacao);

    void edit(Notificacao notificacao);

    void remove(Notificacao notificacao);

    Notificacao find(Object id);

    List<Notificacao> findAll();

}
