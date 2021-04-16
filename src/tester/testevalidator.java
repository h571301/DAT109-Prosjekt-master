package tester;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import loggInn.Validator;

public class testevalidator {
	
	Validator v1 = new Validator();

	@Test
	public void sjekkErBrukernavnGyldig(){
		String b1 = "4dsfg";
		String b2 = "L54123";
		String b3 = "Hefdas";
		String b4 = "Jdf123";
		String b5 = "fjd";
		String b6 = "";
			
		assertTrue(Validator.erBrukernavnGyldig(b2));
		assertTrue(Validator.erBrukernavnGyldig(b3));
		assertTrue(Validator.erBrukernavnGyldig(b4));

		assertFalse(Validator.erBrukernavnGyldig(b1));
		assertFalse(Validator.erBrukernavnGyldig(b5));
		assertFalse(Validator.erBrukernavnGyldig(b6));
	}
	
	@Test
	public void sjekkErPassordGyldig(){
		String b1 = "4dsfg";
		String b2 = "L54123";
		String b3 = "Hefdas";
		String b4 = "Jdf123";
		String b5 = "fjd";
		String b6 = "";
		
		
		assertTrue(Validator.erPassordGyldig(b3));
		assertTrue(Validator.erPassordGyldig(b4));
		assertTrue(Validator.erPassordGyldig(b2));
	
	
		assertFalse(Validator.erPassordGyldig(b1));
		assertFalse(Validator.erPassordGyldig(b5));
		assertFalse(Validator.erPassordGyldig(b6));
	}
}
