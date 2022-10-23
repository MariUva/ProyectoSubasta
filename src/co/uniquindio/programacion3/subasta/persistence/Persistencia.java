package co.uniquindio.programacion3.subasta.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import co.uniquindio.programacion3.subasta.modell.Anunciante;
import co.uniquindio.programacion3.subasta.modell.Anuncio;
import co.uniquindio.programacion3.subasta.modell.Compradores;
import co.uniquindio.programacion3.subasta.modell.Pujas;
import co.uniquindio.programacion3.subasta.modell.TipoProducto;

public class Persistencia {

	public static final String RUTA_ARCHIVO_LOG = "C:/td/Persistencia/Log/Subasta_Log.txt";
	public static final String RUTA_ARCHIVO_ANUNCIANTES = "C:/td/Persistencia/Archivos/Anunciantes.txt";
	public static final String RUTA_ARCHIVO_COMPRADORES = "C:/td/Persistencia/Archivos/Compradores.txtt";
	public static final String RUTA_ARCHIVO_PUJAS = "C:/td/Persistencia/Archivos/Pujas.txt";
	public static final String RUTA_ARCHIVO_ANUNCIOS = "C:/td/Persistencia/Archivos/Anuncios.txt";
	
	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion){
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}
	
	public static ArrayList<Anunciante> cargarAnunciantes(){
		ArrayList<Anunciante> anunciantes =new ArrayList<>();

		try {
			ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIANTES);
			String linea="";

			for (int i = 0; i < contenido.size(); i++)
			{
				linea = contenido.get(i);
				Anunciante anunciante = new Anunciante();
				anunciante.setNombre(linea.split("@@")[0]);
				anunciante.setDocumento(linea.split("@@")[1]);
				anunciante.setEdad(Integer.valueOf((linea.split("@@")[2])));
				anunciantes.add(anunciante);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anunciantes;
	}
	
	public static ArrayList<Compradores> cargarCompradores(){
		ArrayList<Compradores> compradores =new ArrayList<>();

		try {
			ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_COMPRADORES);
			String linea="";

			for (int i = 0; i < contenido.size(); i++)
			{
				linea = contenido.get(i);
				Compradores comprador = new Compradores();
				comprador.setNombre(linea.split("@@")[0]);
				comprador.setDocumento(linea.split("@@")[1]);
				comprador.setEdad(Integer.valueOf((linea.split("@@")[2])));
				comprador.setNumeroOfertas(Integer.valueOf((linea.split("@@")[3])));
				compradores.add(comprador);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compradores;
	}
	
	public static ArrayList<Pujas> cargarPujas(){
		ArrayList<Pujas> pujas =new ArrayList<>();

		try {
			ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PUJAS);
			String linea="";

			for (int i = 0; i < contenido.size(); i++)
			{
				linea = contenido.get(i);
				Pujas puja = new Pujas();
				puja.setIdComprador(linea.split("@@")[0]);
				puja.setValorOfertado(Double.valueOf((linea.split("@@")[1])));
				pujas.add(puja);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pujas;
	}
	
	public static ArrayList<Anuncio> cargarAnuncios(){
		ArrayList<Anuncio> anuncios =new ArrayList<>();

		try {
			ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIOS);
			String linea="";

			for (int i = 0; i < contenido.size(); i++)
			{
				linea = contenido.get(i);
				Anuncio anuncio = new Anuncio();
				anuncio.setNombreProdcuto(linea.split("@@")[0]);
				anuncio.setDescripcion(linea.split("@@")[1]);
				anuncio.setNombreAnunciante(linea.split("@@")[2]);
				anuncio.setFechaPpublicacion(linea.split("@@")[3]);
				anuncio.setFechaFinalizacion(linea.split("@@")[4]);
				anuncio.setValorInicial(Double.valueOf((linea.split("@@")[5])));
				anuncio.setValorSuperior(Double.valueOf((linea.split("@@")[6])));
				TipoProducto tipoProducto = obtenerTipoProducto(linea.split("@@")[7]);
				anuncio.setTipoProducto(tipoProducto);
				ArrayList<Pujas> listaPujas = obtenerPujas(linea.split("@@")[8]);
				anuncio.setListaPujas(listaPujas);
				anuncios.add(anuncio);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anuncios;
	}
	
	private static ArrayList<Pujas> obtenerPujas(String linea) {
		ArrayList<Pujas> listaPujas = new ArrayList<>();
		int i=0,j=0;
		do {
			Pujas puja = new Pujas();
			puja.setIdComprador(linea.split(";")[i]);
			puja.setValorOfertado(Double.valueOf((linea.split(";")[i+1])));
			listaPujas.add(puja);
			j=i;
			i=i+2;
		} while (linea.split(";")[j+3] == " ");
		return listaPujas;
	}

	private static TipoProducto obtenerTipoProducto(String string) {
		if(string == "TECNOLOGIA"){
			return TipoProducto.TECNOLOGIA;
		}else{
			if(string == "HOGAR"){
				return TipoProducto.HOGAR;
			}else{
				if(string == "DEPORTES"){
					return TipoProducto.DEPORTES;
				}else{
					if(string == "VEHICULOS"){
						return TipoProducto.VEHICULOS;
					}else{
						if(string == "BIEN_RAIZ"){
							return TipoProducto.BIEN_RAIZ;
						}
					}
				}
			}
		}
		return null;
	}

	public static void guardarAnunciantes(ArrayList<Anunciante> listaAnunciantes){
		String contenido = "";

		for(Anunciante anunciante : listaAnunciantes)
		{
		  contenido+= anunciante.getNombre()+"@@"+anunciante.getDocumento()+"@@"+anunciante.getEdad()+"\r\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIANTES, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void guardarCompradores(ArrayList<Compradores> listaCompradores){
		String contenido = "";

		for(Compradores comprador : listaCompradores)
		{
		  contenido+= comprador.getNombre()+"@@"+comprador.getDocumento()+"@@"+comprador.getEdad()+
				  "@@"+comprador.getNumeroOfertas()+"\r\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRADORES, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void guardarPujas(ArrayList<Pujas> listaPujas){
		String contenido = "";

		for(Pujas puja : listaPujas)
		{
		  contenido+= puja.getIdComprador()+"@@"+puja.getValorOfertado()+"\r\n";
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_COMPRADORES, contenido, false);
			String fecha = ArchivoUtil.fechaSistema;
			String ruta = "C:/td/Persistencia/Respaldo/Pujas_"+fecha+".txt";
			File file = new File(ruta);
			ArchivoUtil.guardarArchivo(ruta, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void guardarAnuncios(ArrayList<Anuncio> listaAnuncios){
		String contenido = "";
		for(Anuncio anuncio : listaAnuncios){
			String tipoProducto = obtenerStringTipoProducto(anuncio.getTipoProducto());
			String pujas = obtenerStringPujas(anuncio.getListaPujas());
			contenido+= anuncio.getNombreProdcuto()+"@@"+anuncio.getDescripcion()+"@@"+anuncio.getNombreAnunciante()+"@@"+
					anuncio.getFechaPpublicacion()+"@@"+anuncio.getFechaFinalizacion()+"@@"+anuncio.getValorInicial()+"@@"+
					anuncio.getValorSuperior()+"@@"+anuncio.getNombreAnunciante()+"@@"+tipoProducto+"@@"+pujas+" "+";"+"\r\n";	
		}
		try {
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIOS, contenido, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String obtenerStringPujas(ArrayList<Pujas> listaPujas) {
		String pujas = "";

		for(Pujas puja : listaPujas)
		{
		  pujas+= puja.getIdComprador()+";"+puja.getValorOfertado()+";";
		}
		return pujas;
	}

	private static String obtenerStringTipoProducto(TipoProducto tipoProducto) {
		if(tipoProducto.equals(TipoProducto.TECNOLOGIA)){
			return "TECNOLOGIA";
		}else{
			if(tipoProducto.equals(TipoProducto.HOGAR) ){
				return "HOGAR";
			}else{
				if(tipoProducto.equals(TipoProducto.DEPORTES)){
					return "DEPORTES";
				}else{
					if(tipoProducto.equals(TipoProducto.VEHICULOS)){
						return "VEHICULOS";
					}else{
						if(tipoProducto.equals(TipoProducto.BIEN_RAIZ)){
							return "BIEN_RAIZ";
						}
					}
				}
			}
		}
		return null;
	}
	
}
