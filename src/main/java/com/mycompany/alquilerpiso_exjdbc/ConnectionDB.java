/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alquilerpiso_exjdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author julen
 */
public class ConnectionDB {
    static Connection conexion = null;

	   public static void conectar() {
	        Properties prop = new Properties();
	        String host, port, db, user, psw;



	       try {
	            FileInputStream file = new FileInputStream("properties.properties");
	            prop.load(file);
	            host = prop.getProperty("host");
	            port = prop.getProperty("port");
	            db = prop.getProperty("db");
	            user = prop.getProperty("user");
	            psw = prop.getProperty("pass");



	       } catch (IOException ex) {
	            System.out.println("No existe el archivo get properties");
	            System.out.println("No se ha podido crear la conexion");
	            return;
	        }



	       try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conexion = DriverManager.getConnection("jdbc:mysql://" + host + " : " + port + " /" + db, user, psw);
	            System.out.println("Conectado a la base de datos");



	       } catch (ClassNotFoundException cnfe) {
	            cnfe.printStackTrace();
	        } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }
	    }



	   public static Connection getConexion() {
	        if (conexion != null) {
	            return conexion;
	        }else{
	            conectar();
	        }
	        return conexion;
	    }



	   public static void desconectar() {
	        try {
	            conexion.close();
	            conexion = null;



	       } catch (SQLException sqle) {
	            sqle.printStackTrace();
	        }

	   }
}
