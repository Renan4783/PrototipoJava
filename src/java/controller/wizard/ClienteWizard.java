/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Cidade;
import bean.Cliente;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CidadeDAO;
import model.ClienteDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class ClienteWizard {
    
    private Cliente cliente = new Cliente();
    private List<Cidade> cidades;
    
    private boolean submit;
    
    @PostConstruct
    public void init(){
        CidadeDAO menuCity = new CidadeDAO();
        setCidades(menuCity.getCidade());
    }
    
    public void save(){
        ClienteDAO saveDAO = ClienteDAO.getSingleton();
        try {
            saveDAO.setCliente(cliente.getNome(), cliente.getEndereco(), cliente.getTelefone1());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alter(){
        ClienteDAO alterDAO = ClienteDAO.getSingleton();
        try {
            alterDAO.alterCliente(cliente.getCodCliente(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone1());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        ClienteDAO deleteDAO = ClienteDAO.getSingleton();
        try {
            deleteDAO.deleteCliente(cliente.getCodCliente());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ClienteWizard.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
