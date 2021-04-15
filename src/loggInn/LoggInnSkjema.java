package loggInn;

import javax.servlet.http.HttpServletRequest;

import dao.DeltagerDAO;

public class LoggInnSkjema {
	
	private String brukernavn;
	private String passord;
	private String feilmelding;
	
	
	public LoggInnSkjema(HttpServletRequest request) {
		this.brukernavn = request.getParameter("brukernavn");
		this.passord = request.getParameter("passord");
	}
	
	public void feilMelding() {
		brukernavn = "";
		passord = "";
		feilmelding = "Ugyldig brukernavn og/eller passord!";
	}
	public boolean sjekkOmInnlogget(DeltagerDAO dao) {
		if(!brukernavn.isEmpty() && dao.eksistererBrukernavn(brukernavn)) {
			PassordUtil hash = new PassordUtil();
			return hash.sjekkPassord(passord, dao.hentUtPassord(brukernavn));
		} else {
			return false;
		}
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public String getPassord() {
		return passord;
	}

	public String getFeilmelding() {
		return feilmelding;
	}
	
}
