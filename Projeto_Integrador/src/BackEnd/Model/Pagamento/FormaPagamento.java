package BackEnd.Model.Pagamento;

import BackEnd.Model.Usuario.Usuario;

public class FormaPagamento {
    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private Usuario usuario;
    private String Cartao;
    private String Pix;
    private String boleto;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCartao() {
        return Cartao;
    }

    public void setCartao(String cartao) {
        Cartao = cartao;
    }

    public String getPix() {
        return Pix;
    }

    public void setPix(String pix) {
        Pix = pix;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }
}
