/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Renan
 */
@Entity
@Table(name="Motivo")
public class Motivo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codMotivo;
    
    private String nome;

    /**
     * @return the codMotivo
     */
    public long getCodMotivo() {
        return codMotivo;
    }

    /**
     * @param codMotivo the codMotivo to set
     */
    public void setCodMotivo(long codMotivo) {
        this.codMotivo = codMotivo;
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
}
