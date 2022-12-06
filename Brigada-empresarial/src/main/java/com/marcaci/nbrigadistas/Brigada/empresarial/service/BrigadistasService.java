package com.marcaci.nbrigadistas.Brigada.empresarial.service;

import java.util.List;
import java.util.Optional;

import com.marcaci.nbrigadistas.Brigada.empresarial.model.Brigadistas;

public interface BrigadistasService {
	
	public Brigadistas actualizarBrigadistas(Brigadistas brigadistas);
	public Brigadistas crearBrigadistas(Brigadistas brigadistas);
	public void eliminarBrigadistasPorID(Long id);
	public Optional<Brigadistas> consultarBrigadistas(Long id, String descripcion);
	public Optional<Brigadistas> consultarBrigadistasPorId(Long Id);
	public List<Brigadistas> consultarLista();
}
