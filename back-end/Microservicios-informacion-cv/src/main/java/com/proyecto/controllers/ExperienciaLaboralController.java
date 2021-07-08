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

import com.proyecto.models.entity.ExperienciaLaboral;
import com.proyecto.services.ExperienciaLaboralService;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaLaboralController {
	
	@Autowired
	private ExperienciaLaboralService experienciaLaboralService;

	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?>balanceadorTest(){
		Map<String,Object> response=new HashMap<String,Object>();
		response.put("balanceador", balanceadorTest);
		response.put("usuarios", experienciaLaboralService.findAll());
		return ResponseEntity.ok(response);
	}
	

@GetMapping
public ResponseEntity<?>listar(){
	return ResponseEntity.ok().body(experienciaLaboralService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<?>ver(@PathVariable int id){
	Optional<ExperienciaLaboral>o= experienciaLaboralService.findById(id);
	if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(o.get());
}

@PostMapping
public ResponseEntity<?>crear(@RequestBody ExperienciaLaboral experienciaLaboral ){
	ExperienciaLaboral experienciaLaboralDB=experienciaLaboralService.save(experienciaLaboral);
	return ResponseEntity.status(HttpStatus.CREATED).body(experienciaLaboralDB);
}

@PutMapping("/{id}")
public ResponseEntity<?>editar(@RequestBody ExperienciaLaboral experienciaLaboral,@PathVariable int id){
	Optional<ExperienciaLaboral>o=experienciaLaboralService.findById(id);

	if(o.isEmpty()) {
	return	ResponseEntity.notFound().build();
	}
	ExperienciaLaboral experienciaLaboralDB=o.get();
	experienciaLaboralDB.setId_usuario(experienciaLaboral.getId_usuario());
	experienciaLaboralDB.setNombre_empresa(experienciaLaboral.getNombre_empresa());
	experienciaLaboralDB.setCargo(experienciaLaboral.getCargo());
	experienciaLaboralDB.setDescripcion(experienciaLaboral.getDescripcion());
	experienciaLaboralDB.setDesde(experienciaLaboral.getDesde());
	experienciaLaboralDB.setHasta(experienciaLaboral.getHasta());
	experienciaLaboralDB.setTrabaja_actualmente(experienciaLaboral.getTrabaja_actualmente());
	
	return ResponseEntity.status(HttpStatus.CREATED).body(experienciaLaboralService.save(experienciaLaboralDB));
}

@DeleteMapping("/{id}")
public ResponseEntity<?>eliminar(@PathVariable int id ){
	experienciaLaboralService.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
