package io.kodlama.devs.entities.concretes;

public class Language {
    private int id;
    private String name;

    public Language(String name) throws Exception {
        setName(name);
    }

    public Language() {
        // Default constructor method
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Name is can't be empty");
        }

        this.name = name;
    }
}
