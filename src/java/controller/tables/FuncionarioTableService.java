/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Funcionario;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.FuncionarioDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "funcionarioTableService")
@ApplicationScoped
public class FuncionarioTableService {

    List<Funcionario> createData() {
        FuncionarioDAO selectDAO = FuncionarioDAO.getSingleton();
        List<Funcionario>list = selectDAO.getUsuario();
        return list;
    }
    
}
