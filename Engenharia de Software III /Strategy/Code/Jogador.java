public class Jogador {

    private String nomeLinha;
    private Futebol futebol;

    public Jogador(String nome, Futebol futebol) {
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