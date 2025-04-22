/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Encomenda;

/**
 *
 * @author offhegoes
 */
@Stateless
public class EncomendaFacade implements EncomendaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Encomenda encomenda) {
        em.persist(encomenda);
    }

    public void edit(Encomenda encomenda) {
        em.merge(encomenda);
    }

    public void remove(Encomenda encomenda) {
        em.remove(em.merge(encomenda));
    }

    public Encomenda find(Object id) {
        return em.find(top.domain.entities.Encomenda.class, id);
    }

    public List<Encomenda> findAll() {
        return em.createQuery("select object(o) from Encomenda as o").getResultList();
    }

}
