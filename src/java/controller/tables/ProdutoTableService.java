/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Produto;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ProdutoDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "produtoTableService")
@ApplicationScoped
public class ProdutoTableService {

    List<Produto> createData() {
        ProdutoDAO selectDAO = ProdutoDAO.getSingleton();
        List<Produto>list = selectDAO.getProduto();
        return list;
    }
    
}
