/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Fornecedor;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="fornecedorTable")
@ViewScoped
public class FornecedorTable {
    private List<Fornecedor> FornecedorList;
    
    private List<Fornecedor> FilteredForList;
    
    private Fornecedor selectedFor;
    
    @ManagedProperty("#{fornecedorTableService}")
    private FornecedorTableService service;
    
    @PostConstruct
    public void init() {
        setService(new FornecedorTableService());
        setFornecedorList(getService().createData());
    }

    public void refresh(){
        setService(new FornecedorTableService());
        setFornecedorList(getService().createData());
    }
    
    /**
     * @return the FuncionarioList
     */
    public List<Fornecedor> getFuncionarioList() {
        return FornecedorList;
    }

    /**
     * @param FuncionarioList the FuncionarioList to set
     */
    public void setFuncionarioList(List<Fornecedor> FuncionarioList) {
        this.FornecedorList = FuncionarioList;
    }

    /**
     * @return the FilteredFuncList
     */
    public List<Fornecedor> getFilteredFuncList() {
        return FilteredForList;
    }

    /**
     * @param FilteredFuncList the FilteredFuncList to set
     */
    public void setFilteredFuncList(List<Fornecedor> FilteredFuncList) {
        this.FilteredForList = FilteredFuncList;
    }

    /**
     * @return the selectedFunc
     */
    public Fornecedor getSelectedFunc() {
        return selectedFor;
    }

    /**
     * @param selectedFunc the selectedFunc to set
     */
    public void setSelectedFunc(Fornecedor selectedFunc) {
        this.selectedFor = selectedFunc;
    }


    /**
     * @return the FornecedorList
     */
    public List<Fornecedor> getFornecedorList() {
        return FornecedorList;
    }

    /**
     * @param FornecedorList the FornecedorList to set
     */
    public void setFornecedorList(List<Fornecedor> FornecedorList) {
        this.FornecedorList = FornecedorList;
    }

    /**
     * @return the FilteredForList
     */
    public List<Fornecedor> getFilteredForList() {
        return FilteredForList;
    }

    /**
     * @param FilteredForList the FilteredForList to set
     */
    public void setFilteredForList(List<Fornecedor> FilteredForList) {
        this.FilteredForList = FilteredForList;
    }

    /**
     * @return the selectedFor
     */
    public Fornecedor getSelectedFor() {
        return selectedFor;
    }

    /**
     * @param selectedFor the selectedFor to set
     */
    public void setSelectedFor(Fornecedor selectedFor) {
        this.selectedFor = selectedFor;
    }

    /**
     * @return the service
     */
    public FornecedorTableService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(FornecedorTableService service) {
        this.service = service;
    }
}
