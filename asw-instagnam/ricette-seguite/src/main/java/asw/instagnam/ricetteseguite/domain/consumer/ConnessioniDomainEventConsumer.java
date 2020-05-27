package asw.instagnam.ricetteseguite.domain.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.connessioniservice.api.event.ConnessioneCreatedEvent;
import asw.instagnam.ricetteseguite.domain.Connessione;
import asw.instagnam.ricetteseguite.domain.repository.ConnessioniRepository;


@Service
public class ConnessioniDomainEventConsumer implements DomainEventConsumer {
	
	@Autowired
	private ConnessioniRepository connessioniRepository; 

	@Override
	public void onEvent(DomainEvent event) {
		if(event instanceof ConnessioneCreatedEvent) {
			this.handleConnessioneCreatedEvent(event);
		}
		else {
			System.out.println("UNKNOWN EVENT\n"); 
		}
	}

	private void handleConnessioneCreatedEvent(DomainEvent event) {
		ConnessioneCreatedEvent cce = (ConnessioneCreatedEvent) event; 
		Connessione connessione = new Connessione(cce.getId(), cce.getFollower(),cce.getFollowed()); 
		connessioniRepository.save(connessione); 
	}
}