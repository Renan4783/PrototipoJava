/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Fornecedor;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.FornecedorDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "fornecedorTableService")
@ApplicationScoped
public class FornecedorTableService {
    List<Fornecedor> createData() {
        FornecedorDAO selectDAO = FornecedorDAO.getSingleton();
        List<Fornecedor>list = selectDAO.getFornecedor();
        return list;
    }
}
