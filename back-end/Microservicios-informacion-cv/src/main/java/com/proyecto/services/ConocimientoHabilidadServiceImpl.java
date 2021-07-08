package com.proyecto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.models.entity.ConocimientoHabilidad;
import com.proyecto.models.repository.ConocimientoHabilidadRepository;


@Service
public class ConocimientoHabilidadServiceImpl implements ConocimientoHabilidadService {

	@Autowired
	private ConocimientoHabilidadRepository conocimientoHabilidadRepository;
	@Override
	@Transactional(readOnly = true)
	public Iterable<ConocimientoHabilidad> findAll() {
		return conocimientoHabilidadRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ConocimientoHabilidad> findById(int id) {
		return conocimientoHabilidadRepository.findById(id);
	}

	@Override
	@Transactional
	public ConocimientoHabilidad save(ConocimientoHabilidad conocimientoHabilidad) {
		return conocimientoHabilidadRepository.save(conocimientoHabilidad);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		 conocimientoHabilidadRepository.deleteById(id);
	}


}
