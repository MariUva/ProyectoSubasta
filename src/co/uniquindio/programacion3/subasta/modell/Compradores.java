package co.uniquindio.programacion3.subasta.modell;

<<<<<<< HEAD
<<<<<<< HEAD
public class Compradores extends Persona{
=======
public class Compradores extends Persona {

	public Compradores (String documento, String nombre, int edad, String clave, String tipoDeUsuario) {
		super(documento, nombre, clave, edad, tipoDeUsuario);
	}
>>>>>>> aa609470ef03d550892fd318f96be072b871e8bd
=======
public class Compradores {
>>>>>>> parent of b92a5be (Actualizacion)

	// Declaracion de atributos
	int numeroOfertas;

	// Metodos getters and setters
	public int getNumeroOfertas() {
		return numeroOfertas;
	}

	public void setNumeroOfertas(int numeroOfertas) {
		this.numeroOfertas = numeroOfertas;
	}

	// Metodo constructor vacio
	public Compradores() {
		super();
	}

	// Metodo constructor
	public Compradores(int numeroOfertas) {
		super();
		this.numeroOfertas = numeroOfertas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroOfertas;
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
		Compradores other = (Compradores) obj;
		if (numeroOfertas != other.numeroOfertas)
			return false;
		return true;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Compradores [numeroOfertas=" + numeroOfertas + "]";
	}

}
