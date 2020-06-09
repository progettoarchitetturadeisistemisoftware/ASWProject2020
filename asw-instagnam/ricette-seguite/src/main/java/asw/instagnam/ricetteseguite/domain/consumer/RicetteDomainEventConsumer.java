package asw.instagnam.ricetteseguite.domain.consumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicettaSeguita;
import asw.instagnam.ricetteseguite.domain.repository.ConnessioniRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteSeguiteRepository;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;


@Service
public class RicetteDomainEventConsumer implements DomainEventConsumer {

	@Autowired
	private RicetteRepository ricetteRepository; 
	
	@Autowired
	private ConnessioniRepository connessioniRepository; 
	
	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;
	
	@Override
	public void onEvent(DomainEvent event) {
		if(event instanceof RicettaCreatedEvent) {
			this.handleRicettaCreatedEvent(event);
		}
		else {
			System.out.println("UNKNOWN EVENT\n"); 
		}
		
	}
	
	
	private void handleRicettaCreatedEvent(DomainEvent event) {
		RicettaCreatedEvent rce = (RicettaCreatedEvent) event;
		Ricetta ricetta = new Ricetta(rce.getId(), rce.getAutore(), rce.getTitolo());
		final Ricetta ricettaNuova = ricetteRepository.save(ricetta);

		// Troviamo tutti i follower (connessioni) dell'autore
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollowed(ricetta.getAutore());
		List<RicettaSeguita> ricetteSeguite = new ArrayList<>();
		// Creiamo le ricetteSeguite con i follower dell'autore della nuova ricetta
		connessioni.stream().forEach(connessione -> ricetteSeguite.add(new RicettaSeguita(connessione.getFollower(),
				ricettaNuova.getId(), ricettaNuova.getAutore(), ricettaNuova.getTitolo())));
		// Salviamo le ricette seguite nella base di dati
		ricetteSeguite.stream().forEach(ricettaSeguita -> ricetteSeguiteRepository.save(ricettaSeguita));

	}

	
}
