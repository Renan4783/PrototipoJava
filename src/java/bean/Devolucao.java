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
@Table(name="Devolucao")
public class Devolucao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codMovimentacao;
    
    @ManyToOne
    private Funcionario cadastrante;
    
    private String dataDevolucao;
    
    @ManyToOne
    private Saida saida;
    
    @ManyToOne
    private Motivo motivo;
        
    @OneToMany(mappedBy = "produto")
    private Set<DevolucaoProduto> produtos;
    
    
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
     * @return the dataDevolucao
     */
    public String getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
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
     * @return the produtos
     */
    public Set<DevolucaoProduto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Set<DevolucaoProduto> produtos) {
        this.produtos = produtos;
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
}
