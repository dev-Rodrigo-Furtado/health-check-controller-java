package com.example.health_check.factory;

import com.example.health_check.response.Response;
import com.example.health_check.exception.ParameterNotMatchException;
import org.springframework.stereotype.Component;

@Component
public class HealthCheckResponseFactory {

    public Response createHealthCheckResponse(String format) {
        if("short".equals(format)) {
            return Response.shortOkResponse();
        } else if ("full".equals(format)) {
            return Response.fullOkResponse();
        } else {
            throw new ParameterNotMatchException();
        }
    }
}
