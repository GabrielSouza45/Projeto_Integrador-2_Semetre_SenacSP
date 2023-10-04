/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.dao;

/**
 *
 * @author snubd
 */
import com.projetopi.hakuzanloja.model.usuario.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;


public class UsuarioDao{

    public void criarTabela(){
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
                + "FK_NIVEL INT NOT NULL,PRIMARY KEY(PK_ID));";
        
        PreparedStatement ps = null;
        
        try{
            ps = ConectarDao.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Banco Criado");
            ps.close();
        }catch(SQLException erro){
        erro.printStackTrace();}
    }
}