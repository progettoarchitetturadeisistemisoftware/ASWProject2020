package asw.instagnam.ricetteseguite.domain.consumer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicettaSeguita;
import asw.instagnam.ricetteseguite.domain.repository.ConnessioniRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteSeguiteRepository;

@Service
public class ConnessioniDomainEventConsumer implements DomainEventConsumer {

	@Autowired
	private ConnessioniRepository connessioniRepository;

	@Autowired
	private RicetteRepository ricetteRepository;

	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;

	@Override
	public void onEvent(DomainEvent event) {
		if (event instanceof ConnessioneCreatedEvent) {
			this.handleConnessioneCreatedEvent(event);
		} else {
			System.out.println("UNKNOWN EVENT\n");
		}
	}

	private void handleConnessioneCreatedEvent(DomainEvent event) {
		ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event;
		// Creiamo una nuova connessione
		Connessione connessione = new Connessione(cce.getId(), cce.getFollower(), cce.getFollowed());
	    connessioniRepository.save(connessione);
	    
		String autore = connessione.getFollowed();

		// Troviamo tutte le ricette dell'utente seguito
		ricetteRepository.findAllByAutore(autore)
				.stream()
				// Creiamo le ricette seguite
				.map(ricetta -> new RicettaSeguita(connessione.getFollower(), ricetta.getId(), ricetta.getAutore(),
						ricetta.getTitolo()))
				// Salviamo le ennuple nella base di dati
				.forEach(ricettaSeguita -> ricetteSeguiteRepository.save(ricettaSeguita));
		
		
	}
}