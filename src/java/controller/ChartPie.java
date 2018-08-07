/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Renan
 */

@ManagedBean
public class ChartPie implements Serializable {
 
    private PieChartModel pieModel;
 
    @PostConstruct
    public void init() {
        createPieModel();
    }
 
    public PieChartModel getPieModel() {
        return pieModel;
    }
     
 
    private void createPieModel() {
        pieModel = new PieChartModel();
         
        pieModel.set("Situação normal", 540);
        pieModel.set("Estoque zerado", 325);
        pieModel.set("Abaixo de uma quantidade definida", 702);
         
        pieModel.setTitle("Porcentagem de estoque (Produtos)");
        pieModel.setLegendPosition("w");
        pieModel.setShowDataLabels(true);
    }
     
     
}
