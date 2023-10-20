/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConectarDao {
    private final static String url = "jdbc:mysql://root:h5pkT1OsE1LU224ALtoV@containers-us-west-91.railway.app:7667/railway";
    private final static String usuario = "root";
    private final static String senha = "h5pkT1OsE1LU224ALtoV";
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
    


    

