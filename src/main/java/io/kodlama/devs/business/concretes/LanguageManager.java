package io.kodlama.devs.business.concretes;

import io.kodlama.devs.business.abstracts.LanguageService;
import io.kodlama.devs.dataaccess.abstracts.LanguageRepository;
import io.kodlama.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) throws Exception {
        return languageRepository.getById(id);
    }

    @Override
    public void add(Language language) throws Exception {
        if (languageRepository.isNameExists(language.getName())) {
            throw new Exception("There is already a language with this name");
        }

        languageRepository.add(language);
    }

    @Override
    public void update(int oldLanguageId, Language newLanguage) throws Exception {
        if (languageRepository.isNameExists(newLanguage.getName())) {
            throw new Exception("There is already a language with this name");
        }

        languageRepository.update(oldLanguageId, newLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        languageRepository.delete(id);
    }
}
