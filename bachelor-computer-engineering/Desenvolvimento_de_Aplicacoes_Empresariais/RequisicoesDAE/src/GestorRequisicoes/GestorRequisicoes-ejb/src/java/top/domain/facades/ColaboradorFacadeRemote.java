/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Colaborador;

/**
 *
 * @author offhegoes
 */
@Remote
public interface ColaboradorFacadeRemote {

    void create(Colaborador colaborador);

    void edit(Colaborador colaborador);

    void remove(Colaborador colaborador);

    Colaborador find(Object id);

    List<Colaborador> findAll();

    public Colaborador find(java.lang.String username);

}
