package com.proyecto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.models.entity.ExperienciaLaboral;
import com.proyecto.models.repository.ExperienciaLaboralRepository;

@Service
public class ExperienciaLaboralServiceImpl implements ExperienciaLaboralService {

	@Autowired
	private ExperienciaLaboralRepository experienciaLaboralRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ExperienciaLaboral> findAll() {
		return experienciaLaboralRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ExperienciaLaboral> findById(int id) {
		return experienciaLaboralRepository.findById(id);
	}

	@Override
	@Transactional
	public ExperienciaLaboral save(ExperienciaLaboral experienciaLaboral) {
		return experienciaLaboralRepository.save(experienciaLaboral);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		experienciaLaboralRepository.deleteById(id);
	}


}
