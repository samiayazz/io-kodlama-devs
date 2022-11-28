package io.kodlama.devs.dataaccess.concretes;

import io.kodlama.devs.dataaccess.abstracts.LanguageRepository;
import io.kodlama.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    private List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();

        try {
            languages.add(new Language("Java"));
            languages.add(new Language("C#"));
            languages.add(new Language("PHP"));
            languages.add(new Language("JavaScript"));
        } catch (Exception e) {
        }
    }

    @Override
    public List<Language> getAll() {
        return this.languages;
    }

    @Override
    public Language getById(int id) {
        return this.languages.stream().filter(language -> id == language.getId()).findFirst().orElse(null);
    }

    @Override
    public boolean isNameExists(String name) {
        return this.languages.stream().filter(language -> name == language.getName()).findFirst().orElse(null) == null ? false : true;
    }

    @Override
    public void add(Language language) throws Exception {
        try {
            this.languages.add(language);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(int oldLanguageId, Language newLanguage) throws Exception {
        Language updatingLanguage = this.languages.stream().filter(language -> oldLanguageId == language.getId()).findFirst().orElse(null);
        if (updatingLanguage == null) {
            throw new Exception("Language not found");
        }
        this.languages.set(this.languages.indexOf(updatingLanguage), newLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        Language removingLanguage = this.languages.stream().filter(language -> id == language.getId()).findFirst().orElse(null);
        if (removingLanguage == null) {
            throw new Exception("Language not found");
        }
        languages.remove(this.languages.indexOf(removingLanguage));
    }
}
