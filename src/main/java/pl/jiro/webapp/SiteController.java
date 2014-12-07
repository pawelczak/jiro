package pl.jiro.webapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.jiro.photo.*;

@Controller
public class SiteController {
	@Autowired private CategoryDAO categoryDAO;
    
    @RequestMapping("/")
    public String home(ModelMap model) {
        
        return "home";
    }
    
    @RequestMapping("/contact")
    public String contact(ModelMap model) {
        
        return "contact";
    }
    
    @RequestMapping("/links")
    public String links(ModelMap model) {
        
        return "links";
    }
    
    @RequestMapping("/test")
    public String test(ModelMap model) {
        
        return "test";
    }
}