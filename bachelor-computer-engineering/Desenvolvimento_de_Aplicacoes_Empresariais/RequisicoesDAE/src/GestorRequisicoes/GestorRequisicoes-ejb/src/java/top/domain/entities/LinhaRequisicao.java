/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Knitter
 */
@Entity
public class LinhaRequisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Produto produto;
    
    private int quantidade;
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
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
        if(this == object) {
            return true;
        }
        if (!(object instanceof LinhaRequisicao)) {
            return false;
        }
        LinhaRequisicao other = (LinhaRequisicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)) || 
                (!this.produto.equals(other.produto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "top.domain.entities.LinhaRequisicao[id=" + id + "]";
    }
 
    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
