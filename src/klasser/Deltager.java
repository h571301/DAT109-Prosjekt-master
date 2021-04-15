package klasser;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(schema = "DeltagerPU", name = "deltager")
public class Deltager {
	@Id
	private String brukernavn;
	
	private String epost;
	private String passord;

	public Deltager(String brukernavn, String passord, String epost) {
		this.brukernavn = brukernavn;
		this.passord = passord;
		this.epost = epost;

	}

	public Deltager() {

	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	@Override
	public String toString() {
		return "navn=" + brukernavn + ", epost=" + epost;
	}

}
