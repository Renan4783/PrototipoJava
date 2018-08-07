/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Produto;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.ProdutoDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class ProdutoWizard {
    
    private Produto produto = new Produto();
    
    private boolean submit;
    
    
    public void save(){
        ProdutoDAO saveDAO = ProdutoDAO.getSingleton();
        try {
            saveDAO.setProduto(produto.getNome(), produto.getDescricao());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ProdutoWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alter(){
        ProdutoDAO alterDAO = ProdutoDAO.getSingleton();
        try {
            alterDAO.alterProduto(produto.getCodProduto(), produto.getNome(), produto.getDescricao());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ProdutoWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        ProdutoDAO deleteDAO = ProdutoDAO.getSingleton();
        try {
            deleteDAO.deleteProduto(produto.getCodProduto());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ProdutoWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String onFlowProcess(FlowEvent event) {
        if (isSubmit()) {
            setSubmit(false);   //reset in case funcionario goes back
            return "first";
        } else {
            return event.getNewStep();
        }
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the submit
     */
    public boolean isSubmit() {
        return submit;
    }

    /**
     * @param submit the submit to set
     */
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
    
}
