package br.com.murilobeltrame.companyapi.models;

public class CompanyCreateRequest extends CompanyUpdateRequest {
    private final String doc;

    public CompanyCreateRequest(String doc, String name) {
        super(name);
        this.doc = doc;
    }

    public String getDoc() {
        return doc;
    }
}
