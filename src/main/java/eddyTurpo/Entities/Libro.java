package eddyTurpo.Entities;

public class Libro extends Book {
    private String Autore;
    private String Genere;

    public Libro(long codiceISBN, String titolo, int annoPub, int numPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPub, numPagine);
        Autore = autore;
        Genere = genere;
    }

    public String getAutore() {
        return Autore;
    }

    public void setAutore(String autore) {
        Autore = autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "CodiceISBN=" + CodiceISBN +
                ", Titolo='" + Titolo + '\'' +
                ", AnnoPub=" + annoPub +
                ", NumPagine=" + numPagine +
                ", Autore='" + Autore + '\'' +
                ", Genere='" + Genere + '\'' +
                '}';
    }

}
