package pl.jiro.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class ArticleController {
	
	@Autowired private ArticleDAO articleDAO;
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Article> articles = articleDAO.findAll();
		model.addAttribute("articles", articles);
		return "index";
	}*/
	
	@RequestMapping(value="/admin/article", method=RequestMethod.GET)
    public String adminView(ModelMap model) {
    	List<Article> articles = articleDAO.findAll();
		model.addAttribute("articles", articles);
    	
        return "articleView";
    }
}

