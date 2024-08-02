package eddyTurpo.Entities;

import eddyTurpo.enums.TipiPeriodicita;

public class Rivista extends Book {
    private TipiPeriodicita Periodicita;

    public Rivista(long codiceISBN, String titolo, int annoPub, int numPagine, TipiPeriodicita periodicita) {
        super(codiceISBN, titolo, annoPub, numPagine);
        Periodicita = periodicita;
    }

    public TipiPeriodicita getPeriodicita() {
        return Periodicita;
    }

    public void setPeriodicita(TipiPeriodicita periodicita) {
        Periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "CodiceISBN=" + CodiceISBN +
                ", Titolo='" + Titolo + '\'' +
                ", AnnoPub=" + annoPub +
                ", NumPagine=" + numPagine +
                ", Periodicita=" + Periodicita +
                '}';
    }
}
