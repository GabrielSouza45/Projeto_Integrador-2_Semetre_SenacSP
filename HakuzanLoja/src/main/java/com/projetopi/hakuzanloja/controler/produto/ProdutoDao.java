/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler.produto;

import com.projetopi.hakuzanloja.controler.ConectarDao;
import com.projetopi.hakuzanloja.model.produto.Produto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDao extends ConectarDao{

    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela() {
        String sql = "CREATE TABLE TB_PRODUTO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_NOME VARCHAR(70) NOT NULL,"
                + "DS_DESCRICAO VARCHAR(255),"
                + "VL_COMPRA NUMERIC(14,2),"
                + "VL_VENDA NUMERIC(14,2),"
                + "FK_CATEGORIA INT, "
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_CATEGORIA) REFERENCES TB_CATEGORIA(PK_ID));";

        PreparedStatement ps = null;

        try {
            ps = getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Banco Criado");
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void insertInicial() {

        String sql = "INSERT INTO TB_PRODUTO (DS_NOME, DS_DESCRICAO, VL_COMPRA, VL_VENDA, FK_CATEGORIA)"
                + "VALUES ('Produto 1', 'Descrição do Produto 1', 50.00, 75.00, 1);";

        PreparedStatement ps = null;
        try {
            ps = getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Inset");
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

    }

    public void cadastrarProduto(Produto produto){

        String sql =  "INSERT INTO TB_PRODUTO (DS_NOME, DS_DESCRICAO, VL_COMPRA, VL_VENDA, FK_CATEGORIA)"
                + "VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, produto.getProduto());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(1, produto.getValorCompra());
            ps.setDouble(1, produto.getValor());
            ps.setLong(1, produto.getCategoria().getId());
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Produto. " + err.getMessage());
        }
    }

}
