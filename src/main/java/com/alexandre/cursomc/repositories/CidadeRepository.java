package com.alexandre.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexandre.cursomc.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
