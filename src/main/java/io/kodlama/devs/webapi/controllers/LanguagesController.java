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
    public Language getById(@RequestParam("id") int id) {
        return languageService.getById(id);
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
