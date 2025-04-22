/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package top.domain.ejbs;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import top.domain.entities.Produto;
import top.domain.facades.ProdutoFacadeRemote;

/**
 *
 * @author offhegoes
 */


@Stateful
public class ControladorProdutoBean implements ControladorProdutoRemote {

    @EJB ProdutoFacadeRemote prateleira;

    public Produto findByID(long parseLong) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return prateleira.find(parseLong);
    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    
    public Produto getProduto(String name){
      return this.prateleira.findProduto(name);
    }

    public List<Produto> getProdutos() {
        return prateleira.findAll();
    }
    
}
