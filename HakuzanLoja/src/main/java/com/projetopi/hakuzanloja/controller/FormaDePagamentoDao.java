/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.FormaPagamento;
import com.projetopi.hakuzanloja.repository.CrudDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            ps = ConectarDao.getConexao().prepareStatement(sql);
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
            ps = ConectarDao.getConexao().prepareStatement(sql);
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


}
