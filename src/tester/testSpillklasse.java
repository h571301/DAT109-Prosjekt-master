package tester;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import klasser.Poeng;
import klasser.Spill;
import klasser.Spiller;

public class testSpillklasse {

	Spill s1 = new Spill(1,"s1");

	Poeng p1 = new Poeng(1);

	Spiller sp1 = new Spiller(1, "sp1", s1, p1);
	Spiller sp2 = new Spiller(2, "sp2", s1, p1);

	@Test
	public void sjekkLeggTilSpiller(){
		
		s1.leggTilSpiller(sp1);
		assertEquals(sp1,s1.getSpillere().get(0));
		
		// må gjøre endring i opprettelse av liste i spill.java
		//private List<Spiller> spillere = new ArrayList<Spiller>();
	}

	@Test
	public void sjekkOppdaterSpiller(){
		s1.leggTilSpiller(sp1);
		s1.oppdaterSpiller(0, sp2);
		assertEquals(sp2,s1.getSpillere().get(0));
		
	}

	@Test
	public void sjekkOppdaterScore(){

		
	}
}
