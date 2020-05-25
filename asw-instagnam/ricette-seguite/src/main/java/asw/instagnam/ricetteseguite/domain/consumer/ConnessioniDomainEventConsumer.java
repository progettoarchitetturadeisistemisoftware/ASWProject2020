package asw.instagnam.ricetteseguite.domain.consumer;

import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.DomainEvent;
import asw.instagnam.ricetteseguite.domain.consumer.handleEvent.EventHandler;


@Service
public class ConnessioniDomainEventConsumer implements DomainEventConsumer {

	@Override
	public void onEvent(DomainEvent event) {
		try {
			EventHandler handler = (EventHandler) Class.forName(
					"asw.instagnam.ricetteseguite.domain.consumer.handleEvent.connessioni" + event.getClass().getSimpleName() + "Handler")
					.newInstance();
			
			handler.handle(event);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}