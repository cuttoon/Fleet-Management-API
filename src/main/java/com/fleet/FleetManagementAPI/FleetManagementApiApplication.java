package com.fleet.FleetManagementAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Agregar la anotación RestController para consultar información, ahora se volvio un constrolador
@SpringBootApplication
public class FleetManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetManagementApiApplication.class, args);
	}

    // crear metodo, retornando una lista con información
    /* @GetMapping(path = "/")
    public List<String> getTaxis(){
        return List.of(
                "Karen",
                "Huamán"
                );
    } */
}
