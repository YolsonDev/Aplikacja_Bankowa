import java.io.*;

public abstract class KontoBankowe implements Metody {
    protected String numerKonta;
    protected double saldo;
    protected int nrOperacji = 1;

    public KontoBankowe(String numerKonta, double saldo){
        this.numerKonta = numerKonta;
        this.saldo = saldo;
    }

    public void setNumerKonta(String numerKonta){
        this.numerKonta = numerKonta;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    public String getNumerKonta(){
        return numerKonta;
    }
    public double getSaldo(){
        return  saldo;
    }
    public void wplac(String sciezkaDoPliku, double kwota){
        saldo += kwota;

        System.out.println("Wpłacono: " + kwota + " PLN");
        System.out.println("Aktualny stan konta: " + saldo + " PLN");
        try {
            // Tworzymy obiekt FileOutputStream, który wskazuje na plik, do którego będziemy zapisywać
            FileOutputStream fileOutputStream = new FileOutputStream(new File(sciezkaDoPliku), true);
            // Tworzymy obiekt PrintStream, który wskazuje na nasz niestandardowy strumień wyjścia
            PrintStream customOut = new PrintStream(fileOutputStream);
            // Zapisujemy niestandardowy strumień wyjścia (PrintStream) jako standardowy strumień wyjścia (System.out)
            System.setOut(customOut);
            // Teraz wszystko, co jest wypisywane na System.out, zostanie zapisane do pliku
            System.out.println("Operacja nr " + nrOperacji);
            System.out.println("Wpłacono: " + kwota + " PLN");
            System.out.println("Stan konta: " + saldo + " PLN");
            System.out.println();
            // Poniższa linia odpowiada za powrót do standarowego strumienia wyjścia czyli na konsole(możemy go użyć, jeśli chcemy przywrócić normalne wyjście na konsolę)
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); // teraz wyjście będzie wyświetlane na konsole
            // Zamykamy strumień wyjścia, co spowoduje też zamknięcie pliku
            customOut.close();
            System.out.println("Operacja została zapisana.");
        } catch (Exception e) {
            // Obsługa błędów związanych z operacją zapisu do pliku
            e.printStackTrace();
        }
        nrOperacji++;
    }

    public void wyplac(String sciezkaDoPliku, double kwota){
        if(saldo >= kwota) {
            saldo -=kwota;
            System.out.println("Wypłacono: " + kwota + " PLN");
            System.out.println("Aktualny stan konta: " + saldo);

            try {
                // Tworzymy obiekt FileOutputStream, który wskazuje na plik, do którego będziemy zapisywać
                FileOutputStream fileOutputStream = new FileOutputStream(new File(sciezkaDoPliku), true);
                // Tworzymy obiekt PrintStream, który wskazuje na nasz niestandardowy strumień wyjścia
                PrintStream customOut = new PrintStream(fileOutputStream);
                // Zapisujemy niestandardowy strumień wyjścia (PrintStream) jako standardowy strumień wyjścia (System.out)
                System.setOut(customOut);
                // Teraz wszystko, co jest wypisywane na System.out, zostanie zapisane do pliku
                System.out.println("Operacja nr " + nrOperacji);
                System.out.println("Wypłacono: " + kwota + " PLN");
                System.out.println("Stan konta: " + saldo + " PLN");
                System.out.println();
                // Poniższa linia odpowiada za powrót do standarowego strumienia wyjścia czyli na konsole(możemy go użyć, jeśli chcemy przywrócić normalne wyjście na konsolę)
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); // teraz wyjście będzie wyświetlane na konsole
                // Zamykamy strumień wyjścia, co spowoduje też zamknięcie pliku
                customOut.close();
                System.out.println("Operacja została zapisana.");
            } catch (Exception e) {
                // Obsługa błędów związanych z operacją zapisu do pliku
                e.printStackTrace();
            }
            nrOperacji++;

        } else {
            System.out.println("Brak wystarczających środków na koncie");
        }
    }
    public void odczytajOperacje(String sciezkaDoPliku){
        try {
            // Tworzymy obiekt FileReader, który odczytuje znaki z pliku
            FileReader fileReader = new FileReader(sciezkaDoPliku);
            // Tworzymy obiekt BufferedReader, który umożliwia odczyt linia po linii
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Odczytujemy tekst z pliku linia po linii
            System.out.println("Historia operacji na koncie: ");
            String linia;
            while ((linia = bufferedReader.readLine()) != null) {
                System.out.println(linia);
            }
            // Zamykamy BufferedReader i FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            // Obsługa błędów związanych z operacją odczytu pliku
            e.printStackTrace();
        }
    }

    @Override
    public void infoKonto() {
        System.out.println("Nr konta: " + numerKonta +" \nSaldo wynosi: " + saldo +" PLN");
    }
}
