package co.uniquindio.programacion3.subasta.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.uniquindio.programacion3.subasta.modell.Anunciante;
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
        // El constructor de Singleton puede ser llamado desde aquï¿½ al ser
        // protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Mï¿½todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    ArrayList<Anunciante> listaAnunciantes = new ArrayList<>();

    public ModelFactoryController() {

        // 1. inicializar datos y luego guardarlo en archivos
        // iniciarSalvarDatosPrueba();
        iniciarSalvarDatosPrueba();
        cargarDatosDesdeArchivos();

        // 2. Cargar los datos de los archivos
        // cargarDatosDesdeArchivos();

        // 3. Guardar y Cargar el recurso serializable binario
        // guardarResourceBinario();
        guardarResourceBinario();
        cargarResourceBinario();

        // 4. Guardar y Cargar el recurso serializable XML
        // guardarResourceXML();
        guardarResourceXML();
        cargarResourceXML();

        // Siempre se debe verificar si la raiz del recurso es null
        if (subasta == null) {
            System.out.println("Es null");
            inicializarDatos();
            // guardarResourceSerializable();
            guardarResourceXML();
        }

        // Registrar la accion de incio de sesiï¿½n

        Persistencia.guardaRegistroLog("Inicio de sesiÃ³n del usuario:pedro", 1, "inicioSesion");
    }

    private void iniciarSalvarDatosPrueba() {

        inicializarDatos();

        try {

            Persistencia.guardarPersonas(getSubasta().getListaPersonas());
            Persistencia.guardarAnunciantes(getSubasta().getListaAnunciantes());
            Persistencia.guardarAnuncios(getSubasta().getListaAnuncios());
            Persistencia.guardarCompradores(getSubasta().getListaCompradores());

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

    public void inicializarDatos() {

        subasta = new Subasta();

        Persona persona = new Persona();
        persona.setClave("0000");
        persona.setDocumento("1234");
        persona.setEdad(20);
        persona.setNombre("Ana");

        subasta.getListaPersonas().add(persona);

        System.out.println("Subasta inicializado " + subasta);

    }

    // --------------- GETTERS AND SETTERS---------------

    public static Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public ArrayList<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }

    // -----------------PERSONA------------------

    public static Persona crearPersona(String documento, String nombre, String clave, int edad, String tipoDeUsuario) {

        Persona persona = null;
        try {
            persona = subasta.agregarPersona(documento, nombre, clave, edad, tipoDeUsuario);
        } catch (Exception e) {
            e.getMessage();

        }
        return persona;

    }

    public static Persona buscarPersona(String nombre) {

        Persona persona = null;
        try {
            persona = getSubasta().obtenerUsuario(nombre);
        } catch (Exception e) {
            e.getMessage();

        }
        return persona;

    }

    public static Boolean existeUsuario (String nombre){

        try {

            if (getSubasta().existeUsuario(nombre)){
                return true;
            }

        } catch (Exception e) {
            e.getMessage();

        }
        return false;
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

    // -----------------ANUNCIO------------------

    public Anuncio crearAnuncio(String nombreProdcuto, String descripcion, String nombreAnunciante,
            String fechaPublicacion, String fechaFinalizacion, double valorInicial, double valorSuperior,
            TipoProducto tipoProducto, ArrayList<Puja> listaPujas, String codigo) {

        Anuncio anuncio = null;
        try {
            anuncio = getSubasta().agregarAnuncio(nombreProdcuto, descripcion, nombreAnunciante, fechaPublicacion,
                    fechaFinalizacion, valorInicial, valorSuperior, tipoProducto, listaPujas,
                    codigo);
        } catch (Exception e) {
            e.getMessage();

        }
        return anuncio;

    }
    // public Anuncio crearAnuncio(String nombreProdcuto, String descripcion,
    // String nombreAnunciante,
    // String fechaPublicacion, String fechaFinalizacion, double valorInicial,
    // double valorSuperior,
    // TipoProducto tipoProducto, Puja listaPujas, String codigo) {
    //
    // Anuncio anuncio = null;
    // try {
    // anuncio = getSubasta().agregarAnuncio(nombreProdcuto, descripcion,
    // nombreAnunciante, fechaPublicacion,
    // fechaFinalizacion, valorInicial, valorSuperior, tipoProducto, listaPujas,
    // codigo);
    // } catch (Exception e) {
    // e.getMessage();
    //
    // }
    // return anuncio;
    //
    // }

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

    public static void cargarDatos() throws IOException {

        subasta.setListaAnunciantes(Persistencia.cargarAnunciantes());
        subasta.setListaCompradores(Persistencia.cargarCompradores());
        subasta.setListaPujas(Persistencia.cargarPujas());
        subasta.setListaAnuncios(Persistencia.cargarAnuncios());
    }

    public static void guardarAnunciantes() throws IOException {
        Persistencia.guardarAnunciantes(subasta.getListaAnunciantes());
    }

    public static void guardarCompradores() throws IOException {
        Persistencia.guardarCompradores(subasta.getListaCompradores());
    }

    public static void guardarPujas() throws IOException {
        Persistencia.guardarPujas(subasta.getListaPujas());
    }

    public static void guardarAnuncios() throws IOException {
        Persistencia.guardarAnuncios(subasta.getListaAnuncios());
    }

}
