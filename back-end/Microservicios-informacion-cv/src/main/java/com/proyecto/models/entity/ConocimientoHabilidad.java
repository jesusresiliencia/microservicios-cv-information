package com.proyecto.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conocimiento_habilidad")
public class ConocimientoHabilidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id  ;
	
	private int id_usuario;
	private String nombre_conocimiento;
	private String nivel_porcentaje;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_conocimiento() {
		return nombre_conocimiento;
	}
	public void setNombre_conocimiento(String nombre_conocimiento) {
		this.nombre_conocimiento = nombre_conocimiento;
	}
	public String getNivel_porcentaje() {
		return nivel_porcentaje;
	}
	public void setNivel_porcentaje(String nivel_porcentaje) {
		this.nivel_porcentaje = nivel_porcentaje;
	}
}
