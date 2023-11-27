public class Internacional implements Partida {
    private String pais;
    private double preco;

    public Internacional(String pais, double preco) {
        this.pais = pais;
        this.preco = preco;
    }

    public void setInternacional(double preco, String pais) {
        this.pais = pais;
        this.preco = preco;
    }

    @Override
    public double getIngressoPreco() {
        return this.preco;
    }

    @Override
    public void acompanhar() {
        System.out.println("Acompanhando a partida internacional no país " + this.pais + " por: R$" + this.preco);
    }
}

public interface Partida {
    void acompanhar();
    double getIngressoPreco();
}