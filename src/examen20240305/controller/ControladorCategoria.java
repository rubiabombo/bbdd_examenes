package examen20240305.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import examen20240305.model.Categoria;





public class ControladorCategoria {



	public static List<Categoria> findAllByIdCentro(int idProducto) {
		List<Categoria> lista = new ArrayList<Categoria>();
		
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel where idProducto = " + idProducto);
			
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setId(rs.getInt("idProducto"));
				lista.add(c);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return lista;
	}

	public static List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
