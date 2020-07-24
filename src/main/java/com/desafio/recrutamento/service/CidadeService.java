package com.desafio.recrutamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.recrutamento.domain.Cidade;
import com.desafio.recrutamento.exception.ObjectNotFoundException;
import com.desafio.recrutamento.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	/**
	 * Busca Cidade pelo ID
	 * @param id
	 * @return
	 */
	public Cidade findById(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException("Não existe uma cidade com este id = " + id+ ", Erro : "+ Cidade.class.getName()));
	}

	/**
	 * Inseri uma nova cidade
	 * @param cidade
	 * @return
	 */
	public Cidade insertClient(Cidade cidade) {
		cidade.setIdCidade(null);
		return cidadeRepository.save(cidade);
	}

	/**
	 * Busca cidade pelo nome
	 * @param nomeCidade
	 * @return
	 */
	public Cidade findByName(String nomeCidade) {
		Cidade cidade = cidadeRepository.findByNome(nomeCidade);
		if(cidade == null)
			throw new ObjectNotFoundException("Não existe uma cidade com este nome = " + nomeCidade+ ", Erro : "+ Cidade.class.getName());
		return cidade;
	}
	

	/**
	 * Busca cidade pelo nome
	 * @param nomeCidade
	 * @return
	 */
	public Cidade findByEstado(String estado) {
		Cidade cidade = cidadeRepository.findByEstado(estado);
		if(cidade == null)
			throw new ObjectNotFoundException("Não existe uma cidade com este Estado = " + estado+ ", Erro : "+ Cidade.class.getName());
		return cidade;
	}
	
}
