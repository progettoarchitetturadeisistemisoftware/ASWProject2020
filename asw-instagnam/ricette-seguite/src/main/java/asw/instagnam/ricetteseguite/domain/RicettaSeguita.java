package asw.instagnam.ricetteseguite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor 
public class RicettaSeguita {
	
	@Id @GeneratedValue
	private Long id; 
	private String follower; 
	private Long idRicetta; 
	private String autore; 
	private String titolo;
	
	public RicettaSeguita(String follower, Long idRicetta, String autore, String titolo) {
		super();
		this.follower = follower;
		this.idRicetta = idRicetta;
		this.autore = autore;
		this.titolo = titolo;
	} 

	
}
