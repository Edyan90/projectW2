package eddyTurpo;

import eddyTurpo.Entities.Book;
import eddyTurpo.Entities.Libro;
import eddyTurpo.Entities.Rivista;
import eddyTurpo.enums.TipiPeriodicita;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        List<Book> listaArchivio = new ArrayList<>();
        Libro libro1 = new Libro(123, "book1", 2001, 159, "autore1", "genere1");
        Libro libro2 = new Libro(124, "book2", 2001, 159, "autore1", "genere1");
        Libro libro3 = new Libro(125, "book3", 2001, 159, "autore1", "genere1");
        Libro libro4 = new Libro(126, "book4", 2001, 159, "autore1", "genere1");
        Collections.addAll(listaArchivio, libro1, libro2, libro3, libro4);
        System.out.println(listaArchivio);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Premi 1 per Aggiungi un Libro");
            System.out.println("Premi 2 Aggiungi una Rivista");
            System.out.println("Premi 3 Rimuovere un libro/rivista tramite ISBN");
            System.out.println("Premi 4 per Ricercare un libro/rivista tramite ANNO di pubblicazione");
            System.out.println("Premi 5 per Ricercare un libro/rivista tramite AUTORE");
            System.out.println("Premi 6 per SALVARE su un file l'archivio creato");
            System.out.println("Premi 7 per CARICARE e creare dal file una nuovo Archivio");
            System.out.println("Premi 0 per USCIRE");
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
                    removeBook(scanner, listaArchivio);
                    break;
                case 4:
                    searchYear(scanner, listaArchivio);
                    break;
                case 5:
                    searchAuthor(scanner, listaArchivio);
               /* case 6:
                    saveFile();
                    break;
                case 7:
                    loadFile();*/
                case 0:
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

    private static void removeBook(Scanner scanner, List<Book> listaArchivio) {
        long codiceISBN = -1;
        while (codiceISBN == -1) {
            System.out.print("Inserisci Codice ISBN da rimuovere: ");
            try {
                codiceISBN = scanner.nextLong();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero ISBN valido!");
                scanner.nextLine();
            }
        }
        Book bookRemove = null;
        for (Book book : listaArchivio) {
            if (book.getCodiceISBN() == codiceISBN) {
                bookRemove = book;
                break;
            }
        }

        if (bookRemove != null) {
            listaArchivio.remove(bookRemove);
            System.out.println("Libro/Rivista rimosso con successo!");
        } else {
            System.out.println("Nessun libro/rivista è stato trovato con il Codice ISBN specificato.");
        }
    }

    public static void searchBook(Scanner scanner, List<Book> listaArchivio) {
        long codiceISBN = -1;
        while (codiceISBN == -1) {
            System.out.print("Inserisci Codice ISBN da cercare dentro l'archivio: ");
            try {
                codiceISBN = scanner.nextLong();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un numero ISBN valido!");
                scanner.nextLine();
            }
        }

        for (Book book : listaArchivio) {

            if (book.getCodiceISBN() == codiceISBN) {
                System.out.println("il libro trovato è: " + book);
                break;
            } else {
                System.out.println("Nessun libro/rivista è stato trovato, riprova con un'altro codice ISBN");
                break;
            }


        }
    }

    public static void searchAuthor(Scanner scanner, List<Book> listaArchivio) {
        String autore = "";
        while (autore.isEmpty()) {
            System.out.print("Inserisci nome Autore da cercare dentro l'archivio: ");
            autore = scanner.nextLine();

            for (Book book : listaArchivio) {
                if (book instanceof Libro && ((Libro) book).getAutore().equals(autore)) {
                    System.out.println("il libro/i trovato/i è: " + book);

                } else {
                    System.out.println("Nessun libro/rivista è stato trovato, riprova con un altro Autore");
                    break;
                }
            }
        }
    }

    public static void searchYear(Scanner scanner, List<Book> listaArchivio) {
        int anno = -1;
        while (anno == -1) {
            System.out.print("Inserisci un anno di pubblicazione da cercare dentro l'archivio: ");
            try {
                anno = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un valore valido!");
                scanner.nextLine();
            }

            for (Book book : listaArchivio) {
                if (book.getAnnoPub() == anno) {
                    System.out.println("il libro/i trovato/i è: " + book);

                } else {
                    System.out.println("Nessun libro/rivista è stato trovato, riprova con un altro anno");
                    break;
                }
            }
        }

    }
}