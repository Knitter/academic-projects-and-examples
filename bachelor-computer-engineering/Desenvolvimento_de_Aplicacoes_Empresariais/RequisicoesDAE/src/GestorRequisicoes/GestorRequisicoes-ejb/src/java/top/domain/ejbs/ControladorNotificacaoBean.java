/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package top.domain.ejbs;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import top.domain.entities.Colaborador;
import top.domain.entities.Notificacao;
import top.domain.entities.Requisicao;
import top.domain.facades.NotificacaoFacadeRemote;
import top.domain.facades.RequisicaoFacadeRemote;

/**
 *
 * @author Knitter
 */
@Stateless
public class ControladorNotificacaoBean implements ControladorNotificacaoRemote {

    @EJB
    NotificacaoFacadeRemote nfc;
    @EJB
    RequisicaoFacadeRemote rfc;

    public void requisicaoEncomendada(Integer id) {
        Requisicao r = rfc.find(id);
        if (r != null) {
            LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

            associados.add(r.getAprovador());
            associados.add(r.getRequerente());
            associados.add(r.getUltimoAlterador());

            nfc.create(new Notificacao("Requisicao " + id + " em espera.", "A requisi\u00E7\u00E4o n\u00E4o pode ser satisfeita" +
                    " neste momento. Deu origem a uma encomenda.", new Date(), associados));
        }
    }

    public void requisicaoSatisfeita(Integer id) {
        Requisicao r = rfc.find(id);
        if (r != null) {
            LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

            associados.add(r.getAprovador());
            associados.add(r.getRequerente());
            associados.add(r.getUltimoAlterador());

            nfc.create(new Notificacao("Requisicao " + id + " satisfeita.", "A requisi\u00E7\u00E4o est\u00E1 pronta a levantar.", new Date(), associados));
        }
    }

    public void requisicaoParcialmenteSatisfeita(Integer id) {
        Requisicao r = rfc.find(id);
        if (r != null) {
            LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

            associados.add(r.getAprovador());
            associados.add(r.getRequerente());
            associados.add(r.getUltimoAlterador());

            nfc.create(new Notificacao("Requisicao " + id + " parcialmente satisfeita.", "A requisi\u00E7\u00E4o n\u00E4o pode ser satisfeita " +
                    "na sua totalidade e deu origem a uma encomenda.", new Date(), associados));
        }
    }

    public void requisicaoAprovada(Integer id) {
        Requisicao r = rfc.find(id);
        if (r != null) {
            LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

            associados.add(r.getAprovador());
            associados.add(r.getRequerente());
            associados.add(r.getUltimoAlterador());

            nfc.create(new Notificacao("Requisicao " + id + " aprovada.", "A requisi\u00E7\u00E4o foi aprovada.", new Date(), associados));
        }
    }

    public void requisicaoReprovada(Integer id) {
        Requisicao r = rfc.find(id);
        if (r != null) {
            LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

            associados.add(r.getAprovador());
            associados.add(r.getRequerente());
            associados.add(r.getUltimoAlterador());

            nfc.create(new Notificacao("Requisicao " + id + " reprovada.", "A requisi\u00E7\u00E4o foi reprovada.", new Date(), associados));
        }
    }

    public void requisicaoApagada(Requisicao requisicao) {
        LinkedList<Colaborador> associados = new LinkedList<Colaborador>();

        associados.add(requisicao.getAprovador());
        associados.add(requisicao.getRequerente());
        associados.add(requisicao.getUltimoAlterador());

        nfc.create(new Notificacao("Requisicao " + requisicao.getId() + " reprovada.", "A requisi\u00E7\u00E4o foi reprovada.", new Date(), associados));
    }
    
    public void apagar(Long id) {
        Notificacao n = nfc.find(id);
        if(n != null) {
            nfc.remove(n);
        }
    }
}
