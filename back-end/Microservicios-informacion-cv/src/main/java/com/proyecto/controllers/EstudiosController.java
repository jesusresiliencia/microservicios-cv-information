package com.proyecto.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.entity.Estudios;
import com.proyecto.services.EstudiosService;

@RestController
@RequestMapping("/estudios")
public class EstudiosController {

	@Autowired
	private EstudiosService estudiosService;

	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?>balanceadorTest(){
		Map<String,Object> response=new HashMap<String,Object>();
		response.put("balanceador", balanceadorTest);
		response.put("usuarios", estudiosService.findAll());
		return ResponseEntity.ok(response);
	}


@GetMapping
public ResponseEntity<?>listar(){
	return ResponseEntity.ok().body(estudiosService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<?>ver(@PathVariable int id){
	Optional<Estudios>o= estudiosService.findById(id);
	if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(o.get());
}

@PostMapping
public ResponseEntity<?>crear(@RequestBody Estudios estudios ){
	Estudios estudiosDB=estudiosService.save(estudios);
	return ResponseEntity.status(HttpStatus.CREATED).body(estudiosDB);
}

@PutMapping("/{id}")
public ResponseEntity<?>editar(@RequestBody Estudios estudios,@PathVariable int id){
	Optional<Estudios>o=estudiosService.findById(id);

	if(o.isEmpty()) {
	return	ResponseEntity.notFound().build();
	}
	Estudios estudiosDB=o.get();
	estudiosDB.setId_usuario(estudios.getId_usuario());
	estudiosDB.setNombre_centro_estudio(estudios.getNombre_centro_estudio());
	estudiosDB.setNombre_carrera_curso(estudios.getNombre_carrera_curso());
	estudiosDB.setDesde(estudios.getDesde());
	estudiosDB.setHasta(estudios.getHasta());
	estudiosDB.setEstudia_actualmente(estudios.getEstudia_actualmente());
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(estudiosService.save(estudiosDB));
}

@DeleteMapping("/{id}")
public ResponseEntity<?>eliminar(@PathVariable int id ){
	estudiosService.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
