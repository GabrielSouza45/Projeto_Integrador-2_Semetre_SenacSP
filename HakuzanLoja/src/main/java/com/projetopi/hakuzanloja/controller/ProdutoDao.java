/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.Categoria;
import com.projetopi.hakuzanloja.model.Produto;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends ConectarDao implements CrudDao<Produto> {

    /*Criação de tabela para caso o db atual dê problema*/
    @Override
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

    @Override
    public void cadastrar(Produto produto){

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

    @Override
    public void editar(Produto produto) {

        String sql = "UPDATE TB_PRODUTO SET DS_NOME = ?, DS_DESCRICAO = ?, VL_COMPRA = ?, VL_VENDA = ?, FK_CATEGORIA = ? " +
                " WHERE PK_ID = ?";

        try (PreparedStatement ps = (PreparedStatement)
                getConexao().prepareStatement(sql)) {

            ps.setString(1, produto.getProduto());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValorCompra());
            ps.setDouble(4, produto.getValor());
            ps.setLong(5, produto.getCategoria().getId());
            ps.setLong(6, produto.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Produto. \n" + err.getMessage());
        }
    }

    public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {

        String sql = "SELECT * FROM TB_PRODUTO WHERE FK_CATEGORIA = ?";

        try (PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql)) {

            ps.setLong(1, categoria.getId());

            ResultSet res = ps.executeQuery();

            List<Produto> prods = new ArrayList<>();
            while (res.next()){
                Produto prod = new Produto();
                prod.setId(res.getLong("PK_ID"));
                prod.setProduto(res.getString("DS_NOME"));
                prod.setDescricao(res.getString("DS_DESCRICAO"));
                prod.setValor(res.getDouble("VL_VENDA"));
                prod.setValorCompra(res.getDouble("VL_COMPRA"));
                prod.setCategoria(categoria);

                prods.add(prod);
            }

            return prods;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produtos. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public void excluir(Produto prod){

        String sql = "DELETE FROM TB_PRODUTO WHERE PK_ID = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {

            ps.setLong(1, prod.getId());
            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum Produto encontrado com o ID fornecido.");
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Produto. " + err.getMessage());
        }

    }

    public List<Produto> listarProdutos(){
        String sql = "SELECT * FROM TB_PRODUTO";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<Produto> produtoList = new ArrayList<>();

            while(res.next()){
                Produto produto = new Produto();
                produto.setId(res.getLong("PK_ID"));
                produto.setProduto(res.getString("DS_NOME"));
                produto.setDescricao(res.getString("DS_DESCRICAO"));
                produto.setValor(res.getDouble("VL_COMPRA"));
                produto.setValorCompra(res.getDouble("VL_VENDA"));
                produto.setCategoria(new CategoriaDao().buscarCategoriaPorId(res.getLong("FK_CATEGORIA")));

                produtoList.add(produto);
            }

            return produtoList;

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }



    public List<Produto> buscarProdutoPorNome(Produto produto){
        String sql = "SELECT * FROM TB_PRODUTO WHERE DS_NOME = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setString(1, produto.getProduto());

            ResultSet res = ps.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while(res.next()){
                Produto produto1 = new Produto();
                produto1.setId(res.getLong("PK_ID"));
                produto1.setProduto(res.getString("DS_NOME"));
                produto1.setDescricao(res.getString("DS_DESCRICAO"));
                produto1.setValor(res.getDouble("VL_COMPRA"));
                produto1.setValorCompra(res.getDouble("VL_VENDA"));
                produto1.setCategoria(new CategoriaDao().buscarCategoriaPorId(res.getLong("FK_CATEGORIA")));

                produtos.add(produto1);
            }

            return produtos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto. \n" + err.getMessage());
            return null;
        }
    }

    public List<Produto> buscarProdutoPorDescricao(Produto produto){
        String sql = "SELECT * FROM TB_PRODUTO WHERE DS_DESCRICAO = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setString(1, produto.getDescricao());

            ResultSet res = ps.executeQuery();

            List<Produto> produtos = new ArrayList<>();

            while(res.next()){
                Produto produto1 = new Produto();
                produto1.setId(res.getLong("PK_ID"));
                produto1.setProduto(res.getString("DS_NOME"));
                produto1.setDescricao(res.getString("DS_DESCRICAO"));
                produto1.setValor(res.getDouble("VL_COMPRA"));
                produto1.setValorCompra(res.getDouble("VL_VENDA"));
                produto1.setCategoria(new CategoriaDao().buscarCategoriaPorId(res.getLong("FK_CATEGORIA")));

                produtos.add(produto1);
            }

            return produtos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar a Descricao. \n" + err.getMessage());
            return null;
        }
    }
}
