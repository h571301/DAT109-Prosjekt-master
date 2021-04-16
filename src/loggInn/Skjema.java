package loggInn;

import javax.servlet.http.HttpServletRequest;

import klasser.Deltager;
/**
 * @author Prosjektgrupe 4
 */
public class Skjema {

	private String brukernavn;
	private String epost;
	private String passord;
	private String passordRepetert;
	private String feilmelding;
	private Validator v;
	
	public Skjema(HttpServletRequest request) {
		this.brukernavn = request.getParameter("brukernavn");
		this.epost = request.getParameter("epost");
		this.passord = request.getParameter("passord");
		this.passordRepetert = request.getParameter("passordRepetert");
		this.feilmelding="";
		v = new Validator();
	}
	/**
	 * Lager en deltaker.
	 * @return en deltaker.
	 */
	public Deltager lagDeltager() {
		PassordUtil hash = new PassordUtil();
		passord = hash.krypterPassord(passord);
		
		return new Deltager(brukernavn, passord, epost);
	}
	/**
	 * Sjekker om dataene i skjemaet er gyldig.
	 * @return true/false om gyldig.
	 */
	public boolean erAllDataGyldig() {
		return v.erBrukernavnGyldig(brukernavn) && v.erPassordGyldig(passord);
	}
	
	/**
	 * Gjemmer passord.
	 */
	public void gjemPassord() {
		passord = "";
		passordRepetert = "";
	}
	/**
	 * Setter feilmelding.
	 */
	public void setFeilmelding() {
		if(!v.erBrukernavnGyldig(brukernavn)|| !v.erPassordGyldig(passord)) {
			this.feilmelding= "Brukernavn/passord er ugyldig!";
		}
	}
/**
 * Getters og setters.
 */
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getPassord() {
		return passord;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public void setPassordRepetert(String passordRepetert) {
		this.passordRepetert = passordRepetert;
	}

	public String getFeilmelding() {
		return feilmelding;
	}

	public void setFeilmelding(String feilmelding) {
		this.feilmelding = feilmelding;
	}
	
}
