package pl.jiro.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import pl.jiro.article.*;




@Controller
public class AdminController {
	
    
	@RequestMapping("/admin")
    public String adminBase(ModelMap model) {
    	
        return "redirect:/admin/home";
    }
	
	@RequestMapping("/admin/home")
    public String adminHome(ModelMap model) {
    	
        return "adminHome";
    }
    
    
    @RequestMapping(value="/admin/add", method=RequestMethod.POST)
    public String adminShow(ModelMap model) {
    	
    	
        return "adminShow";
    }
    
    @RequestMapping(value="/admin/add", method=RequestMethod.GET)
    public String adminAdd(ModelMap model) {
    
    	
        return "adminAdd";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    
}