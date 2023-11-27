## Singleton

## Diagrama

(imagem)

## Código

```java
public class Time {
    private static Time time;
    private Time() {}

    public static Time getInstance() {
        if (time == null) {
            time = new Time();
        }
        return time;
    }
    
    public void acompanhar(String evento) {
        System.out.println("Acompanhando: " + evento);
    }
}
```
