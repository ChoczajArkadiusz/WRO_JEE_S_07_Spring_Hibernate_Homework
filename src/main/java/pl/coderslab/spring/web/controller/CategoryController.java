package pl.coderslab.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring.domain.dao.CategoryDao;
import pl.coderslab.spring.domain.model.Category;

import javax.validation.Valid;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @GetMapping
    public String prepareList(Model model) {
        model.addAttribute("categories", categoryDao.loadAll());
        return "/categories/all";
    }

    @GetMapping("/add")
    public String prepareAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "/categories/add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/categories/add-form";
        }
        categoryDao.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id:[1-9][0-9]*}/update")
    public String prepareUpdate(@PathVariable Long id, Model model) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("category", category);
        return "/categories/edit-form";
    }

    @PostMapping("/{id:[1-9][0-9]*}/update")
    public String update(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/categories/add-form";
        }
        categoryDao.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id:[1-9][0-9]*}/confirm-delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("category", category);
        return "/categories/confirm-delete";
    }

    @GetMapping("/{id:[1-9][0-9]*}/delete")
    public String delete(@PathVariable Long id) {
        Category category = categoryDao.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        categoryDao.delete(category);
        return "redirect:/categories";
    }


}
