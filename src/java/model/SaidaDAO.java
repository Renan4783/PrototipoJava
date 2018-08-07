/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Renan
 */
@ManagedBean
@SessionScoped
public class SaidaDAO {
    
    private static final SaidaDAO singleton = new SaidaDAO();

    /**
     * @return the singleton
     */
    public static SaidaDAO getSingleton() {
        return singleton;
    }
    
    
    private final SessionFactory sessionFactory;
    
    public SaidaDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public void deleteMaterial (String firstname, String lastname, Integer age, String street, String city, String postalCode, String info, String email, String phone){
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        
        trans.commit();
        session.close();
    }
}
