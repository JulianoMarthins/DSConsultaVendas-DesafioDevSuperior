package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<?> getReport() {
		// TODO:
		/*
				A função deve receber nome, data inicial e data final
				Esses dados não são obrigatórios
				Caso o nome não seja inserido, o mesmo deve ser uma string vazia
				Caso a data inicial não seja inserida, deve ser armazenada um ano antes da data atual
				Caso a data final não seja inserida, deve ser armazenada a data atual do sistema

		 */
		return null;
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<?> getSummary() {
		// TODO:
		/*
				A função deve receber os dados de entrada, data inicial, data final e nome
				Nenhum desses dados é obrigatório
				Caso a data inicial não seja inserida, ela deve ser um ano antes da data final
				Caso a data final não seja inserida, ela deve ser o dia atual do sistema
				Caso o nome do vendedor não seja inserido, deve ser armazenado uma string vazia
		 */
		return null;
	}
}
