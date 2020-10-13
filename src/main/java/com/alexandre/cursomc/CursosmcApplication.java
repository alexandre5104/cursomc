package com.alexandre.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.cursomc.model.Categoria;
import com.alexandre.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursosmcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursosmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "INFORMATICA");
		Categoria categoria2 = new Categoria(null, "ESCRITORIO");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		
	}

}
