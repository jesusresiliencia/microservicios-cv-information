package com.proyecto.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query(value="SELECT *  FROM usuario where correo= :correo and clave= :clave", nativeQuery=true)
    List<Usuario> getAccess(String correo,String clave);
	
}
