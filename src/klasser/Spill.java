package klasser;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * @author Prosjektgrupe 4
 */
@Entity
@Table(schema = "YatzyDB", name = "spill")
public class Spill {
	
	@Id
	private int spillID;
	private String navn;
	
	@OneToMany(mappedBy = "spill")
	private List<Spiller> spillere;
	
	public Spill() {}
	
	
	/*
	 * Konstruktør, getters og setters.
	 */
	public Spill(int id, String navn) {
		this.spillID = id;
		this.navn = navn;
	}
	public int getSpillID() {
		return this.spillID;
	}
	
	public List<Spiller> getSpillere() {
		return this.spillere;
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
/**
 * Legge til en spiler.
 * @param spiller
 */
	public void leggTilSpiller(Spiller spiller) {
		spillere.add(spiller);
	}
	/**
	 * Oppdatere en spiller med id.
	 * @param id
	 * @param spiller
	 */
	public void oppdaterSpiller(int id, Spiller spiller) {
		spillere.set(id, spiller);
	}
	
	/**
	 * Gir oss en liste med topp 3 spillere.
	 * @return Liste med de tre beste.
	 */
	public List<Spiller> finnTop3() {

		List<Spiller> top = spillere;
		
		//Collections.sort(temp);
		Collections.sort(top, (s1, s2) -> {
			return s1.compareTo(s2);
		});
		
		
		return top;
		
	}
	
	
	
}