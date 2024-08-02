package eddyTurpo;

import eddyTurpo.Entities.Book;
import eddyTurpo.Entities.Libro;
import eddyTurpo.Entities.Rivista;
import eddyTurpo.enums.TipiPeriodicita;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        List<Book> listaArchivio = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Premi 1 per Aggiungi un Libro");
            System.out.println("Premi 2 Aggiungi una Rivista");
            System.out.println("Premi 3 Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = -1;
            try {
                scelta = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("inserisci un numero valido!");
                scanner.nextLine();
                continue;
            }
            switch (scelta) {
                case 1:
                    addLibro(scanner, listaArchivio);
                    break;
                case 2:
                    addRivista(scanner, listaArchivio);
                    break;
                case 3:
                    System.out.println("Chiusura in corso...");
                    return;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
    }

    private static void addLibro(Scanner scanner, List<Book> listaArchivio) {
        System.out.print("Inserisci Codice ISBN: ");
        long codiceISBN = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Inserisci Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci Anno di Pubblicazione: ");
        int annoPub = scanner.nextInt();
        System.out.print("Inserisci Numero di Pagine: ");
        int numPagine = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Inserisci Autore: ");
        String autore = scanner.nextLine();
        System.out.print("Inserisci Genere: ");
        String genere = scanner.nextLine();

        Libro libro = new Libro(codiceISBN, titolo, annoPub, numPagine, autore, genere);
        listaArchivio.add(libro);
        System.out.println("Libro aggiunto con successo!");
    }

    private static void addRivista(Scanner scanner, List<Book> listaArchivio) {
        System.out.print("Inserisci Codice ISBN: ");
        long codiceISBN = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Inserisci Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Inserisci Anno di Pubblicazione: ");
        int annoPub = scanner.nextInt();
        System.out.print("Inserisci Numero di Pagine: ");
        int numPagine = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Seleziona Periodicità:  2. Mensile 3. Semestrale");
        System.out.println("1. Settimanale");
        System.out.println(" 2. Mensile");
        System.out.println("3. Semestrale");
        int periodicitaScelta = scanner.nextInt();
        scanner.nextLine();

        TipiPeriodicita periodicita;
        switch (periodicitaScelta) {
            case 1:
                periodicita = TipiPeriodicita.SETTIMANALE;
                break;
            case 2:
                periodicita = TipiPeriodicita.MENSILE;
                break;
            case 3:
                periodicita = TipiPeriodicita.SEMESTRALE;
                break;
            default:
                System.out.println("Periodicità non valida. Impostata a Settimanale di default.");
                periodicita = TipiPeriodicita.SETTIMANALE;
        }

        Rivista rivista = new Rivista(codiceISBN, titolo, annoPub, numPagine, periodicita);
        listaArchivio.add(rivista);
        System.out.println("Rivista aggiunta con successo!");
    }
}