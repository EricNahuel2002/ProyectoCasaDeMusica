package ar.edu.unlam.pb2.dominio;
import ar.edu.unlam.pb2.dominio.*;

import java.util.ArrayList;
import java.util.Comparator;
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
	public Instrumento buscarInstrumentoPorCodigo(Integer codigo) throws InstrumentoNoEncontradoException {
		for(Instrumento i : instrumentos) {
			if(i.getCodigo().equals(codigo)) {
				return i;
			}
		}
		throw new InstrumentoNoEncontradoException();
	}

	@Override
	public Double obtenerPrecioInstrumento(Integer codigo) throws InstrumentoNoEncontradoException {
		Instrumento instrumento = this.buscarInstrumentoPorCodigo(codigo);
		return instrumento.getPrecioBase();
	}

	@Override
	public Boolean agregarEvento(Evento evento) throws Validacion1Exception,Validacion2Exception {
		validacion1();
		validacion2();
		return eventos.add(evento);
	}

	private void validacion1() throws Validacion1Exception {
		throw new Validacion1Exception();
	}
	private void validacion2() throws Validacion2Exception {
		throw new Validacion2Exception();
	}

	@Override
	public Boolean agregarConciertoAEvento(Evento evento, Concierto concierto) {
		Evento eventoEncontrado = this.buscarEvento(evento);
		return eventoEncontrado.agregarConcierto(concierto);
	}

	public Evento buscarEvento(Evento evento) {
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
		for(Evento e: eventos) {
			if(e.equals(evento)) {
				return e.agregarConciertoInstrumento(new ConciertoInstrumento(concierto,instrumento));
			}
		}
		return null;
	}

	@Override
	public List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto) {
		Evento eventoEncontrado = this.buscarEvento(evento);
		return eventoEncontrado.obtenerLosInstrumentosDeUnConcierto(concierto);
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

	public List<Concierto> obtenerLosConciertosQueUsanUnInstrumento(Evento evento, Instrumento bateria) {
		Evento eventoEncontrado = this.buscarEvento(evento);
		return eventoEncontrado.obtenerLosConciertosQueUsanUnInstrumento(bateria);
	}

	public List<Evento> obtenerEventosDondeSeDioUnConcierto(Concierto concierto) {
		List<Evento> eventosAux = new ArrayList<>();
		for(Evento e: eventos) {
			for(Concierto c: e.getConciertos()) {
				if(c.equals(concierto)) {
					eventosAux.add(e);
				}
			}
		}
		return eventosAux;
	}

	public List<Concierto> obtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra(Evento evento) {
		Evento eventoEncontrado = this.buscarEvento(evento);
		return eventoEncontrado.obtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra();
	}

	public TreeSet<Instrumento> obtenerUnaListaOrdenadaDeInstrumentosPorCodigo() {
		return instrumentos;
	}

	public TreeSet<Instrumento> obtenerUnaListaOrdenadaDeInstrumentosPorOrdenEspecifico(
			Comparator<Instrumento> ordenEspecifico) {
		TreeSet<Instrumento> instrumentosAux = new TreeSet<Instrumento>(ordenEspecifico);
		instrumentosAux.addAll(instrumentos);
		return instrumentosAux;
	}
}
