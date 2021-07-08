package com.proyecto.controllers;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.entity.Usuario;
import com.proyecto.services.UsuarioService;


@RestController
public class UsuarioController {

@Autowired
private UsuarioService usuarioService;

@Value("${config.balanceador.test}")
private String balanceadorTest;

@GetMapping("/balanceador-test")
public ResponseEntity<?>balanceadorTest(){
	Map<String,Object> response=new HashMap<String,Object>();
	response.put("balanceador", balanceadorTest);
	response.put("usuarios", usuarioService.findAll());
	return ResponseEntity.ok(response);
}

@PostMapping("/login")
public ResponseEntity<?>login(@RequestBody Usuario usuario){
 List<Usuario> usuarioDB=usuarioService.getAccess(usuario.getCorreo(), usuario.getClave());
 Map<String,Object> response=new HashMap<String,Object>();
 boolean acceso=false;
 if(usuarioDB.size()>0) {
	 acceso=true;
 }
	response.put("accede",acceso);
	return ResponseEntity.ok(response);
}

@GetMapping
public ResponseEntity<?>listar(){
	return ResponseEntity.ok().body(usuarioService.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<?>ver(@PathVariable Long id){
	Optional<Usuario>o= usuarioService.findById(id);
	if(o.isEmpty()) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok(o.get());
}

@PostMapping
public ResponseEntity<?>crear(@RequestBody Usuario usuario ){
	Usuario usuarioDB=usuarioService.save(usuario);
	return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDB);
}

@PutMapping("/{id}")
public ResponseEntity<?>editar(@RequestBody Usuario usuario,@PathVariable Long id){
	Optional<Usuario>o=usuarioService.findById(id);

	if(o.isEmpty()) {
	return	ResponseEntity.notFound().build();
	}
	Usuario usuarioDB=o.get();
	usuarioDB.setNombres(usuario.getNombres());
	usuarioDB.setApellidos(usuario.getApellidos());
	usuarioDB.setCorreo(usuario.getCorreo());
	usuarioDB.setClave(usuario.getClave());
	
	
	return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioDB));
}

@DeleteMapping("/{id}")
public ResponseEntity<?>eliminar(@PathVariable Long id ){
	usuarioService.deleteById(id);
	return ResponseEntity.noContent().build();
}

}
