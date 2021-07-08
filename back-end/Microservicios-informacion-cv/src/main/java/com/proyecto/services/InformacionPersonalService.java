package com.proyecto.services;

import java.util.Optional;

import com.proyecto.models.entity.InformacionPersonal;

public interface InformacionPersonalService {
	public Iterable< InformacionPersonal> findAll();

	public Optional< InformacionPersonal> findById(int id);

	public  InformacionPersonal save( InformacionPersonal informacionPersonal);

	public void deleteById(int id);
}
