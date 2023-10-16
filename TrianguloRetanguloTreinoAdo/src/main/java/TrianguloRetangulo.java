public class TrianguloRetangulo{

    private double catetoOposto;
    private double catetoAdjacente;

    public double getCatetoOposto() {
        return catetoOposto;
    }

    public void setCatetoOposto(double catetoOposto) {
        this.catetoOposto = catetoOposto;
    }

    public double getCatetoAdjacente() {
        return catetoAdjacente;
    }

    public void setCatetoAdjacente(double catetoAdjacente) {
        this.catetoAdjacente = catetoAdjacente;
    }


    public double area(){
        return catetoOposto * catetoAdjacente / 2;
    }


}