package co.uniquindio.programacion3.subasta.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import co.uniquindio.programacion3.subasta.exception.NoCreadoException;
import co.uniquindio.programacion3.subasta.modell.Anunciante;
import co.uniquindio.programacion3.subasta.modell.Anuncio;
import co.uniquindio.programacion3.subasta.modell.Compradores;
import co.uniquindio.programacion3.subasta.modell.Persona;
import co.uniquindio.programacion3.subasta.modell.Puja;
import co.uniquindio.programacion3.subasta.modell.Subasta;
import co.uniquindio.programacion3.subasta.modell.TipoProducto;

public class Persistencia {

    public static final String RUTA_ARCHIVO_PERSONAS = "/Subasta/Persistencia/Archivos/Personas.txt";
    public static final String RUTA_ARCHIVO_ANUNCIANTES = "/Subasta/Persistencia/Archivos/Anunciantes.txt";
    public static final String RUTA_ARCHIVO_COMPRADORES = "/Subasta/Persistencia/Archivos/Compradores.txt";
    public static final String RUTA_ARCHIVO_LOG = "/Subasta/Persistencia/Log/Subasta_Log.txt";
    public static final String RUTA_ARCHIVO_PUJAS = "/Subasta/Persistencia/Archivos/Pujas.txt"
            + ArchivoUtil.fechaSistema + ".txt";

    public static final String RUTA_ARCHIVO_SUBASTA_BINARIO = "/Subasta/Persistencia/model.dat";
    public static final String RUTA_ARCHIVO_SUBASTA_XML = "/Subasta/Persistencia/model.xml";

    // public static final String RUTA_ARCHIVO_PUJAS =
    // "C:/td/Persistencia/Archivos/Pujas.txt";
    public static final String RUTA_ARCHIVO_ANUNCIOS = "C:/td/Persistencia/Archivos/Anuncios.txt";

    public static void cargarDatosArchivos(Subasta subasta) throws FileNotFoundException, IOException {

        // Cargar archivo anunciantes
        ArrayList<Anunciante> anunciantesCargados = cargarAnunciantes();
        if (anunciantesCargados.size() > 0) {
            subasta.getListaAnunciantes().addAll(anunciantesCargados);

        }

        // Cargar archivo compradores
        ArrayList<Compradores> compradoresCargador = cargarCompradores();
        if (compradoresCargador.size() > 0) {
            subasta.getListaCompradores().addAll(compradoresCargador);

        }

    }

    /**
     * Guarda en un archivo de texto todos la informaci n de las personas
     * almacenadas en el ArrayList
     *
     * @param objetos
     * @param ruta
     * @throws IOException
     */
    public static void guardarPersonas(ArrayList<Persona> listaPersonas) throws IOException {
        String contenido = "";

        for (Persona persona : listaPersonas) {
            contenido += persona.getNombre() + "@@" + persona.getDocumento() + "@@" + persona.getEdad() + "@@"
                    + persona.getClave() + "\r\n";

        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PERSONAS, contenido, false);

    }

    public static void guardarAnunciantes(ArrayList<Anunciante> listaAnunciantes) throws IOException {

        String contenido = "";

        for (Anunciante anunciante : listaAnunciantes) {
            contenido += anunciante.getNombre() + "@@" + anunciante.getDocumento() + "@@" + anunciante.getEdad() + "@@"
                    + anunciante.getClave() + "\r\n";
        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIANTES, contenido, false);

    }

    public static void guardarCompradores(ArrayList<Compradores> listaCompradores) throws IOException {

        String contenido = "";

        for (Compradores comprador : listaCompradores) {
            contenido += comprador.getNombre() + "@@" + comprador.getDocumento() + "@@" + comprador.getEdad() + "@@"
                    + comprador.getClave() + "@@" + +comprador.getNumeroOfertas() + "\r\n";
        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRADORES, contenido, false);

    }

