/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Compra;
import bean.CompraProduto;
import bean.Produto;
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
public class CompraProdutoDAO {
    
    private final SessionFactory sessionFactory;
    
    public CompraProdutoDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Compra> getCompraProduto(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Compra> result = session.createQuery("from Compra_Produto").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setCompraProduto(CompraProduto compraProduto) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.flush();
        session.clear();
        session.merge(compraProduto);
        trans.commit();
        session.close();
    }
    
    public void alterCompraProduto(long codCompra, Produto produto, int quantidade) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        CompraProduto compraProduto = (CompraProduto) session.get(CompraProduto.class, codCompra);
        compraProduto.setProduto(produto);
        compraProduto.setQuantidade(quantidade);
        session.update(compraProduto);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteCompraProduto(long codCompra) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        CompraProduto compraProduto = (CompraProduto) session.get(CompraProduto.class, codCompra);
        session.delete(compraProduto);
        trans.commit();
        session.close();
    }
    
}
