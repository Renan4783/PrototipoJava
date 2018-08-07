/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import model.*;
import bean.*;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Renan
 */
public class DatabaseCreator {
    public DatabaseCreator(){
        List<Cliente> userlist = new LinkedList<>();
        Cliente userbean = new Cliente();
        ClienteDAO u1 = new ClienteDAO();
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}
