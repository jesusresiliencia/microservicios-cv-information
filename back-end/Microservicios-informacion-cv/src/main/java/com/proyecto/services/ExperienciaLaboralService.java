package com.proyecto.services;

import java.util.Optional;

import com.proyecto.models.entity.ExperienciaLaboral;


public interface ExperienciaLaboralService {
	public Iterable< ExperienciaLaboral> findAll();

	public Optional< ExperienciaLaboral> findById(int id);

	public  ExperienciaLaboral save( ExperienciaLaboral experienciaLaboral);

	public void deleteById(int id);
}
