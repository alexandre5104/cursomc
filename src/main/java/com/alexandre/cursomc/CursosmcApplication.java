package com.alexandre.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.cursomc.model.Categoria;
import com.alexandre.cursomc.model.Cidade;
import com.alexandre.cursomc.model.Estado;
import com.alexandre.cursomc.model.Produto;
import com.alexandre.cursomc.repositories.CategoriaRepository;
import com.alexandre.cursomc.repositories.CidadeRepository;
import com.alexandre.cursomc.repositories.EstadoRepository;
import com.alexandre.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursosmcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursosmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "INFORMATICA");
		Categoria categoria2 = new Categoria(null, "ESCRITORIO");
		
		Produto produto1 = new Produto(null, "COMPUTADOR", 2000.00);
		Produto produto2 = new Produto(null, "RESMA", 20.00);
		Produto produto3 = new Produto(null, "IMPRESSORA", 800.00);
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1, produto3));
		categoria2.getProdutos().add(produto2);
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		Estado estado1 = new Estado(null, "Ceará");
		
		Estado estado2 = new Estado(null, "Bahia");
		
		Cidade cidade1 = new Cidade(null, "Fortaleza", estado1);
		Cidade cidade2 = new Cidade(null, "Horizonte", estado1);
		Cidade cidade3 = new Cidade(null, "Salvador", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		
		estado2.getCidades().addAll(Arrays.asList(cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
	}

}
