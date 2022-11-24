package com.marcaci.nbrigadistas.Brigada.empresarial.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;
import com.marcaci.nbrigadistas.Brigada.empresarial.service.BrigadistasService;


@Controller
@RequestMapping("api/brigadistas")
public class BrigadistasController {
	
	@Autowired
	private BrigadistasService servicio;

	@GetMapping
	public ResponseEntity<?> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
		Optional<Brigadistas> brigadista = servicio.consultarBrigadistas(id, null);
		if (brigadista.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(brigadista.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Brigadistas brigadista) {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.crearBrigadistas(brigadista));
	}
}
