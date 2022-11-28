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
            this.add(new Language("Java"));
            this.add(new Language("C#"));
            this.add(new Language("PHP"));
            this.add(new Language("JavaScript"));
        } catch (Exception e) {
        }
    }

    @Override
    public List<Language> getAll() {
        return this.languages;
    }

    @Override
    public Language getById(int id) throws Exception {
        Language language = this.languages.stream().filter(lang -> id == lang.getId()).findFirst().orElse(null);
        if (language == null) {
            throw new Exception("Language not found");
        }
        return language;
    }

    @Override
    public boolean isNameExists(String name) {
        return this.languages.stream().filter(language -> language.getName().equals(name)).findFirst().orElse(null) == null ? false : true;
    }

    @Override
    public void add(Language language) throws Exception {
        try {
            int lastIndex = (int) this.languages.stream().count() - 1;
            int lastId = 0;
            if (lastIndex >= 0) {
                lastId = this.languages.get(lastIndex).getId();
            }
            language.setId(lastId + 1);

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
        newLanguage.setId(updatingLanguage.getId());
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
