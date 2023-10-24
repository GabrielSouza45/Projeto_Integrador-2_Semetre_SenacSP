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

public class FormaDePagamentoDao implements CrudDao<FormaPagamento> {


    /*Criação de tabela para caso o db atual dê problema*/
    @Override
    public void criarTabela() {
        String sql = "CREATE TABLE TB_FORMAPAGAMENTO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "FK_USUARIO INT," +
                "  DS_CARTAO VARCHAR(50),"
                + "DS_PIX VARCHAR(100),BOLETO VARCHAR(200),"
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY (FK_USUARIO) REFERENCES TB_USUARIO(PK_ID));";

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

        String sql = "INSERT INTO TB_NIVEL (DS_NOME)"
                + "VALUES ('Nível 1');";

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

  //  @Override
    public void listarTodos() {

    }

    @Override
    public void cadastrar(FormaPagamento pagamento){

    }


    @Override
    public void editar(FormaPagamento pagamento){

    }



    @Override
    public void excluir(FormaPagamento pagamento){

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
                formaPagamento.setCartao(res.getString("DS_CARTAO"));
                formaPagamento.setBoleto(res.getString("DS_BOLETO"));
                formaPagamento.setPix(res.getString("DS_PIX"));
                formaPagamento.setUsuario(usuario);

                formaPagamentos.add(formaPagamento);
            }

            return formaPagamentos;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Usuario. \n" + err.getMessage());
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
                formaPagamento1.setCartao(res.getString("DS_CARTAO"));
                formaPagamento1.setBoleto(res.getString("DS_BOLETO"));
                formaPagamento1.setPix(res.getString("DS_PIX"));
                formaPagamento1.setUsuario((Usuario) new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));

                formaPagamentos.add(formaPagamento1);
            }

            return formaPagamentos;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Usuario. \n" + err.getMessage());
            return null;
        }
    }

    public List<FormaPagamento> formaPagamentos(){
        String sql = "SELECT * FROM TB_FORMAPAGAMENTO";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<FormaPagamento> formaPagamentos = new ArrayList<>();

            while(res.next()){
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setId(res.getLong("PK_ID"));
                formaPagamento.setCartao(res.getString("DS_CARTAO"));
                formaPagamento.setBoleto(res.getString("DS_BOLETO"));
                formaPagamento.setPix(((ResultSet) res).getString("DS_PIX"));
                formaPagamento.setUsuario((Usuario) new UsuarioDao().buscarUsuarioPorId(res.getLong("FK_USUARIO")));

                formaPagamentos.add(formaPagamento);
            }

            return formaPagamentos;

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }
}
