package com.proyecto.services;

import java.util.Optional;

import com.proyecto.models.entity.ConocimientoHabilidad;

public interface ConocimientoHabilidadService {
	public Iterable< ConocimientoHabilidad> findAll();

	public Optional< ConocimientoHabilidad> findById(int id);

	public  ConocimientoHabilidad save( ConocimientoHabilidad conocimientoHabilidad);

	public void deleteById(int id);
}
