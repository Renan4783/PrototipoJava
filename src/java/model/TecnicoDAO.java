/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Funcionario;
import bean.Produto;
import bean.Tecnico;
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
public class TecnicoDAO {
     private static final TecnicoDAO singleton = new TecnicoDAO();

    /**
     * @return the singleton
     */
    public static TecnicoDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public TecnicoDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Tecnico> getTecnico(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Tecnico> result = session.createQuery("from Tecnico").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setTecnico(String nome, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Tecnico tecnico = new Tecnico();
        tecnico.setNome(nome);
        tecnico.setTelefone1(telefone);
        session.save(tecnico);
        trans.commit();
        session.close();
    }
    
    public void alterTecnico(long codTecnico, String nome, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Tecnico tecnico = (Tecnico) session.get(Tecnico.class, codTecnico);
        tecnico.setNome(nome);
        tecnico.setTelefone1(telefone);
        session.update(tecnico);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteTecnico(long codTecnico) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Tecnico tecnico = (Tecnico) session.get(Tecnico.class, codTecnico);
        session.delete(tecnico);
        trans.commit();
        session.close();
    }
}
