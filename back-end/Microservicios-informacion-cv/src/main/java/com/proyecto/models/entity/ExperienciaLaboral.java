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
@Table(name="experiencia_laboral")
public class ExperienciaLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id  ;
	
	private int id_usuario;
	private String nombre_empresa;
	private String cargo;
	private String descripcion;
	@Temporal(TemporalType.TIMESTAMP)
	private Date desde;
	@Temporal(TemporalType.TIMESTAMP)
	private Date hasta;
	private String trabaja_actualmente;
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
	public String getNombre_empresa() {
		return nombre_empresa;
	}
	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public String getTrabaja_actualmente() {
		return trabaja_actualmente;
	}
	public void setTrabaja_actualmente(String trabaja_actualmente) {
		this.trabaja_actualmente = trabaja_actualmente;
	}
}
