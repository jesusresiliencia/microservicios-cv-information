package com.proyecto.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="estudios")
public class Estudios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id  ;
	
	private int id_usuario;
	private String nombre_centro_estudio;
	private String nombre_carrera_curso;
	@Temporal(TemporalType.TIMESTAMP)
	private Date desde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date hasta;
	private String estudia_actualmente;
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
	public String getNombre_centro_estudio() {
		return nombre_centro_estudio;
	}
	public void setNombre_centro_estudio(String nombre_centro_estudio) {
		this.nombre_centro_estudio = nombre_centro_estudio;
	}
	public String getNombre_carrera_curso() {
		return nombre_carrera_curso;
	}
	public void setNombre_carrera_curso(String nombre_carrera_curso) {
		this.nombre_carrera_curso = nombre_carrera_curso;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	public Date getHasta() {
		return hasta;
	}
	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	public String getEstudia_actualmente() {
		return estudia_actualmente;
	}
	public void setEstudia_actualmente(String estudia_actualmente) {
		this.estudia_actualmente = estudia_actualmente;
	}
	
}
