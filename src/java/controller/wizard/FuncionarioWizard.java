/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Funcionario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.FuncionarioDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class FuncionarioWizard {

    private Funcionario funcionario = new Funcionario();

    private boolean submit;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void save() {
        FuncionarioDAO saveDAO = FuncionarioDAO.getSingleton();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Novo", "Dados criados com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);    
        try {
            saveDAO.setUsuario(funcionario.getLogin(), funcionario.getSenha(), funcionario.isAdministrador());
            funcionario.setLogin(null);
            funcionario.setSenha(null);
            funcionario.setAdministrador(false);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alter() {
        FuncionarioDAO saveDAO = FuncionarioDAO.getSingleton();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração", "Dados alterados com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        funcionario.setLogin("teste");
        try {
            saveDAO.alterUsuario(funcionario.getCodFuncionario(), funcionario.getLogin(), funcionario.getSenha(), funcionario.isAdministrador());
            funcionario.setCodFuncionario(0);
            funcionario.setLogin("teste");
            funcionario.setSenha(null);
            funcionario.setAdministrador(false);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        FuncionarioDAO saveDAO = FuncionarioDAO.getSingleton();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão", "Dados deletados com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            saveDAO.deleteUsuario(funcionario.getCodFuncionario());
            funcionario.setCodFuncionario(0);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(FuncionarioWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isSubmit() {
        return submit;
    }

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
}
