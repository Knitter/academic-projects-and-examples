/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.LinhaEncomenda;

/**
 *
 * @author offhegoes
 */
@Remote
public interface LinhaEncomendaFacadeRemote {

    void create(LinhaEncomenda linhaEncomenda);

    void edit(LinhaEncomenda linhaEncomenda);

    void remove(LinhaEncomenda linhaEncomenda);

    LinhaEncomenda find(Object id);

    List<LinhaEncomenda> findAll();

}
