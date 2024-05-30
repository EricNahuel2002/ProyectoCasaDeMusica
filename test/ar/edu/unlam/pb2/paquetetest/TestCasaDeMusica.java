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

	@Test (expected = InstrumentoNoEncontradoException.class)
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoInexistenteObtengoNull() throws InstrumentoNoEncontradoException {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);

		Instrumento instrumentoObtenido = casaDeMusica.buscarInstrumentoPorCodigo(15);
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
	public void dadoQueExisteUnaCasaDeMusicaSePuedeAgregarUnEvento() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));

		Boolean eventoAgregado = casaDeMusica.agregarEvento(evento);

		assertTrue(eventoAgregado);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoSePuedeAgregarVariosConciertos() throws Validacion1Exception, Validacion2Exception {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		
		Boolean conciertoAgregadoAlEvento = casaDeMusica.agregarConciertoAEvento(evento, concierto);
		
		assertTrue(conciertoAgregadoAlEvento);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConEventosQueSePuedaObtenerUnEvento() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		
		Evento eventoObtenido = casaDeMusica.buscarEvento(evento);
		
		assertEquals(evento,eventoObtenido);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedeAgregarVariosInstrumentosAUnConcierto() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Boolean instrumentoAgregadoAlConcierto = casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		
		assertTrue(instrumentoAgregadoAlConcierto);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYUnConciertoSePuedenObtenerLosInstrumentosDeUnConcierto() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Concierto concierto2 = new Concierto(17,"Red Hot Chili Peppers");
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto2, bateria);
		
		List<Instrumento> instrumentosDeUnConcierto = casaDeMusica.obtenerLosInstrumentosDeUnConciertoParaUnEvento(evento, concierto);
		
		assertEquals(2,instrumentosDeUnConcierto.size());
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumento() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Concierto concierto2 = new Concierto(17,"Red Hot Chili Peppers");
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto2, bateria);
		
		List<Concierto> conciertosQueUsanUnInstrumento = casaDeMusica.obtenerLosConciertosQueUsanUnInstrumento(evento,bateria);
				
		assertEquals(2, conciertosQueUsanUnInstrumento.size());
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosNoSePuedeAgregarUnConciertoInstrumentoExistente() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		Boolean conciertoInstrumentoAgregadoAEvento = casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, bateria);
		Boolean conciertoInstrumentoAgregadoAEvento2 = casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, bateria);
		
		assertTrue(conciertoInstrumentoAgregadoAEvento);
		assertFalse(conciertoInstrumentoAgregadoAEvento2);
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConMuchosEventosYVariosConciertosEnCadaEventoSePuedenObtenerLosEventosDondeSeDioUnConcierto() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Evento evento2 = new Evento("Viña del mar", LocalDate.of(2024, 6, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento2);
		Evento evento3 = new Evento("Bla", LocalDate.of(2024, 9, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento3);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Concierto concierto2 = new Concierto(15,"Ed Sheeran");
		casaDeMusica.agregarConciertoAEvento(evento, concierto);
		casaDeMusica.agregarConciertoAEvento(evento2, concierto);
		casaDeMusica.agregarConciertoAEvento(evento3, concierto2);
		
		List<Evento> eventosObtenidos = casaDeMusica.obtenerEventosDondeSeDioUnConcierto(concierto);
		
		assertEquals(2, eventosObtenidos.size());
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoYVariosConciertosConInstrumentosSePuedenObtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra() {
		Evento evento = new Evento("LolaPalooza", LocalDate.of(2024, 5, 16), LocalTime.of(18, 0), LocalTime.of(20, 0));
		casaDeMusica.agregarEvento(evento);
		Concierto concierto = new Concierto(16,"Taylor Swift");
		Concierto concierto2 = new Concierto(17,"Red Hot Chili Peppers");
		Concierto concierto3 = new Concierto(19,"Eminem");
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		casaDeMusica.agregarInstrumento(bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, guitarraElectrica);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto, bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto2, bateria);
		casaDeMusica.agregarConciertoInstrumentoAEvento(evento, concierto3, guitarraElectrica);
		
		List<Concierto> conciertosObtenidos = casaDeMusica.obtenerLosConciertosDondeSeUtilizoUnInstrumentosGuitarra(evento);
		
		assertEquals(2,conciertosObtenidos.size());
	}
	
	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosEstanOrdenados() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		
		Instrumento guitarraElectrica2 = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(guitarraElectrica2);
		casaDeMusica.agregarInstrumento(bateria);

		TreeSet<Instrumento> instrumentosObtenidos = casaDeMusica.obtenerInstrumentosOrdenados();

		assertEquals(guitarraElectrica, instrumentosObtenidos.first());
		assertEquals(bateria, instrumentosObtenidos.last());
	}

	@Test
	public void queSePuedaObtenerUnaListaOrdenadaDeInstrumentosPorCodigo() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento guitarraElectrica2 = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(guitarraElectrica2);
		casaDeMusica.agregarInstrumento(bateria);
		
		TreeSet<Instrumento> instrumentosOrdenadosPorCodigo = casaDeMusica.obtenerUnaListaOrdenadaDeInstrumentosPorCodigo();
		
		assertEquals(guitarraElectrica, instrumentosOrdenadosPorCodigo.first());
		assertEquals(bateria, instrumentosOrdenadosPorCodigo.last());
	}

//	@Test
//	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosPorOrdenNatural() {
//		
//	}

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosPorOrdenEspecifico() {
		Instrumento bateria = this.crearBateria(2001, 1, 4, "Dorada", "Jazz", "Un modelo", 2000, 20, 2000D);
		Instrumento guitarraElectrica2 = this.crearGuitarraElectrica(1002, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		Instrumento guitarraElectrica = this.crearGuitarraElectrica(1001, 6, "Azul", "Fender", "Stratocaster", 1994,
				true, 10, 1000D);
		
		casaDeMusica.agregarInstrumento(guitarraElectrica);
		casaDeMusica.agregarInstrumento(guitarraElectrica2);
		casaDeMusica.agregarInstrumento(bateria);
		
		TreeSet<Instrumento> instrumentosOrdenadosPorCodigo = casaDeMusica.obtenerUnaListaOrdenadaDeInstrumentosPorOrdenEspecifico(new OrdenMayorAMenor());
		
		assertEquals(bateria, instrumentosOrdenadosPorCodigo.first());
		assertEquals(guitarraElectrica, instrumentosOrdenadosPorCodigo.last());
	}
	
	@Test
	public void dividirDosNumeros() throws DividirPorCeroException{
		Double resultado = dividir(10.0,0.0);
			assertEquals(3.33,resultado,0.01);

		
	}
	
//	a.metodo() llama a b.metodo() y b.metodo() llama a c.metodo()
//														termina con excepcion
//					relanza excepcion
//	recibe la excepcion
//	relanza
	
	
//	a.metodo() llama a b.metodo() y b.metodo() llama a c.metodo()
//														termina con excepcion
//						captura y maneja la excepcion
	
	@Test (expected = DividirPorCeroException.class)
	public void siAlIntentardividirUnNumeroPorCeroSeTieneQueProducirUnaExcepcion() throws DividirPorCeroException {
		Double resultado = dividir(10.0,3.0);
	}
	
	public Double dividir(Double numerador,Double denominador) throws DividirPorCeroException{
		if(!denominador.equals(0.0))
		return numerador / denominador;
		else 
			throw new DividirPorCeroException("No es posible dividir por cero");
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
