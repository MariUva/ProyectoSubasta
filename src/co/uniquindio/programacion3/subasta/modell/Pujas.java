package co.uniquindio.programacion3.subasta.modell;

import java.util.ArrayList;

public class Pujas {

	String idComprador;
	double valorOfertado;

	ArrayList<String> listaPujas = new ArrayList<String>();

	// Metodos getters and setters
	public String getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(String idComprador) {
		this.idComprador = idComprador;
	}

	public double getValorOfertado() {
		return valorOfertado;
	}

	public void setValorOfertado(double valorOfertado) {
		this.valorOfertado = valorOfertado;
	}

	public ArrayList<String> getListaPujas() {
		return listaPujas;
	}

	public void setListaPujas(ArrayList<String> listaPujas) {
		this.listaPujas = listaPujas;
	}

	// Metodo constructor vacio
	public Pujas() {
		super();
	}

	// Metodo constructor
	public Pujas(String idComprador, double valorOfertado, ArrayList<String> listaPujas) {
		super();
		this.idComprador = idComprador;
		this.valorOfertado = valorOfertado;
		this.listaPujas = listaPujas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idComprador == null) ? 0 : idComprador.hashCode());
		result = prime * result + ((listaPujas == null) ? 0 : listaPujas.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorOfertado);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pujas other = (Pujas) obj;
		if (idComprador == null) {
			if (other.idComprador != null)
				return false;
		} else if (!idComprador.equals(other.idComprador))
			return false;
		if (listaPujas == null) {
			if (other.listaPujas != null)
				return false;
		} else if (!listaPujas.equals(other.listaPujas))
			return false;
		if (Double.doubleToLongBits(valorOfertado) != Double.doubleToLongBits(other.valorOfertado))
			return false;
		return true;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Pujas [idComprador=" + idComprador + ", valorOfertado=" + valorOfertado + ", listaPujas=" + listaPujas
				+ "]";
	}

}
