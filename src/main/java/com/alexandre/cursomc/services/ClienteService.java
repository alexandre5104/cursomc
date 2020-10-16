package com.alexandre.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.cursomc.model.Cliente;
import com.alexandre.cursomc.repositories.ClienteRepository;
import com.alexandre.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository categoriaRepository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
