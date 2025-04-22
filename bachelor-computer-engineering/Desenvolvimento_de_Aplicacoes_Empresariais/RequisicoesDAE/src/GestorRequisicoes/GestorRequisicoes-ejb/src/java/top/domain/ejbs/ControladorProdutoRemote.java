/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.ejb.Remote;
import top.domain.entities.Produto;

/**
 *
 * @author offhegoes
 */
@Remote
public interface ControladorProdutoRemote {

    public Produto getProduto(String name);
    public List<Produto> getProdutos();

    public top.domain.entities.Produto findByID(long parseLong);
    
}
