package asw.instagnam.ricetteseguite.domain.repository;

import org.springframework.data.repository.CrudRepository;

import asw.instagnam.ricetteseguite.domain.Connessione;

import java.util.*; 

public interface ConnessioniRepository extends CrudRepository<Connessione, Long> {

	public Collection<Connessione> findAll();

	public Collection<Connessione> findAllByFollower(String follower);
	
	public Collection<Connessione> findAllByFollowed(String followed);


}