    public static void guardarPujas(ArrayList<Puja> listaPujas) throws IOException {

        String contenido = "";

        for (Puja puja : listaPujas) {
            contenido += puja.getIdComprador() + "@@" + puja.getValorOfertado() + "@@" + puja.getCodigoPuja() + "@@"
                    + puja.getFinPuja() + "@@" + puja.getInicioPuja() + "@@" + puja.getNombreProducto() + "\r\n";
        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRADORES, contenido, false);
        // File file = new File(RUTA_ARCHIVO_PUJAS);
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PUJAS, contenido, false);
    }

    public static void guardarAnuncios(ArrayList<Anuncio> listaAnuncios) throws IOException {

        String contenido = "";

        for (Anuncio anuncio : listaAnuncios) {

            String tipoProducto = obtenerStringTipoProducto(anuncio.getTipoProducto());
            String pujas = obtenerStringPujas(anuncio.getListaPujas());

            contenido += anuncio.getNombreProdcuto() + "@@" + anuncio.getDescripcion() + "@@"
                    + anuncio.getNombreAnunciante() + "@@" + anuncio.getFechaPublicacion() + "@@"
                    + anuncio.getFechaFinalizacion() + "@@" + anuncio.getValorInicial() + "@@"
                    + anuncio.getValorSuperior() + "@@" + tipoProducto + "@@" + anuncio.getCodigo() + "@@" + pujas + " "
                    + ";" + "\r\n";
        }

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIOS, contenido, false);

    }

    // ----------------------LOADS------------------------

    /**
     *
     * @param tipoPersona
     * @param ruta
     * @return un Arraylist de personas con los datos obtenidos del archivo de
     * texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static ArrayList<Persona> cargarPersonas() throws IOException {

        ArrayList<Persona> personas = new ArrayList<Persona>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PERSONAS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Persona persona = new Persona();
            persona.setClave(linea.split("@@")[0]);
            persona.setDocumento(linea.split("@@")[1]);
            persona.setEdad(Integer.valueOf((linea.split("@@")[2])));
            persona.setNombre(linea.split("@@")[3]);
            personas.add(persona);
        }
        return personas;

    }

    public static ArrayList<Anunciante> cargarAnunciantes() throws IOException {

        ArrayList<Anunciante> anunciantes = new ArrayList<Anunciante>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIANTES);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Anunciante anunciante = new Anunciante();
            anunciante.setNombre(linea.split("@@")[0]);
            anunciante.setDocumento(linea.split("@@")[1]);
            anunciante.setEdad(Integer.valueOf((linea.split("@@")[2])));
            anunciante.setClave(linea.split("@@")[3]);
            anunciantes.add(anunciante);

        }
        return anunciantes;
    }

    public static ArrayList<Compradores> cargarCompradores() throws IOException {

        ArrayList<Compradores> compradores = new ArrayList<Compradores>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_COMPRADORES);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Compradores comprador = new Compradores();
            comprador.setNombre(linea.split("@@")[0]);
            comprador.setDocumento(linea.split("@@")[1]);
            comprador.setEdad(Integer.valueOf((linea.split("@@")[2])));
            comprador.setClave(linea.split("@@")[3]);
            comprador.setNumeroOfertas(Integer.valueOf((linea.split("@@")[4])));
            compradores.add(comprador);

        }
        return compradores;
    }

    private static ArrayList<Persona> obtenerPersonas(String linea) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        int i = 0, j = 0;
        do {
            Persona persona = new Persona();
            persona.setClave(linea.split(";")[i]);
            persona.setDocumento(linea.split(";")[i]);
            persona.setEdad(Integer.valueOf((linea.split(";")[i + 1])));
            persona.setNombre(linea.split(";")[i]);

            listaPersonas.add(persona);
            j = i;
            i = i + 2;
        } while (linea.split(";")[j + 3] == " ");
        return listaPersonas;
    }

    public static ArrayList<Puja> cargarPujas() throws IOException {
        ArrayList<Puja> pujas = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PUJAS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Puja puja = new Puja();
            puja.setIdComprador(linea.split("@@")[0]);
            puja.setValorOfertado(Double.valueOf((linea.split("@@")[1])));
            puja.setCodigoPuja(linea.split("@@")[2]);
            puja.setFinPuja(Double.valueOf((linea.split("@@")[3])));
            puja.setInicioPuja(Double.valueOf((linea.split("@@")[4])));
            ArrayList<Persona> listaPersonas = obtenerPersonas(linea.split("@@")[5]);
            puja.setNombreProducto(linea.split("@@")[6]);

            pujas.add(puja);
        }

        return pujas;
    }

    private static ArrayList<Puja> obtenerPujas(String linea) {
        ArrayList<Puja> listaPujas = new ArrayList<>();
        int i = 0, j = 0;
        do {
            Puja puja = new Puja();
            puja.setIdComprador(linea.split(";")[i]);
            puja.setCodigoPuja(linea.split(";")[i]);
            puja.setFinPuja(Double.valueOf((linea.split(";")[i + 1])));
            puja.setInicioPuja(Double.valueOf((linea.split(";")[i + 1])));
            // puja.setListaPersonas(listaPersonas);
            puja.setNombreProducto(linea.split(";")[i]);
            puja.setValorOfertado(Double.valueOf((linea.split(";")[i + 1])));
            listaPujas.add(puja);
            j = i;
            i = i + 2;
        } while (linea.split(";")[j + 3] == " ");
        return listaPujas;
    }

    public static ArrayList<Anuncio> cargarAnuncios() throws IOException {

        ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIOS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Anuncio anuncio = new Anuncio();
            anuncio.setNombreProdcuto(linea.split("@@")[0]);
            anuncio.setDescripcion(linea.split("@@")[1]);
            anuncio.setNombreAnunciante(linea.split("@@")[2]);
            anuncio.setFechaPublicacion(linea.split("@@")[3]);
            anuncio.setFechaFinalizacion(linea.split("@@")[4]);
            anuncio.setValorInicial(Double.valueOf((linea.split("@@")[5])));
            anuncio.setValorSuperior(Double.valueOf((linea.split("@@")[6])));
            TipoProducto tipoProducto = obtenerTipoProducto(linea.split("@@")[7]);
            anuncio.setTipoProducto(tipoProducto);
            ArrayList<Puja> listaPujas = obtenerPujas(linea.split("@@")[8]);
            anuncio.setListaPujas(listaPujas);
            anuncio.setCodigo(linea.split("@@")[9]);
            anuncios.add(anuncio);
        }

        return anuncios;
    }

    // -----------------------REGISTRO LOG------------------
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }

    // ----------------------EXCEPCIONES-----------------

    public static boolean iniciarSesion(String nombre, String clave)
            throws FileNotFoundException, IOException, NoCreadoException {

        if (validarUsuario(nombre, clave)) {
            return true;
        } else {
            throw new NoCreadoException("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String nombre, String clave) throws FileNotFoundException, IOException {

        ArrayList<Persona> personas = Persistencia.cargarPersonas();

        for (int indicePersona = 0; indicePersona < personas.size(); indicePersona++) {
            Persona personaAux = personas.get(indicePersona);
            if (personaAux.getNombre().equalsIgnoreCase(nombre) && personaAux.getClave().equalsIgnoreCase(clave)) {
                return true;
            }
        }
        return false;
    }

    // ----------------------SAVES------------------------

    // /**
    // * Guarda en un archivo de texto todos la informaci n de las personas
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

    // ------------------------------------SERIALIZACI N y XML

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
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_SUBASTA_BINARIO, subasta);
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

    // -----------------------------------------------------------------------------

    private static TipoProducto obtenerTipoProducto(String string) {
        if (string == "TECNOLOGIA") {
            return TipoProducto.TECNOLOGIA;
        } else {
            if (string == "HOGAR") {
                return TipoProducto.HOGAR;
            } else {
                if (string == "DEPORTES") {
                    return TipoProducto.DEPORTES;
                } else {
                    if (string == "VEHICULOS") {
                        return TipoProducto.VEHICULOS;
                    } else {
                        if (string == "BIEN_RAIZ") {
                            return TipoProducto.BIEN_RAIZ;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String obtenerStringPujas(ArrayList<Puja> puja2) {
        String pujas = "";

        for (Puja puja : puja2) {
            pujas += puja.getIdComprador() + ";" + puja.getValorOfertado() + ";";
        }
        return pujas;
    }

    private static String obtenerStringTipoProducto(TipoProducto tipoProducto) {
        if (tipoProducto.equals(TipoProducto.TECNOLOGIA)) {
            return "TECNOLOGIA";
        } else {
            if (tipoProducto.equals(TipoProducto.HOGAR)) {
                return "HOGAR";
            } else {
                if (tipoProducto.equals(TipoProducto.DEPORTES)) {
                    return "DEPORTES";
                } else {
                    if (tipoProducto.equals(TipoProducto.VEHICULOS)) {
                        return "VEHICULOS";
                    } else {
                        if (tipoProducto.equals(TipoProducto.BIEN_RAIZ)) {
                            return "BIEN_RAIZ";
                        }
                    }
                }
            }
        }
        return null;
    }

}