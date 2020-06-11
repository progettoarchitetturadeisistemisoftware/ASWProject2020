package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;

import asw.instagnam.ricetteseguite.domain.repository.RicetteSeguiteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors; 

@Service 
public class RicetteSeguiteService {

	@Autowired 
	private RicetteSeguiteRepository ricetteSeguiteRepository;

	/*Variante piu' complessa
    //Trova le ricette create da utenti seguiti da: utente*/
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		return ricetteSeguiteRepository.findAllByFollower(utente).stream()
				.map(ricettaSeguita -> new Ricetta(ricettaSeguita.getIdRicetta(), ricettaSeguita.getAutoreRicetta(),
						ricettaSeguita.getTitoloRicetta()))
				                   .collect(Collectors.toList());

	}
	
	/* Versione base
	 //Trova le ricette (in formato breve) degli utenti seguiti da utente. 
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		//Trova le connessioni in cui utente e' follower
		return connessioniRepository.findAllByFollower(utente).stream()
				//Trova le ricette create da ogni utente followed
				.map(connessione -> ricetteRepository.findAllByAutore(connessione.getFollowed()))
				         .flatMap(Collection::stream).collect(Collectors.toList());

	} 
	 */
	
}
