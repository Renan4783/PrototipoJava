/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Cidade;
import bean.Fornecedor;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CidadeDAO;
import model.FornecedorDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class FornecedorWizard {
    
    private Fornecedor fornecedor = new Fornecedor();
    
    private List<Cidade> cidades;
    
    private boolean submit;
    
    @PostConstruct
    public void init(){
        CidadeDAO menuCity = new CidadeDAO();
        setCidades(menuCity.getCidade());
    }
    
    /**
     * @return the fornecedor
     */
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void save(){
        FornecedorDAO saveDAO = FornecedorDAO.getSingleton();
        try {
            saveDAO.setFornecedor(fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone1());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FornecedorWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alter(){
        FornecedorDAO alterDAO = FornecedorDAO.getSingleton();
        try {
            alterDAO.alterFornecedor(fornecedor.getCodFornecedor(), fornecedor.getNome(), fornecedor.getEndereco(), fornecedor.getTelefone1());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FornecedorWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        FornecedorDAO deleteDAO = FornecedorDAO.getSingleton();
        try {
            deleteDAO.deleteFornecedor(fornecedor.getCodFornecedor());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FornecedorWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isSubmit() {
        return submit;
    }

    /**
     * @param submit the submit to set
     */
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if (submit) {
            submit = false;   //reset in case funcionario goes back
            return "first";
        } else {
            return event.getNewStep();
        }
    }

    /**
     * @return the cidades
     */
    public List<Cidade> getCidades() {
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
}
