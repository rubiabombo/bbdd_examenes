package examen20240305.model;

import java.sql.Timestamp;
import java.util.Date;

public class Producto {
	private int id;
	private String nombre;
	private String codigo;
	private Date perecedero;
	private Timestamp fechaCaducidad;
	private int unidadesStock;
	private int IdCategoria;

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getPerecedero() {
		return perecedero;
	}

	public void setPerecedero(Date date) {
		this.perecedero = date;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Timestamp fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getUnidadesStock() {
		return unidadesStock;
	}

	public void setUnidadesStock(int unidadesStock) {
		this.unidadesStock = unidadesStock;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public void setPerecedero1(boolean selected) {
		// TODO Auto-generated method stub
		
	}

}
