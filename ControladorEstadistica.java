package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import model.*;
import view.*;

public class ControladorEstadistica implements ActionListener {

	SistemaReservas sistema;
	VentanaEstadisticaUsuario ventana;
	ControladorFichero controladorFichero;

	public ControladorEstadistica(SistemaReservas sistema, VentanaEstadisticaUsuario ventana) {
		this.sistema = sistema;
		this.ventana = ventana;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventana.salir) {
			ventana.dispose();
		} 
	}

	public void setVentanaControlada(VentanaEstadisticaUsuario ventana) {
		this.ventana = ventana;
	}
}
