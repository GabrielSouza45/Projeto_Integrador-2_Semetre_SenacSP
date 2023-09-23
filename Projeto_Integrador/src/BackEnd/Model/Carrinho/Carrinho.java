package BackEnd.Model.Carrinho;

import BackEnd.Model.Usuario.Cliente;

public class Carrinho {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private Cliente cliente;

    public Carrinho() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
