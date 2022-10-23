package co.uniquindio.programacion3.subasta.modell;

public enum Rol {

	VENDEDOR(1, "Vendedor"), COMPRADOR(2, "Comprador");

	int numTipo;
	String nombreTipo;

	// Constructor privado para que las personas no sepan que se creo si no que
	// quede almacenado dentro de la subasta
	private Rol(int numTipo, String nombreTipo) {
		this.nombreTipo = nombreTipo;
		this.numTipo = numTipo;
	}

	// Metodos getters and setters
	public int getNumTipo() {
		return numTipo;
	}

	public void setNumTipo(int numTipo) {
		this.numTipo = numTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

}
