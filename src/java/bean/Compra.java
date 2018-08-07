/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Compra")
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codMovimentacao;
    
    @ManyToOne
    private Funcionario cadastrante;
    
    private String dataCompra;
    
    @ManyToOne
    private Fornecedor fornecedor;
    
    @ManyToOne
    private Motivo motivo;

    @OneToMany(mappedBy = "produto")
    private Set<CompraProduto> produtos;
    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
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
     * @return the cadastrante
     */
    public Funcionario getCadastrante() {
        return cadastrante;
    }

    /**
     * @param cadastrante the cadastrante to set
     */
    public void setCadastrante(Funcionario cadastrante) {
        this.cadastrante = cadastrante;
    }

    /**
     * @return the dataCompra
     */
    public String getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    /**
     * @return the motivo
     */
    public Motivo getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the produtos
     */
    public Set<CompraProduto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Set<CompraProduto> produtos) {
        this.produtos = produtos;
    }
}
