/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.ItemPedido;
import com.projetopi.hakuzanloja.model.Pedido;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ItensPedidoDao extends ConectarDao implements CrudDao<ItemPedido> {


    /*Criação de tabela para caso o db atual dê problema*/
    @Override
    public void criarTabela() {
        String sql = "CREATE TABLE TB_ITENSPEDIDO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "FK_PRODUTO INT NOT NULL,"
                + "QT_PRODUTO INT NOT NULL,"
                + "VL_UNITARIO NUMERIC(14,2) NOT NULL,"
                + "VL_TOTAL NUMERIC(14,2) NOT NULL,"
                + "FK_PEDIDO INT NOT NULL,"
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_PEDIDO) REFERENCES TB_PEDIDO(PK_ID));";

        PreparedStatement ps = null;

        try {
            ps = ConectarDao.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Banco Criado");
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    @Override
    public void cadastrar(ItemPedido itemPedido) {

        String sql = "INSERT INTO TB_ITENSPEDIDO (FK_PRODUTO, QT_PRODUTO, VL_UNITARIO, VL_TOTAL, FK_PEDIDO) " +
                " VALUES (?, ?, ?, ?, ?)";

        try{

            double total = itemPedido.getProduto().getValor() * itemPedido.getQuantidade();

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setLong(1, itemPedido.getProduto().getId());
            ps.setInt(2, itemPedido.getQuantidade());
            ps.setDouble(3, itemPedido.getProduto().getValor());
            ps.setDouble(4, total);
            ps.setLong(5, itemPedido.getPedido().getId());

            ps.execute();

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar item no pedido. \n"
                    + itemPedido.getProduto().getProduto() + "\n"
                    + err.getMessage());
        }

    }

    @Override
    public void editar(ItemPedido itemPedido) {

        String sql = "UPDATE TB_ITENSPEDIDO QT_PRODUTO=?, VL_UNITARIO=?, VL_TOTAL=?) WHERE PK_ID=? ";

        try{

            double total = itemPedido.getProduto().getValor() * itemPedido.getQuantidade();

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setInt(1, itemPedido.getQuantidade());
            ps.setDouble(2, itemPedido.getValorUnitario());
            ps.setDouble(3, total);
            ps.setLong(4, itemPedido.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Pedido editado com sucesso.");

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao editar item. \n"
                    + itemPedido.getProduto().getProduto() + "\n"
                    + err.getMessage());
        }


    }

    @Override
    public void excluir(ItemPedido itemPedido) {

        String sql = "DELETE FROM TB_ITENSPEDIDO WHERE PK_ID=?";

        try{

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setLong(1, itemPedido.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Item deletado com sucesso.");

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar item. \n"
                    + itemPedido.getProduto().getProduto() + "\n"
                    + err.getMessage());
        }


    }

    public List<ItemPedido> buscarPorPedido(Pedido pedido){
        String sql = "SELECT * FROM TB_ITENSPEDIDO WHERE FK_PEDIDO = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, pedido.getId());

            ResultSet res = ps.executeQuery();

            List<ItemPedido> itemPedidos = new ArrayList<>();

            while(res.next()){
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setId(res.getLong("PK_ID"));
                itemPedido.setPedido(pedido);
                itemPedido.setQuantidade(res.getInt("QT_PRODUTO"));
                itemPedido.setQuantidade(res.getInt("VL_TOTAL"));
                itemPedido.setValorUnitario(res.getDouble("VL_UNITARIO"));

                itemPedidos.add(itemPedido);
            }

            return itemPedidos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Pedido. \n" + err.getMessage());
            return null;
        }
    }

    public List<ItemPedido> buscarPorId(ItemPedido itemPedido){
        String sql = "SELECT * FROM TB_ITENSPEDIDO WHERE PK_ID = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, itemPedido.getId());

            ResultSet res = ps.executeQuery();

            List<ItemPedido> itemPedidos = new ArrayList<>();

            while(res.next()){
                ItemPedido itemPedido1 = new ItemPedido();
                itemPedido1.setId(res.getLong("PK_ID"));
                itemPedido1.setPedido(new PedidoDao().buscarPorId(res.getLong("FK_PEDIDO")));
                itemPedido1.setQuantidade(res.getInt("QT_PRODUTO"));
                itemPedido1.setQuantidade(res.getInt("VL_TOTAL"));
                itemPedido1.setValorUnitario(res.getDouble("VL_UNITARIO"));

                itemPedidos.add(itemPedido1);
            }

            return itemPedidos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Id. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public List<ItemPedido> listarTodos(){
        String sql = "SELECT * FROM TB_ITENSPEDIDO";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<ItemPedido> itemPedidos = new ArrayList<>();

            while(res.next()){
                ItemPedido itemPedido1 = new ItemPedido();
                itemPedido1.setId(res.getLong("PK_ID"));
                itemPedido1.setPedido(new PedidoDao().buscarPorId(res.getLong("FK_PEDIDO")));
                itemPedido1.setQuantidade(res.getInt("QT_PRODUTO"));
                itemPedido1.setQuantidade(res.getInt("VL_TOTAL"));
                itemPedido1.setValorUnitario(((ResultSet) res).getDouble("VL_UNITARIO"));

                itemPedidos.add(itemPedido1);
            }

            return itemPedidos;

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }
}
