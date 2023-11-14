package com.projetopi.hakuzanloja.model;

public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String localidade; // cidade
    private String uf;

    public Endereco(){

    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("""
               Cep = %s,
                Rua = %s,
                Número = %s
                Bairro = %s,
                Cidade = %s,
                Estado = %s
                """,
                cep, logradouro, numero, bairro, localidade, uf);
    }
}
