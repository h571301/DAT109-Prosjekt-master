package klasser;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "YatzyDB", name = "poeng")
public class Poeng {

	@Id
	private int poengID;

	public void setPoengID(int poengID) {
		this.poengID = poengID;
	}

	@OneToOne(mappedBy = "poeng", cascade = CascadeType.PERSIST)
	private Spiller spiller;

	private int enere;
	private int toere;

	public void setSpiller(Spiller spiller) {
		this.spiller = spiller;
	}

	private int trere;
	private int firere;
	private int femmere;
	private int seksere;
	private int summ; // Denne er skrevet slik fordi sum er et låst ord SQL
	private int bonus;
	private int etPar;
	private int toPar;
	private int treLike;
	private int fireLike;
	private int hus;
	private int litenStraight;
	private int storStraight;
	private int sjanse;
	private int yatzy;
	private int total;

	public Poeng() {
	}

	public Poeng(int poengId) {
		this.poengID = poengId;
		this.enere = -1;
		this.toere = -1;
		this.trere = -1;
		this.firere = -1;
		this.femmere = -1;
		this.seksere = -1;
		this.summ = -1;
		this.bonus = -1;
		this.etPar = -1;
		this.toPar = -1;
		this.treLike = -1;
		this.fireLike = -1;
		this.litenStraight = -1;
		this.storStraight = -1;
		this.hus = -1;
		this.sjanse = -1;
		this.yatzy = -1;
		this.total = -1;
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
		this.summ = enere + toere + trere + firere + femmere + seksere;
	}

	public void setBonus() {
		if(this.summ > 63) 
			this.bonus = 50;
		else this.bonus = 0;
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
        this.total = -1;
        List<Integer> poengListe = lagrePoengSomListe();
        int tot = 0;

        for (Integer i : poengListe) {
            if (i > 0)
                tot += i;
        }

        this.total = tot;

    }

	public void oppdaterSummer() {
		this.summ = enere + toere + trere + firere + femmere + seksere;
		this.total = summ + bonus + etPar + toPar + treLike + fireLike + litenStraight + storStraight + hus + sjanse
				+ yatzy;
	}

	public int getPoengID() {
		return poengID;
	}

	public Spiller getSpiller() {
		return spiller;
	}

	public int getEnere() {
		return enere;
	}

	public int getToere() {
		return toere;
	}

	public int getTrere() {
		return trere;
	}

	public int getFirere() {
		return firere;
	}

	public int getFemmere() {
		return femmere;
	}

	public int getSeksere() {
		return seksere;
	}

	public int getSum() {
		return summ;
	}

	public int getBonus() {
		return bonus;
	}

	public int getEtPar() {
		return etPar;
	}

	public int getToPar() {
		return toPar;
	}

	public int getTreLike() {
		return treLike;
	}

	public int getFireLike() {
		return fireLike;
	}

	public int getLitenStraight() {
		return litenStraight;
	}

	public int getStorStraight() {
		return storStraight;
	}

	public int getHus() {
		return hus;
	}

	public int getSjanse() {
		return sjanse;
	}

	public int getYatzy() {
		return yatzy;
	}

	public int getTotal() {
		return total;
	}

	public List<Integer> lagrePoengSomListe() {
		List<Integer> poengListe = new ArrayList<Integer>();
		poengListe.add(enere);
		poengListe.add(toere);
		poengListe.add(trere);
		poengListe.add(firere);
		poengListe.add(femmere);
		poengListe.add(seksere);
		poengListe.add(bonus);
		poengListe.add(etPar);
		poengListe.add(toPar);
		poengListe.add(treLike);
		poengListe.add(fireLike);
		poengListe.add(hus);
		poengListe.add(litenStraight);
		poengListe.add(storStraight);
		poengListe.add(sjanse);
		poengListe.add(yatzy);
		poengListe.add(total);
		return poengListe;
	}

//	@Override
//	public String toString() {
//		return "Poeng [poengID=" + poengID + ", spiller=" + spiller + ", enere=" + enere + ", toere=" + toere
//				+ ", trere=" + trere + ", firere=" + firere + ", femmere=" + femmere + ", seksere=" + seksere + ", sum="
//				+ summ + ", bonus=" + bonus + ", etPar=" + etPar + ", toPar=" + toPar + ", treLike=" + treLike
//				+ ", fireLike=" + fireLike + ", litenStraight=" + litenStraight + ", storStraight=" + storStraight
//				+ ", hus=" + hus + ", sjanse=" + sjanse + ", yatzy=" + yatzy + ", total=" + total + "]";
//	}
}