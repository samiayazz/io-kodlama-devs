package io.kodlama.devs.webapi.controllers;

import io.kodlama.devs.business.abstracts.LanguageService;
import io.kodlama.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getbyid")
    public Object getById(@RequestParam("id") int id) {
        try {
            return languageService.getById(id);
        } catch (Exception e) {
            if (e.getMessage().equals("Language not found")) {
                return e.getMessage();
            } else {
                return "An exception occurred while deleting the language";
            }
        }
    }

    @GetMapping("/add")
    public String add(@RequestParam("name") String name) {
        try {
            Language addingLanguage = new Language(name);
            languageService.add(addingLanguage);
            return "The language added successfully";
        } catch (Exception e) {
            if (e.getMessage().equals("There is already a language with this name")) {
                return e.getMessage();
            } else {
                return "An exception occurred while adding the language";
            }
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, @RequestParam("name") String name) {
        try {
            Language updatingLanguage = new Language(name);
            languageService.update(id, updatingLanguage);
            return "The language updated successfully";
        } catch (Exception e) {
            if (e.getMessage().equals("There is already a language with this name")) {
                return e.getMessage();
            } else {
                return "An exception occurred while updating the language";
            }
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        try {
            languageService.delete(id);
            return "The language deleted successfully";
        } catch (Exception e) {
            if (e.getMessage().equals("Language not found")) {
                return e.getMessage();
            } else {
                return "An exception occurred while deleting the language";
            }
        }
    }
}
