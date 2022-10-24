package co.uniquindio.programacion3.subasta.modell;

import java.util.ArrayList;

public class Subasta {

	// Atributos de la clase
	String nit;
	String nombre;

	ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
	ArrayList<Puja> listaPujas = new ArrayList<>();
	ArrayList<Anunciante> ListaAnunciantes = new ArrayList<Anunciante>();
	ArrayList<Compradores> ListaCompradores = new ArrayList<Compradores>();

	public ArrayList<Anunciante> getListaAnunciantes() {
		return ListaAnunciantes;
	}

	public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
		ListaAnunciantes = listaAnunciantes;
	}

	public ArrayList<Compradores> getListaCompradores() {
		return ListaCompradores;
	}

	public void setListaCompradores(ArrayList<Compradores> listaCompradores) {
		ListaCompradores = listaCompradores;
	}

	// Metodo constructor
	public Subasta(String nit, String nombre, ArrayList<Persona> listaPersonas, ArrayList<Anuncio> listaAnuncions,
			ArrayList<Puja> listaPujas) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.listaPersonas = listaPersonas;
		this.listaAnuncios = listaAnuncions;
		this.listaPujas = listaPujas;
	}

	// Metodo contructor vacio
	public Subasta() {
		super();
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Subasta [nit=" + nit + ", nombre=" + nombre + ", listaPersonas=" + listaPersonas + ", listaAnuncions="
				+ listaAnuncios + ", listaPujas=" + listaPujas + "]";
	}

	// Metodos getters and setters
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public ArrayList<Anuncio> getListaAnuncios() {
		return listaAnuncios;
	}

	public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}

	public ArrayList<Puja> getListaPujas() {
		return listaPujas;
	}

	public void setListaPujas(ArrayList<Puja> listaPujas) {
		this.listaPujas = listaPujas;
	}

	// -----------------------CREAR PERSONA----------------

	public Persona agregarPersona(String documento, String nombre, String clave, int edad) {

		if (existePersona(documento)) {
			return null;

		} else {
			Persona nuevaPersona = new Persona();
			nuevaPersona.setNombre(nombre);
			nuevaPersona.setEdad(edad);
			nuevaPersona.setDocumento(documento);
			nuevaPersona.setClave(clave);
			getListaPersonas().add(nuevaPersona);
			return nuevaPersona;
		}

	}

	private boolean existePersona(String documento) {
		boolean existe = false;
		for (Persona persona : listaPersonas) {
			if (persona.getDocumento().equals(documento)) {
				existe = true;
				return existe;

			}

		}

		return false;
	}

	public Boolean eliminarPersona(String documento) {
		Boolean flagEliminado = false;
		Persona persona = obtenerPersona(documento);

		if (persona != null) {
			getListaPersonas().remove(persona);
			flagEliminado = true;
		}
		return flagEliminado;
	}

	public Persona obtenerPersona(String documentoPersona) {

		Persona personaEncontrado = null;

		for (Persona persona : listaPersonas) {
			if (persona.getDocumento().equals(documentoPersona)) {
				personaEncontrado = persona;
				break;

			}
		}
		return personaEncontrado;

	}

	public void actualizarPersona(String documento, String nombre, String clave, int edad) {
		Persona persona = obtenerPersona(documento);

		if (persona != null) {
			persona.setClave(clave);
			persona.setDocumento(documento);
			persona.setEdad(edad);
			persona.setNombre(nombre);

		}
	}

	// -----------------------CREAR ANUNCIO----------------
	public Anuncio agregarAnuncio(String nombreProdcuto, String descripcion, String nombreAnunciante,
			String fechaPublicacion, String fechaFinalizacion, double valorInicial, double valorSuperior,
			TipoProducto tipoProducto, ArrayList<Puja> listaPujas, String codigo) {

		if (existeAnuncio(codigo)) {
			return null;

		} else {
			Anuncio nuevoAnuncio = new Anuncio();

			nuevoAnuncio.setDescripcion(descripcion);
			nuevoAnuncio.setFechaFinalizacion(fechaFinalizacion);
			nuevoAnuncio.setFechaPublicacion(fechaPublicacion);
			nuevoAnuncio.setListaPujas(listaPujas);
			nuevoAnuncio.setNombreAnunciante(nombreAnunciante);
			nuevoAnuncio.setNombreProdcuto(nombreProdcuto);
			nuevoAnuncio.setTipoProducto(tipoProducto);
			nuevoAnuncio.setValorInicial(valorInicial);
			nuevoAnuncio.setValorSuperior(valorSuperior);
			nuevoAnuncio.setCodigo(codigo);

			getListaAnuncios().add(nuevoAnuncio);
			return nuevoAnuncio;

		}

	}

	public boolean existeAnuncio(String codigo) {
		boolean existe = false;
		for (Anuncio anuncio : listaAnuncios) {
			if (anuncio.getCodigo().equals(codigo)) {
				existe = true;
				return existe;

			}

		}
		return existe;
	}

	public Boolean eliminarAnuncio(String codigo) {
		Boolean flagEliminado = false;
		Anuncio anuncio = obtenerAnuncio(codigo);

		if (anuncio != null) {
			getListaAnuncios().remove(anuncio);
			flagEliminado = true;

		}
		return flagEliminado;
	}

	public Anuncio obtenerAnuncio(String codigoAnuncio) {
		Anuncio anuncioEncontrado = null;
		for (Anuncio anuncio : listaAnuncios) {
			if (anuncio.getCodigo().equals(codigoAnuncio)) {
				anuncioEncontrado = anuncio;
				break;

			}
		}
		return anuncioEncontrado;

	}

	public void actualizarAnuncio(String nombreProdcuto, String descripcion, String nombreAnunciante,
			String fechaPublicacion, String fechaFinalizacion, double valorInicial, double valorSuperior,
			TipoProducto tipoProducto, ArrayList<Puja> listaPujas, String codigo) {

		Anuncio anuncio = obtenerAnuncio(codigo);

		if (anuncio != null) {
			anuncio.setDescripcion(descripcion);
			anuncio.setFechaFinalizacion(fechaFinalizacion);
			anuncio.setFechaPublicacion(fechaPublicacion);
			anuncio.setListaPujas(listaPujas);
			anuncio.setNombreAnunciante(nombreAnunciante);
			anuncio.setNombreProdcuto(nombreProdcuto);
			anuncio.setTipoProducto(tipoProducto);
			anuncio.setValorInicial(valorInicial);
			anuncio.setValorSuperior(valorSuperior);
			anuncio.setCodigo(codigo);

		}

	}

}
