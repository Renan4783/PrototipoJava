/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tables;

import bean.CompraProduto;
import bean.Produto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.ProdutoDAO;

/**
 *
 * @author Renan
 */
@ManagedBean(name="compraProdutoTable")
@ViewScoped
public class CompraProdutoTable {
    
    private Produto item;
    
    private int quantidade;
    
    private List<CompraProduto> itens;
    
    private List<Produto> produtos;
    
    
    @PostConstruct
    public void init(){
        ProdutoDAO menuProd = ProdutoDAO.getSingleton();
        setProdutos(menuProd.getProduto());
    }

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the item
     */
    public Produto getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Produto item) {
        this.item = item;
    }

    /**
     * @return the itens
     */
    public List<CompraProduto> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<CompraProduto> itens) {
        this.itens = itens;
    }

    
    public void addItem(){
        CompraProduto itemLista = new CompraProduto();
        itemLista.setProduto(getItem());
        itemLista.setQuantidade(getQuantidade());
        itens.add(itemLista);
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
