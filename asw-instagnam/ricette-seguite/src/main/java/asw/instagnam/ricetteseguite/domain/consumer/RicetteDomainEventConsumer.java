package asw.instagnam.ricetteseguite.domain.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicettaSeguita;
import asw.instagnam.ricetteseguite.domain.repository.RicetteRepository;
import asw.instagnam.ricetteseguite.domain.repository.RicetteSeguiteRepository;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;


@Service
public class RicetteDomainEventConsumer implements DomainEventConsumer {

	@Autowired
	private RicetteRepository ricetteRepository; 
	
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
		RicettaSeguita ricettaSeguita = new RicettaSeguita(null, rce.getId(), rce.getAutore(), rce.getTitolo());
		ricetteRepository.save(ricetta); 
		ricetteSeguiteRepository.save(ricettaSeguita);
	}

	
}
