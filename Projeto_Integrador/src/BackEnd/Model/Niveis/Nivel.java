package BackEnd.Model.Niveis;
public class Nivel {

    // Atributos Padrão
    private Long id;
    private int inativo;

    // Atributos da Entidade
    private String descNiveis;

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

    public String getDescNiveis() {
        return descNiveis;
    }

    public void setDescNiveis(String descNiveis) {
        this.descNiveis = descNiveis;
    }
}
