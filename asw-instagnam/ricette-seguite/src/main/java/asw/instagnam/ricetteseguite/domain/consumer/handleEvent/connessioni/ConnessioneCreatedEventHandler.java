package asw.instagnam.ricetteseguite.domain.consumer.handleEvent.connessioni;

import org.springframework.beans.factory.annotation.Autowired;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.ConnessioniRepository;
import asw.instagnam.ricetteseguite.domain.consumer.handleEvent.EventHandler;

public class ConnessioneCreatedEventHandler implements EventHandler {

	@Autowired
	private ConnessioniRepository connessioniRepository; 
	
	@Override
	public void handle(DomainEvent event) {
		ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event; 
		Connessione connessione = new Connessione(cce.getId(), cce.getFollower(),cce.getFollowed()); 
		connessioniRepository.save(connessione); 
	}

}
