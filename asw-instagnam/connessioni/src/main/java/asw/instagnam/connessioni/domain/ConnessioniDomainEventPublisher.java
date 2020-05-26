package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.DomainEvent;

public interface DomainEventPublisher {
	public void publish(DomainEvent event); 
}
