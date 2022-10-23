package co.uniquindio.programacion3.subasta.controller;

import co.uniquindio.programacion3.subasta.modell.Subasta;
import co.uniquindio.programacion3.subasta.persistence.Persistencia;

public class ModelFactoryController {
	static Subasta subasta = new Subasta();
	
	public static void guardarRegistroLog(String mensajeLog, int nivel, String accion){
		Persistencia.guardarRegistroLog(mensajeLog, nivel, accion);
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
