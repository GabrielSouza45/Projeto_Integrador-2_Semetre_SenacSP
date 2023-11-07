/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.model;

/**
 *
 * @author snubd
 */
public class UsuarioAtual {
    
    private static Usuario userAtual;

    public static Usuario getUserAtual() {
        return userAtual;
    }

    public static void setUserAtual(Usuario userAtual) {
        UsuarioAtual.userAtual = userAtual;
    }
    
    
    
}
