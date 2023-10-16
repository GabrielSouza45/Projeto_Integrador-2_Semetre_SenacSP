import java.lang.reflect.Array;
import java.util.Arrays;

public class Pessoa {

    private String nomeCompleto;
    privatae int anoNasc;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public int idade(){
        return anoNasc - 2023;

    }

    public String primeroNome(){
       String [] nomeSeparado = nomeCompleto.split("");

       return nomeSeparado[0];

    }

    public String ultimoNome(){
        String [] nomeSeparado = nomeCompleto.split("");
         return nomeSeparado[nomeSeparado.length-1];
    }


}