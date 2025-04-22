/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author offhegoes
 */
@Entity
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "utilizador")
    private String username;
    
    private String nome;
    
    private String apelido;
    
    @ManyToMany(mappedBy = "associados")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Notificacao> notificacoes;

    public Colaborador() {
        //do nothing
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)) ||
                (!this.apelido.equals(other.apelido)) || (!this.nome.equals(other.nome)) || 
                (!this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + nome + " " + apelido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacaos(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }

}
