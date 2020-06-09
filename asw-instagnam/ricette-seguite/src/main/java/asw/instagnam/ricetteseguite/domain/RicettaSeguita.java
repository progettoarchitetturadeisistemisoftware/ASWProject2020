package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor 
public class RicettaSeguita {
	
	
	@Id
	private Long idRicetta; 
	@Column(nullable=true)
	private String utenteFollower; 
	private String autoreRicetta; 
	private String titoloRicetta;
	
	public RicettaSeguita(String utenteFollower, Long idRicetta, String autoreRicetta, String titoloRicetta) {
		super();
		this.utenteFollower = utenteFollower;
		this.idRicetta = idRicetta;
		this.autoreRicetta = autoreRicetta;
		this.titoloRicetta = titoloRicetta;
	} 
	
	public RicettaSeguita(String utenteFollower, Ricetta ricetta) {
		this(utenteFollower, ricetta.getId(), ricetta.getAutore(), ricetta.getTitolo()); 
	} 
}
