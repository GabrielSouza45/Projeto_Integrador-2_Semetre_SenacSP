
package com.projetopi.hakuzanloja.model.pedidos;


import com.projetopi.hakuzanloja.model.pagamento.FormaPagamento;
import com.projetopi.hakuzanloja.model.usuario.Usuario;

import java.util.Date;


public class Pedido {
    // Atributos Padrão
    private Long id;

    // Atributos da Entidade
    private FormaPagamento pagamento;
    private Usuario usuario;
    private ItemPedido itemPedido;
    private Date data;
    private double valorTotal;

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }
}
