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
	private String follower; 
	private String autoreRicetta; 
	private String titoloRicetta;
	
	
	 
}
