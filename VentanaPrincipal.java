package view;

import java.awt.event.KeyEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import control.ControladorMenu;

public class VentanaPrincipal extends JFrame {

    private JMenuBar menuBar;
    private JMenu datosMenu;
    private JMenu reservasMenu;
    private JMenu estadisticasMenu;
    private JMenu usuariosMenu;
    private JMenu actividadesMenu;
    public JMenuItem leerMenuItem;
    public JMenuItem guardarMenuItem;
    public JMenuItem porUsuarioMenuItem;
    public JMenuItem porActividadMenuItem;
    public JMenuItem nuevaReservaMenuItem;
    public JMenuItem cancelarReservaMenuItem;
    public JMenuItem estadisticasUsuariosMenuItem;
    public JMenuItem estadisticasActividadesMenuItem;
    public JMenuItem top3UsuariosMenuItem;
    public JMenuItem top3ActividadesMenuItem;
    public JMenuItem altaUsuarioMenuItem;
    public JMenuItem bajaUsuarioMenuItem;
    public JMenuItem altaActividadMenuItem;
    public JMenuItem bajaActividadMenuItem;

    ControladorMenu controlador;

    public VentanaPrincipal(ControladorMenu c) {
        this.controlador = c;
        this.menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        datosMenu = new JMenu("Datos");
        datosMenu.setMnemonic(KeyEvent.VK_C);
        leerMenuItem = new JMenuItem("Leer", KeyEvent.VK_L);
        guardarMenuItem = new JMenuItem("Guardar", KeyEvent.VK_G);

        reservasMenu = new JMenu("Reservas");
        reservasMenu.setMnemonic(KeyEvent.VK_C);
        porUsuarioMenuItem = new JMenuItem("Por Usuario", KeyEvent.VK_U);
        porActividadMenuItem = new JMenuItem("Por Actividad", KeyEvent.VK_A);
        nuevaReservaMenuItem = new JMenuItem("Nueva Reserva", KeyEvent.VK_R);
        cancelarReservaMenuItem = new JMenuItem("Cancelar Reserva", KeyEvent.VK_DELETE);

        estadisticasMenu = new JMenu("Estadísticas");
        estadisticasMenu.setMnemonic(KeyEvent.VK_C);
        estadisticasUsuariosMenuItem = new JMenuItem("Usuario", KeyEvent.VK_E);
        estadisticasActividadesMenuItem = new JMenuItem("Actividad", KeyEvent.VK_N);
        top3UsuariosMenuItem = new JMenuItem("Top 3 Usuarios", KeyEvent.VK_E);
        top3ActividadesMenuItem = new JMenuItem("Top 3 Actividades", KeyEvent.VK_E);

        usuariosMenu = new JMenu("Usuarios");
        altaUsuarioMenuItem = new JMenuItem("Alta Usuario");
        bajaUsuarioMenuItem = new JMenuItem("Baja Usuario");

        actividadesMenu = new JMenu("Actividades");
        altaActividadMenuItem = new JMenuItem("Alta Actividad");
        bajaActividadMenuItem = new JMenuItem("Baja Actividad");

        leerMenuItem.addActionListener(controlador);
        guardarMenuItem.addActionListener(controlador);
        datosMenu.add(leerMenuItem);
        datosMenu.add(guardarMenuItem);
        porUsuarioMenuItem.addActionListener(controlador);
        porActividadMenuItem.addActionListener(controlador);
        nuevaReservaMenuItem.addActionListener(controlador);
        cancelarReservaMenuItem.addActionListener(controlador);
        reservasMenu.add(porUsuarioMenuItem);
        reservasMenu.add(porActividadMenuItem);
        reservasMenu.add(nuevaReservaMenuItem);
        reservasMenu.add(cancelarReservaMenuItem);
        estadisticasUsuariosMenuItem.addActionListener(controlador);
        estadisticasActividadesMenuItem.addActionListener(controlador);
        top3UsuariosMenuItem.addActionListener(controlador);
        top3ActividadesMenuItem.addActionListener(controlador);
        estadisticasMenu.add(estadisticasUsuariosMenuItem);
        estadisticasMenu.add(estadisticasActividadesMenuItem);
        estadisticasMenu.add(top3UsuariosMenuItem);
        estadisticasMenu.add(top3ActividadesMenuItem);
        altaUsuarioMenuItem.addActionListener(controlador);
        bajaUsuarioMenuItem.addActionListener(controlador);
        usuariosMenu.add(altaUsuarioMenuItem);
        usuariosMenu.add(bajaUsuarioMenuItem);
        altaActividadMenuItem.addActionListener(controlador);
        bajaActividadMenuItem.addActionListener(controlador);
        actividadesMenu.add(altaActividadMenuItem);
        actividadesMenu.add(bajaActividadMenuItem);

        this.menuBar.add(datosMenu);
        this.menuBar.add(reservasMenu);
        this.menuBar.add(estadisticasMenu);
        this.menuBar.add(usuariosMenu);
        this.menuBar.add(actividadesMenu);

        this.setContentPane(new JDesktopPane());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setTitle("Principal");
        this.setVisible(true);
    }
}
