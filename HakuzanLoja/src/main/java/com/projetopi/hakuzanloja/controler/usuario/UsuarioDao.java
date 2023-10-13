/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler.usuario;


import com.projetopi.hakuzanloja.controler.ConectarDao;
import com.projetopi.hakuzanloja.model.usuario.Usuario;

import javax.swing.*;
import java.sql.*;


public class UsuarioDao extends ConectarDao{
    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela() {
        String sql = "CREATE TABLE TB_USUARIO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_LOGIN VARCHAR(50) NOT NULL,"
                + "DS_SENHA VARCHAR(20) NOT NULL,"
                + "NR_TELEFONE VARCHAR(20),"
                + "DS_CEP VARCHAR(10) NOT NULL,"
                + "DS_UF VARCHAR(2),"
                + "DS_CIDADE VARCHAR(60) NOT NULL,"
                + "DS_BAIRRO VARCHAR(60) NOT NULL,"
                + "DS_LOGRADOURO VARCHAR(60) NOT NULL,"
                + "NR_LOGRADOURO VARCHAR(20) NOT NULL,"
                + "DS_NOME VARCHAR(80) NOT NULL,"
                + "DS_EMAIL VARCHAR(80),"
                + "NR_CPFCNPJ VARCHAR(20),"
                + "FK_NIVEL INT NOT NULL,PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY (FK_NIVEL) REFERENCES TB_USUARIO(PK_ID));";

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

        String sql = "INSERT INTO TB_USUARIO (DS_LOGIN, DS_SENHA, NR_TELEFONE, DS_CEP, DS_UF, DS_CIDADE, DS_BAIRRO, DS_LOGRADOURO, NR_LOGRADOURO, DS_NOME, DS_EMAIL, NR_CPFCNPJ, FK_NIVEL)"
                + "VALUES ('admin', '123', '1234567890', '12345-678', 'SP', 'São Paulo', 'Bairro', 'Rua Teste', '123', 'Administrador', 'admin@example.com', '12345678900', 1);";

        PreparedStatement ps = null;
        try {
            ps = ConectarDao.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Insert sucesso!");
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }

    }

    public ResultSet validarLogin(String login, String senha) {
        String sql = "SELECT * FROM TB_USUARIO WHERE DS_LOGIN = '"  + login + "' AND DS_SENHA = '" + senha + "'";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            return ps.executeQuery();

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public void incluir(Usuario user) {

        String sql = "INSERT INTO TB_USUARIO (DS_LOGIN, DS_SENHA, NR_TELEFONE, DS_CEP, DS_UF, DS_CIDADE, DS_BAIRRO, DS_LOGRADOURO, NR_LOGRADOURO, DS_NOME, DS_EMAIL, NR_CPFCNPJ, FK_NIVEL)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement ps = getConexao().prepareStatement(sql);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getSenha());
            ps.setString(3, user.getTelefone());
            ps.setString(4, user.getCep());
            ps.setString(5, user.getUf());
            ps.setString(6, user.getCidade());
            ps.setString(7, user.getBairro());
            ps.setString(8, user.getLogradouro());
            ps.setString(9, user.getNumero());
            ps.setString(10, user.getNome());
            ps.setString(11, user.getEmail());
            ps.setString(12, user.getDocumento());
            ps.setLong(13, user.getNivel().getId());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário. " + err.getMessage());
        }

    }
}