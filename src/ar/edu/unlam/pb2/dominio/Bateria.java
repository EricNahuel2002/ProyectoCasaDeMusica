package ar.edu.unlam.pb2.dominio;

public class Bateria extends Instrumento {


	public Bateria(int codigo, int cantidadTambores, int cantidadPlatillos, String color, String marca, String modelo,
			int anioFabricacion, int stock, Double precioBase) {
		super(codigo, color, marca, stock, modelo, anioFabricacion, precioBase);
	}

	@Override
	public String emitirSonido() {
		return "Pushh";
	}

	

}
