import java.util.ArrayList;
import java.util.List;

public class Ingressos implements Partida {
    private List<Partida> partidas;
    private double precoTotal;

    public Ingressos() {
        this.partidas = new ArrayList<>();
        this.precoTotal = 0.00;
    }

    @Override
    public void acompanhar() {
        System.out.println("Preço total dos ingressos: R$" + this.precoTotal);
    }

    @Override
    public double getIngressoPreco() {
        return this.precoTotal;
    }

    public void addPartida(Partida partida) {
        partidas.add(partida);
        this.precoTotal += partida.getIngressoPreco();
    }

    public void delPartida(Partida partida) {
        partidas.remove(partida);
        this.precoTotal -= partida.getIngressoPreco();
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
}