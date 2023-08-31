package BackEnd.Model.Usuario;

public class Cargo {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private String cargo;

    public Cargo(){}

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
