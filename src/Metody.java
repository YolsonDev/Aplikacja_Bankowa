public interface Metody {
    String getNumerKonta();
    double getSaldo();
    void setNumerKonta(String numerKonta);
    void setSaldo(double saldo);
    void wplac(String sciezkaDoPliku, double kwota);
    void wyplac(String sciezkaDoPlikudouble, double kwota);
    void odczytajOperacje(String sciezkaDoPliku);
    void infoKonto();
}
