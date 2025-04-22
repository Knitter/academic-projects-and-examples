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
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Knitter
 */
@Entity
public class Notificacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(value = javax.persistence.TemporalType.DATE)
    private Date dataCriacao;
    private String assunto;
    private String corpo;
    
    
    @ManyToMany
    private List<Colaborador> associados;
    
    public Notificacao() {
        //do nothing
    }
    
    public Notificacao(String assunto, String corpo, Date dataCriacao, List<Colaborador> associados) {
        this.assunto = assunto;
        this.corpo = corpo;
        this.dataCriacao = dataCriacao;
        this.associados = associados;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
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
        if (!(object instanceof Notificacao)) {
            return false;
        }
        Notificacao other = (Notificacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "top.domain.entities.Notificacao[id=" + id + "]";
    }

    public List<Colaborador> getAssociados() {
        return associados;
    }

    public void setAssociados(List<Colaborador> associados) {
        this.associados = associados;
    }

}
