package br.com.murilobeltrame.companyapi.models;

public class CompanyUpdateRequest {
    private final String name;

    public CompanyUpdateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
