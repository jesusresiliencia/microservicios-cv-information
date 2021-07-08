package com.proyecto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.models.entity.InformacionPersonal;
import com.proyecto.models.repository.InformacionPersonalRepository;

@Service
public class InformacionPersonalServiceImpl implements InformacionPersonalService{

	@Autowired
	private InformacionPersonalRepository informacionPersonalRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<InformacionPersonal> findAll() {
		return informacionPersonalRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<InformacionPersonal> findById(int id) {
		return informacionPersonalRepository.findById(id);
	}

	@Override
	@Transactional
	public InformacionPersonal save(InformacionPersonal informacionPersonal) {
		return informacionPersonalRepository.save(informacionPersonal);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		 informacionPersonalRepository.deleteById(id);
	}


}
