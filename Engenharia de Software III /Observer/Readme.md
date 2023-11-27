## Observer

## Diagrama

![DiagramaObserver](https://github.com/ViktorHenrique/bertoti/blob/main/Engenharia%20de%20Software%20III%20/Observer/Images/DiagramaObserver.PNG)

## Código

```java
public class DisplayDesktop implements Observer{
    @Override
    public void enviarMensagem(String msg) {
        System.out.println(msg);
    }
}
```

```java
public class DisplayMobile implements Observer{
    @Override
    public void enviarMensagem(String msg) {
        System.out.println(msg);
    }
}
```

```java
public interface Observer {
    public void enviarMensagem(String msg);
}
```

```java
public class Tarefa {
    private String titulo;
    private String professor;

    public Tarefa(String titulo, String professor){
        this.titulo = titulo;
        this.professor = professor;

    }

    public String getTitulo(){
        return this.titulo;
    }
    public String getProfessor(){
        return this.professor;
    }

}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Teams {
    private List<Observer> observers;
    private List<Tarefa> tarefas;

    public Teams(){
        this.observers = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }
    public List<Observer> getObservers(){
        return this.observers;
    }

    public void notificarTodos(String msg){
        this.observers.stream().forEach(item -> {
            System.out.println(msg);
        });
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
        notificarTodos(String.format("Olá, uma nova tarefa de " + tarefa.getTitulo() + " foi adicionada ao canal pelo professor " + tarefa.getProfessor()));
    }

    public void removeTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);
        notificarTodos(String.format("Olá, a tarefa " + tarefa.getTitulo() + " foi removida do canal pelo professor " + tarefa.getProfessor()));
    }

    public List<Tarefa> getTarefas(){
        return this.tarefas;
    }
}
```

```java
public class Teste {
    public static void main(String[] args) {

        Teams t = new Teams();
        DisplayDesktop tela = new DisplayDesktop();
        DisplayMobile cel = new DisplayMobile();

        t.addObserver(tela);
        t.addObserver(cel);

        Tarefa tarefa = new Tarefa("Quimica", "Fabio");
        t.addTarefa(tarefa);

        t.removeObserver(tela);
        t.removeObserver(cel);


        t.removeTarefa(tarefa);

    }
}
```
