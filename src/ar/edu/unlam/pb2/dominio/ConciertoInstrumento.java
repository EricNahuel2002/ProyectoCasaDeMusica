package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class ConciertoInstrumento {

	private Concierto concierto;
	private Instrumento instrumento;

	public ConciertoInstrumento(Concierto concierto, Instrumento instrumento) {
		this.concierto = concierto;
		this.instrumento = instrumento;
	}

	public Concierto getConcierto() {
		return concierto;
	}

	public Instrumento getInstrumento() {
		return instrumento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(concierto, instrumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConciertoInstrumento other = (ConciertoInstrumento) obj;
		return Objects.equals(concierto, other.concierto) && Objects.equals(instrumento, other.instrumento);
	}

}
