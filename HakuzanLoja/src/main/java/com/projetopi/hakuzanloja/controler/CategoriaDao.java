/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author everton.lcsousa
 */
public class CategoriaDao {





    
    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela(){
        String sql = "CREATE TABLE TB_CATEGORIA("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_TIPO VARCHAR(30) NOT NULL,"
                + "PRIMARY KEY(PK_ID));";
        
        PreparedStatement ps = null;
        
        try{
            ps = ConectarDao.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Banco Criado");
            ps.close();
        }catch(SQLException erro){
        erro.printStackTrace();}
    }
     public void insertInicial(){
        
        String sql = "INSERT INTO TB_CATEGORIA (DS_TIPO)"
                + "VALUES ('CALÇA')";
        
        PreparedStatement ps = null;
        try{
            ps = ConectarDao.getConexao().prepareStatement(sql);
            ps.execute();
            System.out.println("Inset");
            ps.close();
        }catch(SQLException erro){
        erro.printStackTrace();}
     
     }
    
    
    
}
