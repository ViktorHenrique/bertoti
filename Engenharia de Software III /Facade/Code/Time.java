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