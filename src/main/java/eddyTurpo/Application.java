package eddyTurpo;

import eddyTurpo.Entities.Book;
import eddyTurpo.Entities.Libro;
import eddyTurpo.Entities.Rivista;
import eddyTurpo.enums.TipiPeriodicita;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        List<Book> listaArchivio = new ArrayList<>();
        Libro libro1 = new Libro(123, "libro1", 2001, 159, "autore1", "genere1");
        Libro libro2 = new Libro(124, "libro2", 2001, 159, "autore1", "genere1");
        Libro libro3 = new Libro(125, "libro3", 2001, 159, "autore1", "genere1");
        Libro libro4 = new Libro(126, "libro4", 2001, 159, "autore1", "genere1");
        Rivista rivista1 = new Rivista(127, "rivista1", 2024, 54, TipiPeriodicita.MENSILE);
        Collections.addAll(listaArchivio, libro1, libro2, libro3, libro4, rivista1);
        System.out.println(listaArchivio);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Premi 1 per Aggiungi un Libro");
            System.out.println("Premi 2 Aggiungi una Rivista");
            System.out.println("Premi 3 Rimuovere un libro/rivista tramite ISBN");
            System.out.println("Premi 4 per Ricercare un libro/rivista tramite ISBN");
            System.out.println("Premi 5 per Ricercare un libro/rivista tramite ANNO di pubblicazione");
            System.out.println("Premi 6 per Ricercare un libro/rivista tramite AUTORE");
            System.out.println("Premi 7 per SALVARE su un file l'archivio creato");
            System.out.println("Premi 8 per CARICARE e creare dal file una nuovo Archivio");
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
                    searchBook(scanner, listaArchivio);
                    break;
                case 5:
                    searchYear(scanner, listaArchivio);
                    break;
                case 6:
                    searchAuthor(scanner, listaArchivio);
                    break;
                case 7:
                    saveFile(listaArchivio);
                    break;
                case 8:
                    System.out.println(loadFile());
                    break;
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

    public static void saveFile(List<Book> listaArchivio) {
        File file = new File("src/info.txt");
        String fileStringa = genString(listaArchivio);
        try {
            FileUtils.writeStringToFile(file, fileStringa + System.lineSeparator(), StandardCharsets.UTF_8, true);
            System.out.println("Archivio salvato su file!");
        } catch (IOException e) {
            System.out.println("Houston abbiamo un problema, passo.");
        }
    }

    public static List<Book> loadFile() {
        List<Book> nuovalistaArchivio = new ArrayList<>();
        File file = new File("src/info.txt");
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = parseBook(line);
                if (book != null) {
                    nuovalistaArchivio.add(book);
                }
            }
            System.out.println("Archivio caricato dal file!");
        } catch (IOException e) {
            System.out.println("Houston abbiamo un problema nella lettura del file, passo.");
        }
        return nuovalistaArchivio;
    }

    public static String genString(List<Book> listaArchivio) {
        StringBuilder gen = new StringBuilder();
        for (Book book : listaArchivio) {
            if (book instanceof Libro) {
                gen.append("Libro").append("§")
                        .append(book.getCodiceISBN()).append("§")
                        .append(book.getTitolo()).append("§")
                        .append(book.getAnnoPub()).append("§")
                        .append(book.getNumPagine()).append("§")
                        .append(((Libro) book).getAutore()).append("§")
                        .append(((Libro) book).getGenere()).append(System.lineSeparator());
            } else if (book instanceof Rivista) {
                gen.append("Rivista").append("§")
                        .append(book.getCodiceISBN()).append("§")
                        .append(book.getTitolo()).append("§")
                        .append(book.getAnnoPub()).append("§")
                        .append(book.getNumPagine()).append("§")
                        .append(((Rivista) book).getPeriodicita()).append(System.lineSeparator());
            }
        }
        return gen.toString();
    }

    private static Book parseBook(String line) {
        String[] parts = line.split("§");
        if (parts[0].equals("Libro")) {
            try {
                long codiceISBN = Long.parseLong(parts[1]);
                String titolo = parts[2];
                int annoPub = Integer.parseInt(parts[3]);
                int numPagine = Integer.parseInt(parts[4]);
                String autore = parts[5];
                String genere = parts[6];
                return new Libro(codiceISBN, titolo, annoPub, numPagine, autore, genere);
            } catch (Exception e) {
                System.out.println("Houston abbiamo un problema nella creazione di un libro dal file ");
            }
        } else if (parts[0].equals("Rivista")) {
            try {
                long codiceISBN = Long.parseLong(parts[1]);
                String titolo = parts[2];
                int annoPub = Integer.parseInt(parts[3]);
                int numPagine = Integer.parseInt(parts[4]);
                TipiPeriodicita periodicita = TipiPeriodicita.valueOf(parts[5]);
                return new Rivista(codiceISBN, titolo, annoPub, numPagine, periodicita);
            } catch (Exception e) {
                System.out.println("Houston abbiamo un problema nella creazione di una rivista dal file ");
            }
        }
        return null;
    }
}
