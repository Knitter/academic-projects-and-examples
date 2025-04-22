/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Requisicao;
import top.domain.utils.EstadoRequisicao;
import top.domain.utils.EstadoSatisfacao;

/**
 *
 * @author offhegoes
 */
@Stateless
public class RequisicaoFacade implements RequisicaoFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public Requisicao create(Requisicao requisicao) {
        em.persist(requisicao);
        Integer id = Integer.parseInt(em.createQuery("select MAX(id) from Requisicao").getSingleResult().toString());
        requisicao.setId(id);
        return requisicao;
    }

    public void edit(Requisicao requisicao) {
        em.merge(requisicao);
    }

    public void remove(Requisicao requisicao) {
        em.remove(em.merge(requisicao));
    }

    public Requisicao find(Object id) {
        return em.find(top.domain.entities.Requisicao.class, id);
    }

    public List<Requisicao> findAll() {
        return em.createQuery("select object(o) from Requisicao as o").getResultList();
    }

    public List<Requisicao> getRequisicoesPendentes() {
        return em.createQuery("select object(o) from Requisicao as o where estado = '" + EstadoRequisicao.ESTADO_SUBMETIDA + "'").getResultList();
    }
    
    public List<Requisicao> getRequisicoesPorServir() {
        return em.createQuery("select object(o) from Requisicao as o where estado = '" + 
                EstadoRequisicao.ESTADO_APROVADO + "' and estadoSatisfacao = '" + 
                EstadoSatisfacao.ESTADO_SATISFACAO_INSATISFEITA + "' or estadoSatisfacao = '" + 
                EstadoSatisfacao.ESTADO_SATISFACAO_PARCIALMENTE +"'").getResultList();
    }

    public List<Requisicao> getMeusRascunhos(Long idColaborador) {
        return em.createQuery("select object(o) from Requisicao as o where requerente_id = " + idColaborador).getResultList();
    }

    public List<Requisicao> getTodasRequisicoesExceptoRascunhosOutrem(Long idColaborador) {
        return em.createQuery("select object(o) from Requisicao as o where " +
                "(requerente_id = "+ idColaborador + ") or (estado <> '" + EstadoRequisicao.ESTADO_RASCUNHO + "')").getResultList();
    }

    public List<Requisicao> getProprias(Long idColaborador) {
        return em.createQuery("select object(o) from Requisicao as o where requerente_id = " + idColaborador).getResultList();
    }
}
