package asw.instagnam.ricetteseguite.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*; 

/* Ricetta, in formato breve. */ 
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ricetta {

	@Id
	private Long id; 
	private String autore; 
	private String titolo; 
	
	public Ricetta(Ricetta r) {
		this.id = r.getId(); 
		this.autore = r.getAutore(); 
		this.titolo = r.getTitolo(); 
	}
	
}
