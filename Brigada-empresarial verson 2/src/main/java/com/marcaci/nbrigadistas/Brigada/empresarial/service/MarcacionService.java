package com.marcaci.nbrigadistas.Brigada.empresarial.service;

import java.util.List;
import java.util.Optional;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Marcacion;

public interface MarcacionService {
	public Marcacion actualizarMarcacion(Marcacion marcacion);

	public Marcacion crearMarcacion(Marcacion marcacion);

	public void eliminarMarcacionPorID(Long id);

	public Optional<Marcacion> consultarMarcacion(Long id, String descripcion);

	public List<Marcacion> consultarMarcacionPorId(Long Id);

	public List<Marcacion> consultarLista();
}
