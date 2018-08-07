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
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "Tecnico")
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codTecnico;

    private String nome;

    private String telefone1;
    
    private String telefone2;

    @ManyToMany(mappedBy = "tecnicos")
    private Set<Saida> saidas;

    /**
     * @return the codTecnico
     */
    public long getCodTecnico() {
        return codTecnico;
    }

    /**
     * @param codTecnico the codTecnico to set
     */
    public void setCodTecnico(long codTecnico) {
        this.codTecnico = codTecnico;
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
     * @return the telefone1
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     * @param telefone1 the telefone1 to set
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * @param telefone2 the telefone2 to set
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    /**
     * @return the saidas
     */
    public Set<Saida> getSaidas() {
        return saidas;
    }

    /**
     * @param saidas the saidas to set
     */
    public void setSaidas(Set<Saida> saidas) {
        this.saidas = saidas;
    }

    

}
