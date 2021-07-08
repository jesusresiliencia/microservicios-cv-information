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

import com.proyecto.models.entity.ConocimientoHabilidad;
import com.proyecto.services.ConocimientoHabilidadService;

@RestController
@RequestMapping("/conocimiento")
public class ConocimientoHabilidadController {

	@Autowired
	private ConocimientoHabilidadService conocimientoHabilidadService;

	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?>balanceadorTest(){
		Map<String,Object> response=new HashMap<String,Object>();
		response.put("balanceador", balanceadorTest);
		response.put("usuarios", conocimientoHabilidadService.findAll());
		return ResponseEntity.ok(response);
	}


@GetMapping
public ResponseEntity<?>listar(){
	return ResponseEntity.ok().body(conocimientoHabilidadService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<?>ver(@PathVariable int id){
	Optional<ConocimientoHabilidad>o= conocimientoHabilidadService.findById(id);
	if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(o.get());
}

@PostMapping
public ResponseEntity<?>crear(@RequestBody ConocimientoHabilidad conocimientoHabilidad ){
	ConocimientoHabilidad conocimientoHabilidadDB=conocimientoHabilidadService.save(conocimientoHabilidad);
	return ResponseEntity.status(HttpStatus.CREATED).body(conocimientoHabilidadDB);
}

@PutMapping("/{id}")
public ResponseEntity<?>editar(@RequestBody ConocimientoHabilidad conocimientoHabilidad,@PathVariable int id){
	Optional<ConocimientoHabilidad>o=conocimientoHabilidadService.findById(id);

	if(o.isEmpty()) {
	return	ResponseEntity.notFound().build();
	}
	ConocimientoHabilidad conocimientoHabilidadDB=o.get();
	conocimientoHabilidadDB.setId_usuario(conocimientoHabilidad.getId_usuario());
	conocimientoHabilidadDB.setNombre_conocimiento(conocimientoHabilidad.getNombre_conocimiento());
	conocimientoHabilidadDB.setNivel_porcentaje(conocimientoHabilidad.getNivel_porcentaje());
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(conocimientoHabilidadService.save(conocimientoHabilidadDB));
}

@DeleteMapping("/{id}")
public ResponseEntity<?>eliminar(@PathVariable int id ){
	conocimientoHabilidadService.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
