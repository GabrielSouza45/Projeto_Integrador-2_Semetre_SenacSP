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
public class PedidoDao {








    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela(){
        String sql = "CREATE TABLE TB_PEDIDO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "VL_TOTAL DECIMAL(14,2),"
                + "DT_PEDIDO DATE,TG_STATUS VARCHAR(1),"
                + "FK_USUARIO INT,"
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_USUARIO)REFERENCES TB_USUARIO(PK_ID));";

        
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
