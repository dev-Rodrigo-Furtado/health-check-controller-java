package com.example.health_check.controller;

import com.example.health_check.factory.HealthCheckResponseFactory;
import com.example.health_check.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {

    @Autowired
    private HealthCheckResponseFactory healthCheckResponseFactory;

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<Response> healthcheck(@RequestParam(value = "format") String format) {
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .body(healthCheckResponseFactory.createHealthCheckResponse(format));
    }

}
