package com.proyecto.services;

import java.util.Optional;

import com.proyecto.models.entity.Estudios;

public interface EstudiosService {
	public Iterable< Estudios> findAll();

	public Optional< Estudios> findById(int id);

	public  Estudios save( Estudios estudios);

	public void deleteById(int id);
}
