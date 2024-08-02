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
                System.out.println("Inserisci un numero valido!");
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
        long codiceISBN = -1;
        while (codiceISBN == -1) {
            System.out.print("Inserisci Codice ISBN: ");
            try {
                codiceISBN = scanner.nextLong();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero ISBN valido!");
                scanner.nextLine();
            }
        }

        System.out.print("Inserisci Titolo: ");
        String titolo = scanner.nextLine();

        int annoPub = -1;
        while (annoPub == -1) {
            System.out.print("Inserisci Anno di Pubblicazione: ");
            try {
                annoPub = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un anno valido!");
                scanner.nextLine();
            }
        }

        int numPagine = -1;
        while (numPagine == -1) {
            System.out.print("Inserisci Numero di Pagine: ");
            try {
                numPagine = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero di pagine valido!");
                scanner.nextLine();
            }
        }

        System.out.print("Inserisci Autore: ");
        String autore = scanner.nextLine();
        System.out.print("Inserisci Genere: ");
        String genere = scanner.nextLine();

        Libro libro = new Libro(codiceISBN, titolo, annoPub, numPagine, autore, genere);
        listaArchivio.add(libro);
        System.out.println("Libro aggiunto con successo!");
    }

    private static void addRivista(Scanner scanner, List<Book> listaArchivio) {
        long codiceISBN = -1;
        while (codiceISBN == -1) {
            System.out.print("Inserisci Codice ISBN: ");
            try {
                codiceISBN = scanner.nextLong();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero ISBN valido!");
                scanner.nextLine();
            }
        }

        System.out.print("Inserisci Titolo: ");
        String titolo = scanner.nextLine();

        int annoPub = -1;
        while (annoPub == -1) {
            System.out.print("Inserisci Anno di Pubblicazione: ");
            try {
                annoPub = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un anno valido!");
                scanner.nextLine();
            }
        }

        int numPagine = -1;
        while (numPagine == -1) {
            System.out.print("Inserisci Numero di Pagine: ");
            try {
                numPagine = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero di pagine valido!");
                scanner.nextLine();
            }
        }

        TipiPeriodicita periodicita = null;
        while (periodicita == null) {
            System.out.println("Seleziona Periodicità:");
            System.out.println("1. Settimanale");
            System.out.println("2. Mensile");
            System.out.println("3. Semestrale");
            try {
                int periodicitaScelta = scanner.nextInt();
                scanner.nextLine();
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
                        System.out.println("Periodicità non valida. Riprova.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero valido per la periodicità!");
                scanner.nextLine();
            }
        }

        Rivista rivista = new Rivista(codiceISBN, titolo, annoPub, numPagine, periodicita);
        listaArchivio.add(rivista);
        System.out.println("Rivista aggiunta con successo!");
    }
}