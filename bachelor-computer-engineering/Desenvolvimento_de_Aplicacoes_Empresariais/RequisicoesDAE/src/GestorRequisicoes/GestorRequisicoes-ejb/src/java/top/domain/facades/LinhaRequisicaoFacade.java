/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.LinhaRequisicao;

/**
 *
 * @author offhegoes
 */
@Stateless
public class LinhaRequisicaoFacade implements LinhaRequisicaoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(LinhaRequisicao linhaRequisicao) {
        em.persist(linhaRequisicao);
    }

    public void edit(LinhaRequisicao linhaRequisicao) {
        em.merge(linhaRequisicao);
    }

    public void remove(LinhaRequisicao linhaRequisicao) {
        em.remove(em.merge(linhaRequisicao));
    }

    public LinhaRequisicao find(Object id) {
        return em.find(top.domain.entities.LinhaRequisicao.class, id);
    }

    public List<LinhaRequisicao> findAll() {
        return em.createQuery("select object(o) from LinhaRequisicao as o").getResultList();
    }

}
