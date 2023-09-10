package br.com.murilobeltrame.companyapi.controllers;

import br.com.murilobeltrame.companyapi.models.CompanyCreateRequest;
import br.com.murilobeltrame.companyapi.models.CompanyResponse;
import br.com.murilobeltrame.companyapi.models.CompanyUpdateRequest;
import br.com.murilobeltrame.companyapi.utils.ResourceUri;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/companies")
public class CompaniesController {
    private ResponseEntity<CompanyResponse> badRequest() {
        return ResponseEntity.badRequest().build();
    }

    private ResponseEntity<CompanyResponse> notFound() {
        return ResponseEntity.notFound().build();
    }

    private boolean cantFind(String doc) {
        return doc.isEmpty() ||
                Objects.equals(doc, "111222334");
    }

    private boolean missingRequiredData(CompanyCreateRequest request) {
        return request.getDoc().isEmpty() ||
                request.getName().isEmpty();
    }

    private boolean missingRequiredData(CompanyUpdateRequest request) {
        return request.getName().isEmpty();
    }

    @GetMapping("/")
    public List<CompanyResponse> fetch() {
        return Arrays.asList(
                new CompanyResponse("111222333", "The Company"),
                new CompanyResponse("333222111", "Another Company")
        );
    }

    @PostMapping("/")
    public ResponseEntity<CompanyResponse> create(@RequestBody CompanyCreateRequest request) {
        if (missingRequiredData(request)) return badRequest();
        CompanyResponse response = CompanyResponse.from(request);
        return ResponseEntity
                .created(ResourceUri.getLocationURI(response))
                .body(response);
    }

    @GetMapping("/{doc}")
    public ResponseEntity<CompanyResponse> get (@PathParam("doc") String doc) {
        if (cantFind(doc)) return notFound();
        return ResponseEntity.ok(new CompanyResponse(doc, "The Asked Company"));
    }

    @PutMapping("/{doc}")
    public ResponseEntity<?> update(@PathParam("doc") String doc, @RequestBody CompanyUpdateRequest request) {
        if (cantFind(doc)) return notFound();
        if (missingRequiredData(request)) return badRequest();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{doc}")
    public ResponseEntity<?> delete(@PathParam("doc") String doc) {
        if (cantFind(doc)) return notFound();
        return ResponseEntity.noContent().build();
    }
}
