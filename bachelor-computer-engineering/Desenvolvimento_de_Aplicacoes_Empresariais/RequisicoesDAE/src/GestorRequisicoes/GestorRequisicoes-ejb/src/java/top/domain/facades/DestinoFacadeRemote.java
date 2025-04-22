/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Destino;

/**
 *
 * @author offhegoes
 */
@Remote
public interface DestinoFacadeRemote {

    void create(Destino destino);

    void edit(Destino destino);

    void remove(Destino destino);

    Destino find(Object id);

    List<Destino> findAll();

}
