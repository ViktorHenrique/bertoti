public class Local implements Partida {
    private String estadio;
    private double preco;

    public Local(String estadio, double preco) {
        this.estadio = estadio;
        this.preco = preco;
    }

    public void setLocal(double preco, String estadio) {
        this.estadio = estadio;
        this.preco = preco;
    }

    @Override
    public double getIngressoPreco() {
        return this.preco;
    }

    @Override
    public void acompanhar() {
        System.out.println("Acompanhando a partida no estádio " + this.estadio + " por: R$" + this.preco);
    }
}