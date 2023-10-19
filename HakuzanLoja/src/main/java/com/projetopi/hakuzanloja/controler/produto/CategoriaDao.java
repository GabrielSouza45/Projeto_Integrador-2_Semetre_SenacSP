/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler.produto;

import com.projetopi.hakuzanloja.controler.ConectarDao;
import com.projetopi.hakuzanloja.model.produto.Categoria;
import com.projetopi.hakuzanloja.model.produto.Produto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDao extends ConectarDao{


    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela() {
        String sql = "CREATE TABLE TB_CATEGORIA("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_TIPO VARCHAR(30) NOT NULL,"
                + "PRIMARY KEY(PK_ID));";

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

        String sql = "INSERT INTO TB_CATEGORIA (DS_TIPO)"
                + "VALUES ('CALÇA')";

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

    public void cadastrarCategoria(Categoria categoria){

        String sql =   "INSERT INTO TB_CATEGORIA (DS_TIPO)"
                + "VALUES (?)";
        try {
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso!");

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Categoria. " + err.getMessage());
        }
    }

}
