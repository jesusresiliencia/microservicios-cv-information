package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.entity.Usuario;

public interface UsuarioService {

public Iterable<Usuario> findAll();

public Optional<Usuario> findById(Long id);

public Usuario save(Usuario usuario);

public void deleteById(Long id);

public List<Usuario> getAccess(String correo,String clave);
}
