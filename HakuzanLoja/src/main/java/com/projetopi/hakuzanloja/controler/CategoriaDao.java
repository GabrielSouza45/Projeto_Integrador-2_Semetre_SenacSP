/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler;

import com.projetopi.hakuzanloja.model.Categoria;
import com.projetopi.hakuzanloja.model.Produto;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

        Categoria cat = this.verificarSeCategoriaExiste(categoria.getCategoria());
        if (cat != null) {
            JOptionPane.showMessageDialog(null, "Categoria já cadastrada!");
            return;
        }

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

    public void editarCategoria(Categoria categoria) {

        Categoria cat = this.verificarSeCategoriaExiste(categoria.getCategoria());
        if (cat != null) {
            JOptionPane.showMessageDialog(null, "Categoria já cadastrada!");
            return;
        }

        String sql = "UPDATE TB_CATEGORIA SET DS_TIPO = ? WHERE PK_ID = ?";

        try (PreparedStatement ps = (PreparedStatement)
                getConexao().prepareStatement(sql)) {

            ps.setString(1, categoria.getCategoria());
            ps.setLong(2, categoria.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Categoria editado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao editar categoria. \n" + err.getMessage());
        }
    }

    private Categoria verificarSeCategoriaExiste(String tipo) {
        String sql = "SELECT * FROM TB_CATEGORIA WHERE DS_TIPO LIKE (?)";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            String item = "%" + tipo + "%";

            ps.setString(1, item);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                Categoria cat = new Categoria();
                cat.setId(res.getLong("PK_ID"));
                cat.setCategoria(res.getString("DS_TIPO"));
                return cat;
            } else {
                return null;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar existencia da categoria. \n" + err.getMessage());
            return null;
        }
    }


    public void excluirCategoria(Categoria categoria) {

        List<Produto> produtos = new ProdutoDao().buscarProdutosPorCategoria(categoria);
        if (!produtos.isEmpty()) {
            int opcao = JOptionPane.showOptionDialog(
                    null,
                    "Existem produtos utilizando esta categoria, deseja continuar?",
                    "Risco de quebra de Banco!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new String[]{"Sim", "Não"},
                    "Não"
            );

            if (opcao == 1) {
                return;
            }
        }

        String sql = "DELETE FROM TB_CATEGORIA WHERE PK_ID = ?";

        try (PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql)) {

            ps.setLong(1, categoria.getId());

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrado com o ID fornecido.");
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Categoria. \n" +  err.getMessage());
        }
    }
}
