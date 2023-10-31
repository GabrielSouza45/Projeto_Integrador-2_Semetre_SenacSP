

package com.projetopi.hakuzanloja.model;

public class FormaPagamento {
    // Atributos Padrão
    private Long id;

    // Atributos da Entidade
    private String tipo;
    private String descCartao;
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescCartao() {
        return descCartao;
    }

    public void setDescCartao(String descCartao) {
        this.descCartao = descCartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
