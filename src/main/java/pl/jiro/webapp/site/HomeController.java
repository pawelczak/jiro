package pl.jiro.webapp.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	//------------------------ LOGIC --------------------------
    
    @RequestMapping("/")
    public String home(ModelMap model) {
        
        return "home";
    }
}