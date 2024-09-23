package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Actividad;
import model.Reserva;
import model.Usuario;
import view.CrearInternalFrame;
import view.EliminarInternalFrame;
import view.SeleccionarVistaReservaInternalFrame;
import view.VentanaPrincipal;

public class ControladorMenu implements ActionListener {
    public SistemaReservas sistema;
    public VentanaPrincipal ventana;

    public ControladorMenu(SistemaReservas sistema) {
        this.sistema = sistema;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.leerMenuItem) {
            // Cargar los ficheros a listas del sistema
            sistema.listaUsuarios = ControladorFichero.leerFicheroPersonas(sistema.URL_USUARIOS);
            sistema.listaActividades = ControladorFichero.leerFicheroActividades(sistema.URL_ACTIVIDADES);
            sistema.listaReservas = ControladorFichero.leerFicheroReservas(sistema.URL_RESERVAS);

        } else if (e.getSource() == ventana.guardarMenuItem) {
            // Guardar listas al los ficheros
            ArrayList<Usuario> listaUsuarios = sistema.getListaUsuarios();
            ArrayList<Actividad> listaActividades = sistema.getListaActividades();
            ArrayList<Reserva> listaReservas = sistema.getListaReservas();

            String URL_USUARIOS = sistema.URL_USUARIOS;
            String URL_ACTIVIDADES = sistema.URL_ACTIVIDADES;
            String URL_RESERVAS = sistema.URL_RESERVAS;

            ControladorFichero.guardarInstancias(listaUsuarios, listaActividades, listaReservas, URL_USUARIOS,
                    URL_ACTIVIDADES, URL_RESERVAS);

        } else if (e.getSource() == ventana.porUsuarioMenuItem) {
            // Vista de reservas por Usuario
            ventana.add(new SeleccionarVistaReservaInternalFrame(ArrayListToUsuarioArray(sistema.listaUsuarios), sistema));

        } else if (e.getSource() == ventana.porActividadMenuItem) {
            // Vista de reservas por Actividad
            ventana.add(new SeleccionarVistaReservaInternalFrame(ArrayListToActividadArray(sistema.listaActividades), sistema));

        } else if (e.getSource() == ventana.nuevaReservaMenuItem) {
            // Crear ventana para crear reservas
            Usuario[] listaUsuarios = ArrayListToUsuarioArray(sistema.listaUsuarios);
            Actividad[] listActividades = ArrayListToActividadArray(sistema.listaActividades);

            ventana.add(new CrearInternalFrame(listaUsuarios, listActividades, sistema));

        } else if (e.getSource() == ventana.altaActividadMenuItem) {
            // Crear ventana para crear actividades

            Actividad[] actividadArray = ArrayListToActividadArray(sistema.listaActividades);

            ventana.add(new CrearInternalFrame(actividadArray, sistema));

        } else if (e.getSource() == ventana.altaUsuarioMenuItem) {
            // Crear ventana para crear usuarios
            Usuario[] usuariosArray = ArrayListToUsuarioArray(sistema.listaUsuarios);

            ventana.add(new CrearInternalFrame(usuariosArray, sistema));

        } else if (e.getSource() == ventana.bajaUsuarioMenuItem) {
            // Crear ventana para eliminar usuarios
            Usuario[] usuariosArray = ArrayListToUsuarioArray(sistema.listaUsuarios);

            ventana.add(new EliminarInternalFrame(usuariosArray, sistema));

        } else if (e.getSource() == ventana.bajaActividadMenuItem) {
            // Crear ventana para eliminar actividades
            Actividad[] actividadArray = ArrayListToActividadArray(sistema.listaActividades);

            ventana.add(new EliminarInternalFrame(actividadArray, sistema));

        } else if (e.getSource() == ventana.cancelarReservaMenuItem) {
            // Crear ventana para eliminar reservas
            Reserva[] reservaArray = ArrayListToReservaArray(sistema.listaReservas);

            ventana.add(new EliminarInternalFrame(reservaArray, sistema));

        } else {
            System.out.println("Accion de origen desconocido. " + this);
        }
    }

    private Usuario[] ArrayListToUsuarioArray(ArrayList<Usuario> listaActividades) {
        Usuario[] arrayUsuarios = new Usuario[sistema.getListaActividades().toArray().length + 1];

        int count = 0;
        for (Object object : sistema.getListaUsuarios().toArray()) {
            if (object instanceof Usuario) {
                arrayUsuarios[count] = (Usuario) object;
            } else {
                System.out.println(object + " is not an activity");
            }
            count++;

        }

        return arrayUsuarios;
    }

    private Actividad[] ArrayListToActividadArray(ArrayList<Actividad> listaActividades) {
        Actividad[] arrayActividades = new Actividad[listaActividades.toArray().length + 1];

        int count = 0;
        for (Object object : sistema.getListaActividades().toArray()) {
            if (object instanceof Actividad) {
                arrayActividades[count] = (Actividad) object;
            } else {
                System.out.println(object + " is not an activity");
            }
            count++;

        }

        return arrayActividades;
    }

    private Reserva[] ArrayListToReservaArray(ArrayList<Reserva> listaReservas) {
        Reserva[] arrayReservas = new Reserva[listaReservas.toArray().length + 1];

        int count = 0;
        for (Object object : sistema.getListaReservas().toArray()) {
            if (object instanceof Reserva) {
                arrayReservas[count] = (Reserva) object;
            } else {
                System.out.println(object + " is not an reserva");
            }
            count++;

        }

        return arrayReservas;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

}
