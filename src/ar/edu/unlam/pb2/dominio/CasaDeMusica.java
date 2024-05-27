package ar.edu.unlam.pb2.dominio;
import ar.edu.unlam.pb2.dominio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CasaDeMusica implements ICasaDeMusica{

	private String nombre;
	private TreeSet<Instrumento> instrumentos;
	private List<Evento> eventos;

	public CasaDeMusica(String nombreCasaMusical) {
		this.nombre = nombreCasaMusical;
		this.instrumentos = new TreeSet<>();
		this.eventos = new ArrayList<>();
	}

	public Boolean agregarInstrumento(Instrumento guitarraElectrica) {
		return instrumentos.add(guitarraElectrica);
	}

	@Override
	public Instrumento buscarInstrumentoPorCodigo(Integer codigo) {
		for(Instrumento i : instrumentos) {
			if(i.getCodigo().equals(codigo)) {
				return i;
			}
		}
		return null;
	}

	@Override
	public Double obtenerPrecioInstrumento(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean agregarEvento(Evento evento) {
		return eventos.add(evento);
	}

	@Override
	public Boolean agregarConciertoAEvento(Evento evento, Concierto concierto) {
		Evento eventoEncontrado = this.buscarEvento(evento);
		return eventoEncontrado.agregarConcierto(concierto);
	}

	private Evento buscarEvento(Evento evento) {
		for(Evento e: eventos) {
			if(e.equals(evento)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto, Instrumento instrumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean agregarConciertoInstrumentoAEvento(Evento evento, Concierto concierto, Instrumento instrumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Instrumento> obtenerGuitarras() {
		List<Instrumento> instrumentosAux = new ArrayList<>();
		for(Instrumento i : instrumentos) {
			if(i instanceof GuitarraElectrica) {
				instrumentosAux.add(i);
			}
		}
		return instrumentosAux;
	}

	public TreeSet<Instrumento> obtenerInstrumentosOrdenados() {
		return instrumentos;
	}

}
