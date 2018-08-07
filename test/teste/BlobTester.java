package teste;

import bean.*;
import java.util.List;
import controller.Estoque;
import controller.EstoqueTable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import model.MotivoDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Renan
 */
public class BlobTester {
    public static void main(String[] args) {
        //DatabaseCreator db = new DatabaseCreator();
        Set<CompraProduto> produtos = new HashSet<>();
        Funcionario cadastrante = new Funcionario();
        Fornecedor fornecedor = new Fornecedor();
        Motivo motivo = new Motivo();
        Compra compra = new Compra();
        ProdutoDAO func = new ProdutoDAO();
        CompraDAO compraSave = new CompraDAO();
        CompraProdutoDAO compraProdutosSave = new CompraProdutoDAO();
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        CompraProduto p1 = new CompraProduto();
        CompraProduto p2 = new CompraProduto();
        cadastrante.setCodFuncionario(2);
        cadastrante.setLogin("Admin");
        cadastrante.setSenha("Admin");
        cadastrante.setAdministrador(true);
        fornecedor.setCodFornecedor(1);
        fornecedor.setNome("Tiao");
        fornecedor.setEndereco("Rua 123");
        fornecedor.setTelefone1("999662262");
        motivo.setCodMotivo(1);
        motivo.setNome("Reposição");
        produto1.setCodProduto(1);
        produto1.setNome("Roteador ZTE");
        produto1.setDescricao("ZTE ZXHN H108N Series");
        produto2.setCodProduto(2);
        produto2.setNome("Airgrid");
        produto2.setDescricao("M1000 Series");
        p1.setCompra(compra);
        p1.setProduto(produto1);
        p1.setQuantidade(5);
        p1.setCompra(compra);
        p2.setProduto(produto2);
        p2.setQuantidade(3);
        produtos.add(p1);
        produtos.add(p2);
        compra.setCadastrante(cadastrante);
        compra.setDataCompra("04-10-2017");
        compra.setFornecedor(fornecedor);
        compra.setMotivo(motivo);
        compra.setProdutos(produtos);
        try {
            compraSave.setCompra(compra);
            compraProdutosSave.setCompraProduto(p1);
            compraProdutosSave.setCompraProduto(p2);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(BlobTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
