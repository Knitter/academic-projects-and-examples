/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Remote;
import top.domain.entities.Colaborador;
import top.domain.entities.Destino;
import top.domain.entities.Requisicao;

@Remote
public interface ControladorRequisicaoRemote {
    
    @RolesAllowed("empregado")
    Requisicao criar(Colaborador requerente, Date dataRequisicao, Date dataConclusao, 
            Date ultimaAlteracao, Colaborador aprovador, Destino destino, String estado, 
            String assunto, Colaborador ultimoAlterador);

    @RolesAllowed("empregado")
    Requisicao criar(Colaborador requerente, Date dataConclusao, Destino destino, String assunto, boolean rascunho);
   
    @RolesAllowed("empregado")
    void actualizar(Requisicao requisicao);
            
    @RolesAllowed("aprovador")
    boolean apagar(Integer id);
    
    @RolesAllowed("empregado")
    void submeterParaAprovacao(Integer id);
            
    @RolesAllowed("aprovador")
    void aprovar(Integer id);
    
    @RolesAllowed("aprovador")
    void reprovar(Integer id);
    
    @RolesAllowed("empregado")
    List<Requisicao> getProprias(Long idColaborador);
    
    @RolesAllowed({"responsavel", "aprovador"})
    List<Requisicao> getTodasRequisicoesExceptoRascunhosOutrem(Long idColaborador);

    @RolesAllowed("aprovador")
    List<Requisicao> getRequisicoesPendentes();
    
    @RolesAllowed("responsavel")
    List<Requisicao> getRequisicoesPorServir();
    
    @RolesAllowed("responsavel")
    void satisfazer(Integer id);

    @RolesAllowed("responsavel")
    void satisfazerParcialmente(Integer id);
    
    @RolesAllowed("empregado")
    List<Requisicao> getMeusRascunhos(Long idColaborador);

    @RolesAllowed("empregado")
    public Requisicao getRequisicaoActiva(Integer id);
    
    @RolesAllowed("empregado")
    boolean apagar(Long idColaborador, Integer idRequisicao);
}
