/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "Funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codFuncionario;

    private String login;

    private String senha;

    private boolean administrador;

    @OneToMany(mappedBy = "cadastrante")
    private final Set<Compra> compras = new HashSet<>();

    @OneToMany(mappedBy = "cadastrante")
    private final Set<Saida> saidas = new HashSet<>();

    @OneToMany(mappedBy = "cadastrante")
    private final Set<Devolucao> devolucoes = new HashSet<>();
    
    /**
     * @return the codFuncionario
     */
    public long getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the administrador
     */
    public boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param administrador the administrador to set
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    /**
     * @return the compras
     */
    public Set<Compra> getCompras() {
        return compras;
    }

    /**
     * @return the saidas
     */
    public Set<Saida> getSaidas() {
        return saidas;
    }

    /**
     * @return the devolucoes
     */
    public Set<Devolucao> getDevolucoes() {
        return devolucoes;
    }

}
