package pl.jiro.webapp.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Łukasz Pawełczak
 */
@Controller
public class LinksController {

	
	//------------------------ LOGIC --------------------------
	
    @RequestMapping("/links")
    public String links(ModelMap model) {
        
        return "links";
    }
}
