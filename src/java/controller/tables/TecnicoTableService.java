/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Tecnico;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.TecnicoDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "tecnicoTableService")
@ApplicationScoped
public class TecnicoTableService {

    List<Tecnico> createData() {
        TecnicoDAO selectDAO = TecnicoDAO.getSingleton();
        List<Tecnico> list = selectDAO.getTecnico();
        return list;
    }
}
