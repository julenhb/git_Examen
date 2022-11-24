/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alquilerpiso_exjdbc;

import static com.mycompany.alquilerpiso_exjdbc.ConnectionDB.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

/**
 *
 * @author julen
 */
public class CRUD_Pisos {

    public static void addPiso(Connection con, Piso p) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "insert into pisos(Id_piso, Id_Zona, Tipo_Operacion, Metros, Nombre_propietario, Telefono_contacto, Precio, Reservado) values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, p.getId_piso());
            ps.setInt(2, p.getId_Zona());
            ps.setString(3, p.getTipo_Operacion());
            ps.setInt(4, p.getMetros());
            ps.setString(5, p.getNombre_propietario());
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
            sql = "DELETE FROM pisos WHERE Id_piso=(?)";
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.print("ERROR AL BORRAR");
        }
    }

    public static boolean comprobarReservado(RadioButton r1) {
        if (r1.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public static void fillArrayCombo(ArrayList<String> array) {
        array.add("Alquiler");
        array.add("Compra");
    }

    public static ObservableList<Piso> mostrarDisponibles() throws SQLException {
        Connection con;
        con = getConexion();
        ObservableList<Piso> list;
        list = FXCollections.observableArrayList();
        PreparedStatement ps;
        ResultSet rs;

        ps = con.prepareStatement("SELECT * FROM pisos WHERE Reservado = 0");
        rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Piso(rs.getInt("Id_Piso"), rs.getInt("Id_Zona"), rs.getString("Tipo_Operacion"), rs.getInt("Metros"), rs.getString("Nombre_propietario"), rs.getString("Telefono_contacto"), rs.getInt("Precio"), rs.getBoolean("Reservado")));
        }

        return list;
    }
}
