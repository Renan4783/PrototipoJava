/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Motivo;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.MotivoDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name = "motivoTableService")
@ApplicationScoped
public class MotivoTableService {
    List<Motivo> createData() {
        MotivoDAO selectDAO = MotivoDAO.getSingleton();
        List<Motivo>list = selectDAO.getMotivo();
        return list;
    }
}
