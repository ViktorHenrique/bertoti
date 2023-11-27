## Strategy

## Diagrama

(imagem)

## Código

```java
public class Usuario {

    private String nomeLinha;
    private Futebol futebol;

    public Usuario(String nome, Futebol futebol) {
        this.nomeLinha = nome;
        this.futebol = futebol;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void jogar() {
        futebol.jogar();
    }

    public void setFutebol(Futebol futebol) {
        this.futebol = futebol;
    }
}
```

```java
public interface Futebol {

    void jogar();
}
```

```java
public class Goleiro implements Futebol {

    public void jogar() {
        System.out.println("Jogando como goleiro.");
    }
}
```

```java
public class Linha implements Futebol {

    public void jogar() {
        System.out.println("Jogando como jogador de linha.");
    }
}
```
