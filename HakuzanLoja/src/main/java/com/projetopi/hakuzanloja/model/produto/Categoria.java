
package com.projetopi.hakuzanloja.model.produto;

public class Categoria {

    // Atributos Padrão
    private Long id;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

