package co.uniquindio.programacion3.subasta.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.programacion3.subasta.modell.Anuncio;
import co.uniquindio.programacion3.subasta.modell.Persona;
import co.uniquindio.programacion3.subasta.modell.Puja;
import co.uniquindio.programacion3.subasta.modell.Subasta;
import co.uniquindio.programacion3.subasta.modell.TipoProducto;
import co.uniquindio.programacion3.subasta.persistence.Persistencia;

public class ModelFactoryController {

	static Subasta subasta = new Subasta();

	// ---------------------Singleton--------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aqu� al ser
		// protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// M�todo para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {

		// 1. inicializar datos y luego guardarlo en archivos
		// iniciarSalvarDatosPrueba();

		// 2. Cargar los datos de los archivos
		// cargarDatosDesdeArchivos();

		// 3. Guardar y Cargar el recurso serializable binario
		// guardarResourceBinario();
		cargarResourceBinario();

		// 4. Guardar y Cargar el recurso serializable XML
		// guardarResourceXML();
		cargarResourceXML();

		// Siempre se debe verificar si la raiz del recurso es null
		if (subasta == null) {
			System.out.println("es null");
			inicializarDatos();
			// guardarResourceSerializable();
			guardarResourceXML();
		}

		// Registrar la accion de incio de sesi�n

		Persistencia.guardaRegistroLog("Inicio de sesión del usuario:pedro", 1, "inicioSesion");
	}

	private void iniciarSalvarDatosPrueba () {

		inicializarDatos();

		try {

			Persistencia.guardarPersonas(getSubasta().getListaPersonas());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cargarDatosDesdeArchivos() {

		subasta = new Subasta();

		try {

			Persistencia.cargarDatosArchivos(getSubasta());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargarResourceBinario() {

		subasta = Persistencia.cargarRecursoSubastaBinario();
	}

	public void guardarResourceBinario() {

		Persistencia.guardarRecursoSubastaBinario(subasta);
	}

	public void cargarResourceXML() {

		subasta = Persistencia.cargarRecursoSubastaXML();
	}

	public void guardarResourceXML() {

		Persistencia.guardarRecursoSubastaXML(subasta);
	}

	private void inicializarDatos() {

		subasta = new Subasta();

		Persona persona = new Persona();
		persona.setClave("0000");
		persona.setDocumento("1234");
		persona.setEdad(20);
		persona.setNombre("Ana");

		subasta.getListaPersonas().add(persona);

		System.out.println("Subasta inicializado " + subasta);

	}

	// Metodos getters and setters
	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	// -----------------CREAR PERSONA------------------

	public Persona crearPersona(String documento, String nombre, String clave, int edad) {

		Persona persona = null;
		try {
			persona = getSubasta().agregarPersona(documento, nombre, clave, edad);
		} catch (Exception e) {
			e.getMessage();

		}
		return persona;

	}

	// public boolean actualizarPersona(String documentoActual, String
	// documento, String nombre, String clave, int edad) {
	//
	// return getSubasta().actualizarPersona(documento, nombre, clave, edad);
	//
	// }

	public Boolean eliminarPersona(String codigo) {

		boolean flagPersonaExiste = false;

		try {
			flagPersonaExiste = getSubasta().eliminarPersona(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return flagPersonaExiste;
	}

	public Persona obtenerPersona(String codigo) {
		return null;
	}

	public ArrayList<Persona> obtenerPersona() {
		return subasta.getListaPersonas();
	}

	// -----------------CREAR ANUNCIO------------------







//	public Anuncio crearAnuncio(String nombreProdcuto, String descripcion, String nombreAnunciante,
//			String fechaPublicacion, String fechaFinalizacion, double valorInicial, double valorSuperior,
//			TipoProducto tipoProducto, Puja listaPujas, String codigo) {
//
//		Anuncio anuncio = null;
//		try {
//			anuncio = getSubasta().agregarAnuncio(nombreProdcuto, descripcion, nombreAnunciante, fechaPublicacion,
//					fechaFinalizacion, valorInicial, valorSuperior, tipoProducto, listaPujas, codigo);
//		} catch (Exception e) {
//			e.getMessage();
//
//		}
//		return anuncio;
//
//	}







	// public boolean actualizarAnuncio(String codigoActual, String
	// nombreProdcuto, String descripcion, String nombreAnunciante,
	// String fechaPublicacion, String fechaFinalizacion, double valorInicial,
	// double valorSuperior,
	// TipoProducto tipoProducto, Puja listaPujas, String codigo) {
	//
	// return getSubasta().actualizarAnuncio(String nombreProdcuto, String
	// descripcion, String nombreAnunciante,
	// String fechaPublicacion, String fechaFinalizacion, double valorInicial,
	// double valorSuperior,
	// TipoProducto tipoProducto, Puja listaPujas, String codigo);
	//
	// }

	public Boolean eliminarAnuncio(String codigo) {

		boolean flagPersonaExiste = false;

		try {
			flagPersonaExiste = getSubasta().eliminarAnuncio(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return flagPersonaExiste;
	}

	public Persona obtenerAnuncio(String codigo) {
		return null;
	}

	public ArrayList<Anuncio> obtenerAnuncios() {
		return subasta.getListaAnuncios();
	}




public static void cargarDatos() {

		subasta.setListaAnunciantes(Persistencia.cargarAnunciantes());
		subasta.setListaCompradores(Persistencia.cargarCompradores());
		subasta.setListaPujas(Persistencia.cargarPujas());
		subasta.setListaAnuncios(Persistencia.cargarAnuncios());
	}

	public static void guardarAnunciantes(){
		Persistencia.guardarAnunciantes(subasta.getListaAnunciantes());
	}

	public static void guardarCompradores(){
		Persistencia.guardarCompradores(subasta.getListaCompradores());
	}

	public static void guardarPujas(){
		Persistencia.guardarPujas(subasta.getListaPujas());
	}

	public static void guardarAnuncios(){
		Persistencia.guardarAnuncios(subasta.getListaAnuncios());
	}

}
