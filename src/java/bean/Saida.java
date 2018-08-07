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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Saida")
public class Saida implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codMovimentacao;
    
    @ManyToOne
    private Funcionario cadastrante;
    
    private String dataSaida;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Motivo motivo;
    
    @ManyToMany
    private Set<Tecnico> tecnicos;
    
    @OneToMany(mappedBy = "produto") 
    private Set<SaidaProduto> produtos;

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
     * @return the dataSaida
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
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
     * @return the tecnicos
     */
    public Set<Tecnico> getTecnicos() {
        return tecnicos;
    }

    /**
     * @return the produtos
     */
    public Set<SaidaProduto> getProdutos() {
        return produtos;
    }

    /**
     * @param tecnicos the tecnicos to set
     */
    public void setTecnicos(Set<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Set<SaidaProduto> produtos) {
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
