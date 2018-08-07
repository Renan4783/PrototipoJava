/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Cidade;
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
public class CidadeDAO {
    private static final CidadeDAO singleton = new CidadeDAO();

    /**
     * @return the singleton
     */
    public static CidadeDAO getSingleton() {
        return singleton;
    }
    
    private final SessionFactory sessionFactory;
    
    public CidadeDAO(){
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        sessionFactory = conf.buildSessionFactory();
    }
    
    public List<Cidade> getCidade(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Cidade> result = session.createQuery("from Cidade").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
    
     public void setCidade(String nome) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Cidade cidade = new Cidade();
        cidade.setNome(nome);
        session.save(cidade);
        trans.commit();
        session.close();
    }
    
    public void alterCidade(long codCidade, String nome) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        //cria um novo objeto da classe Usuario
        Cidade cidade = (Cidade) session.get(Cliente.class, codCidade);
        cidade.setNome(nome);
        session.update(cidade);
        /*salva o objeto na sessão do Hibernate
se for usado o comando saveOrUpdate(), o Hibernate irá inserir no banco de dados caso seja um novo objeto (new Usuario())
ou alterar se for um objeto já existente*/
        trans.commit(); //confirma a transação salvando o objeto no banco de dados
        session.close();
    }
    
    public void deleteCidade(long codCidade) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Cidade cidade = (Cidade) session.get(Cliente.class, codCidade);
        session.delete(cidade);
        trans.commit();
        session.close();
    }
}
