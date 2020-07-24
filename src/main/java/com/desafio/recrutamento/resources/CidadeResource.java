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

import com.desafio.recrutamento.domain.Cidade;
import com.desafio.recrutamento.service.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> findById(@PathVariable Integer id) {
		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok().body(cidade);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertCidade(@RequestBody Cidade cidade) {
		cidade = cidadeService.insertClient(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cidade.getIdCidade()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/nome/{nomeCidade}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> findByName(@PathVariable String nomeCidade) {
		Cidade cidade = cidadeService.findByName(nomeCidade);
		return ResponseEntity.ok().body(cidade);
	}
	
	@RequestMapping(value = "/estado/{estado}", method = RequestMethod.GET)
	public ResponseEntity<Cidade> findByEstado(@PathVariable String estado) {
		Cidade cidade = cidadeService.findByEstado(estado);
		return ResponseEntity.ok().body(cidade);
	}

}
