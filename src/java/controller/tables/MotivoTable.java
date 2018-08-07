/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Motivo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="motivoTable")
@ViewScoped
public class MotivoTable {
    private List<Motivo> MotivoList;
    
    private List<Motivo> FilteredMotList;
    
    private Motivo selectedMot;
    
    @ManagedProperty("#{motivoTableService}")
    private MotivoTableService service;
    
    @PostConstruct
    public void init() {
        setService(new MotivoTableService());
        setMotivoList(service.createData());
    }

    public void refresh(){
        setService(new MotivoTableService());
        setMotivoList(service.createData());
    }
    
    /**
     * @return the MotivoList
     */
    public List<Motivo> getFuncionarioList() {
        return getMotivoList();
    }

    /**
     * @param FuncionarioList the MotivoList to set
     */
    public void setFuncionarioList(List<Motivo> FuncionarioList) {
        this.setMotivoList(FuncionarioList);
    }

    /**
     * @return the selectedMot
     */
    public Motivo getSelectedMot() {
        return selectedMot;
    }

    /**
     * @param selectedMot the selectedMot to set
     */
    public void setSelectedMot(Motivo selectedMot) {
        this.selectedMot = selectedMot;
    }

    /**
     * @param service the service to set
     */
    public void setService(MotivoTableService service) {
        this.service = service;
    }

    /**
     * @return the MotivoList
     */
    public List<Motivo> getMotivoList() {
        return MotivoList;
    }

    /**
     * @param MotivoList the MotivoList to set
     */
    public void setMotivoList(List<Motivo> MotivoList) {
        this.MotivoList = MotivoList;
    }

    /**
     * @return the FilteredMotList
     */
    public List<Motivo> getFilteredMotList() {
        return FilteredMotList;
    }

    /**
     * @param FilteredMotList the FilteredMotList to set
     */
    public void setFilteredMotList(List<Motivo> FilteredMotList) {
        this.FilteredMotList = FilteredMotList;
    }
}
