import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClimaApi {
    private final String API_KEY;

    public ClimaApi(){
        try {
            API_KEY = Files.readString(Path.of("apikey.txt")).trim();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer la API KEY", e);
        }
    }

    public Clima obtenerClima(String ciudad) {
        try {
            String direccion = "https://api.openweathermap.org/data/2.5/weather?q="
                    + URLEncoder.encode(ciudad, StandardCharsets.UTF_8)
                    + "&appid=" + API_KEY + "&units=metric&lang=es";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            RespuestaClima respuesta = new Gson().fromJson(response.body(), RespuestaClima.class);
            return respuesta.toClima();
        } catch (Exception e) {
            throw new RuntimeException("No se puede obtener los datos de su ciudad: " + ciudad);
        }
    }
}
