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

import com.proyecto.models.entity.InformacionPersonal;
import com.proyecto.services.InformacionPersonalService;

@RestController
@RequestMapping("/informacion")
public class InformacionPersonalController {
	
	@Autowired
	private InformacionPersonalService informacionPersonalService;

	@Value("${config.balanceador.test}")
	private String balanceadorTest;

	@GetMapping("/balanceador-test")
	public ResponseEntity<?>balanceadorTest(){
		Map<String,Object> response=new HashMap<String,Object>();
		response.put("balanceador", balanceadorTest);
		response.put("usuarios", informacionPersonalService.findAll());
		return ResponseEntity.ok(response);
	}
	

@GetMapping
public ResponseEntity<?>listar(){
	return ResponseEntity.ok().body(informacionPersonalService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<?>ver(@PathVariable int id){
	Optional<InformacionPersonal>o= informacionPersonalService.findById(id);
	if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(o.get());
}

@PostMapping
public ResponseEntity<?>crear(@RequestBody InformacionPersonal informacionPersonal ){
	InformacionPersonal usuarioDB=informacionPersonalService.save(informacionPersonal);
	return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);
}

@PutMapping("/{id}")
public ResponseEntity<?>editar(@RequestBody InformacionPersonal informacionPersonal,@PathVariable int id){
	Optional<InformacionPersonal>o=informacionPersonalService.findById(id);

	if(o.isEmpty()) {
	return	ResponseEntity.notFound().build();
	}
	InformacionPersonal informacionPersonalDB=o.get();
	informacionPersonalDB.setId_usuario(informacionPersonal.getId_usuario());
	informacionPersonalDB.setDescripcion(informacionPersonal.getDescripcion());
	informacionPersonalDB.setFecha_nacimiento(informacionPersonal.getFecha_nacimiento());
	informacionPersonalDB.setTelefono(informacionPersonal.getTelefono());
	informacionPersonalDB.setRuta_imagen(informacionPersonal.getRuta_imagen());
	informacionPersonalDB.setDireccion(informacionPersonal.getDireccion());
	
	return ResponseEntity.status(HttpStatus.CREATED).body(informacionPersonalService.save(informacionPersonalDB));
}

@DeleteMapping("/{id}")
public ResponseEntity<?>eliminar(@PathVariable int id ){
	informacionPersonalService.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
