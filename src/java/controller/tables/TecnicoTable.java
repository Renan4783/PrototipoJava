/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Tecnico;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="tecnicoTable")
@ViewScoped
public class TecnicoTable {
    private List<Tecnico> TecnicoList;
    
    private List<Tecnico> FilteredTecList;
    
    private Tecnico selectedTec;
    
    @ManagedProperty("#{tecnicoTableService}")
    private TecnicoTableService service;
    
    @PostConstruct
    public void init() {
        setService(new TecnicoTableService());
        setTecnicoList(getService().createData());
    }

    public void refresh(){
        setService(new TecnicoTableService());
        setTecnicoList(getService().createData());
    }
    
    /**
     * @return the FuncionarioList
     */
    public List<Tecnico> getFuncionarioList() {
        return TecnicoList;
    }

    /**
     * @param FuncionarioList the FuncionarioList to set
     */
    public void setFuncionarioList(List<Tecnico> FuncionarioList) {
        this.TecnicoList = FuncionarioList;
    }

    /**
     * @return the FilteredFuncList
     */
    public List<Tecnico> getFilteredFuncList() {
        return FilteredTecList;
    }

    /**
     * @param FilteredFuncList the FilteredFuncList to set
     */
    public void setFilteredFuncList(List<Tecnico> FilteredFuncList) {
        this.FilteredTecList = FilteredFuncList;
    }

    /**
     * @return the selectedFunc
     */
    public Tecnico getSelectedFunc() {
        return selectedTec;
    }

    /**
     * @param selectedFunc the selectedFunc to set
     */
    public void setSelectedFunc(Tecnico selectedFunc) {
        this.selectedTec = selectedFunc;
    }


    /**
     * @return the TecnicoList
     */
    public List<Tecnico> getTecnicoList() {
        return TecnicoList;
    }

    /**
     * @param TecnicoList the TecnicoList to set
     */
    public void setTecnicoList(List<Tecnico> TecnicoList) {
        this.TecnicoList = TecnicoList;
    }

    /**
     * @return the FilteredTecList
     */
    public List<Tecnico> getFilteredTecList() {
        return FilteredTecList;
    }

    /**
     * @param FilteredTecList the FilteredTecList to set
     */
    public void setFilteredTecList(List<Tecnico> FilteredTecList) {
        this.FilteredTecList = FilteredTecList;
    }

    /**
     * @return the selectedTec
     */
    public Tecnico getSelectedTec() {
        return selectedTec;
    }

    /**
     * @param selectedTec the selectedTec to set
     */
    public void setSelectedTec(Tecnico selectedTec) {
        this.selectedTec = selectedTec;
    }

    /**
     * @return the service
     */
    public TecnicoTableService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(TecnicoTableService service) {
        this.service = service;
    }
}
