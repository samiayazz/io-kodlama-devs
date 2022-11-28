package io.kodlama.devs.business.abstracts;

import io.kodlama.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();

    Language getById(int id) throws Exception;

    void add(Language language) throws Exception;

    void update(int oldLanguageId, Language newLanguage) throws Exception;

    void delete(int id) throws Exception;
}
