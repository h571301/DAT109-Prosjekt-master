package Prosjekt1Pakke;

import java.util.List;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Entity
@Table(schema = "YatzyDB", name = "spiller")
public class Spiller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillerID;
	private String navn;

//	@ManyToOne
//	@JoinColumn(name = "spillID", referencedColumnName = "spillID")
//	private Spill spill;

	@OneToOne
	@JoinColumn(name = "poengID", referencedColumnName = "poengID")
	private Poeng poeng;


public Spiller(String navn) {
	this.navn = navn;
	this.poeng = new Poeng();
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

	public void printScore() {
		System.out.println(poeng.toString());

	}

	public void oppdaterScore(HttpServletRequest request, HttpServletResponse response) {

		Integer x = 0;
		
		
		List<Integer> poengliste = poeng.lagrePoengSomListe();
		
		for(Integer i : poengliste) {
			if(i != null) break;
			x++;
			
		}
		
		
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
			else if(x == 8)
				poeng.setBonus(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 9)
				poeng.setEtPar(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 10)
				poeng.setToPar(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 11)
				poeng.setTreLike(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 12)
				poeng.setFireLike(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 13)
				poeng.setHus(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 14)
				poeng.setLitenStraight(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 15)
				poeng.setStorStraight(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 16)
				poeng.setSjanse(Integer.parseInt(request.getParameter("dice-value")));
			else if(x == 17) 
				poeng.setYatzy(Integer.parseInt(request.getParameter("dice-value")));
	
		}
		
		poeng.setSum();
		poeng.setTotal();
		
	}
}