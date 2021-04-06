package klasser;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Entity
@Table(schema = "YatzyDB", name = "spiller")
public class Spiller {

	@Id
	private int spillerID;
	private String navn;

	@ManyToOne
	@JoinColumn(name = "spillID", referencedColumnName = "spillID")
	private Spill spill;

	@OneToOne
	@JoinColumn(name = "poengID", referencedColumnName = "poengID")
	private Poeng poeng;

	public Spiller() {}
	
	public Spiller(int id, String navn, Spill spill,Poeng poeng) {
		this.spillerID = id;
		this.navn = navn;
		this.spill = spill;
		this.poeng = poeng;
	}

	public int getSpillerID() {
		return spillerID;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Poeng getPoeng() {
		return poeng;
	}
	
	
	
	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}

	public void setPoeng(Poeng poeng) {
		this.poeng = poeng;
	}

	public void printScore() {
		System.out.println(poeng.toString());

	}

	public void oppdaterScore(HttpServletRequest request, HttpServletResponse response) {

		Integer x = 1;

		List<Integer> poengliste = poeng.lagrePoengSomListe();

		for (Integer i : poengliste) {
			
			if (i == -1)
				break;
			x++;

		}
		System.out.println("X verdi :" + " " + x);
		if (request.getParameter("dice-value") != null) {
			if (x == 1)
				poeng.setEnere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 2)
				poeng.setToere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 3)
				poeng.setTrere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 4)
				poeng.setFirere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 5)
				poeng.setFemmere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 6)
				poeng.setSeksere(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 7)
				poeng.setBonus(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 8)
				poeng.setEtPar(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 9)
				poeng.setToPar(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 10)
				poeng.setTreLike(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 11)
				poeng.setFireLike(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 12)
				poeng.setHus(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 13)
				poeng.setLitenStraight(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 14)
				poeng.setStorStraight(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 15)
				poeng.setSjanse(Integer.parseInt(request.getParameter("dice-value")));
			else if (x == 16)
				poeng.setYatzy(Integer.parseInt(request.getParameter("dice-value")));

		}

		poeng.setTotal();

//		printScore();
	}

	@Override
	public String toString() {
		return "Spiller [spillerID=" + spillerID + ", navn=" + navn + ", spill=" + spill + ", poeng=" + poeng + "]";
	}
}
