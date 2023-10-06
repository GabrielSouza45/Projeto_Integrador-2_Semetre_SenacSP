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
public class ProdutoDao {












    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela(){
        String sql = "CREATE TABLE TB_PRODUTO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "DS_NOME VARCHAR(70) NOT NULL,"
                + "DS_DESCRICAO VARCHAR(255),"
                + "VL_COMPRA NUMERIC(14,2),"
                + "VL_VENDA NUMERIC(14,2),"
                + "FK_CATEGORIA INT, "
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_CATEGORIA) REFERENCES TB_CATEGORIA(PK_ID));";
        
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
        
        String sql = "INSERT INTO TB_PRODUTO (DS_NOME, DS_DESCRICAO, VL_COMPRA, VL_VENDA, FK_CATEGORIA)"
                + "VALUES ('Produto 1', 'Descrição do Produto 1', 50.00, 75.00, 1);";
        
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
