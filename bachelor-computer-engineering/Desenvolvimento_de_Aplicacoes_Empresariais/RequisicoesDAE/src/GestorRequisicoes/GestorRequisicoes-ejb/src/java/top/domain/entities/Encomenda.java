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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author offhegoes
 */
@Entity
public class Encomenda implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "encomenda")
    private List<LinhaEncomenda> linhasDeEncomenda;
    
    @OneToOne
    private Requisicao requisicao;
    
    private String estado;

    public Encomenda() {
    }

    public Encomenda(Requisicao requisicao, List linhasDeEncomenda) {
        //do nothing
        this.requisicao = requisicao;
        this.linhasDeEncomenda = linhasDeEncomenda;
    }

    public void setEstado(String ESTADO_SUBMETIDA) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this.estado = ESTADO_SUBMETIDA;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
   
    public Requisicao getRequisicao() {
        return requisicao;
    }

    public List getLinhasDeEncomenda() {
        return linhasDeEncomenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;//TODO
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if(this == object) {
            return true;
        }
        if (!(object instanceof Encomenda)) {
            return false;
        }
        Encomenda other = (Encomenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)) ||
                (!this.requisicao.equals(other.requisicao))) {
           return false;
        }
        return true;
        //TODO: confirmar lista de linhas de encomendas
    }

    @Override
    public String toString() {
        return "top.domain.entities.Encomenda[encomendaId=" + id + "]";
    }

}
