package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import model.*;

public class ControladorFichero {

	public static ArrayList<Usuario> leerFicheroPersonas(String rutaUsuarios) {
		File ficheroUsuarios = new File(rutaUsuarios);
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		if (ficheroUsuarios != null) {
			try {
				Scanner sc = new Scanner(ficheroUsuarios);
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					String[] trozos = linea.split(";");
					Usuario nuevoUsuario;
					nuevoUsuario = new Usuario(trozos[0], trozos[1], trozos[2]);
					listaUsuarios.add(nuevoUsuario);
				}
				sc.close();
			} catch (Exception e) {
				System.out.println("Ningún fichero de Usuarios encontrado");
				System.out.println(e);
			}
		}
		return listaUsuarios;
	}

	public static ArrayList<Actividad> leerFicheroActividades(String rutaActividades) {
		File ficheroActividades = new File(rutaActividades);
		ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();
		if (ficheroActividades != null) {
			try {
				Scanner sc = new Scanner(ficheroActividades);
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					String[] trozos = linea.split(";");
					Actividad nuevaActividad;
					nuevaActividad = new Actividad(Integer.parseInt(trozos[0]), trozos[1], Integer.parseInt(trozos[2]));
					listaActividades.add(nuevaActividad);
				}
				sc.close();
			} catch (Exception e) {
				System.out.println("Ningún fichero de Actividades encontrado");
				System.out.println(e);
			}
		}
		return listaActividades;
	}

	public static ArrayList<Reserva> leerFicheroReservas(String rutaReservas) {
		File ficheroReservas = new File(rutaReservas);
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		if (ficheroReservas != null) {
			try {
				Scanner sc = new Scanner(ficheroReservas);
				while (sc.hasNextLine()) {
					String linea = sc.nextLine();
					String[] trozos = linea.split(";");
					Reserva nuevaReserva;
					nuevaReserva = new Reserva(trozos[0], Integer.parseInt(trozos[1]), trozos[2],
							Integer.parseInt(trozos[3]));
					listaReservas.add(nuevaReserva);
				}
				sc.close();
			} catch (Exception e) {
				System.out.println("Ningún fichero de Reservas encontrado");
				System.out.println(e);
			}
		}

		return listaReservas;
	}

	public static ArrayList<Reserva> asignarReservasAUsuario(ArrayList<Reserva> listaReservas, Usuario usuario) {
		ArrayList<Reserva> returnArrayList = new ArrayList<>();

		for (Reserva reserva : listaReservas) {
			if (reserva.getDni().equals(usuario.getDni())) {
				returnArrayList.add(reserva);
			}
		}

		return returnArrayList;
	}

	public static ArrayList<Reserva> asignarReservasAActividad(ArrayList<Reserva> listaReservas, Actividad actividad) {
		ArrayList<Reserva> returnArrayList = new ArrayList<>();

		for (Reserva reserva : listaReservas) {
			if (reserva.getId() == actividad.getId()) {
				returnArrayList.add(reserva);
			}
		}

		return returnArrayList;
	}

	public static void guardarInstancias(ArrayList<Usuario> listaUsuarios, ArrayList<Actividad> listaActividades,
			ArrayList<Reserva> listaReservas, String rutaUsuarios, String rutaActividades, String rutaReservas) {
		File ficheroUsuarios = new File(rutaUsuarios);
		File ficheroActividades = new File(rutaActividades);
		File ficheroReservas = new File(rutaReservas);
		try {
			PrintWriter writer1 = new PrintWriter(ficheroUsuarios);
			for (Usuario u : listaUsuarios) {
				writer1.println(u.getDni() + ";" + u.getNombre() + ";" + u.getNacimiento());
			}
			writer1.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
		try {
			PrintWriter writer2 = new PrintWriter(ficheroActividades);
			for (Actividad a : listaActividades) {
				writer2.println(a.getId() + ";" + a.getNombre() + ";" + a.getAforo());
			}
			writer2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
		try {
			PrintWriter writer3 = new PrintWriter(ficheroReservas);
			for (Reserva r : listaReservas) {
				writer3.println(r.getDni() + ";" + r.getId() + ";" + r.getFecha() + ";" + r.getHora());
			}
			writer3.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void altaUsuario(ArrayList<Usuario> listaUsuarios, String rutaUsuarios, String DNI, String nombre,
			String nacimiento) throws IOException {
		File ficheroUsuarios = new File(rutaUsuarios);
		try (FileWriter fw = new FileWriter(ficheroUsuarios, true); PrintWriter writer1 = new PrintWriter(fw)) {
			writer1.println(DNI + ";" + nombre + ";" + nacimiento);

		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void bajaUsuario(ArrayList<Usuario> listaUsuarios, String rutaUsuarios, String DNI) {
		File ficheroUsuarios = new File(rutaUsuarios);
		try {
			PrintWriter writer1 = new PrintWriter(ficheroUsuarios);
			for (Usuario u : listaUsuarios) {
				if (DNI != u.getDni()) {
					writer1.println(u.getDni() + ";" + u.getNombre() + ";" + u.getNacimiento());
				}
			}
			writer1.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void altaActividad(ArrayList<Actividad> listaActividades, String rutaActividades, int ID,
			String nombre, int aforo) throws IOException {
		File ficheroActividades = new File(rutaActividades);
		try (FileWriter fw = new FileWriter(ficheroActividades, true); PrintWriter writer1 = new PrintWriter(fw);) {

			writer1.println("\n" + ID + ";" + nombre + ";" + aforo);

		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void bajaActividad(ArrayList<Actividad> listaActividades, int ID, String rutaActividades) {
		File ficheroActividades = new File(rutaActividades);
		try {
			PrintWriter writer1 = new PrintWriter(ficheroActividades);
			for (Actividad ad : listaActividades) {
				if (ID != ad.getId()) {
					writer1.println(ad.getId() + ";" + ad.getNombre() + ";" + ad.getAforo());
				}
			}
			writer1.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void reservasPorUsuario(ArrayList<Usuario> listaUsuarios, ArrayList<Reserva> listaReservas, Usuario u,
			String DNI) {
		DNI = u.getDni();
		for (Reserva r : listaReservas) {
			if (DNI == r.getDni()) {
				System.out.println(r.getId() + ";" + r.getFecha() + ";" + r.getHora());
			}
		}
	}

	public static void reservasPorActividades(ArrayList<Actividad> listaActividades, ArrayList<Reserva> listaReservas,
			Actividad ad, Reserva rs, int ID, String fecha) {
		ID = ad.getId();
		fecha = rs.getDni();
		for (Reserva r : listaReservas) {
			if (ID == r.getId()) {
				System.out.println(r.getId() + ";" + r.getFecha() + ";" + r.getHora());
			}
		}
	}

	public static void crearReserva(ArrayList<Usuario> listaUsuarios, ArrayList<Actividad> listaActividades,
			ArrayList<Reserva> listaReservas, Usuario u, Actividad ad, String rutaReservas, String fecha, int hora) {
		String DNI = u.getDni();
		int ID = ad.getId();
		File ficheroReservas = new File(rutaReservas);
		try (FileWriter fw = new FileWriter(ficheroReservas, true)) {
			PrintWriter writer = new PrintWriter(fw);
			int aforo = ad.getAforo();
			if (aforo > 0) {
				writer.println("\n" + DNI + ";" + ID + ";" + fecha + ";" + hora);
				ad.setAforo(aforo - 1);
			}
		} catch (Exception e) {
			System.out.println("Ningún fichero encontrado");
		}
	}

	public static void cancelarReserva(ArrayList<Usuario> listaUsuarios, ArrayList<Actividad> listaActividades,
			ArrayList<Reserva> listaReservas, String rutaReservas, Reserva rs) {

		String DNI = rs.getDni();
		int ID = rs.getId();
		String fecha = rs.getFecha();
		int hora = rs.getHora();

		Actividad ad = null;
		for (Actividad actividad : listaActividades) {
			if (ID == actividad.getId()) {
				ad = actividad;
				break;
			}
		}

		if (ad == null) {
			System.out.println("Actividad no encontrada");
			return;
		}

		//
		File ficheroReservas = new File(rutaReservas);
		File ficheroTemporal = new File("ficheroTemporal.txt");

		try (BufferedReader lector = new BufferedReader(new FileReader(ficheroReservas));
				PrintWriter escritor = new PrintWriter(new FileWriter(ficheroTemporal))) {

			String linea;
			while ((linea = lector.readLine()) != null) {
				String[] lineaData = linea.split(";");
				String currentDNI = lineaData[0];
				int currentID = Integer.parseInt(lineaData[1]);
				String currentFecha = lineaData[2];
				int currentHora = Integer.parseInt(lineaData[3]);

				if (!(currentDNI.equals(DNI) && currentID == ID && currentFecha.equals(fecha) && currentHora == hora)) {
					escritor.println(linea);
				} else {
					ad.setAforo(ad.getAforo() + 1);
				}
			}
			lector.close();
			escritor.close();

			if (!ficheroReservas.delete()) {
				System.out.println("No se pudo eliminar el fichero original");
				return;
			}

			if (!ficheroTemporal.renameTo(ficheroReservas)) {
				System.out.println("No se pudo renombrar el fichero temporal");
			}

		} catch (IOException e) {
			System.out.println("No se encontro el fichero: " + e.getMessage());
		}

	}

	public static String estadisticasDeUsuarios(ArrayList<Usuario> listaUsuarios, ArrayList<Actividad> listaActividades,
			ArrayList<Reserva> listaReservas) {
		int masReservas = 0;
		int menosResevas = 9999;
		String usuarioMejor = "";
		String usuarioPeor = "";
		float reservasSemanalesMayores = 0;
		float reservasSemanalesMenores = 99;
		String usuarioMejorPorSemana = "";
		String usuarioPeorPorSemana = "";
		for (Usuario u : listaUsuarios) {
			if(u.getListaReservas().size() >= masReservas) {
				masReservas = u.getListaReservas().size();
				usuarioMejor = u.getNombre();
			} else if(u.getListaReservas().size() <= menosResevas) {
				menosResevas = u.getListaReservas().size();
				usuarioPeor = u.getNombre();
			}
		}
		for (Usuario u : listaUsuarios) {
			int nReservas = u.getListaReservas().size();
			String fechas[] = new String[nReservas];
			for(int i = 0; i < u.getListaReservas().size(); i++) {
				fechas[i] = u.getListaReservas().get(i).getFecha();
			}
			int diaMayor = 0;
			int diaMenor = 99999999;
			int mesMayor = 0;
			int mesMenor = 99999999;
			String dia = "";
			String mes = "";
			for (int k = 0; k < fechas.length; k++) {
				for (int j = 0; j < 2; j++) {
					dia += fechas[k].charAt(j);
				}
				for (int j = 0; j < 2; j++) {
					mes += fechas[k].charAt(j + 2);
				}
				int diaConv = Integer.parseInt(dia);
				int mesConv = Integer.parseInt(mes);
				if (mesConv > mesMayor) {
					mesMayor = mesConv;
					diaMayor = diaConv;
				} else if (mesConv < mesMenor) {
					mesMenor = mesConv;
					diaMenor = diaConv;
				}
			}
			int mesesTotales = mesMayor - mesMenor;
			int semanasTotales = (mesesTotales * 4) + (diaMayor - diaMenor) / 7;
			float reservasPorSemana = nReservas / semanasTotales;

			if (semanasTotales >= reservasSemanalesMayores) {
				reservasSemanalesMayores = reservasPorSemana;
				usuarioMejorPorSemana = u.getDni();
			} else if (semanasTotales <= reservasSemanalesMenores) {
				reservasSemanalesMenores = reservasPorSemana;
				usuarioPeorPorSemana = u.getDni();
			}
		}
		String estadisticasUsuariosTotales = "El Usuario con más actividades reservadas es " + usuarioMejor + " con "
				+ masReservas
				+ " mientras que el con menos es " + usuarioPeor + " con " + menosResevas + "." + "\n";
		String estadisticasUsuariosSemanales = "El Usuario con más actividades reservadas a la semana es "
				+ usuarioMejorPorSemana + " con "
				+ reservasSemanalesMayores + " mientras que el con menos es " + usuarioPeorPorSemana + " con "
				+ reservasSemanalesMenores + ".";
		String estadisticas = estadisticasUsuariosTotales + estadisticasUsuariosSemanales;
		return estadisticas;
	}

	public static String estadisticasDeActividades(ArrayList<Usuario> listaUsuarios,
			ArrayList<Actividad> listaActividades,
			ArrayList<Reserva> listaReservas) {
		int masActividades = 0;
		int menosActividades = 9999;
		String actividadMasPopular = "";
		String actividadMenosPopular = "";
		float reservasSemanalesMayores = 0;
		float reservasSemanalesMenores = 99;
		String actividadMejorPorSemana = "";
		String actividadPeorPorSemana = "";
		for (Actividad u : listaActividades) {
			if(u.getListaReservas().size() >= masActividades) {
				masActividades = u.getListaReservas().size();
				actividadMasPopular = u.getNombre();
			} else if(u.getListaReservas().size() <= menosActividades) {
				menosActividades = u.getListaReservas().size();
				actividadMenosPopular = u.getNombre();
			}
		}
		for (Actividad a : listaActividades) {
			int nReservas = a.getListaReservas().size();
			String fechas[] = new String[nReservas];
			for(int i = 0; i < a.getListaReservas().size(); i++) {
				fechas[i] = a.getListaReservas().get(i).getFecha();
			}
			int diaMayor = 0;
			int diaMenor = 99999999;
			int mesMayor = 0;
			int mesMenor = 99999999;
			String dia = "";
			String mes = "";
			for (int k = 0; k < fechas.length; k++) {
				for (int j = 0; j < 2; j++) {
					dia += fechas[k].charAt(j);
				}
				for (int j = 0; j < 2; j++) {
					mes += fechas[k].charAt(j + 2);
				}
				int diaConv = Integer.parseInt(dia);
				int mesConv = Integer.parseInt(mes);
				if (mesConv > mesMayor) {
					mesMayor = mesConv;
					diaMayor = diaConv;
				} else if (mesConv < mesMenor) {
					mesMenor = mesConv;
					diaMenor = diaConv;
				}
				int mesesTotales = mesMayor - mesMenor;
				int semanasTotales = (mesesTotales * 4) + (diaMayor - diaMenor) / 7;
				float actividadesPorSemana = nReservas / semanasTotales;

				if (semanasTotales >= reservasSemanalesMayores) {
					reservasSemanalesMayores = actividadesPorSemana;
					actividadMejorPorSemana = a.getNombre();
				} else if (semanasTotales <= reservasSemanalesMenores) {
					reservasSemanalesMenores = actividadesPorSemana;
					actividadPeorPorSemana = a.getNombre();
				}
			}
		}
		String estadisticasActividadesTotales = "La Actividad más reservada es " + actividadMasPopular
				+ " con " + masActividades
				+ " mientras que la menos reservada es " + actividadMenosPopular + " con " + menosActividades + "." + "\n";
		String estadisticasActividadesSemanales = "La Actividad más reservada en una semana es "
				+ actividadMejorPorSemana +
				" con " + reservasSemanalesMayores + " mientras que la menos reservada es " + actividadPeorPorSemana + " con "
				+ reservasSemanalesMenores + ".";
		String estadisticas = estadisticasActividadesTotales + estadisticasActividadesSemanales;
		return estadisticas;
	}

	public static String top3Usuarios(ArrayList<Usuario> listaUsuarios, ArrayList<Reserva> listaReservas) {
		Collections.sort(listaUsuarios);
		String top3Usuarios = "Los usuarios con el mayor número de reservas son: ";
		for (int i = 1; i <= 3; i++) {
			top3Usuarios += "\n" + (i) + " - " + listaUsuarios.get(i - 1).getNombre();
		}
		return top3Usuarios;
	}

	public static String top3Actividades(ArrayList<Actividad> listaActividades, ArrayList<Reserva> listaReservas) {
		Collections.sort(listaActividades);
		String top3Actividades = "Las actividades con el mayor número de reservas son: ";
		for (int i = 1; i <= 3; i++) {
			top3Actividades += "\n" + (i) + " - " + listaActividades.get(i - 1).getNombre();
		}
		return top3Actividades;
	}

}
