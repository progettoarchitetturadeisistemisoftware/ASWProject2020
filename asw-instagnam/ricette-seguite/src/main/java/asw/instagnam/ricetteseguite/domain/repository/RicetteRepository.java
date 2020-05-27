package asw.instagnam.ricetteseguite.domain.repository;

import org.springframework.data.repository.CrudRepository;

import asw.instagnam.ricetteseguite.domain.Ricetta;

import java.util.*; 

public interface RicetteRepository extends CrudRepository<Ricetta, Long> {

	public Collection<Ricetta> findAll();

	public Collection<Ricetta> findAllByAutore(String autore);

}

