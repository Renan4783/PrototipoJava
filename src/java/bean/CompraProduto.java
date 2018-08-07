/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Compra_Produto")
public class CompraProduto implements Serializable {
    
    @Id
    @Column(name = "compras_codMovimentacao")
    private long codMovimentacao;
    
    @Id
    @Column(name = "compras_codProduto")
    private long codProduto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("codMovimentacao")
    @JoinColumn(name = "compras_codMovimentacao")
    private Compra compra;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("codProduto")
    @JoinColumn(name = "compras_codProduto")
    private Produto produto;
    
    private int quantidade;
    
    private int preco;

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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

    /**
     * @return the codMovimentacao
     */
    public long getCodMovimentacao() {
        return codMovimentacao;
    }

    /**
     * @param codMovimentacao the codMovimentacao to set
     */
    public void setCodMovimentacao(long codMovimentacao) {
        this.codMovimentacao = codMovimentacao;
    }

    /**
     * @return the codProduto
     */
    public long getCodProduto() {
        return codProduto;
    }

    /**
     * @param codProduto the codProduto to set
     */
    public void setCodProduto(long codProduto) {
        this.codProduto = codProduto;
    }

    /**
     * @return the preco
     */
    public int getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(int preco) {
        this.preco = preco;
    }
}
