package BackEnd.Model.Carrinho;

import BackEnd.Model.Produtos.Produto;

public class ItemCarrinho {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private Carrinho carrinho;
    private int quantidade;
    private Produto produto;

    public ItemCarrinho() {
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

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
