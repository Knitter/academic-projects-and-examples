/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import top.domain.entities.LinhaRequisicao;
import top.domain.facades.LinhaRequisicaoFacadeRemote;

/**
 *
 * @author Knitter
 */
@Stateless
public class ControladorLinhaRequisicaoBean implements ControladorLinhaRequisicaoRemote {

    @EJB LinhaRequisicaoFacadeRemote fc;
    
    public List<LinhaRequisicao> findAll() {
        return fc.findAll();
    }
}
