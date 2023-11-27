## Composite

## Diagrama

(imagem)

## Código

```java
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
```

```java
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
```

```java
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
```

