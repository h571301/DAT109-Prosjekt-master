  
package Prosjekt1Pakke;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (schema = "YatzyDB", name = "poeng")
public class Poeng {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int poengID; 
	
	@OneToOne(mappedBy = "poeng")
	private Spiller spiller;
	
	private int enere; 
	private int toere; 
	private int trere; 
	private int firere; 
	private int femmere; 
	private int seksere; 
	private int sum; 
	private int bonus; 
	private int etPar; 
	private int toPar; 
	private int treLike; 
	private int fireLike; 
	private int litenStraight; 
	private int storStraight; 
	private int hus; 
	private int sjanse; 
	private int yatzy; 
	private int total;
	
	public Poeng() {
		this.poengID = 0;
		this.enere = 0;
		this.toere = 0;
		this.trere = 0;
		this.firere = 0;
		this.femmere = 0;
		this.seksere = 0;
		this.sum = 0;
		this.bonus = 0;
		this.etPar = 0;
		this.toPar = 0;
		this.treLike = 0;
		this.fireLike = 0;
		this.litenStraight = 0;
		this.storStraight = 0;
		this.hus = 0;
		this.sjanse = 0;
		this.yatzy = 0;
		this.total = 0;
	}
	public void setEnere(int enere) {
		this.enere = enere;
	}
	public void setToere(int toere) {
		this.toere = toere;
	}
	public void setTrere(int trere) {
		this.trere = trere;
	}
	public void setFirere(int firere) {
		this.firere = firere;
	}
	public void setFemmere(int femmere) {
		this.femmere = femmere;
	}
	public void setSeksere(int seksere) {
		this.seksere = seksere;
	}
	public void setSum() {
		this.sum = enere + toere + trere + firere + femmere + seksere;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public void setEtPar(int etPar) {
		this.etPar = etPar;
	}
	public void setToPar(int toPar) {
		this.toPar = toPar;
	}
	public void setTreLike(int treLike) {
		this.treLike = treLike;
	}
	public void setFireLike(int fireLike) {
		this.fireLike = fireLike;
	}
	public void setLitenStraight(int litenStraight) {
		this.litenStraight = litenStraight;
	}
	public void setStorStraight(int storStraight) {
		this.storStraight = storStraight;
	}
	public void setHus(int hus) {
		this.hus = hus;
	}
	public void setSjanse(int sjanse) {
		this.sjanse = sjanse;
	}
	public void setYatzy(int yatzy) {
		this.yatzy = yatzy;
	}
	public void setTotal() {
		this.total = sum + bonus + etPar + toPar + treLike + fireLike + litenStraight + storStraight + hus + sjanse + yatzy;
	}
	
	public List<Integer> lagrePoengSomListe() {
		List<Integer> poengListe = new ArrayList<Integer>();
		poengListe.add(enere);
		poengListe.add(toere);
		poengListe.add(trere);
		poengListe.add(firere);
		poengListe.add(femmere);
		poengListe.add(seksere);
		poengListe.add(sum);
		poengListe.add(bonus);
		poengListe.add(etPar);
		poengListe.add(toPar);
		poengListe.add(treLike);
		poengListe.add(fireLike);
		poengListe.add(litenStraight);
		poengListe.add(storStraight);
		poengListe.add(hus);
		poengListe.add(sjanse);
		poengListe.add(yatzy);
		poengListe.add(total);
		return poengListe;
	}
	@Override
	public String toString() {
		return "Poeng [poengID=" + poengID + ", spiller=" + spiller + ", enere=" + enere + ", toere=" + toere
				+ ", trere=" + trere + ", firere=" + firere + ", femmere=" + femmere + ", seksere=" + seksere + ", sum="
				+ sum + ", bonus=" + bonus + ", etPar=" + etPar + ", toPar=" + toPar + ", treLike=" + treLike
				+ ", fireLike=" + fireLike + ", litenStraight=" + litenStraight + ", storStraight=" + storStraight
				+ ", hus=" + hus + ", sjanse=" + sjanse + ", yatzy=" + yatzy + ", total=" + total + "]";
	}
	
	
	
}