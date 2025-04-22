/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Encomenda;

/**
 *
 * @author offhegoes
 */
@Remote
public interface EncomendaFacadeRemote {

    void create(Encomenda encomenda);

    void edit(Encomenda encomenda);

    void remove(Encomenda encomenda);

    Encomenda find(Object id);

    List<Encomenda> findAll();

}
