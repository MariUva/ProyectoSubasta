package co.uniquindio.programacion3.subasta.modell;

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
