package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*; 

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class Connessione {

	@Id 
	private Long id; 
	private String follower; 
	private String followed; 
	
	
}
