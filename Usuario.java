package model;

import java.util.ArrayList;

public class Usuario implements Comparable <Usuario>{
	private String dni;
	private String nombre;
	private String nacimiento;
	private ArrayList<Reserva> listaReservas;

	public String toString() {
		return this.nombre;
	}

	public Usuario(String dni, String nombre, String nacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.listaReservas = new ArrayList<Reserva>();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String imprimirReservas() {
		return this.nombre;

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	public int compareTo(Usuario otroUsuario) {
        return Integer.compare(otroUsuario.getListaReservas().size(), this.getListaReservas().size());
    }

}