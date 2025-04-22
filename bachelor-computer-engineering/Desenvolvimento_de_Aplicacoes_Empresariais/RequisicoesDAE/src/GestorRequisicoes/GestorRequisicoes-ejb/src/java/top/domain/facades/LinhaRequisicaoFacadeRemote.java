/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.LinhaRequisicao;

/**
 *
 * @author offhegoes
 */
@Remote
public interface LinhaRequisicaoFacadeRemote {

    void create(LinhaRequisicao linhaRequisicao);

    void edit(LinhaRequisicao linhaRequisicao);

    void remove(LinhaRequisicao linhaRequisicao);

    LinhaRequisicao find(Object id);

    List<LinhaRequisicao> findAll();

}
