/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Funcionario;
import bean.Produto;
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
public class ProdutoDAO {
    
    private static final ProdutoDAO singleton = new ProdutoDAO();

    /**
     * @return the singleton
     */
    public static ProdutoDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public ProdutoDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Produto> getProduto(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Produto> result = session.createQuery("from Produto").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setProduto(String nome, String descricao) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        session.save(produto);
        trans.commit();
        session.close();
    }
    
    public void alterProduto(long codProduto, String nome, String descricao) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Produto produto = (Produto) session.get(Produto.class, codProduto);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        session.update(produto);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteProduto(long codProduto) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Produto produto = (Produto) session.get(Produto.class, codProduto);
        session.delete(produto);
        trans.commit();
        session.close();
    }
}
