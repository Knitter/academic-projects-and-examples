/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package top.domain.ejbs;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import top.domain.entities.Colaborador;
import top.domain.entities.Destino;
import top.domain.entities.Requisicao;
import top.domain.facades.RequisicaoFacadeRemote;
import top.domain.utils.EstadoRequisicao;
import top.domain.utils.EstadoSatisfacao;

/**
 *
 * @author Knitter
 */
@Stateful
public class ControladorRequisicaoBean implements ControladorRequisicaoRemote {

    @EJB
    RequisicaoFacadeRemote fc;
    @EJB
    ControladorNotificacaoRemote rnot;
    
    @PersistenceContext
    EntityManager mng;
    

    public Requisicao criar(Colaborador requerente, Date dataRequisicao, Date dataConclusao,
            Date ultimaAlteracao, Colaborador aprovador, Destino destino, String estado,
            String assunto, Colaborador ultimoAlterador) {

        Requisicao nova = new Requisicao(requerente, dataRequisicao, dataConclusao, ultimaAlteracao, aprovador, destino, estado, assunto, ultimoAlterador); 
        return fc.create(nova);
    }

    public Requisicao criar(Colaborador requerente, Date dataConclusao, Destino destino, String assunto, boolean rascunho) {
        return criar(requerente, new Date(), dataConclusao, null, null, destino,
                (rascunho ? EstadoRequisicao.ESTADO_RASCUNHO : EstadoRequisicao.ESTADO_SUBMETIDA),
                assunto, null);
    }

    public void actualizar(Requisicao requisicao) {
        fc.edit(requisicao);
    }

    public boolean apagar(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null && !r.getEstadoSatisfacao().equals(EstadoSatisfacao.ESTADO_SATISFACAO_SATISFEITA) && 
                !r.getEstadoSatisfacao().equals(EstadoSatisfacao.ESTADO_SATISFACAO_PARCIALMENTE)) {
            fc.remove(r);
            rnot.requisicaoApagada(r);
            return true;
        }
        return false;
    }
    
    public boolean apagar(Long idColaborador, Integer idRequisicao) {
        Requisicao r = fc.find(idRequisicao);
        if(r != null && r.getRequerente().getId().equals(idColaborador) && 
                !r.getEstado().equals(EstadoRequisicao.ESTADO_APROVADO) && 
                !r.getEstado().equals(EstadoRequisicao.ESTADO_REPROVADO)) {
            fc.remove(r);
        }
        return false;
    } 

    public void submeterParaAprovacao(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null) {
            r.setEstado(EstadoRequisicao.ESTADO_SUBMETIDA);
            fc.edit(r);
        }
    }

    public void aprovar(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null) {
            r.setEstado(EstadoRequisicao.ESTADO_APROVADO);
            fc.edit(r);
            rnot.requisicaoAprovada(id);
        }
    }

    public void reprovar(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null) {
            r.setEstado(EstadoRequisicao.ESTADO_REPROVADO);
            fc.edit(r);
            rnot.requisicaoReprovada(id);
        }
    }

    public List<Requisicao> getProprias(Long idColaborador) {
        return fc.getProprias(idColaborador);
    }

    /**
     * Implementacao do requisito F7
     */
    public List<Requisicao> getTodasRequisicoesExceptoRascunhosOutrem(Long idColaborador) {
        return fc.getTodasRequisicoesExceptoRascunhosOutrem(idColaborador);
    }

    public List<Requisicao> getMeusRascunhos(Long idColaborador) {
        return fc.getMeusRascunhos(idColaborador);
    }

    public List<Requisicao> getRequisicoesPendentes() {
        return fc.getRequisicoesPendentes();
    }

    public List<Requisicao> getRequisicoesPorServir() {
        return fc.getRequisicoesPorServir();
    }

    public void satisfazer(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null) {
            r.setEstadoSatisfacao(EstadoSatisfacao.ESTADO_SATISFACAO_SATISFEITA);
            fc.edit(r);
            rnot.requisicaoSatisfeita(id);
        }
    }

    public void satisfazerParcialmente(Integer id) {
        Requisicao r = fc.find(id);
        if (r != null) {
            r.setEstadoSatisfacao(EstadoSatisfacao.ESTADO_SATISFACAO_PARCIALMENTE);
            fc.edit(r);
            rnot.requisicaoParcialmenteSatisfeita(id);
        }
    }

    public Requisicao getRequisicaoActiva(Integer id) {
        return fc.find(id);
    }
}
