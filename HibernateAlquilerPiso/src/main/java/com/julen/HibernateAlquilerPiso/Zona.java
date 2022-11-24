package com.julen.HibernateAlquilerPiso;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name ="Zonas")
public class Zona {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="Id_Zona")
	private int Id_Zona;
	
	@Column(name="nombre_zona")
	private String nombre_zona;
	
	@OneToMany(mappedBy = "Id_piso", cascade = CascadeType.ALL)
	private List<Piso> pisos;
	
	
	public Zona() {
		
	}
	
	public Zona(int Id_Zona, String nombre_zona) {
		super();
		this.Id_Zona = Id_Zona;
		this.nombre_zona = nombre_zona;
	}
	
	public int getId_Zona() {
		return Id_Zona;
	}

	public void setId_Zona(int id_zona) {
		Id_Zona = id_zona;
	}

	public String getNombre_zona() {
		return nombre_zona;
	}

	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}

	public List<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(List<Piso> pisos) {
		this.pisos = pisos;
	}

	
	
	
}
