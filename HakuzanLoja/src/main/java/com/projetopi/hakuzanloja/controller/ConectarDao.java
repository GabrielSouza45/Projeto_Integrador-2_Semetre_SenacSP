/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.controller;

import java.sql.*;

public class ConectarDao {
    private final static String url = "jdbc:mysql://hakuzanlojal.mysql.database.azure.com:3306/projetopi?useSSL=true";
    private final static String usuario = "hakuzanloja";
    private final static String senha = "Ineedsugar203040@";
    private static Connection conexao;


    public static Connection getConexao() {

        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(url, usuario, senha);
            }
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
    


    

