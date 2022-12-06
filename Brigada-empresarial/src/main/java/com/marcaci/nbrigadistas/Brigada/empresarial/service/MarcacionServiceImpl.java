package com.marcaci.nbrigadistas.Brigada.empresarial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;
import com.marcaci.nbrigadistas.Brigada.empresarial.model.Marcacion;
import com.marcaci.nbrigadistas.Brigada.empresarial.repository.BrigadistaRepository;
import com.marcaci.nbrigadistas.Brigada.empresarial.repository.MarcacionRepository;
@Service
public class MarcacionServiceImpl implements MarcacionService {
	@Autowired
	private MarcacionRepository repositorio;
	@Override
	public Marcacion actualizarMarcacion(Marcacion marcacion) {
		if (marcacion == null) {
			return null;
		}
		Optional<Marcacion> marcacionAActualizar = repositorio.findById(marcacion.getId());
		if (marcacionAActualizar.isPresent()) {
			return repositorio.save(marcacion);
		}
		return null;
	}

	@Override
	public Marcacion crearMarcacion(Marcacion marcacion) {
		return null;
	}

	@Override
	public void eliminarMarcacionPorID(Long id) {
		Optional<Marcacion> eliminarMarcacion = repositorio.findById(id);
		if (eliminarMarcacion.isPresent()) {
			repositorio.delete(eliminarMarcacion .get());
		}

	}

	@Override
	public Optional<Marcacion> consultarMarcacion(Long id, String descripcion) {
		if (id == null) {

			return Optional.empty();
		}
		return repositorio.findById(id);
	}

	@Override
	public List<Marcacion> consultarMarcacionPorId(Long Id) {
		return null;
	}

	@Override
	public List<Marcacion> consultarLista() {
		return repositorio.findAll();
	}

}
