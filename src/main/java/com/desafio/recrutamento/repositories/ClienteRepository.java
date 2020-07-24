package com.desafio.recrutamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.recrutamento.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

	Cliente findByNomeCompleto(String nomeCompleto);
	
	@Transactional
	@Modifying //(flushAutomatically = true)
	@Query("update Cliente cl set cl.nomeCompleto =:nome where cl.idCliente =:id")
	void updateNome(@Param("nome") String nomeCompleto, @Param("id") Integer id);

}
