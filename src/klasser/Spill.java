package klasser;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "YatzyDB", name = "spill")
public class Spill {
	
	@Id
	private int spillID;
	private String navn;
	
	@OneToMany(mappedBy = "spill")
	private List<Spiller> spillere;
	
	public Spill() {}
	
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

	public void leggTilSpiller(Spiller spiller) {
		spillere.add(spiller);
	}
	
	public void oppdaterSpiller(int id, Spiller spiller) {
		spillere.set(id, spiller);
	}
	
	
	
}