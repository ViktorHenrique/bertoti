## MVC

## Diagrama

![DiagramaMVC]()

## Código

```java
package model;
import java.util.List;
import java.util.LinkedList;
import view.Torcedor;

public class Campeonato implements Championship {

    private List<Partida> partidas;
    private List<Torcedor> torcedores;

    public Campeonato(){
        partidas = new LinkedList<>();
        torcedores = new LinkedList<>();
    }

    public void registerTorcedor(Torcedor t){
        torcedores.add(t);
    }

    public void notifyTorcedores(List encontrados){
        for(Torcedor t : torcedores){
            t.torcer(encontrados);
        }
    }

    public void addPartida(Partida p){
        partidas.add(p);
    }

    public void buscarPartida(Partida p){
        List<Partida> encontrados = new LinkedList<>();
        for(Partida partidaCampeonato : partidas){
            if(partidaCampeonato.matches(p)) {
                encontrados.add(partidaCampeonato);
            }
        }
        notifyTorcedores(encontrados);
    }

    public void adicionarPartida(String timeA, String timeB, int data){
        Partida partida = new Partida(timeA, timeB, data);
        addPartida(partida);
    }

    public void buscarPartidaPorTime(String time){
        Partida partida = new Partida(time, "", 0);
        buscarPartida(partida);
    }

    public void buscarPartidaPorTimesEData(String timeA, String timeB, int data){
        Partida partida = new Partida(timeA, timeB, data);
        buscarPartida(partida);
    }
}
```

```java
package model;

import java.util.List;

import view.Torcedor;

public interface Championship {

    public void registerTorcedor(Torcedor t);
    public void notifyTorcedores(List encontrados);
}
```

```java
package view;

import java.util.List;

import model.Partida;

import controler.Ingresso;

public class Estadio implements Torcedor {

    private Ingresso i;
    private List listaPartidas;

    public void setI(Ingresso ingresso){
        i = ingresso;
    }

    public void torcer(List l){
        listaPartidas = l;
        i.emitirIngresso();
    }

    public void imprimirDadosPartida(){
        if(!listaPartidas.isEmpty()){
            for(Object j: listaPartidas){
                Partida p = (Partida)j;
                System.out.println(p.getTimeA() + " vs " + p.getTimeB() + " - " + p.getData());
            }
        }
    }

    public void imprimirTipoSetor(){
        System.out.println("\nSetor: Arquibancada");
        System.out.println("Número do Assento: xxx");
    }

}
```

```java
import java.util.List;

public class Facade {
    private Controller controller;
    private Estadio estadio;

    public Facade() {
        this.controller = new Controller();
        this.estadio = new Estadio(controller);
    }

    public List<Partida> emitirIngresso() {
        return controller.lista();
    }

    public List<Partida> imprimir() {
        return controller.lista();
    }
}
```

```java
package controler;

public interface Ingresso {
    public void emitirIngresso();
}
```

```java
package view;
import java.util.List;

public interface Observer {

    public void torcer(List l);

}
```

```java
package model;

public class Partida {

    private String timeA;
    private String timeB;
    private int data;

    public Partida(String a, String b, int d){
        timeA = a;
        timeB = b;
        data = d;
    }

    public String getTimeA(){
        return timeA;
    }

    public String getTimeB(){
        return timeB;
    }

    public int getData(){
        return data;
    }

    public boolean matches(Partida p){
        if(!timeA.equals(p.timeA)) return false;
        if(!timeB.equals(p.timeB)) return false;
        if(data!=p.data) return false;
        return true;
    }

}
```

```java
package controler;

import model.Campeonato;
import view.Estadio;

public class SetorArquibancada implements Ingresso {

    private Estadio e;
    private Campeonato c;

    public void setE(Estadio estadio){
        e = estadio;
    }

    public void emitirIngresso(){
        e.imprimirDadosPartida();
        e.imprimirTipoSetor();
    }

}
```

```java
package controler;

import model.Campeonato;
import view.Estadio;

public class SetorCadeira implements Ingresso {

    private Estadio e;
    private Campeonato c;

    public void setE(Estadio estadio){
        e = estadio;
    }

    public void emitirIngresso(){
        e.imprimirDadosPartida();
    }

}
```

```java
import java.util.List;

class Torcedor implements Torcedor {
    private String email;

    public Torcedor(String email) {
        this.email = email;
    }

    public void torcer(List l) {
        System.out.println("A lista foi atualizada");
    }
}
```
