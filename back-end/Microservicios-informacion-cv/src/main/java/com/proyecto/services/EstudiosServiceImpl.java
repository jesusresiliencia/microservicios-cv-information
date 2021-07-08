package com.proyecto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.models.entity.Estudios;
import com.proyecto.models.repository.EstudiosRepository;

@Service
public class EstudiosServiceImpl implements EstudiosService {

	@Autowired
	private EstudiosRepository estudiosRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Estudios> findAll() {
		return estudiosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Estudios> findById(int id) {
		return estudiosRepository.findById(id);
	}

	@Override
	@Transactional
	public Estudios save(Estudios estudios) {
		return estudiosRepository.save(estudios);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		 estudiosRepository.deleteById(id);
	}



}
