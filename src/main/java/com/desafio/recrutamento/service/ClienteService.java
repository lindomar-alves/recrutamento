package com.desafio.recrutamento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.recrutamento.domain.Cliente;
import com.desafio.recrutamento.exception.ObjectNotFoundException;
import com.desafio.recrutamento.repositories.ClienteRepository;



@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	/**
	 * Busca Cliente pelo ID
	 * @param id
	 * @return
	 */
	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Não existe um cliente com este id = " + id+ ", Erro : "+ Cliente.class.getName()));
	}

	/**
	 * Inseri o cliente na base de dados
	 * @param cliente
	 * @return
	 */
	public Cliente insertClient(Cliente cliente) {
		cliente.setIdCliente(null);
		//verifica se ha uma cidade antes de salvar o cliente
		if(cliente.getCidade() != null) {
			cidadeService.findById(cliente.getCidade().getIdCidade());
		}
		return clienteRepository.save(cliente);
	}

	/**
	 * Busca Cliente pelo nome
	 * @param nomeCompleto
	 * @return
	 */
	public Cliente findByNomeCompleto(String nomeCompleto) {
		Cliente cliente = clienteRepository.findByNomeCompleto(nomeCompleto);
		if(cliente == null) {
			throw new ObjectNotFoundException("Não existe uma cliente com este nome = " + nomeCompleto+ ", Erro : "+ Cliente.class.getName());
		}
		
		return cliente;
	}

	/**
	 * Exclui um cliente
	 * @param id
	 */
	public void deleteClienteById(Integer id) {
		findById(id);
		clienteRepository.deleteById(id);
	}

	/**
	 * atualiza os dados do Cliente
	 * @param cliente
	 * @param id
	 * @return
	 */
	public void updateName(String nomeCompleto, Integer id) {
		 // Verifica se o cliente existe
		findById(id);
		clienteRepository.updateNome(nomeCompleto, id); 
	}
	
}
