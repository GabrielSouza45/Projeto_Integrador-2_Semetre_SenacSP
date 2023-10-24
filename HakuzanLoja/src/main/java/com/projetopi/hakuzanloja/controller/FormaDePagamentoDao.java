/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.FormaPagamento;
import com.projetopi.hakuzanloja.model.Usuario;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.projetopi.hakuzanloja.controller.ConectarDao.getConexao;

public class FormaDePagamentoDao extends ConectarDao implements CrudDao<FormaPagamento> {


    /*Criação de tabela para caso o db atual dê problema*/
    @Override
    public void criarTabela() {
        String sql = "CREATE TABLE TB_FORMAPAGAMENTO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_TIPO INT,"
                + "PRIMARY KEY(PK_ID)";

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
    public void cadastrar(FormaPagamento pagamento){

        String sql = "INSERT INTO TB_FORMAPAGAMENTO (DS_TIPO) VALUES (?);";
        try{

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setString(1, pagamento.getTipo());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Forma de Pagamento cadastrada com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Forma de Pagamento. \n" + e.getMessage());
        }

    }


    @Override
    public void editar(FormaPagamento pagamento){

        String sql = "UPDATE TB_FORMAPAGAMENTO SET " +
                " DS_TIPO = ? " +
                " WHERE PK_ID = ? ";
        try{

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setString(1, pagamento.getTipo());
            ps.setLong(2, pagamento.getId());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Forma de Pagamento editada com sucesso!");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao editar Forma de Pagamento. \n" + e.getMessage());
        }

    }



    @Override
    public void excluir(FormaPagamento pagamento){

        String sql = "DELETE FROM TB_FORMAPAGAMENTO WHERE PK_ID = ? ";
        try{

            PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql);
            ps.setLong(1, pagamento.getId());

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Forma de pagamento excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Forma de pagamento encontrada com o ID fornecido.");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar Forma de Pagamento. \n" + e.getMessage());
        }

    }

    public List<FormaPagamento> buscarPorUsuario(Usuario usuario){
        String sql = "SELECT * FROM TB_FORMAPAGAMENTO WHERE FK_USUARIO = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, usuario.getId());

            ResultSet res = ps.executeQuery();

            List<FormaPagamento> formaPagamentos = new ArrayList<>();

            while(res.next()){
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setId(res.getLong("PK_ID"));
                formaPagamento.setTipo(res.getString("DS_TIPO"));

                formaPagamentos.add(formaPagamento);
            }

            return formaPagamentos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Forma de Pagamento. \n" + err.getMessage());
            return null;
        }
    }

    public List<FormaPagamento> buscarPorId(FormaPagamento formaPagamento) {
        String sql = "SELECT * FROM TB_FORMAPAGAMENTO WHERE PK_ID = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, formaPagamento.getId());

            ResultSet res = ps.executeQuery();

            List<FormaPagamento> formaPagamentos = new ArrayList<>();

            while (res.next()) {
                FormaPagamento formaPagamento1 = new FormaPagamento();
                formaPagamento1.setId(res.getLong("PK_ID"));
                formaPagamento1.setTipo(res.getString("DS_TIPO"));

                formaPagamentos.add(formaPagamento1);
            }

            return formaPagamentos;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Usuario. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public List<FormaPagamento> listarTodos(){
        String sql = "SELECT * FROM TB_FORMAPAGAMENTO";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<FormaPagamento> formaPagamentos = new ArrayList<>();

            while(res.next()){
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setId(res.getLong("PK_ID"));
                formaPagamento.setTipo(res.getString("DS_TIPO"));

                formaPagamentos.add(formaPagamento);
            }

            return formaPagamentos;

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }
}
