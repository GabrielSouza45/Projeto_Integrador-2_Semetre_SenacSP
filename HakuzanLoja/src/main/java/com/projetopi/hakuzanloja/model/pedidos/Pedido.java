package com.projetopi.hakuzanloja.model.pedidos;

import BackEnd.Model.Pagamento.FormaPagamento;
import BackEnd.Model.Usuario.Cliente;
import BackEnd.Model.Usuario.Usuario;

public class Pedido {
    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private FormaPagamento pagamento;
    private Usuario usuario;
    private ItemPedido itemPedido;
    private String data;
    private String Status;
    private double valorTotal;

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }
}
