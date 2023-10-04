package com.projetopi.hakuzanloja.model.pedidos.produtos;

public class Categoria {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade

    private String categoria;

    public Categoria() {
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
