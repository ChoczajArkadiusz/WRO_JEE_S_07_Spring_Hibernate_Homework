package pl.coderslab.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.domain.dao.ArticleDao;
import pl.coderslab.spring.domain.dao.CategoryDao;
import pl.coderslab.spring.domain.model.Article;
import pl.coderslab.spring.domain.model.Category;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping
    public String showHomepage(Model model) {
        List<Article> articles = articleDao.loadNewest(5);
        List<Category> categories = categoryDao.loadAll();
        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        return "/homepage";
    }


}
