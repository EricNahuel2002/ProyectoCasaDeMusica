package ar.edu.unlam.pb2.dominio;

import java.util.List;

public interface ICasaDeMusica {
	
	Boolean agregarInstrumento(Instrumento instrumento);
	Instrumento buscarInstrumentoPorCodigo(Integer codigo) throws InstrumentoNoEncontradoException;
	Double obtenerPrecioInstrumento(Integer codigo) throws InstrumentoNoEncontradoException;
	Boolean agregarEvento(Evento evento) throws Validacion1Exception, Validacion2Exception;
	/**
	 * Agrega un concierto a un evento
	 * */
	Boolean agregarConciertoAEvento(Evento evento, Concierto concierto);
	Boolean asignarInstrumentoAConciertoDeEvento(Evento evento, Concierto concierto,
			Instrumento instrumento);
	Boolean agregarConciertoInstrumentoAEvento(Evento evento, Concierto concierto,
			Instrumento instrumento);
	List<Instrumento> obtenerLosInstrumentosDeUnConciertoParaUnEvento(Evento evento, Concierto concierto);
}
