/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;


import com.projetopi.hakuzanloja.model.Nivel;
import com.projetopi.hakuzanloja.model.Usuario;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao extends ConectarDao implements CrudDao<Usuario> {
    /*Criação de tabela para caso o db atual dê problema*/
    @Override
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
            ps = getConexao().prepareStatement(sql);
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
            ps = getConexao().prepareStatement(sql);
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

    @Override
    public void cadastrar(Usuario user) {

        Usuario usuario = this.verificarExistenciaUsuarioPorEmailouLogin(user);
        if (usuario != null){
            JOptionPane.showMessageDialog(null, "Email ou Login já cadastrados.");
            return;
        }

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

    @Override
    public void editar(Usuario usuario) {

        Usuario user = this.verificarExistenciaUsuarioPorEmailouLogin(usuario);
        if (user != null){
            JOptionPane.showMessageDialog(null, "Email ou Login já cadastrados.");
            return;
        }

        String sql = "UPDATE TB_USUARIO SET DS_LOGIN = ?, DS_SENHA = ?, NR_TELEFONE = ?, " +
                "DS_CEP = ?, DS_UF = ?, DS_CIDADE = ?, DS_BAIRRO = ?, DS_LOGRADOURO = ?, " +
                "NR_LOGRADOURO = ?, DS_NOME = ?, DS_EMAIL = ?, NR_CPFCNPJ = ?, FK_NIVEL = ? " +
                "WHERE PK_ID = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {

            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getTelefone());
            ps.setString(4, usuario.getCep());
            ps.setString(5, usuario.getUf());
            ps.setString(6, usuario.getCidade());
            ps.setString(7, usuario.getBairro());
            ps.setString(8, usuario.getLogradouro());
            ps.setString(9, usuario.getNumero());
            ps.setString(10, usuario.getNome());
            ps.setString(11, usuario.getEmail());
            ps.setString(12, usuario.getDocumento());
            ps.setLong(13, usuario.getNivel().getId());
            ps.setLong(14, usuario.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário. \n" + err.getMessage());
        }
    }


    private Usuario verificarExistenciaUsuarioPorEmailouLogin(Usuario user){
        String sql = "SELECT * FROM TB_USUARIO " +
                "WHERE DS_LOGIN LIKE (?) " +
                "OR DS_EMAIL LIKE (?) ";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            String login = "%" + user.getLogin() + "%";
            String email = "%" + user.getEmail() + "%";
            ps.setString(1, login);
            ps.setString(2, email);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(res.getLong("PK_ID"));
                usuario.setNome(res.getString("DS_NOME"));
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar existencia do Nível. \n" + err.getMessage());
            return null;
        }
    }

    public Usuario buscarUsuarioPorEmail(String email){
        String sql = "SELECT * FROM TB_USUARIO WHERE DS_EMAIL = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setString(1, email);

            ResultSet res = ps.executeQuery();

            Usuario user = new Usuario();
            while(res.next()) {
                user.setId(res.getLong("PK_ID"));
                user.setNome(res.getString("DS_NOME"));
                user.setEmail(res.getString("DS_EMAIL"));
                user.setLogin(res.getString("DS_LOGIN"));
                user.setSenha(res.getString("DS_SENHA"));
                user.setTelefone(res.getString("NR_TELEFONE"));
                user.setCep(res.getString("DS_CEP"));
                user.setUf(res.getString("DS_UF"));
                user.setCidade(res.getString("DS_CIDADE"));
                user.setBairro(res.getString("DS_BAIRRO"));
                user.setLogradouro(res.getString("DS_LOGRADOURO"));
                user.setNumero(res.getString("NR_LOGRADOURO"));
                user.setDocumento(res.getString("NR_CPFCNPJ"));
                user.setNivel(new NivelDao().buscarNivelPorId(res.getLong("FK_NIVEL")));
            }
            return user;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário. \n" + err.getMessage());
            return null;
        }
    }

    public List<Usuario> buscarUsuarioPorNivel(Nivel nivel){
        String sql = "SELECT * FROM TB_USUARIO WHERE FK_NIVEL = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, nivel.getId());

            ResultSet res = ps.executeQuery();

            List<Usuario> users = new ArrayList<>();

            while(res.next()){
                Usuario user = new Usuario();
                user.setId(res.getLong("PK_ID"));
                user.setNome(res.getString("DS_NOME"));
                user.setEmail (res.getString("DS_EMAIL"));
                user.setLogin (res.getString("DS_LOGIN"));
                user.setSenha (res.getString("DS_SENHA"));
                user.setTelefone (res.getString("NR_TELEFONE"));
                user.setCep(res.getString("DS_CEP"));
                user.setUf (res.getString("DS_UF"));
                user.setCidade (res.getString("DS_CIDADE"));
                user.setBairro (res.getString("DS_BAIRRO"));
                user.setLogradouro (res.getString("DS_LOGRADOURO"));
                user.setNumero(res.getString("NR_LOGRADOURO"));
                user.setDocumento (res.getString("NR_CPFCNPJ"));
                user.setNivel (nivel);

                users.add(user);
            }

            return users;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuários. \n" + err.getMessage());
            return null;
        }
    }

    public List<Usuario> listarTodos(){
        String sql = "SELECT * FROM TB_USUARIO ORDER BY DS_NOME ASC";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<Usuario> users = new ArrayList<>();

            while(res.next()){

                Usuario user = new Usuario();
                user.setId(res.getLong("PK_ID"));
                user.setNome(res.getString("DS_NOME"));
                user.setEmail (res.getString("DS_EMAIL"));
                user.setLogin (res.getString("DS_LOGIN"));
                user.setSenha (res.getString("DS_SENHA"));
                user.setTelefone (res.getString("NR_TELEFONE"));
                user.setCep(res.getString("DS_CEP"));
                user.setUf (res.getString("DS_UF"));
                user.setCidade (res.getString("DS_CIDADE"));
                user.setBairro (res.getString("DS_BAIRRO"));
                user.setLogradouro (res.getString("DS_LOGRADOURO"));
                user.setNumero(res.getString("NR_LOGRADOURO"));
                user.setDocumento (res.getString("NR_CPFCNPJ"));
                user.setNivel (new NivelDao().buscarNivelPorId(res.getLong("FK_NIVEL")));

                users.add(user);
            }

            return users;

        }catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuários. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public void excluir(Usuario user){

        String sql = "DELETE FROM TB_USUARIO WHERE PK_ID = ?";

        try (PreparedStatement ps = getConexao().prepareStatement(sql)) {

            ps.setLong(1, user.getId());
            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado com o ID fornecido.");
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário. " + err.getMessage());
        }

    }
}