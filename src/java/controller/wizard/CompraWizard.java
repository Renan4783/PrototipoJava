/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

/**
 *
 * @author Renan
 */
 
import bean.Compra;
import bean.Fornecedor;
import bean.Motivo;
import bean.Produto;
import controller.FuncionarioLogin;
import model.CompraDAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.FornecedorDAO;
import model.MotivoDAO;
import model.ProdutoDAO;
import org.primefaces.event.FlowEvent;
 
@ManagedBean
@ViewScoped
public class CompraWizard implements Serializable {
 
    private Compra compra = new Compra();
    private List<Fornecedor> fornecedores;
    private List<Motivo> motivos;
     
    private boolean skip;
     
    @PostConstruct
    public void init(){
        FuncionarioLogin func = new FuncionarioLogin();
        MotivoDAO menuMot = MotivoDAO.getSingleton();
        FornecedorDAO menuForc = FornecedorDAO.getSingleton();
        ProdutoDAO menuProd = ProdutoDAO.getSingleton();
        setFornecedores(menuForc.getFornecedor());
        setMotivos(menuMot.getMotivo());
        this.compra.setCadastrante(func.request());
    }
    
    public Compra getCompra() {
        return compra;
    }
 
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    
    
    public void save() {
        CompraDAO saveDAO = CompraDAO.getSingleton();
        //FacesMessage msg = new FacesMessage("Successful", "Welcome :" + compra.getFirstname());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //saveDAO.insertMaterial(compra.getFirstname(), compra.getLastname(), compra.getAge(), compra.getStreet(), compra.getCity(), compra.getPostalCode(), compra.getInfo(), compra.getEmail(), compra.getPhone());
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case compra goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    /**
     * @return the fornecedores
     */
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    /**
     * @param fornecedores the fornecedores to set
     */
    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    /**
     * @return the motivos
     */
    public List<Motivo> getMotivos() {
        return motivos;
    }

    /**
     * @param motivos the motivos to set
     */
    public void setMotivos(List<Motivo> motivos) {
        this.motivos = motivos;
    }

}