/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.Pedido;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao extends ConectarDao implements CrudDao<Pedido> {


    /*Criação de tabela para caso o db atual dê problema*/
    @Override
    public void criarTabela() {
        String sql = "CREATE TABLE `TB_PEDIDO` ( " +
                "  `PK_ID` int NOT NULL AUTO_INCREMENT, " +
                "  `VL_TOTAL` decimal(14,2) DEFAULT NULL, " +
                "  `DT_PEDIDO` date DEFAULT NULL, " +
                "  `TG_STATUS` varchar(1) DEFAULT NULL, " +
                "  `FK_USUARIO` int DEFAULT NULL, " +
                "  `FK_FORMAPAGAMENTO` int DEFAULT NULL, " +
                "  PRIMARY KEY (`PK_ID`), " +
                "  KEY `FK_USUARIO` (`FK_USUARIO`), " +
                "  KEY `FK_TB_PEDIDO_TB_FORMAPAGAMENTO` (`FK_FORMAPAGAMENTO`), " +
                "  CONSTRAINT `FK_TB_PEDIDO_TB_FORMAPAGAMENTO` FOREIGN KEY (`FK_FORMAPAGAMENTO`) REFERENCES `TB_FORMAPAGAMENTO` (`PK_ID`), " +
                "  CONSTRAINT `TB_PEDIDO_ibfk_1` FOREIGN KEY (`FK_USUARIO`) REFERENCES `TB_USUARIO` (`PK_ID`) ";


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

    @Override
    public void cadastrar(Pedido pedido) {

        String sql = "INSERT INTO TB_PEDIDO (DT_PEDIDO, VL_TOTAL , FK_USUARIO, TG_STATUS, FK_FORMAPAGAMENTO)"
                + "VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setDate(1, (Date) pedido.getData());
            ps.setDouble(2, pedido.getValorTotal());
            ps.setLong(3, pedido.getUsuario().getId());
            ps.setString(4, pedido.getStatus());
            ps.setLong(5, pedido.getPagamento().getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Produto. \n" + err.getMessage());
        }
    }

    @Override
    public void editar(Pedido objeto) {

    }

    @Override
    public void excluir(Pedido objeto) {

    }

    @Override
    public List<Pedido> listarTodos(){
        String sql = "SELECT * FROM TB_PEDIDO";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();

            while (res.next()){
                Pedido pedido = new Pedido();
                pedido.setId(res.getLong("PK_ID"));
                pedido.setUsuario(new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));
                pedido.setData(res.getDate("DT_PEDIDO"));
                pedido.setValorTotal(res.getDouble("VL_TOTAL"));
                pedido.setStatus(res.getString("TG_STATUS"));
                pedido.setPagamento(new FormaDePagamentoDao().buscarPorId(res.getLong("FK_FORMAPAGAMENTO")));

                pedidos.add(pedido);
            }

            return pedidos;
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public Pedido buscarUsuario(Long userId){
        String sql = "SELECT * FROM TB_USUARIO WHERE FK_USUARIO = ?";

        try {
            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, userId);

            ResultSet res = ps.executeQuery();

            if (res.next()){
                Pedido pedido = new Pedido();
                pedido.setId(res.getLong("PK_ID"));
                pedido.setUsuario(new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));
                pedido.setData(res.getDate("DT_PEDIDO"));
                pedido.setValorTotal(res.getDouble("VL_TOTAL"));
                pedido.setStatus(res.getString("TG_STATUS"));
                pedido.setPagamento(new FormaDePagamentoDao().buscarPorId(res.getLong("FK_FORMAPAGAMENTO")));

                return pedido;
            }else {
                JOptionPane.showMessageDialog(null, "Usuário não localizado!");
                return null;
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Erro ao buscar o Usuário. \n" + err.getMessage());
            return null;
        }
    }

    public Pedido buscarPorId(Long id){
        String sql = "SELECT * FROM TB_USUARIO WHERE PK_ID = ?";

        try {
            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet res = ps.executeQuery();

            if (res.next()){
                Pedido pedido = new Pedido();
                pedido.setId(res.getLong("PK_ID"));
                pedido.setUsuario(new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));
                pedido.setData(res.getDate("DT_PEDIDO"));
                pedido.setValorTotal(res.getDouble("VL_TOTAL"));
                pedido.setStatus(res.getString("TG_STATUS"));
                pedido.setPagamento(new FormaDePagamentoDao().buscarPorId(res.getLong("FK_FORMAPAGAMENTO")));

                return pedido;
            }else {
                JOptionPane.showMessageDialog(null, "ID não localizado!");
                return null;
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Erro ao buscar o ID. \n" + err.getMessage());
            return null;
        }
    }

    public Pedido buscarData (Date data){
        String sql = "SELECT * FROM TB_USUARIO WHERE DT_PEDIDO = ?";

        try {
            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setDate(1, data);

            ResultSet res = ps.executeQuery();

            if (res.next()){
                Pedido pedido = new Pedido();
                pedido.setId(res.getLong("PK_ID"));
                pedido.setUsuario(new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));
                pedido.setData(res.getDate("DT_PEDIDO"));
                pedido.setValorTotal(res.getDouble("VL_TOTAL"));
                pedido.setStatus(res.getString("TG_STATUS"));
                pedido.setPagamento(new FormaDePagamentoDao().buscarPorId(res.getLong("FK_FORMAPAGAMENTO")));

                return pedido;
            }else {
                JOptionPane.showMessageDialog(null, "Data não localizada!");
                return null;
            }
        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a Data. \n" + err.getMessage());
            return null;
        }
    }
}
