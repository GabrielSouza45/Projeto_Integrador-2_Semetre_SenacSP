package BackEnd.Model.Pedidos;

import BackEnd.Model.Pagamento.FormaPagamento;
import BackEnd.Model.Usuario.Cliente;

public class Pedido {
    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private double saldo;
    private Cliente cliente;
    private FormaPagamento pagamento;

    public Pedido() {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }
}
