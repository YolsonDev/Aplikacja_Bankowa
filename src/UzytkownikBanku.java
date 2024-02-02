public class UzytkownikBanku extends KontoBankowe{
    protected String imie;
    protected String nazwisko;
    public UzytkownikBanku(String numerKonta, double saldo, String imie, String nazwisko){
        super(numerKonta, saldo);
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public void infoKonto() {
    System.out.println("Dane konta:\n" + imie + " " + nazwisko);
        super.infoKonto();
    }
}
