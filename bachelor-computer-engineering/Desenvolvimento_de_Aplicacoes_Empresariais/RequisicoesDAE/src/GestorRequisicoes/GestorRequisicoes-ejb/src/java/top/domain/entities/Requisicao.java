/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package top.domain.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author offhegoes
 */
@Entity
public class Requisicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Colaborador requerente;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRequisicao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataConclusao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ultimaAlteracao;
    @OneToOne
    private Colaborador aprovador;
    @OneToOne
    private Destino destino;
    private String estado;
    private String assunto;
    @OneToOne
    private Colaborador ultimoAlterador;
    
    private String estadoSatisfacao;

    public Requisicao(Colaborador requerente, Date dataRequisicao, Date dataConclusao,
            Date ultimaAlteracao, Colaborador aprovador, Destino destino, String estado,
            String assunto, Colaborador ultimoAlterador) {

        this.requerente = requerente;
        this.dataRequisicao = dataRequisicao;
        this.dataConclusao = dataConclusao;
        this.ultimaAlteracao = ultimaAlteracao;
        this.aprovador = aprovador;
        this.destino = destino;
        this.estado = estado;
        this.assunto = assunto;
        this.ultimoAlterador = ultimoAlterador;
    }

    public Colaborador getAprovador() {
        return aprovador;
    }

    public List<LinhaRequisicao> getLinhasRequisicao() {
        return null;
    }

    public void setAprovador(Colaborador aprovador) {
        this.aprovador = aprovador;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Colaborador getRequerente() {
        return requerente;
    }

    public void setRequerente(Colaborador requerente) {
        this.requerente = requerente;
    }

    public Colaborador getUltimoAlterador() {
        return ultimoAlterador;
    }

    public void setUltimoAlterador(Colaborador ultimoAlterador) {
        this.ultimoAlterador = ultimoAlterador;
    }

    public Requisicao() {
    //do nothing
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (this == object) {
            return true;
        }
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)) ||
                (!this.aprovador.equals(other.aprovador)) || (!this.destino.equals(other.destino) ||
                (!this.requerente.equals(other.requerente)) || (this.estado.equals(other.estado)) ||
                (!this.dataRequisicao.equals(other.dataRequisicao)) || (!this.dataConclusao.equals(other.dataConclusao)) ||
                (!this.assunto.equals(other.assunto))) || (!this.ultimaAlteracao.equals(other.ultimaAlteracao)) ||
                (!this.ultimoAlterador.equals(other.ultimoAlterador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "top.domain.entities.Requisicao[id=" + id + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getEstadoSatisfacao() {
        return estadoSatisfacao;
    }

    public void setEstadoSatisfacao(String estadoSatisfacao) {
        this.estadoSatisfacao = estadoSatisfacao;
    }
}
