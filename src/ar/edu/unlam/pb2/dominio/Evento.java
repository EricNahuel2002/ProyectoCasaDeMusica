package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Evento {
	private String nombre;
	private LocalDate dia;
	private LocalTime horaDeInicio;
	private LocalTime horaDeFin;
	private List<Concierto> conciertos;

	public Evento(String nombre, LocalDate dia, LocalTime horaDeInicio, LocalTime horaDeFin) {
		this.nombre = nombre;
		this.dia = dia;
		this.horaDeInicio = horaDeInicio;
		this.horaDeFin = horaDeFin;
		this.conciertos = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, horaDeFin, horaDeInicio, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(horaDeFin, other.horaDeFin)
				&& Objects.equals(horaDeInicio, other.horaDeInicio) && Objects.equals(nombre, other.nombre);
	}

	public Boolean agregarConcierto(Concierto concierto) {
		return conciertos.add(concierto);
	}
}
