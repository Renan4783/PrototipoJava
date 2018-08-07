/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Renan
 */
import bean.Funcionario;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.*;

import org.primefaces.context.RequestContext;

//Classe de controle e visão do login
@ManagedBean
public class FuncionarioLogin {

    private String login;

    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //método que verifica o login, consultando o banco de dados
    public void startSession(ActionEvent event) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        FacesMessage message = null;
        boolean loggedIn = false;
        byte[] bytestoMessage = senha.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(bytestoMessage);
        String senhastr = new String(digest, StandardCharsets.UTF_8);
        try {
            List<Funcionario> user = new LinkedList<>();
            Funcionario userBean = new Funcionario();
            FuncionarioDAO usuario = FuncionarioDAO.getSingleton();
            user = usuario.getUmUsuario(login, senhastr);
            userBean = user.get(0);
            if (usuario.getUmUsuario(login, senhastr).size() > 0) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!", login);
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", "Credenciais inválidas!");
            }
            FacesContext.getCurrentInstance().addMessage(null, message);
            session.setAttribute("ID_USER", userBean);
            context.addCallbackParam("loggedIn", loggedIn);
        } catch (IndexOutOfBoundsException ie) {
            message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario ou senha não encontrados!", "Digite corretamente ou crie uma nova conta!");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //Método que retorna o nome do usuário gravado em uma sessão
    public String requestUser() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = (HttpSession) request.getSession();
        Funcionario userReq;
        userReq = (Funcionario) session.getAttribute("ID_USER");
        return userReq.getLogin();
    }

    public Funcionario request() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = (HttpSession) request.getSession();
        Funcionario userReq;
        userReq = (Funcionario) session.getAttribute("ID_USER");
        return userReq;
    }

    //Método que destroi a sessão
    public void endSession() {
        try {
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletRequest request = (HttpServletRequest) req;
            HttpSession session = (HttpSession) request.getSession();
            session.invalidate();
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(FuncionarioLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
