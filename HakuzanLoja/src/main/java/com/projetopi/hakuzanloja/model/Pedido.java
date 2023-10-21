
package com.projetopi.hakuzanloja.model;


import java.util.Date;


public class Pedido {
    // Atributos Padrão
    private Long id;

    // Atributos da Entidade
    private FormaPagamento pagamento;
    private Usuario usuario;
<<<<<<< HEAD
    private String data;
    private String Status;
    private double valorTotal;

    public String getData() {
=======
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
>>>>>>> origin/01_desenvolvido
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
