package examen20240305.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen20240305.model.Producto;



public class ControladorProducto {


	public static List<Producto> findAllByIdCategorial(int idCategoria) {
		List<Producto> lista = new ArrayList<Producto>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from producto where idNivel = " + idCategoria);
			
			while (rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt("id"));
				p.setCodigo(rs.getString("codigo"));
				p.setFechaCaducidad(rs.getTimestamp("fechaCaducidad"));
				p.setNombre(rs.getString("descripcion"));
				p.setIdCategoria(rs.getInt("idCategoria"));
				p.setPerecedero(rs.getDate("perecedero"));
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}

	public static List<Producto> findByLikeName(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void update(Producto o) {
		
	}

	public static int modificar(Producto p) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

}
