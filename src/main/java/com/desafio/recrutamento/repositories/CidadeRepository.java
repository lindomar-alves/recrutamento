package com.desafio.recrutamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.recrutamento.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	Cidade findByNome(String nomeCidade);
	
	Cidade findByEstado(String estado);

}
