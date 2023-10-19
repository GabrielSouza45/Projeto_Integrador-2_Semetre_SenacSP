/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler.pedido;

import com.projetopi.hakuzanloja.controler.ConectarDao;
import com.projetopi.hakuzanloja.model.produto.Produto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDao extends ConectarDao{


    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela() {
        String sql = "CREATE TABLE TB_PEDIDO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "VL_TOTAL DECIMAL(14,2),"
                + "DT_PEDIDO DATE,TG_STATUS VARCHAR(1),"
                + "FK_USUARIO INT,"
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_USUARIO)REFERENCES TB_USUARIO(PK_ID));";


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


    public void cadastrarProduto(Produto produto) {

        String sql = "INSERT INTO TB_PEDIDO (DT_PEDIDO, VL_TOTAL , FK_USUARIO)"
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

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Produto. " + err.getMessage());
        }
    }

}
