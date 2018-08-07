/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Produto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="produtoTable")
@ViewScoped
public class ProdutoTable {
    private List<Produto> ProdutoList;
    
    private List<Produto> FilteredProdList;
    
    private Produto selectedProd;
    
    @ManagedProperty("#{produtoTableService}")
    private ProdutoTableService service;
    
    @PostConstruct
    public void init() {
        setService(new ProdutoTableService());
        setProdutoList(getService().createData());
    }

    public void refresh(){
        setService(new ProdutoTableService());
        setProdutoList(getService().createData());
    }
    
    /**
     * @return the FuncionarioList
     */
    public List<Produto> getFuncionarioList() {
        return ProdutoList;
    }

    /**
     * @param FuncionarioList the FuncionarioList to set
     */
    public void setFuncionarioList(List<Produto> FuncionarioList) {
        this.ProdutoList = FuncionarioList;
    }

    /**
     * @return the FilteredFuncList
     */
    public List<Produto> getFilteredFuncList() {
        return FilteredProdList;
    }

    /**
     * @param FilteredFuncList the FilteredFuncList to set
     */
    public void setFilteredFuncList(List<Produto> FilteredFuncList) {
        this.FilteredProdList = FilteredFuncList;
    }

    /**
     * @return the selectedFunc
     */
    public Produto getSelectedFunc() {
        return selectedProd;
    }

    /**
     * @param selectedFunc the selectedFunc to set
     */
    public void setSelectedFunc(Produto selectedFunc) {
        this.selectedProd = selectedFunc;
    }


    /**
     * @return the ProdutoList
     */
    public List<Produto> getProdutoList() {
        return ProdutoList;
    }

    /**
     * @param ProdutoList the ProdutoList to set
     */
    public void setProdutoList(List<Produto> ProdutoList) {
        this.ProdutoList = ProdutoList;
    }

    /**
     * @return the FilteredProdList
     */
    public List<Produto> getFilteredProdList() {
        return FilteredProdList;
    }

    /**
     * @param FilteredProdList the FilteredProdList to set
     */
    public void setFilteredProdList(List<Produto> FilteredProdList) {
        this.FilteredProdList = FilteredProdList;
    }

    /**
     * @return the selectedProd
     */
    public Produto getSelectedProd() {
        return selectedProd;
    }

    /**
     * @param selectedProd the selectedProd to set
     */
    public void setSelectedProd(Produto selectedProd) {
        this.selectedProd = selectedProd;
    }

    /**
     * @return the service
     */
    public ProdutoTableService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(ProdutoTableService service) {
        this.service = service;
    }

}

