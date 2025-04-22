/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Destino;

/**
 *
 * @author offhegoes
 */
@Stateless
public class DestinoFacade implements DestinoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Destino destino) {
        em.persist(destino);
    }

    public void edit(Destino destino) {
        em.merge(destino);
    }

    public void remove(Destino destino) {
        em.remove(em.merge(destino));
    }

    public Destino find(Object id) {
        return em.find(top.domain.entities.Destino.class, id);
    }

    public List<Destino> findAll() {
        return em.createQuery("select object(o) from Destino as o").getResultList();
    }

}
