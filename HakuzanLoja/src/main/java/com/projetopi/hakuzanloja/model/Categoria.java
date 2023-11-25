
package com.projetopi.hakuzanloja.model;

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

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString(){
        return this.getCategoria();
    }
}


