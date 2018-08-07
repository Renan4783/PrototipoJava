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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Produto")
public class Produto implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codProduto;
    
    private String nome;
    
    private String descricao;

    @OneToMany(mappedBy = "compra")
    private Set<CompraProduto> compras;

    @OneToMany(mappedBy = "devolucao")
    private Set<DevolucaoProduto> devolucoes;

    @OneToMany(mappedBy = "saida")
    private Set<SaidaProduto> saidas;
    
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the compras
     */
    public Set<CompraProduto> getCompras() {
        return compras;
    }

    /**
     * @return the devolucoes
     */
    public Set<DevolucaoProduto> getDevolucoes() {
        return devolucoes;
    }

    /**
     * @return the saidas
     */
    public Set<SaidaProduto> getSaidas() {
        return saidas;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(Set<CompraProduto> compras) {
        this.compras = compras;
    }

    /**
     * @param devolucoes the devolucoes to set
     */
    public void setDevolucoes(Set<DevolucaoProduto> devolucoes) {
        this.devolucoes = devolucoes;
    }

    /**
     * @param saidas the saidas to set
     */
    public void setSaidas(Set<SaidaProduto> saidas) {
        this.saidas = saidas;
    }

}
