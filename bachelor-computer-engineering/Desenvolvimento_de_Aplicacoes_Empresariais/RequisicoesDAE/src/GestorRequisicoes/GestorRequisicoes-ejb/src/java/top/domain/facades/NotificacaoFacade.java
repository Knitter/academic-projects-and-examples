/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Notificacao;

/**
 *
 * @author offhegoes
 */
@Stateless
public class NotificacaoFacade implements NotificacaoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Notificacao notificacao) {
        em.persist(notificacao);
    }

    public void edit(Notificacao notificacao) {
        em.merge(notificacao);
    }

    public void remove(Notificacao notificacao) {
        em.remove(em.merge(notificacao));
    }

    public Notificacao find(Object id) {
        return em.find(top.domain.entities.Notificacao.class, id);
    }

    public List<Notificacao> findAll() {
        return em.createQuery("select object(o) from Notificacao as o").getResultList();
    }

}
