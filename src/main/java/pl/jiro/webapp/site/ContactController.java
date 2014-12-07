package pl.jiro.webapp.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * @author £ukasz Pawe³czak
 */
@Controller
public class ContactController {

	
	//------------------------ LOGIC --------------------------
	
	@RequestMapping("/contact")
    public String contact(ModelMap model) {
        return "contact";
    }
}
