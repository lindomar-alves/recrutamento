package com.desafio.recrutamento.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.recrutamento.domain.Cliente;
import com.desafio.recrutamento.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertClient(@RequestBody Cliente cliente) {
		cliente = clienteService.insertClient(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getIdCliente()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/nome/{nomeCompleto}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByNomeCompleto(@PathVariable String nomeCompleto) {
		Cliente cliente = clienteService.findByNomeCompleto(nomeCompleto);
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteClienteById(@PathVariable Integer id) {
		clienteService.deleteClienteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "{id}/nome/{nome}", method = RequestMethod.PUT)
	public ResponseEntity<Void> deleteClienteById(@PathVariable Integer id, @PathVariable String nome) {
		clienteService.updateName(nome, id);
		return ResponseEntity.noContent().build();
	}
	
	
}
