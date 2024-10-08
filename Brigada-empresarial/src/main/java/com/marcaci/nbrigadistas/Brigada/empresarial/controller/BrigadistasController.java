package com.marcaci.nbrigadistas.Brigada.empresarial.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Brigadistas brigadistasDetalle, @PathVariable Long id) {
		Optional<Brigadistas> brigadistas = servicio.consultarBrigadistasPorId(id);

		if (!brigadistas.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(brigadistasDetalle, brigadistas.get());
		brigadistas.get().setId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(servicio.actualizarBrigadistas(brigadistas.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Brigadistas> brigadistas = servicio.consultarBrigadistasPorId(id);
		if (!brigadistas.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		servicio.eliminarBrigadistasPorID(id);
		return ResponseEntity.ok().build();
	}		
}
