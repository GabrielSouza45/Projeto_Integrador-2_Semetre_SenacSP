/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import com.projetopi.hakuzanloja.model.Nivel;
import com.projetopi.hakuzanloja.model.Usuario;
import com.projetopi.hakuzanloja.repository.CrudDao;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NivelDao extends ConectarDao implements CrudDao<Nivel> {


    /*Criação de tabela para caso o db atual dê problema*/
    @Override
    public void criarTabela() {
        String sql = "CREATE TABLE TB_NIVEL("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_NOME VARCHAR(30) NOT NULL," +
                " PRIMARY KEY(PK_ID));";

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
                + "VALUES ('Admin');";

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
    public List<Nivel> listarTodos() {
        String sql = "SELECT * FROM TB_NIVEL";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ResultSet res = ps.executeQuery();

            List<Nivel> niveis = new ArrayList<>();

            while (res.next()) {
                Nivel nivel = new Nivel();
                nivel.setId(res.getLong("PK_ID"));
                nivel.setDescNiveis(res.getString("DS_NOME"));

                niveis.add(nivel);
            }

            return niveis;

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public Nivel buscarNivelPorId(Long id) {
        String sql = "SELECT * FROM TB_NIVEL WHERE PK_ID = ?";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            ps.setLong(1, id);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                Nivel nivel = new Nivel();
                nivel.setId(res.getLong("PK_ID"));
                nivel.setDescNiveis(res.getString("DS_NOME"));
                return nivel;
            } else {
                JOptionPane.showMessageDialog(null, "Nível não localizado!");
                return null;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Nível. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public void cadastrar(Nivel nivel) {

        Nivel nivelExists = this.verificarSeNivelExiste(nivel.getDescNiveis());
        if (nivelExists != null) {
            JOptionPane.showMessageDialog(null, "Nível já cadastrado!");
            return;
        }

        String sql = "INSERT INTO TB_NIVEL (DS_NOME)"
                + "VALUES (?);";

        try (PreparedStatement ps = (PreparedStatement)
                getConexao().prepareStatement(sql)) {

            ps.setString(1, nivel.getDescNiveis());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Nível adicionado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar nivel. \n" + err.getMessage());
        }
    }

    @Override
    public void editar(Nivel nivel) {

        Nivel nivelExists = this.verificarSeNivelExiste(nivel.getDescNiveis());
        if (nivelExists != null) {
            JOptionPane.showMessageDialog(null, "Nível já cadastrado!");
            return;
        }

        String sql = "UPDATE TB_NIVEL SET DS_NOME = ? WHERE PK_ID = ?";

        try (PreparedStatement ps = (PreparedStatement)
                getConexao().prepareStatement(sql)) {

            ps.setString(1, nivel.getDescNiveis());
            ps.setLong(2, nivel.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Nível editado com sucesso!");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao editar nivel. \n" + err.getMessage());
        }
    }

    private Nivel verificarSeNivelExiste(String desc) {
        String sql = "SELECT * FROM TB_NIVEL WHERE DS_NOME LIKE (?)";

        try {

            PreparedStatement ps = (PreparedStatement)
                    getConexao().prepareStatement(sql);

            String descricao = "%" + desc + "%";

            ps.setString(1, descricao);

            ResultSet res = ps.executeQuery();

            if (res.next()) {
                Nivel nivel = new Nivel();
                nivel.setId(res.getLong("PK_ID"));
                nivel.setDescNiveis(res.getString("DS_NOME"));
                return nivel;
            } else {
                return null;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar existencia do Nível. \n" + err.getMessage());
            return null;
        }
    }

    @Override
    public void excluir(Nivel nivel) {

        List<Usuario> users = new UsuarioDao().buscarUsuarioPorNivel(nivel);
        if (!users.isEmpty()) {
            int opcao = JOptionPane.showOptionDialog(
                    null,
                    "Existem usuários utilizando este nível, deseja continuar?",
                    "Risco de quebra de Banco!",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    new String[]{"Sim", "Não"},
                    "Não"
            );

            if (opcao == 1) {
                return;
            }
        }

        String sql = "DELETE FROM TB_NIVEL WHERE PK_ID = ?";

        try (PreparedStatement ps = (PreparedStatement) getConexao().prepareStatement(sql)) {

            ps.setLong(1, nivel.getId());

            int rowCount = ps.executeUpdate();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Nível excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum nível encontrado com o ID fornecido.");
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Nível. \n" +  err.getMessage());
        }
    }
}