package com.marcaci.nbrigadistas.Brigada.empresarial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;
import com.marcaci.nbrigadistas.Brigada.empresarial.repository.BrigadistaRepository;

@Service
public class BrigadistasServiceImpl implements BrigadistasService {

	@Autowired
	private BrigadistaRepository repositorio;

	@Override
	public Brigadistas actualizarBrigadistas(Brigadistas brigadista) {
		if (brigadista == null) {
			return null;
		}
		Optional<Brigadistas> brigadistasAAtualizar = repositorio.findById(brigadista.getId());
		if (brigadistasAAtualizar.isPresent()) {
			return repositorio.save(brigadista);
		}
		return null;
	}
	

	@Override
	public Brigadistas crearBrigadistas(Brigadistas brigadistas) {
		Optional<Brigadistas> creaBrigadistas = repositorio.findById(brigadistas.getId());
		if (creaBrigadistas.isPresent()) {
		}
		return repositorio.insert(brigadistas);

	}

	@Override
	public void eliminarBrigadistasPorID(Long id) {
		Optional<Brigadistas> eliminarBrigadista = repositorio.findById(id);
		if (eliminarBrigadista.isPresent()) {
			repositorio.delete(eliminarBrigadista.get());
		}

	}

	@Override
	public Optional<Brigadistas> consultarBrigadistas(Long id, String descripcion) {
		if (id == null) {
			return Optional.empty();
		}
		return repositorio.findById(id);
	}

	@Override
	public Optional<Brigadistas> consultarBrigadistasPorId(Long Id) {
		return null;
	}

	@Override
	public List<Brigadistas> consultarLista() {
		return repositorio.findAll();
	}

}
