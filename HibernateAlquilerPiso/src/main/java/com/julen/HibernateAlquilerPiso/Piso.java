package com.julen.HibernateAlquilerPiso;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

@Entity
@Table(name="Pisos")
public class Piso {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="Id_piso")
	private int Id_piso;
	
	@ManyToOne
	@JoinColumn(name="Id_Zona", referencedColumnName= "Id_Zona")
	private Zona zona;
	
	@Column(name="Tipo_Operacion")
	private String Tipo_Operacion;
	
	@Column(name="Metros")
	private int Metros;
	
	@Column(name="Nombre_propietario")
	private String Nombre_propietario;
	
	@Column(name="Telefono_contacto")
	private String Telefono_contacto;
	
	@Column(name="Precio")
	private int Precio;
	
	@Column(name="Reservado")
	private boolean Reservado;
	
	
	public Piso() {
		
	}
	
	public Piso(int id_piso, Zona zona, String tipo_Operacion, int metros, String nombre_propietario,
			String telefono_contacto, int precio, boolean reservado) {
		super();
		Id_piso = id_piso;
		this.zona = zona;
		Tipo_Operacion = tipo_Operacion;
		Metros = metros;
		Nombre_propietario = nombre_propietario;
		Telefono_contacto = telefono_contacto;
		Precio = precio;
		Reservado = reservado;
	}



	public int getId_piso() {
		return Id_piso;
	}

	public void setId_piso(int id_piso) {
		Id_piso = id_piso;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
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

	public void setNombre_propietario(String nombre_propietario) {
		Nombre_propietario = nombre_propietario;
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

	

}
