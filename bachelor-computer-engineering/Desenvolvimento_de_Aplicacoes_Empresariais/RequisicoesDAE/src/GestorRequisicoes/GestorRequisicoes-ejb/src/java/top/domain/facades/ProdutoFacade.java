/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Produto;

/**
 *
 * @author offhegoes
 */
@Stateless
public class ProdutoFacade implements ProdutoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Produto produto) {
        em.persist(produto);
    }

    public void edit(Produto produto) {
        em.merge(produto);
    }

    public void remove(Produto produto) {
        em.remove(em.merge(produto));
    }

    public Produto find(Object id) {
        return em.find(top.domain.entities.Produto.class, id);
    }

    public List<Produto> findAll() {
        return em.createQuery("select object(o) from Produto as o").getResultList();
    }
    
    public Produto findProduto(String nome){
        //List quantos = em.createQuery("select object(o) from Produto as o where nome = '" + nome +"'").getResultList();
       System.out.println(nome);
        //return (Produto)quantos.get(quantos.size()-1);
    return (Produto)em.createQuery("select object(o) from Produto as o where nome = '" + nome +"'").getSingleResult();
    }

}
