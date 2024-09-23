package model;

import java.util.ArrayList;

public class Actividad implements Comparable <Actividad>{
    private int id;
    private String nombre;
    private int aforo;
    private ArrayList<Reserva> listaReservas;

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Actividad(int id, String nombre, int aforo) {
        this.id = id;
        this.nombre = nombre;
        this.aforo = aforo;
        this.listaReservas = new ArrayList<Reserva>();
    }

    public String toString() {
        return this.nombre;
    }

    public String imprimirReservas() {
        return this.nombre;

    }
    public int compareTo(Actividad actividad) {
        return Integer.compare(actividad.getListaReservas().size(), this.getListaReservas().size());
    }
}
