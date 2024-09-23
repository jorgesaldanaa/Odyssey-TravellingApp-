package model;

public class Reserva {
	private Usuario usuario;
	private String dniUsuario;
	private Actividad actividad;
	private int id;
	private String fecha;
	private int hora;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDni() {
		return dniUsuario;
	}

	public void setDNI(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public Reserva(String dniUsuario, int id, String fecha, int hora) {
		this.dniUsuario = dniUsuario;
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;

	}

	@Override
	public String toString() {
		return dniUsuario + " " + id + " " + fecha + " " + hora + " ";
	}
}