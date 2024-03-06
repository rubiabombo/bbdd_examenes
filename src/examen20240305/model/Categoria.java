package examen20240305.model;

public class Categoria {

	private int id;
	private String descripcion;
	
	/**
	 *  Getters y Setters
	 * @return
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * To String
	 */
	@Override
	public String toString() {
		return descripcion;
	}
	
}
