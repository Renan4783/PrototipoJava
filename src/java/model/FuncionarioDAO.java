/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Funcionario;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
public class FuncionarioDAO {
    
    private static final FuncionarioDAO singleton = new FuncionarioDAO();

    /**
     * @return the singleton
     */
    public static FuncionarioDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    
    public FuncionarioDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Funcionario> getUsuario(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Funcionario> result = session.createQuery("from Funcionario").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
    
    public List<Funcionario> getUmUsuario(String nome, String senha){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Funcionario> result = session.createQuery("from Funcionario where login=:name and senha=:pass").setString("name", nome).setString("pass", senha).list();
        session.getTransaction().commit();
        session.close();
        return result;
    
    }
    
    public void setUsuario(String login, String senha, boolean admin) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        byte[] bytestoMessage = senha.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytestoMessage);
        String senhastr = new String(digest, StandardCharsets.UTF_8);
//cria um novo objeto da classe Usuario
        Funcionario usuario = new Funcionario();
        usuario.setLogin(login);
        usuario.setSenha(senhastr);
        usuario.setAdministrador(admin);
        session.save(usuario);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void alterUsuario(long codFuncionario, String login, String senha, boolean admin) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        byte[] bytestoMessage = senha.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytestoMessage);
        String senhastr = new String(digest, StandardCharsets.UTF_8);
        //cria um novo objeto da classe Usuario
        Funcionario usuario = (Funcionario) session.get(Funcionario.class, codFuncionario);
        usuario.setLogin(login);
        usuario.setSenha(senhastr);
        usuario.setAdministrador(admin);
        session.update(usuario);
        trans.commit();
        session.close();
    }
    
    public void deleteUsuario(long codFuncionario) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Funcionario usuario = (Funcionario) session.get(Funcionario.class, codFuncionario);
        session.delete(usuario);
        trans.commit();
        session.close();
    }
}
