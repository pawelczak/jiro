package pl.jiro.webapp.admin.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.jiro.persistence.repository.ArticleRepository;


/**
 * @author Łukasz Pawełczak
 */
@Controller
@RequestMapping("/")
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Article> articles = articleDAO.findAll();
		model.addAttribute("articles", articles);
		return "index";
	}*/
	
	@RequestMapping(value="/admin/article", method=RequestMethod.GET)
    public String articleList(ModelMap model) {
		
		model.addAttribute("articles", articleRepository.findAll());
    	
        return "articleView";
    }
}

