//package Prosjekt1Pakke;
//
//import java.util.List;
//
//import javax.persistence.*;
//
//@Entity
//@Table(schema = "YatzyDB", name = "spill")
//public class Spill {
//	
//	@Id
//	private int spillID;
//	
//	@OneToMany(mappedBy = "spill")
//	private List<Spiller> spillere;
//	
//	public int getSpillID() {
//		return this.spillID;
//	}
//	
//	public List<Spiller> getSpillere() {
//		return this.spillere;
//	}
//}