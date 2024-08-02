package eddyTurpo.Entities;

import java.util.Objects;

public abstract class Book {
    protected long CodiceISBN;
    protected String Titolo;
    protected int annoPub;
    protected int numPagine;

    public Book(long codiceISBN, String titolo, int annoPub, int numPagine) {
        CodiceISBN = codiceISBN;
        Titolo = titolo;
        this.annoPub = annoPub;
        this.numPagine = numPagine;
    }


    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String titolo) {
        Titolo = titolo;
    }

    public long getCodiceISBN() {
        return CodiceISBN;
    }

    public void setCodiceISBN(long codiceISBN) {
        CodiceISBN = codiceISBN;
    }

    public int getAnnoPub() {
        return annoPub;
    }

    public void setAnnoPub(int annoPub) {
        this.annoPub = annoPub;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "Book{" +
                "CodiceISBN=" + CodiceISBN +
                ", Titolo='" + Titolo + '\'' +
                ", annoPub=" + annoPub +
                ", numPagine=" + numPagine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return CodiceISBN == book.CodiceISBN && annoPub == book.annoPub && numPagine == book.numPagine && Objects.equals(Titolo, book.Titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CodiceISBN, Titolo, annoPub, numPagine);
    }
}
