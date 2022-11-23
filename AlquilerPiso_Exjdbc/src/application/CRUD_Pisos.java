package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.RadioButton;

public class CRUD_Pisos {
	
	 public static void addPiso(Connection con, Piso p)  {
	     PreparedStatement ps;  
	     String sql;
	     
	     try {
	             sql = "insert into pisos(Id_piso, Id_Zona, Tipo_Operacion, Metros, Nombre_propietario, Telefono_contacto, Precio, Reservado) values(?, ?, ?, ?, ?, ?, ?, ?)";
	             ps = con.prepareStatement(sql);
	         
	            ps.setInt(1, p.getId_piso());
	            ps.setInt(2, p.getId_Zona());
	            ps.setString(3, p.getTipo_Operacion());
	            ps.setInt(4, p.getMetros());
	            ps.setString(5, p.getNombre_propiertario());
	            ps.setString(6, p.getTelefono_contacto());
	            ps.setInt(7, p.getPrecio());
	            ps.setBoolean(8, p.isReservado());
	            
	            ps.executeUpdate();
	           
	            
	        } catch (SQLException e) {
	            System.out.print("ERROR AL INSERTAR");
	        }
	     }
	 
	 public static void deletePiso(Connection con, int id) {
		 PreparedStatement ps;  
	     String sql;
	     
	     try {
	             sql = "DELETE FROM pisis WHERE Id_piso=(?)";
	             ps = con.prepareStatement(sql);
	         
	            ps.setInt(1, id);
	            
	            ps.executeUpdate();
	           
	            
	        } catch (SQLException e) {
	            System.out.print("ERROR AL BORRAR");
	        }
	 }
	 
	 public static boolean comprobarReservado(RadioButton r1) {
		 if(r1.isSelected() == true) {
			 return true;
		 }else 
		return false;
	 }
	 
	 public static void fillArrayCombo(ArrayList<String> array) {
		 array.add("Alquiler");
		 array.add("Venta");
	 }

}
