/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.projetopi.hakuzanloja;

import com.projetopi.hakuzanloja.dao.UsuarioDao;
import com.projetopi.hakuzanloja.model.usuario.Cliente;
import com.projetopi.hakuzanloja.model.usuario.Usuario;
import com.projetopi.hakuzanloja.view.telalogin.TelaLogin;



/**
 *
 * @author snubd
 */
public class HakuzanLoja {

    public static void main(String[] args) {
        
        UsuarioDao user = new UsuarioDao();
        user.criarTabela();
        
        
        
        
    }
}
