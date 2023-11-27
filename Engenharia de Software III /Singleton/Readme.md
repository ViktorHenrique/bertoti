## Singleton

## Diagrama

![DiagramaSingleton](https://github.com/ViktorHenrique/bertoti/blob/main/Engenharia%20de%20Software%20III%20/Singleton/Images/DiagramaSingleton.PNG)

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
