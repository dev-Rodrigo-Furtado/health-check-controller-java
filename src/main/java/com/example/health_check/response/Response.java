package com.example.health_check.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String currentTime;
    private String status;

    public Response(String status) {
        this.status = status;
    }

    public Response(String status, String currentTime) {
        this.status = status;
        this.currentTime = currentTime;
    }

    public static Response shortOkResponse() {
        return new Response("OK");
    }

    public static Response fullOkResponse() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Response response = new Response("OK", ZonedDateTime.now(ZoneId.of("UTC"))
                .toLocalDateTime()
                .format(f));

        return response;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrentTime() {
        return currentTime;
    }
}
