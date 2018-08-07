/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Cidade;
import bean.Tecnico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.CidadeDAO;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class TecnicoWizard {
    
    private Tecnico tecnico = new Tecnico();
    
    private boolean submit;
    
    public void save(){
        
    }
    
    public void alter(){
        
    }
    
    public void delete(){
        
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
     * @return the tecnico
     */
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
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
