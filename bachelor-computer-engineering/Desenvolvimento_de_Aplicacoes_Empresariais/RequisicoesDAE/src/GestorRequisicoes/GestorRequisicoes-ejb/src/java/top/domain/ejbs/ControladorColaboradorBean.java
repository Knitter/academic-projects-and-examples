/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import top.domain.entities.Colaborador;
import top.domain.facades.ColaboradorFacadeRemote;

/**
 *
 * @author Knitter
 */
@Stateless
public class ControladorColaboradorBean implements ControladorColaboradorRemote {

    @EJB ColaboradorFacadeRemote fc;
    
    public Colaborador findByUsername(String username) {
        return fc.find(username);
    }

    public List<Colaborador> findAll() {
        return fc.findAll();
    }

    public Colaborador findByID(Long id) {
        return fc.find(id);
    }
    
    
}
