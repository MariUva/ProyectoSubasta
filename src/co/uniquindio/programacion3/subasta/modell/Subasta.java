package co.uniquindio.programacion3.subasta.modell;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.ArrayList;

import co.uniquindio.programacion3.subasta.persistence.ArchivoUtil;
import co.uniquindio.programacion3.subasta.persistence.Persistencia;

public class Subasta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Anunciante> listaAnunciantes;
	private ArrayList<Compradores> listaCompradores;
	private ArrayList<Pujas> listaPujas;
	private ArrayList<Anuncio> listaAnuncios;
	
	public Subasta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Anunciante> getListaAnunciantes() {
		return listaAnunciantes;
	}

	public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
		this.listaAnunciantes = listaAnunciantes;
	}

	public ArrayList<Compradores> getListaCompradores() {
		return listaCompradores;
	}

	public void setListaCompradores(ArrayList<Compradores> listaCompradores) {
		this.listaCompradores = listaCompradores;
	}

	public ArrayList<Pujas> getListaPujas() {
		return listaPujas;
	}

	public void setListaPujas(ArrayList<Pujas> listaPujas) {
		this.listaPujas = listaPujas;
	}
	
	public ArrayList<Anuncio> getListaAnuncios() {
		return listaAnuncios;
	}

	public void setListaAnuncios(ArrayList<Anuncio> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}

	@Override
	public String toString() {
		return "Subasta [listaAnunciantes=" + listaAnunciantes + ", listaCompradores=" + listaCompradores
				+ ", listaPujas=" + listaPujas + ", listaAnuncios=" + listaAnuncios + "]";
	}

	
	
}
=======
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Subasta {

    // Atributos de la clase
    String nit;
    String nombre;

    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
    ArrayList<Puja> listaPujas = new ArrayList<>();
    ArrayList<Anunciante> ListaAnunciantes = new ArrayList<Anunciante>();
    ArrayList<Compradores> ListaCompradores = new ArrayList<Compradores>();

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
        // TODO Auto-generated constructor stub
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

    // -----------------------CREAR PERSONA----------------

    public Persona agregarPersona(String documento, String nombre, String clave, int edad, String tipoDeUsuario) {

        if (existePersona(documento)) {

            return null;

        } else {

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre(nombre);
            nuevaPersona.setEdad(edad);
            nuevaPersona.setDocumento(documento);
            nuevaPersona.setClave(clave);
            nuevaPersona.setTipoDeUsuario(tipoDeUsuario);
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

    public boolean existeUsuario(String usuario) {
        boolean existe = false;
        for (Persona persona : listaPersonas) {
            if (persona.getNombre().equals(usuario)) {
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

    public Persona obtenerUsuario(String usuario) {

        Persona personaEncontrado = null;

        for (Persona persona : listaPersonas) {
            if (persona.getNombre().equals(usuario)) {
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
    public Anuncio agregarAnuncio(String nombreProducto, String descripcion,
            LocalDate fechaPublicacion, LocalDate fechaFinalizacion, double valorInicial,
            TipoProducto tipoProducto, String codigo, byte[] array) {

        if (existeAnuncio(codigo)) {
            return null;

        } else {
            Anuncio nuevoAnuncio = new Anuncio();

            nuevoAnuncio.setDescripcion(descripcion);
            nuevoAnuncio.setFechaFinalizacion(fechaFinalizacion);
            nuevoAnuncio.setFechaPublicacion(fechaPublicacion);
            nuevoAnuncio.setNombreProducto(nombreProducto);
            nuevoAnuncio.setTipoProducto(tipoProducto);
            nuevoAnuncio.setValorInicial(valorInicial);
            nuevoAnuncio.setCodigo(codigo);
            nuevoAnuncio.setImageByte(array);

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

    public void actualizarAnuncio(String nombreProducto, String descripcion, String nombreAnunciante,
            LocalDate fechaPublicacion, LocalDate fechaFinalizacion, double valorInicial,
            TipoProducto tipoProducto, ArrayList<Puja> listaPujas, String codigo) {

        Anuncio anuncio = obtenerAnuncio(codigo);

        if (anuncio != null) {
            anuncio.setDescripcion(descripcion);
            anuncio.setFechaFinalizacion(fechaFinalizacion);
            anuncio.setFechaPublicacion(fechaPublicacion);
            anuncio.setListaPujas(listaPujas);
            anuncio.setNombreAnunciante(nombreAnunciante);
            anuncio.setNombreProducto(nombreProducto);
            anuncio.setTipoProducto(tipoProducto);
            anuncio.setValorInicial(valorInicial);
            anuncio.setCodigo(codigo);

        }

    }

}
>>>>>>> aa609470ef03d550892fd318f96be072b871e8bd
