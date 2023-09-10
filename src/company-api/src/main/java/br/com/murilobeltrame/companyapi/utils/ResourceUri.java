package br.com.murilobeltrame.companyapi.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ResourceUri {
    public static URI getLocationURI(Object resourceId) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(resourceId).toUri();
    }

    private ResourceUri () {}
}
