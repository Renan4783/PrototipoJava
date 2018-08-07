/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Saida;
import model.SaidaDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Renan
 */
@ManagedBean
@ViewScoped
public class SaidaWizard implements Serializable {
    
    private Saida saida = new Saida();
     
    private boolean skip;
     
     
    public void save() {
        SaidaDAO deleteDAO = SaidaDAO.getSingleton();
        //FacesMessage msg = new FacesMessage("Successful", "Welcome :" + getSaida().getFirstname());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        //deleteDAO.deleteMaterial(saida.getFirstname(), saida.getLastname(), saida.getAge(), saida.getStreet(), saida.getCity(), saida.getPostalCode(), saida.getInfo(), saida.getEmail(), saida.getPhone());
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case saida goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

    /**
     * @return the saida
     */
    public Saida getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(Saida saida) {
        this.saida = saida;
    }
}
