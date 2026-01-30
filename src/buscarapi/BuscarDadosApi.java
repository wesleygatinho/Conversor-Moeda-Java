package buscarapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class BuscarDadosApi {

    public DadosApi buscaDadosApi(String moedaBase) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/54d2413a7ea09abb49e3d2bd/latest/" + moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DadosApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter as taxas de câmbio para: " + moedaBase);
        }
    }

}