/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import top.domain.entities.Destino;
import top.domain.facades.DestinoFacadeRemote;

/**
 *
 * @author Knitter
 */
@Stateful
public class ControladorDestinoBean implements ControladorDestinoRemote {

    @EJB DestinoFacadeRemote fc;
    
    public List<Destino> getDestinos() {
        return fc.findAll();
    }
}
