package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class Concierto {

	private Integer id;
	private String nombre;

	public Concierto(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concierto other = (Concierto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

}
