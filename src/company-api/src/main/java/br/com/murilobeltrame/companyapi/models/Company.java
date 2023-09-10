package br.com.murilobeltrame.companyapi.models;

public class Company {
    private final String doc;
    private final String name;

    public Company(String doc, String name) {
        this.doc = doc;
        this.name = name;
    }

    public String getDoc() {
        return doc;
    }

    public String getName() {
        return name;
    }
}
