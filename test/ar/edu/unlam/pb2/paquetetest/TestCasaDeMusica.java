package ar.edu.unlam.pb2.paquetetest;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.Bateria;
import ar.edu.unlam.pb2.dominio.GuitarraElectrica;
import ar.edu.unlam.pb2.dominio.Instrumento;


public class TestCasaDeMusica {

	private static final String NOMBRE_CASA_MUSICAL = "Casa musical";
	private CasaDeMusica casaDeMusica;

	@Before
	public void init() {
		this.casaDeMusica = new CasaDeMusica(NOMBRE_CASA_MUSICAL);
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoGuitarraElectricaALaCasaDeMusica() {
	}

	@Test
	public void queSePuedaAgregarUnInstrumentoBateriaALaCasaDeMusica() {
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarGuitarrasElectricasObtengoLoPropio() {
	}

	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaPuedeEmitirSonido() {
	}

	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaPuedeEmitirSonido() {
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoExistenteObtengoElInstrumento() {
	}

	@Test
	public void dadoQueExistenInstrumentosEnLaCasaDeMusicaAlBuscarUnInstrumentoPorCodigoInexistenteObtengoNull() {
	}

	@Test
	public void dadoQueExisteUnInstrumentoGuitarraElectricaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
	}

	@Test
	public void dadoQueExisteUnInstrumentoBateriaEnLaCasaDeMusicaAlObtrenerloPorCodigoSePuedeObtenerElPrecio() {
	}

	@Test
	public void dadoQueExistenInstumentosEnLaCasaDeMusicaAlObtenerlosEstanOrdenados() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaSePuedeAgregarUnEvento() {
	}

	@Test
	public void dadoQueExisteUnaCasaDeMusicaConUnEventoSePuedeAgregarVariosConciertos() {
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
