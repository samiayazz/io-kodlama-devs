package io.kodlama.devs.dataaccess.abstracts;

import io.kodlama.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();

    Language getById(int id) throws Exception;

    boolean isNameExists(String name);

    void add(Language language) throws Exception;

    void update(int oldLanguageId, Language newLanguage) throws Exception;

    void delete(int id) throws Exception;
}
