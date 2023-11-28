## Facade

## Diagrama

![DiagramaMVC](https://github.com/ViktorHenrique/bertoti/blob/main/Engenharia%20de%20Software%20III%20/Facade/Images/DiagramaFacade.PNG)

## Código

```java
class Time {
    private TimeReserva timeReserva;
    private TimeTitular timeTitular;

    public Time() {
        timeReserva = new TimeReserva();
        timeTitular = new TimeTitular();
    }

    public void JogarReserva(String escalaReserva) {
        timeReserva.JogarReserva(escalaReserva);
    }

    public void JogarTitular(String escalaTitular) {
        timeTitular.JogarTitular(escalaTitular);
    }
}
```

```java
class TimeReserva {
    public void JogarReserva(String escalaReserva) {
        System.out.println("Jogando no time reserva: " + escalaReserva);
    }
}
```

```java
class TimeTitular {
    public void JogarTitular(String escalaTitular) {
        System.out.println("Jogando no time titular: " + escalaTitular);
    }
}
```
