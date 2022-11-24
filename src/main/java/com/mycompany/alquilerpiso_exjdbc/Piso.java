/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alquilerpiso_exjdbc;

/**
 *
 * @author julen
 */
public class Piso {
    private int Id_piso;
	private int Id_Zona;
	private String Tipo_Operacion;
	private int Metros;
	private String Nombre_propietario;
	private String Telefono_contacto;
	private int Precio;
	private boolean Reservado;
	
	
	public int getId_piso() {
		return Id_piso;
	}
	public void setId_piso(int id_piso) {
		Id_piso = id_piso;
	}
	public int getId_Zona() {
		return Id_Zona;
	}
	public void setId_Zona(int id_Zona) {
		Id_Zona = id_Zona;
	}
	public String getTipo_Operacion() {
		return Tipo_Operacion;
	}
	public void setTipo_Operacion(String tipo_Operacion) {
		Tipo_Operacion = tipo_Operacion;
	}
	public int getMetros() {
		return Metros;
	}
	public void setMetros(int metros) {
		Metros = metros;
	}
	public String getNombre_propietario() {
		return Nombre_propietario;
	}
	public void setNombre_propietario(String nombre_propiertario) {
		Nombre_propietario = nombre_propiertario;
	}
	public String getTelefono_contacto() {
		return Telefono_contacto;
	}
	public void setTelefono_contacto(String telefono_contacto) {
		Telefono_contacto = telefono_contacto;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public boolean isReservado() {
		return Reservado;
	}
	public void setReservado(boolean reservado) {
		Reservado = reservado;
	}
	
	public Piso() {
		
	}
	
	public Piso(int Id_piso, int Id_Zona, String Tipo_Operacion, int Metros, String Nombre_propietario, String Telefono_Contacto, int Precio, boolean Reservado) {
		this.Id_piso = Id_piso;
		this.Id_Zona = Id_Zona;
		this.Tipo_Operacion = Tipo_Operacion;
		this.Metros = Metros;
		this.Nombre_propietario = Nombre_propietario;
		this.Telefono_contacto = Telefono_Contacto;
		this.Precio = Precio;
		this.Reservado = Reservado;
		
	}
}
