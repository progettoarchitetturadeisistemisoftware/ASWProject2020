package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RicettaSeguita {
	
	
	@Id
	private Long idRicetta; 
	private String utenteFollower; 
	private String autoreRicetta; 
	private String titoloRicetta;
	
	
	public RicettaSeguita(String utenteFollower, Ricetta ricetta) {
		this(ricetta.getId(), utenteFollower, ricetta.getAutore(), ricetta.getTitolo()); 
	} 
}
