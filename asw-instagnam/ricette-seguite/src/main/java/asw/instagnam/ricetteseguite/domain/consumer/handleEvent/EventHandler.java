package asw.instagnam.ricetteseguite.domain.consumer.handleEvent;

import asw.instagnam.common.api.event.DomainEvent;

public interface EventHandler {
	
	public void handle(DomainEvent event); 

}
