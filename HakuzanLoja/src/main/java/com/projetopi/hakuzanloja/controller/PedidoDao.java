/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.Pedido;
import com.projetopi.hakuzanloja.model.Usuario;
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

    private Pedido verificarExistenciaPedidoPorId(Pedido peds){
        String sql = "SELECT * FROM TB_PEDIDO " +
                "WHERE PK_ID LIKE (?) ";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            Long id = peds.getId();
            ps.setLong(1, id);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(res.getLong("PK_ID"));
                return pedido;
            } else {
                return null;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar existencia do pedido. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public void editar(Pedido objeto) {
        Pedido pedido = this.verificarExistenciaPedidoPorId(objeto);
        if (pedido != null){
            if (!objeto.getId().equals(objeto.getId())){
                JOptionPane.showMessageDialog(null, "Pedido já realizado!");
                return;
            }
        }

        String sql = "UPDATE TB_PEDIDO SET PK_ID = ?, VL-TOTAL = ?, DT_PEDIDO = ?, " +
                "TG_STATUS = ?, FK_USUARIO = ?, FK_FORMAPAGAMENTO = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {
            ps.setLong(1,objeto.getId());
            ps.setDouble(2, objeto.getValorTotal());
            ps.setDate(3, (Date) objeto.getData());
            ps.setString(4, objeto.getStatus());
            ps.setString(5, String.valueOf(objeto.getUsuario()));
            ps.setDouble(6, objeto.getPagamento().getId());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido atualizado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pedido. \n" + err.getMessage());
        }
    }

    @Override
    public void excluir(Pedido objeto) {
        String sql = "DELETE FROM TB_PEDIDO WHERE PK_ID = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {

            ps.setLong(1, objeto.getId());
            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "pedido excluido com sucesso!");
            } else{
            JOptionPane.showMessageDialog(null, "Nenhum pedido encontrado com o ID fornecido");
        }}
        catch (SQLException err){
                JOptionPane.showMessageDialog(null, "Erro ao excluir pedido." + err.getMessage());
            }
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
    
    
    
    
    public List<Pedido> listarTodosPedidoUser(Usuario user){
        String sql = "SELECT * FROM TB_PEDIDO WHERE FK_USUARIO = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);
            ps.setLong(1, user.getId());

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
        String sql = "SELECT * FROM TB_PEDIDO WHERE FK_USUARIO = ?";

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
        String sql = "SELECT * FROM TB_PEDIDO WHERE PK_ID = ?";

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
    
    
    public Pedido buscarUltimoPedido(){
        String sql = "SELECT * FROM TB_PEDIDO ORDER BY PK_ID DESC LIMIT 1;";

        try {
            PreparedStatement ps = (PreparedStatement)
            getConexao().prepareStatement(sql);

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
        String sql = "SELECT * FROM TB_PEDIDO WHERE DT_PEDIDO = ?";

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
