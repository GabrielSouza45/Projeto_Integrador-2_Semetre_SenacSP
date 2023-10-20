/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import com.projetopi.hakuzanloja.controler.pedido.*;
import controler.ConectarDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItensPedidoDao {


    /*Criação de tabela para caso o db atual dê problema*/
    public void criarTabela() {
        String sql = "CREATE TABLE TB_ITENSPEDIDO("
                + "PK_ID INT NOT NULL AUTO_INCREMENT,"
                + "FK_PRODUTO INT NOT NULL,"
                + "QT_PRODUTO INT NOT NULL,"
                + "VL_UNITARIO NUMERIC(14,2) NOT NULL,"
                + "VL_TOTAL NUMERIC(14,2) NOT NULL,"
                + "FK_PEDIDO INT NOT NULL,"
                + "PRIMARY KEY(PK_ID),"
                + "FOREIGN KEY(FK_PEDIDO) REFERENCES TB_PEDIDO(PK_ID));";

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


}
