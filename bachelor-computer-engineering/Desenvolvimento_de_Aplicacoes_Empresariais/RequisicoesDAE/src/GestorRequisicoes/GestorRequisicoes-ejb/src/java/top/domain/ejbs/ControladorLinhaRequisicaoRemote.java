/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import top.domain.entities.LinhaRequisicao;

/**
 *
 * @author Knitter
 */
@Remote
public interface ControladorLinhaRequisicaoRemote {

    @PermitAll
    List<LinhaRequisicao> findAll();
    
}
