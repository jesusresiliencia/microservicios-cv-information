package com.proyecto.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="usuario")
public class Usuario {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombres;
private String apellidos;
private String correo;
private String clave;

@Column(name="create_at")
@Temporal(TemporalType.TIMESTAMP)
private Date createAt;

@PrePersist
public void prePersist() {
	this.createAt=new Date();
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getClave() {
	return clave;
}
public void setClave(String clave) {
	this.clave = clave;
}
public Date getCreateAt() {
	return createAt;
}
public void setCreateAt(Date createAt) {
	this.createAt = createAt;
}


}
