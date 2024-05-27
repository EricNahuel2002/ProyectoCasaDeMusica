package ar.edu.unlam.pb2.paquetetest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.*;

public class TestCasaDeMusica {

	private static final String NOMBRE_CASA_MUSICAL = "Casa musical";
	private CasaDeMusica casaDeMusica;

	@Before
	public void init() {
		this.casaDeMusica = new CasaDeMusica(NOMBRE_CASA_MUSICAL);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoGuitarraElectricaALaCasaDeMusica() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);

		Boolean instrumentoAgregado = casaDeMusica.agregarInstrumento(guitarraElectrica);

		assertTrue(instrumentoAgregado);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoBateriaALaCasaDeMusica() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);

		Boolean instrumentoAgregado = casaDeMusica.agregarInstrumento(bateria);

		assertTrue(instrumentoAgregado);
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarGuitarrasElectricasObtengoLoPropio() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		Instrumento guitarraElectrica2 = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica2);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);

		List<Instrumento> instrumentosObtenidos = casaDeMusica.obtenerGuitarras();
		assertEquals(2, instrumentosObtenidos.size());
	}

	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaPuedeEmitirSonido() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(bateria.getCodigo());

		assertEquals("Pushh", instrumentoObtenido.emitirSonido());
	}

	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaPuedeEmitirSonido() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(guitarraElectrica.getCodigo());
		assertEquals("Braam", instrumentoObtenido.emitirSonido());
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoExistenteObtengoElInstrumento() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(bateria.getCodigo());

		assertEquals(bateria, instrumentoObtenido);
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoInexistenteObtengoNull() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(15);

		assertTrue(instrumentoObtenido == null);
	}

	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		Double precioEsperado = 1000D;

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(guitarraElectrica.getCodigo());

		assertEquals(precioEsperado, instrumentoObtenido.getPrecioBase());
	}

	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		Double precioEsperado = 2000D;
		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(bateria.getCodigo());
		assertEquals(precioEsperado, instrumentoObtenido.getPrecioBase());
	}

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosEstanOrdenados() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		Instrumento guitarraElectrica2 = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica2);
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);

		TreeSet<Instrumento> instrumentosObtenidos = casaDeMusica.obtenerInstrumentosOrdenados();

		assertEquals(guitarraElectrica, instrumentosObtenidos.first());
		assertEquals(bateria, instrumentosObtenidos.last());
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaSePuedeAgregarUnEvento() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));

		Boolean eventoAgregado = casaDeMusica.agregarEvento(evento);

		assertTrue(eventoAgregado);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoSePuedeAgregarVariosConciertos() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		
		Boolean conciertoAgregadoAlEvento = casaDeMusica.agregarConciertoAEvento(evento, concierto);
		
		assertTrue(conciertoAgregadoAlEvento);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConEventosQueSePuedaObtenerUnEvento() {
		
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAgregarVariosInstrumentosAUnConcierto() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedenObtenerLosInstrumentosDeUnConcierto() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumento() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosNoSePuedeAgregarUnConciertoInstrumentoExistente() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConMuchosEventosYVariosConciertosEnCadaEventoSePuedenObtenerLosEventosDondeSeDioUnConcierto() {

	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra() {

	}

	@Test
	public void queSePuedaObtenerUnaListaOrdenadaDeInstrumentosPorCodigo() {

	}

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosPorOrdenNatural() {

	}

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosPorOrdenEspecifico() {

	}

	private Instrumento crearBateria(int codigo, int cantidadTambores, int cantidadPlatillos, String color,
			String marca, String modelo, int anioFabricacion, int stock, Double precioBase) {
		return new Bateria(codigo, cantidadTambores, cantidadPlatillos, color, marca, modelo, anioFabricacion, stock,
				precioBase);
	}

	private Instrumento crearGuitarraElectrica(Integer codigo, Integer cantidadDeCuerdas, String color, String marca,
			String modelo, Integer anioFabricacion, Boolean microfonosActivos, Integer stock, Double precioBase) {
		return new GuitarraElectrica(codigo, cantidadDeCuerdas, microfonosActivos, stock, color, marca, modelo,
				anioFabricacion, precioBase);

	}

}
