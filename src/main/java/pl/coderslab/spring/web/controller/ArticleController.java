package pl.coderslab.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring.domain.dao.ArticleDao;
import pl.coderslab.spring.domain.dao.AuthorDao;
import pl.coderslab.spring.domain.dao.CategoryDao;
import pl.coderslab.spring.domain.model.Article;
import pl.coderslab.spring.domain.model.Author;
import pl.coderslab.spring.domain.model.Category;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    CategoryDao categoryDao;

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.loadAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.loadAll();
    }

    @GetMapping
    public String prepareList(Model model) {
        model.addAttribute("articles", articleDao.loadAll());
        return "/articles/all";
    }

    @GetMapping("/add")
    public String prepareAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "/articles/add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/articles/add-form";
        }
        articleDao.saveArticle(article);
        return "redirect:/articles";
    }

    @GetMapping("/{id:[1-9][0-9]*}/update")
    public String prepareUpdate(@PathVariable Long id, Model model) {
        Article article = articleDao.findById(id);
        if (article == null) {
            return "redirect:/articles";
        }
        model.addAttribute("article", article);
        return "/articles/edit-form";
    }

    @PostMapping("/{id:[1-9][0-9]*}/update")
    public String update(@Valid Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/articles/edit-form";
        }
        article.setCreated(articleDao.findById(article.getId()).getCreated());
        articleDao.update(article);
        return "redirect:/articles";
    }

    @GetMapping("/{id:[1-9][0-9]*}/confirm-delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        Article article = articleDao.findById(id);
        if (article == null) {
            return "redirect:/articles";
        }
        model.addAttribute("article", article);
        return "/articles/confirm-delete";
    }

    @GetMapping("/{id:[1-9][0-9]*}/delete")
    public String delete(@PathVariable Long id) {
        Article article = articleDao.findById(id);
        if (article == null) {
            return "redirect:/articles";
        }
        articleDao.delete(article);
        return "redirect:/articles";
    }


}
