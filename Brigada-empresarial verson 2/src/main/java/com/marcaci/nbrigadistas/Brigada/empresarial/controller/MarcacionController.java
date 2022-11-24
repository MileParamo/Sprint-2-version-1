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

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Marcacion;
import com.marcaci.nbrigadistas.Brigada.empresarial.service.MarcacionService;



@Controller
@RequestMapping("api/marcaciones")
public class MarcacionController {
	@Autowired
	private MarcacionService servicio;

	@GetMapping
	public ResponseEntity<?> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.consultarLista());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Long id) {
		Optional<Marcacion> marcacion = servicio.consultarMarcacion(id, null);
		if (marcacion.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(marcacion.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Marcacion marcacion) {
		return ResponseEntity.status(HttpStatus.OK).body(servicio.crearMarcacion(marcacion));
	}
}
