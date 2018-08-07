/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Renan
 */
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="estoqueTable")
@ViewScoped
public class EstoqueTable implements Serializable {
     
    private List<Estoque> dataList;
     
    private List<Estoque> filteredDataList;
     
    private Estoque selectedData;
     
    @ManagedProperty("#{dataTableService}")
    private EstoqueTableService service;
 
    @PostConstruct
    public void init() {
        service = new EstoqueTableService();
        dataList = service.createData();
    }
     
    public List<String> getBrands() {
        return service.getBrands();
    }
     
    public List<String> getColors() {
        return service.getColors();
    }
     
    public List<Estoque> getDataList() {
        return dataList;
    }
 
    public List<Estoque> getFilteredDataList() {
        return filteredDataList;
    }
 
    public Estoque getSelectedData() {
        return selectedData;
    }
 
    public void setSelectedData(Estoque selectedData) {
        this.selectedData = selectedData;
    }
 
    public void setFilteredDataList(List<Estoque> filteredDataList) {
        this.filteredDataList = filteredDataList;
    }
 
    public void setService(EstoqueTableService service) {
        this.service = service;
    }
}
