/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Compra;
import bean.Fornecedor;
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
public class CompraDAO {
    
    private static final CompraDAO singleton = new CompraDAO();

    /**
     * @return the singleton
     */
    public static CompraDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public CompraDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Compra> getCompra(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Compra> result = session.createQuery("from Compra").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setCompra(Compra compra) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(compra);
        trans.commit();
        session.close();
    }
    
    public void alterCompra(long codCompra, String dataCompra, Fornecedor fornecedor, Motivo motivo) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Compra compra = (Compra) session.get(Compra.class, codCompra);
        compra.setDataCompra(dataCompra);
        compra.setFornecedor(fornecedor);
        compra.setMotivo(motivo);
        session.update(compra);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteCliente(long codCompra) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Motivo motivo = (Motivo) session.get(Compra.class, codCompra);
        session.delete(motivo);
        trans.commit();
        session.close();
    }
}
