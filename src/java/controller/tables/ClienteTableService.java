/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Cliente;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.ClienteDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "clienteTableService")
@ApplicationScoped
public class ClienteTableService {
    List<Cliente> createData() {
        ClienteDAO selectDAO = ClienteDAO.getSingleton();
        List<Cliente>list = selectDAO.getCliente();
        return list;
    }
}
