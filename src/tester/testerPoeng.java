package tester;
import static org.junit.Assert.assertEquals;


import org.junit.Test;


import klasser.Poeng;


public class testerPoeng {
	
	Poeng p1 = new Poeng(1);

	@Test
	public void sjekkPoeng(){
		p1.setEnere(4);
		p1.setEtPar(10);
		
		p1.setTotal();
		
		assertEquals(14, p1.getTotal());
		
	}


}
