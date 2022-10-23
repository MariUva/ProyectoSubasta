package co.uniquindio.programacion3.subasta.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.programacion3.subasta.exception.NoCreadoException;
import co.uniquindio.programacion3.subasta.modell.Persona;
import co.uniquindio.programacion3.subasta.modell.Subasta;

public class Persistencia {

	public static final String RUTA_ARCHIVO_PERSONAS = "src/resources/archivoPersonas.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/resources/archivoLog.txt";
	public static final String RUTA_ARCHIVO_SUBASTA_BINARIO = "src/resources/SubastaBinario.dat";
	public static final String RUTA_ARCHIVO_SUBASTA_XML = "src/resources/SubastaXml.xml";

	public static void cargarDatosArchivos(Subasta subasta) throws FileNotFoundException, IOException {

		// cargar archivo de clientes

		//
		// ArrayList<Cliente> clientesCargados = cargarClientes();
		//
		// if (clientesCargados.size() > 0)
		// banco.getListaClientes().addAll(clientesCargados);
		//
		// // cargar archivos empleados
		// ArrayList<Empleado> empleadosCargados = cargarEmpleados();
		//
		// if (empleadosCargados.size() > 0)
		// banco.getListaEmpleados().addAll(empleadosCargados);
		//
		// // cargar archivo objetos
		//
		// // cargar archivo empleados
		//
		// // cargar archivo prestamo

	}

	/**
	 * Guarda en un archivo de texto todos la información de las personas
	 * almacenadas en el ArrayList
	 *
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	public static void guardarPersonas(ArrayList<Persona> listaPersonas) throws IOException {
		// TODO Auto-generated method stub
		String contenido = "";

		for (Persona personas : listaPersonas) {
			contenido += personas.getNombre() + "," + personas.getDocumento() + "," + personas.getClave() + ","
					+ personas.getEdad() + "\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PERSONAS, contenido, false);
	}

	// ----------------------LOADS------------------------

	/**
	 *
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de
	 *         texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public static ArrayList<Persona> cargarPersona() throws FileNotFoundException, IOException {

		ArrayList<Persona> cliente = new ArrayList<Persona>();
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PERSONAS);
		String linea = "";

		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			String nombre = linea.split("@@")[0];
			int edad = Integer.parseInt(linea.split("@@")[1]);
			String documento = linea.split("@@")[2];
			String clave = linea.split("@@")[3];

			cliente.add(new Persona(documento, nombre, clave, edad));

		}
		return cliente;

	}

	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}

	// ----------------------EXCEPCIONES------------

	public static boolean iniciarSesion(String usuario, String contrasenia)
			throws FileNotFoundException, IOException, NoCreadoException {

		if (validarUsuario(usuario, contrasenia)) {
			return true;
		} else {
			throw new NoCreadoException("Usuario no existe");
		}

	}

	private static boolean validarUsuario(String nombre, String clave) throws FileNotFoundException, IOException {
		ArrayList<Persona> personas = Persistencia.cargarPersona();

		for (int indicePersona = 0; indicePersona < personas.size(); indicePersona++) {
			Persona personaAux = personas.get(indicePersona);
			if (personaAux.getNombre().equalsIgnoreCase(nombre)
					&& personaAux.getClave().equalsIgnoreCase(clave)) {
				return true;
			}
		}
		return false;
	}

	// ----------------------SAVES------------------------

	// /**
	// * Guarda en un archivo de texto todos la información de las personas
	// * almacenadas en el ArrayList
	// *
	// * @param objetos
	// * @param ruta
	// * @throws IOException
	// */
	//
	// public static void guardarObjetos(ArrayList<Cliente> listaClientes,
	// String ruta) throws IOException {
	// String contenido = "";
	//
	// for (Cliente clienteAux : listaClientes) {
	// contenido += clienteAux.getNombre() + "," + clienteAux.getApellido() +
	// "," + clienteAux.getCedula()
	// + clienteAux.getDireccion() + "," + clienteAux.getCorreo() + "," +
	// clienteAux.getFechaNacimiento()
	// + "," + clienteAux.getTelefono() + "\n";
	// }
	// ArchivoUtil.guardarArchivo(ruta, contenido, true);
	// }

	// ------------------------------------SERIALIZACIÓN y XML

	public static Subasta cargarRecursoSubastaBinario() {

		Subasta subasta = null;

		try {
			subasta = (Subasta) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_SUBASTA_BINARIO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subasta;
	}

	public static void guardarRecursoSubastaBinario(Subasta subasta) {

		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_SUBASTA_BINARIO , subasta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Subasta cargarRecursoSubastaXML() {

		Subasta subasta = null;

		try {
			subasta = (Subasta) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_SUBASTA_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subasta;

	}

	public static void guardarRecursoSubastaXML(Subasta subasta) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_SUBASTA_XML, subasta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
