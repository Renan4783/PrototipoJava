/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Funcionario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="funcionarioTable")
@ViewScoped
public class FuncionarioTable {
    private List<Funcionario> FuncionarioList;
    
    private List<Funcionario> FilteredFuncList;
    
    private Funcionario selectedFunc;
    
    @ManagedProperty("#{funcionarioTableService}")
    private FuncionarioTableService service;
    
    @PostConstruct
    public void init() {
        setService(new FuncionarioTableService());
        setFuncionarioList(service.createData());
    }

    public void refresh(){
        setService(new FuncionarioTableService());
        setFuncionarioList(service.createData());
    }
    
    /**
     * @return the FuncionarioList
     */
    public List<Funcionario> getFuncionarioList() {
        return FuncionarioList;
    }

    /**
     * @param FuncionarioList the FuncionarioList to set
     */
    public void setFuncionarioList(List<Funcionario> FuncionarioList) {
        this.FuncionarioList = FuncionarioList;
    }

    /**
     * @return the FilteredFuncList
     */
    public List<Funcionario> getFilteredFuncList() {
        return FilteredFuncList;
    }

    /**
     * @param FilteredFuncList the FilteredFuncList to set
     */
    public void setFilteredFuncList(List<Funcionario> FilteredFuncList) {
        this.FilteredFuncList = FilteredFuncList;
    }

    /**
     * @return the selectedFunc
     */
    public Funcionario getSelectedFunc() {
        return selectedFunc;
    }

    /**
     * @param selectedFunc the selectedFunc to set
     */
    public void setSelectedFunc(Funcionario selectedFunc) {
        this.selectedFunc = selectedFunc;
    }

    /**
     * @param service the service to set
     */
    public void setService(FuncionarioTableService service) {
        this.service = service;
    }
}
