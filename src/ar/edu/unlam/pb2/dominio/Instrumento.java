package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public abstract class Instrumento implements Comparable<Instrumento>{
	Integer codigo;
	private String color;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer stock;
	private Double precioBase;

	public Instrumento(Integer codigo, String color, String marca, Integer stock, String modelo, Integer anioFabricacion, Double precioBase) {
		this.codigo = codigo;
		this.color = color;
		this.marca = marca;
		this.stock = stock;
		this.modelo = modelo;
		this.anioFabricacion = anioFabricacion;
		this.precioBase = precioBase;
	}
	


	public Integer getCodigo() {
		return codigo;
	}

	public String getColor() {
		return color;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrecioBase() {
		return precioBase;
	}

	public abstract String emitirSonido();

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrumento other = (Instrumento) obj;
		return Objects.equals(codigo, other.codigo);
	}



	@Override
	public int compareTo(Instrumento o) {
		return this.codigo.compareTo(o.getCodigo());
	}

}
