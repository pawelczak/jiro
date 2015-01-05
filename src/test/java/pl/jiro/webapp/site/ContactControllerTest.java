package pl.jiro.webapp.site;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * @author Łukasz Pawełczak
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

	private MockMvc mockMvc;
	
	
	//------------------------ LOGIC --------------------------
	
	@Test
	public void contact() throws Exception {
		
		mockMvc.perform(get("/contact"))
        .andExpect(status().isOk())
        .andExpect(view().name("contact"));
		
		
	}

}
