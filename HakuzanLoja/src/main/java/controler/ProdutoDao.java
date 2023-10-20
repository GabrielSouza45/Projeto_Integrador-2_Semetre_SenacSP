/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import com.projetopi.hakuzanloja.controler.produto.*;
import controler.ConectarDao;
import com.projetopi.hakuzanloja.model.produto.Categoria;
import com.projetopi.hakuzanloja.model.produto.Produto;
import com.projetopi.hakuzanloja.model.usuario.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void editarProduto(Produto produto) {

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

    public void deletarProduto(Usuario user){

        String sql = "DELETE FROM TB_PRODUTO WHERE PK_ID = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {

            ps.setLong(1, user.getId());
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

}
