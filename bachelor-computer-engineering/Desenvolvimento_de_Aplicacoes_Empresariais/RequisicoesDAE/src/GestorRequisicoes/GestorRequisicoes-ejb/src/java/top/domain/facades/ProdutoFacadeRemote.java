/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.facades;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Produto;

/**
 *
 * @author offhegoes
 */
@Remote
public interface ProdutoFacadeRemote {

    public Produto findProduto(String name);

    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);

    List<Produto> findAll();

}
