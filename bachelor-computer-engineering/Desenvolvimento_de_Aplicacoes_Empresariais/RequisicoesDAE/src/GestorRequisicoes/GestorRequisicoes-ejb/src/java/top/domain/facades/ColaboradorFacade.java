/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Colaborador;

/**
 *
 * @author offhegoes
 */
@Stateless
public class ColaboradorFacade implements ColaboradorFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Colaborador colaborador) {
        em.persist(colaborador);
    }

    public void edit(Colaborador colaborador) {
        em.merge(colaborador);
    }

    public void remove(Colaborador colaborador) {
        em.remove(em.merge(colaborador));
    }

    public Colaborador find(Object id) {
        return em.find(top.domain.entities.Colaborador.class, id);
    }
    
    public Colaborador find(String username){
        List quantos = em.createQuery("select object(o) from Colaborador as o where utilizador = '" + username +"'").getResultList();
        return (Colaborador)quantos.get(quantos.size()-1);
    }

    public List<Colaborador> findAll() {
        return em.createQuery("select object(o) from Colaborador as o").getResultList();
    }

}
