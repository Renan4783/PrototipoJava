/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Motivo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class MotivoWizard {
    
    private Motivo motivo = new Motivo();
    
    private boolean submit;

    /**
     * @return the motivo
     */
    public Motivo getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }
    
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
