package br.com.murilobeltrame.vehicleapi.configurations;

import br.com.murilobeltrame.vehicleapi.controllers.VehiclesController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register(VehiclesController.class);
    }
}