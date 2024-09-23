package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.*;
import model.Usuario;

public class VentanaEstadisticaUsuario extends JInternalFrame{
	SistemaReservas miSistema;
	ControladorEstadistica ControladorEstadistica = new ControladorEstadistica(miSistema,this);
	public JTextArea info;
	public JButton salir;
//    public JComboBox dniSelector;
//    public Usuario usuario;
	
	public VentanaEstadisticaUsuario (Usuario[] arrayUsuarios, SistemaReservas sistema) {
		
		JPanel panelCentral = new JPanel();
		this.getContentPane().add(panelCentral);
		this.setSize(270, 230);
		this.setTitle("Estadisticas");
		info = new JTextArea(ControladorFichero.estadisticasDeUsuarios(sistema.listaUsuarios, sistema.listaActividades, sistema.listaReservas));
		salir = new JButton("Salir");
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
//        dniSelector = new JComboBox();
//        ControladorEstadistica controladorComboBox = new ControladorEstadistica(miSistema, this);
//        dniSelector = new JComboBox(arrayUsuarios);
//        dniSelector.addActionListener(controladorComboBox);
	}
	
}
