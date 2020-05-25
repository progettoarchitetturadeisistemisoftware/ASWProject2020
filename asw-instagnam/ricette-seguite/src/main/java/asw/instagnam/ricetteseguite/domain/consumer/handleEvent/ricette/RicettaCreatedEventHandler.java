package asw.instagnam.ricetteseguite.domain.consumer.handleEvent.ricette;

import org.springframework.beans.factory.annotation.Autowired;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicetteRepository;
import asw.instagnam.ricetteseguite.domain.consumer.handleEvent.EventHandler;
import asw.instagnam.ricetteservice.api.event.RicettaCreatedEvent;

public class RicettaCreatedEventHandler implements EventHandler {

	@Autowired
	private RicetteRepository ricetteRepository; 
	
	@Override
	public void handle(DomainEvent event) {
		RicettaCreatedEvent rce = (RicettaCreatedEvent) event; 
		Ricetta ricetta = new Ricetta(rce.getId(), rce.getAutore(), rce.getTitolo());   
		ricetteRepository.save(ricetta); 
	}

}