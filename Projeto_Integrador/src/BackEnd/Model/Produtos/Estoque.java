package BackEnd.Model.Produtos;

public class Estoque {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private Produto produto;
    private int saldo;
    private int pendente;

    public Estoque() {
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPendente() {
        return pendente;
    }

    public void setPendente(int pendente) {
        this.pendente = pendente;
    }
}
