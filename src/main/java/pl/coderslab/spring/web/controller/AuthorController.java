package pl.coderslab.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring.domain.dao.AuthorDao;
import pl.coderslab.spring.domain.model.Author;

import javax.validation.Valid;


@Controller
@RequestMapping(path = "/authors", produces = "text/plain;charset=UTF-8")
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;


    @GetMapping
    public String prepareList(Model model) {
        model.addAttribute("authors", authorDao.loadAll());
        return "/authors/all";
    }

    @GetMapping("/add")
    public String prepareAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "/authors/add-form";
    }

    @PostMapping("/add")
    public String add(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/authors/add-form";
        }
        authorDao.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping(path = "/init", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String init() {
        Author[] authors = new Author[10];
        for (int i = 0; i < authors.length; i++) {
            authors[i] = new Author();
        }
        authors[0].setFirstName("Jacek");
        authors[0].setLastName("Kowalski");
        authors[1].setFirstName("Maciej");
        authors[1].setLastName("Nowak");
        authors[2].setFirstName("Kamil");
        authors[2].setLastName("Polak");
        authors[3].setFirstName("Pawel");
        authors[3].setLastName("Wisniewski");
        authors[4].setFirstName("Jerzy");
        authors[4].setLastName("Zimoch");
        authors[5].setFirstName("Anna");
        authors[5].setLastName("Kowalska");
        authors[6].setFirstName("Katarzyna");
        authors[6].setLastName("Sobczyk");
        authors[7].setFirstName("Magda");
        authors[7].setLastName("Piertas");
        authors[8].setFirstName("Agnieszka");
        authors[8].setLastName("Szymanek");
        authors[9].setFirstName("Janina");
        authors[9].setLastName("Wolna");
        for (int i = 0; i < authors.length; i++) {
            authorDao.saveAuthor(authors[i]);
        }
        return "dodano nowe wpisy";
    }

    @GetMapping(path = "/find/{id}")
    @ResponseBody
    public String find(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        return "Pobrano autora:" + author;
    }


    @GetMapping("/{id:[1-9][0-9]*}/update")
    public String prepareUpdate(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        if (author == null) {
            return "redirect:/authors";
        }
        model.addAttribute("author", author);
        return "/authors/edit-form";
    }

    @PostMapping("/{id:[1-9][0-9]*}/update")
    public String update(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/authors/edit-form";
        }
        authorDao.update(author);
        return "redirect:/authors";
    }


    @GetMapping("/{id:[1-9][0-9]*}/confirm-delete")
    public String confirmDelete(@PathVariable Long id, Model model) {
        Author author = authorDao.findById(id);
        if (author == null) {
            return "redirect:/authors";
        }
        model.addAttribute("author", author);
        return "/authors/confirm-delete";
    }

    @GetMapping("/{id:[1-9][0-9]*}/delete")
    public String delete(@PathVariable Long id) {
        Author author = authorDao.findById(id);
        if (author == null) {
            return "redirect:/authors";
        }
        authorDao.delete(author);
        return "redirect:/authors";
    }


}
