package tester;
import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import loggInn.Deltager;
import loggInn.DeltagerServlet;
import loggInn.LoggInnServlet;
import loggInn.Skjema;
import loggInn.Validator;
import loggInn.PassordUtil;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class testerSkjemaklassen {
	private LoggInnServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    
    @BeforeEach
    public void setUp() throws ServletException, IOException {
    	servlet = new LoggInnServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        
    }	
   

	@Test
	public void sjekkLagDeltager() throws ServletException, IOException{
		request.addParameter("brukernavn", "bruker1");
	    request.addParameter("epost", "test@gmail.com");
	    request.addParameter("passord", "pass1");
	    request.addParameter("passordRepetert", "pass1");
		
	    servlet.doPost(request, response);
	    
		Skjema s1 = new Skjema(request);
		Deltager d1 = new Deltager("bruker1","pass1","test@gmail.com");
		    
		assertEquals(d1, s1.lagDeltager());
		
	
	}
    

	@Test
	public void sjekkErDataGyldig(){
	
	}

    
	@Test
	public void sjekkGjemPassord(){
	
	}
	
}
