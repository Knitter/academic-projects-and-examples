/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import top.domain.entities.Colaborador;

/**
 *
 * @author Knitter
 */
@Remote
public interface ControladorColaboradorRemote {

    @PermitAll
    public Colaborador findByUsername(String username);

    public Colaborador findByID(Long id);
    
    public List<Colaborador> findAll();
}
