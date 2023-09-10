package br.com.murilobeltrame.companyapi.models;

public class CompanyResponse extends Company {
    public CompanyResponse(String doc, String name) {
        super(doc, name);
    }

    public static CompanyResponse from(CompanyCreateRequest request) {
        return new CompanyResponse(request.getDoc(), request.getName());
    }
}
