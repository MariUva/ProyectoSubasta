package co.uniquindio.programacion3.subasta.modell;

import java.time.LocalDate;
import java.util.ArrayList;

public class Anuncio {

	// Declaracion de atributos
	private String nombreProducto;
	private String descripcion;
	private String nombreAnunciante;
	private LocalDate fechaPublicacion;
	private LocalDate fechaFinalizacion;
	private double valorInicial;
	private double valorSuperior;
	private TipoProducto tipoProducto;
	private ArrayList<Puja> listaPujas;
	private String codigo;
	private byte[] imageByte;

	// Metodo constructor
	 public Anuncio(String nombreProducto, String descripcion, String nombreAnunciante, LocalDate fechaPublicacion,
	            LocalDate fechaFinalizacion, double valorInicial, double valorSuperior, TipoProducto tipoProducto,
	            ArrayList<Puja> listaPujas, String codigo, byte[] imageByte) {
	        super();
	        this.nombreProducto = nombreProducto;
	        this.descripcion = descripcion;
	        this.nombreAnunciante = nombreAnunciante;
	        this.fechaPublicacion = fechaPublicacion;
	        this.fechaFinalizacion = fechaFinalizacion;
	        this.valorInicial = valorInicial;
	        this.valorSuperior = valorSuperior;
	        this.tipoProducto = tipoProducto;
	        this.listaPujas = listaPujas;
	        this.codigo = codigo;
	        this.imageByte = imageByte;
	    }



	// Metodos getters and setters

	public byte[] getImageByte() {
        return imageByte;
    }



    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }



    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }




    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }


    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }


    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }


    public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreAnunciante() {
		return nombreAnunciante;
	}

	public void setNombreAnunciante(String nombreAnunciante) {
		this.nombreAnunciante = nombreAnunciante;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public double getValorSuperior() {
		return valorSuperior;
	}

	public void setValorSuperior(double valorSuperior) {
		this.valorSuperior = valorSuperior;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public void setListaPujas(ArrayList<Puja> listaPujas2) {
		this.listaPujas = listaPujas2;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	// Metodo constructor vacio

	public Anuncio() {
		super();
	}

	public ArrayList<Puja> getListaPujas() {
		return listaPujas;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaFinalizacion == null) ? 0 : fechaFinalizacion.hashCode());
		result = prime * result + ((fechaPublicacion == null) ? 0 : fechaPublicacion.hashCode());
		result = prime * result + ((listaPujas == null) ? 0 : listaPujas.hashCode());
		result = prime * result + ((nombreAnunciante == null) ? 0 : nombreAnunciante.hashCode());
		result = prime * result + ((nombreProducto == null) ? 0 : nombreProducto.hashCode());
		result = prime * result + ((tipoProducto == null) ? 0 : tipoProducto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorInicial);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorSuperior);
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
		Anuncio other = (Anuncio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaFinalizacion == null) {
			if (other.fechaFinalizacion != null)
				return false;
		} else if (!fechaFinalizacion.equals(other.fechaFinalizacion))
			return false;
		if (fechaPublicacion == null) {
			if (other.fechaPublicacion != null)
				return false;
		} else if (!fechaPublicacion.equals(other.fechaPublicacion))
			return false;
		if (listaPujas == null) {
			if (other.listaPujas != null)
				return false;
		} else if (!listaPujas.equals(other.listaPujas))
			return false;
		if (nombreAnunciante == null) {
			if (other.nombreAnunciante != null)
				return false;
		} else if (!nombreAnunciante.equals(other.nombreAnunciante))
			return false;
		if (nombreProducto == null) {
			if (other.nombreProducto != null)
				return false;
		} else if (!nombreProducto.equals(other.nombreProducto))
			return false;
		if (tipoProducto != other.tipoProducto)
			return false;
		if (Double.doubleToLongBits(valorInicial) != Double.doubleToLongBits(other.valorInicial))
			return false;
		if (Double.doubleToLongBits(valorSuperior) != Double.doubleToLongBits(other.valorSuperior))
			return false;
		return true;
	}

	// Metodo toString

	@Override
	public String toString() {
		return "Anuncio [nombreProducto=" + nombreProducto + ", descripcion=" + descripcion + ", nombreAnunciante="
				+ nombreAnunciante + ", fechaPublicacion=" + fechaPublicacion + ", fechaFinalizacion="
				+ fechaFinalizacion + ", valorInicial=" + valorInicial + ", valorSuperior=" + valorSuperior
				+ ", tipoProducto=" + tipoProducto + ", listaPujas=" + listaPujas + ", codigo=" + codigo + "]";
	}

}
