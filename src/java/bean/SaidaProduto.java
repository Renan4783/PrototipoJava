/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Saida_Produto")
public class SaidaProduto implements Serializable {
   
    @Id
    @Column(name = "saidas_codMovimentacao")
    private long codMovimentacao;

    @Id
    @Column(name = "saidas_codProduto")
    private long codProduto;
    
    @ManyToOne
    @JoinColumn(name = "saidas_codMovimentacao")
    private Saida saida;
    
    @ManyToOne
    @JoinColumn(name = "saidas_codProduto")
    private Produto produto;
    
    private int quantidade;

    /**
     * @return the saida
     */
    public Saida getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(Saida saida) {
        this.saida = saida;
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
}
