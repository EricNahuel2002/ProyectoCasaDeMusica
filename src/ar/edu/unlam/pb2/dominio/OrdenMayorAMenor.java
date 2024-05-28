package ar.edu.unlam.pb2.dominio;

import java.util.Comparator;

public class OrdenMayorAMenor implements Comparator<Instrumento>{

	@Override
	public int compare(Instrumento o1, Instrumento o2) {
			return o2.getCodigo().compareTo(o1.getCodigo());
	}

	

	

}
