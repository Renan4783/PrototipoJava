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
@Table(name="Devolucao_Produto")
public class DevolucaoProduto implements Serializable {
    
    @Id
    @Column(name = "devolucoes_codMovimentacao")
    private long codMovimentacao;
    
    @Id
    @Column(name = "devolucoes_codProduto")
    private long codProduto;
    
    @ManyToOne
    @JoinColumn(name = "devolucoes_codMovimentacao")
    private Devolucao devolucao;
    
    @ManyToOne
    @JoinColumn(name = "devolucoes_codProduto")
    private Produto produto;
    
    private int quantidade;

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
