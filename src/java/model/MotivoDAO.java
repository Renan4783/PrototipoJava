/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Motivo;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
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
public class MotivoDAO {
    private static final MotivoDAO singleton = new MotivoDAO();

    /**
     * @return the singleton
     */
    public static MotivoDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public MotivoDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Motivo> getMotivo(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Motivo> result = session.createQuery("from Motivo").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setMotivo(String nome) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Motivo motivo = new Motivo();
        motivo.setNome(nome);
        session.save(motivo);
        trans.commit();
        session.close();
    }
    
    public void alterMotivo(long codMotivo, String nome) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Motivo motivo = (Motivo) session.get(Motivo.class, codMotivo);
        motivo.setNome(nome);
        session.update(motivo);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteMotivo(long codMotivo) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Motivo motivo = (Motivo) session.get(Motivo.class, codMotivo);
        session.delete(motivo);
        trans.commit();
        session.close();
    }
}
