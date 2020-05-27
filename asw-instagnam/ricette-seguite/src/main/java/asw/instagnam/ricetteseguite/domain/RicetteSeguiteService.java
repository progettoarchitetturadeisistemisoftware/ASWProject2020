package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;

import asw.instagnam.ricetteseguite.domain.repository.ConnessioniRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors; 

@Service 
public class RicetteSeguiteService {

	@Autowired 
	private ConnessioniRepository connessioniRepository;

	@Autowired 
	private RicetteRepository ricetteRepository;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		//Trova le connessioni in cui utente e' follower
		return connessioniRepository.findAllByFollower(utente).stream()
				//Trova le ricette create da ogni utente followed
				.map(connessione -> ricetteRepository.findAllByAutore(connessione.getFollowed()))
				         .flatMap(Collection::stream).collect(Collectors.toList());

	}
	
}
