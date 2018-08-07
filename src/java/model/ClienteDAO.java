/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Cliente;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Renan
 */
public class ClienteDAO {
    private static final ClienteDAO singleton = new ClienteDAO();

    /**
     * @return the singleton
     */
    public static ClienteDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public ClienteDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Cliente> getCliente(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Cliente> result = session.createQuery("from Cliente").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setCliente(String nome, String endereco, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setTelefone1(telefone);
        session.save(cliente);
        trans.commit();
        session.close();
    }
    
    public void alterCliente(long codCliente, String nome, String endereco, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Cliente cliente = (Cliente) session.get(Cliente.class, codCliente);
        cliente.setNome(nome);
        cliente.setEndereco(endereco);
        cliente.setTelefone1(telefone);
        session.update(cliente);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteCliente(long codCliente) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Cliente cliente = (Cliente) session.get(Cliente.class, codCliente);
        session.delete(cliente);
        trans.commit();
        session.close();
    }
}
