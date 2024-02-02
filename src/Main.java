import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Ustalamy scieżke do pliku historia.txt C:/twoja_sciezka/historia.txt"
        String sciezkaDoPlikuHistoria = "C:/Users/TheSe/Documents/javaZapis/historiaOperacji.txt";

        System.out.println("Witam w banku OKP. Wybierz opcję:");
        System.out.println("Czy chcesz założyć konto?");
        System.out.println("1. Tak");
        System.out.println("2. Nie");
        int wybor = scanner.nextInt();
        scanner.nextLine();


        // Zakładanie konta
        while(true) {
            switch (wybor) {
                case 1: {
                    System.out.println("Podaj imie:");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko:");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj kwote którą deponujesz: ");
                    double kwotaWplaty = scanner.nextDouble();

                    long losowaNumerKonta = (long) random.nextInt(1_000_000_000) + random.nextInt(1_000_000_000) * 1_000_000_000L;
                    long dodaniePierwszegoNumeru = 9_000_000_0000L + losowaNumerKonta;
                    String numerKonta = String.valueOf(dodaniePierwszegoNumeru);

                    UzytkownikBanku uzytkownikBanku = new UzytkownikBanku(numerKonta, kwotaWplaty, imie, nazwisko);
                    System.out.println("Dziękujemy za założenie konta.");

                    //Usuwanie istniejącego pliku historiaOperacji.txrt  jeśli istnieje
                    File plikDoUsuniecia = new File(sciezkaDoPlikuHistoria);
                    // Sprawdzamy, czy plik istnieje przed próbą usunięcia
                    if (plikDoUsuniecia.exists()) {
                        // Usuwamy plik
                        if (plikDoUsuniecia.delete()) {
                            System.out.println("Wczytujemy aplikacje....");
                        } else {
                            System.out.println("Nie udało się usunąć pliku.");
                        }
                    } else {
                        System.out.println("Wczytujemy aplikacje.....");
                    }

                    int koniecAplikacji = 5;

                    // Operacje na koncie
                    do {
                        System.out.println("\nWybierz opcję:");
                        System.out.println("1. Informacje o koncie");
                        System.out.println("2. Wpłać");
                        System.out.println("3. Wypłać");
                        System.out.println("4. Historia wpłat i wypłat");
                        System.out.println("5. Wyjdz");

                        int wyborOpcji = scanner.nextInt();
                        scanner.nextLine();

                        switch (wyborOpcji){
                            case 1:
                                uzytkownikBanku.infoKonto();
                                break;
                            case 2:
                                System.out.println("Podaj kwotę do wpłaty:");
                                double kwotaWplatyNaKonto = scanner.nextDouble();
                                uzytkownikBanku.wplac(sciezkaDoPlikuHistoria, kwotaWplatyNaKonto);
                                break;
                            case 3:
                                System.out.println("Podaj kwotę do wypłaty:");
                                double kwotaWyplatyNaKonto = scanner.nextDouble();
                                uzytkownikBanku.wyplac(sciezkaDoPlikuHistoria, kwotaWyplatyNaKonto);
                                break;
                            case 4:
                                uzytkownikBanku.odczytajOperacje(sciezkaDoPlikuHistoria);
                                break;
                            case 5:
                                System.out.println("Dziękujemy za korzystanie z naszej aplikacji!");
                                System.exit(0);
                            default:
                                System.out.println("Błędnie wybrana opcja. Wybierz ponownie");
                        }
                    } while(koniecAplikacji == 5);

                    }
                    System.exit(0);
                case 2:
                    System.out.println("Dziękujemy zapraszamy ponownie.");
                    System.out.println("Zamykam aplikację.");
                    System.exit(0);
                default:
                    System.out.println("Nie prawidłowy wybór. Wybierz ponownie.");
            }



        }

    }
}
