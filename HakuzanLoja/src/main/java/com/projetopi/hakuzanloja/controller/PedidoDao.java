/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.Pedido;

import javax.swing.*;
import java.sql.Date;
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

    public void cadastrarPedido(Pedido pedido) {

        String sql = "INSERT INTO TB_PEDIDO (DT_PEDIDO, VL_TOTAL , FK_USUARIO)"
                + "VALUES (?, ?, ?);";
        try {
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setDate(1, (Date) pedido.getData());
            ps.setDouble(2, pedido.getValorTotal());
            ps.setLong(3, pedido.getUsuario().getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Produto. \n" + err.getMessage());
        }
    }





}
