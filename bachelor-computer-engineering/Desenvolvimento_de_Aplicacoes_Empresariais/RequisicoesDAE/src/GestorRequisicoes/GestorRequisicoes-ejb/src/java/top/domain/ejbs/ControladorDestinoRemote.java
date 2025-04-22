/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import top.domain.entities.Destino;

/**
 *
 * @author Knitter
 */
@Remote
public interface ControladorDestinoRemote {
    
    @PermitAll
    List<Destino> getDestinos();
    
}
