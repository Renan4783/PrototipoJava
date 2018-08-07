/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.wizard;

import bean.Devolucao;

/**
 *
 * @author Renan
 */
public class DevolucaoWizard {
    
    private Devolucao devolucao = new Devolucao();

    private void save(){
        
    }
    
    /**
     * @return the devolucao
     */
    public Devolucao getDevolucao() {
        return devolucao;
    }

    /**
     * @param devolucao the devolucao to set
     */
    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
    
}
