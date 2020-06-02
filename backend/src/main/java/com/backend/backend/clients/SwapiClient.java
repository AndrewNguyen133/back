package com.backend.backend.clients;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class SwapiClient {

    @Value("https://swapi.dev/api/")
    private String baseUrl;

    private HttpClient client = HttpClient.newHttpClient();

    public Object getSwapiSync(@NonNull String topic, @NonNull Integer num) {

        try {
            HttpClient client = this.client;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.baseUrl + "people/2/"))
                    .build();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            // set headers
            
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
