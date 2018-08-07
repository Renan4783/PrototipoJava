/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Fornecedor;
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
public class FornecedorDAO {
    
    private static final FornecedorDAO singleton = new FornecedorDAO();

    /**
     * @return the singleton
     */
    public static FornecedorDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public FornecedorDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Fornecedor> getFornecedor(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Fornecedor> result = session.createQuery("from Fornecedor").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setFornecedor(String nome, String endereco, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setEndereco(endereco);
        fornecedor.setNome(nome);
        fornecedor.setTelefone1(telefone);
        session.save(fornecedor);
        trans.commit();
        session.close();
    }
    
    public void alterFornecedor(long codFornecedor, String nome, String endereco, String telefone) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Fornecedor fornecedor = (Fornecedor) session.get(Fornecedor.class, codFornecedor);
        fornecedor.setNome(nome);
        fornecedor.setEndereco(endereco);
        fornecedor.setTelefone1(telefone);
        session.update(fornecedor);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteFornecedor(long codFornecedor) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Fornecedor fornecedor = (Fornecedor) session.get(Fornecedor.class, codFornecedor);
        session.delete(fornecedor);
        trans.commit();
        session.close();
    }
}
