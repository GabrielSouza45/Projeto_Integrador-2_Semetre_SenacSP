/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetopi.hakuzanloja.model;

import com.projetopi.hakuzanloja.controller.ProdutoDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snubd
 */
public class ProdutosAtual {
    private static List<Produto> listaProd;
   


    public static List<Produto> getListaProd() {
        return listaProd;
    }

    public static void setListaProd(List<Produto> listaProd) {
        ProdutosAtual.listaProd = listaProd;
    }
    
    
    
    
    
    
}
