package com.projetopi.hakuzanloja.model.usuario;

public class Cliente {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private Usuario user;
    private String nome;
    private String documento;
    private Endereco endereco;
    private String telefone;


    public Cliente() {

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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
     public void setClienteUsuario(Usuario usuario){
        this.user = usuario;
        this.nome = usuario.getNome();
        this.documento = usuario.getDocumento();      
    }


}
