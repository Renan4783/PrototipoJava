/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.Cliente;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Renan
 */
@ManagedBean(name="clienteTable")
@ViewScoped
public class ClienteTable {
    private List<Cliente> ClienteList;
    
    private List<Cliente> FilteredCliList;
    
    private Cliente selectedCli;
    
    @ManagedProperty("#{clienteTableService}")
    private ClienteTableService service;
    
    @PostConstruct
    public void init() {
        setService(new ClienteTableService());
        setClienteList(getService().createData());
    }

    public void refresh(){
        setService(new ClienteTableService());
        setClienteList(getService().createData());
    }
    
    /**
     * @return the FuncionarioList
     */
    public List<Cliente> getClienteList() {
        return ClienteList;
    }

    /**
     * @param FuncionarioList the FuncionarioList to set
     */
    public void setClienteList(List<Cliente> FuncionarioList) {
        this.ClienteList = FuncionarioList;
    }

    /**
     * @return the FilteredFuncList
     */
    public List<Cliente> getFilteredFuncList() {
        return FilteredCliList;
    }

    /**
     * @param FilteredFuncList the FilteredFuncList to set
     */
    public void setFilteredFuncList(List<Cliente> FilteredFuncList) {
        this.FilteredCliList = FilteredFuncList;
    }

    /**
     * @return the selectedFunc
     */
    public Cliente getSelectedFunc() {
        return selectedCli;
    }

    /**
     * @param selectedFunc the selectedFunc to set
     */
    public void setSelectedFunc(Cliente selectedFunc) {
        this.selectedCli = selectedFunc;
    }


    /**
     * @return the ClienteList
     */
    public List<Cliente> getFornecedorList() {
        return ClienteList;
    }

    /**
     * @param FornecedorList the ClienteList to set
     */
    public void setFornecedorList(List<Cliente> FornecedorList) {
        this.ClienteList = FornecedorList;
    }

    /**
     * @return the FilteredCliList
     */
    public List<Cliente> getFilteredForList() {
        return FilteredCliList;
    }

    /**
     * @param FilteredForList the FilteredCliList to set
     */
    public void setFilteredForList(List<Cliente> FilteredForList) {
        this.FilteredCliList = FilteredForList;
    }

    /**
     * @return the selectedCli
     */
    public Cliente getSelectedCli() {
        return selectedCli;
    }

    /**
     * @param selectedCli the selectedCli to set
     */
    public void setSelectedCli(Cliente selectedCli) {
        this.selectedCli = selectedCli;
    }

    /**
     * @return the service
     */
    public ClienteTableService getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(ClienteTableService service) {
        this.service = service;
    }
}
