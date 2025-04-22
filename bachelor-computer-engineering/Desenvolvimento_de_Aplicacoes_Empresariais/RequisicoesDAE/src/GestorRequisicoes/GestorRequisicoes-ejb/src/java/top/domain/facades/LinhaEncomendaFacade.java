/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.LinhaEncomenda;

/**
 *
 * @author offhegoes
 */
@Stateless
public class LinhaEncomendaFacade implements LinhaEncomendaFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(LinhaEncomenda linhaEncomenda) {
        em.persist(linhaEncomenda);
    }

    public void edit(LinhaEncomenda linhaEncomenda) {
        em.merge(linhaEncomenda);
    }

    public void remove(LinhaEncomenda linhaEncomenda) {
        em.remove(em.merge(linhaEncomenda));
    }

    public LinhaEncomenda find(Object id) {
        return em.find(top.domain.entities.LinhaEncomenda.class, id);
    }

    public List<LinhaEncomenda> findAll() {
        return em.createQuery("select object(o) from LinhaEncomenda as o").getResultList();
    }

}
