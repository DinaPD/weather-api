package base;


import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Weather {

    public static void main(String args[]){

        String apiKey = "c0f2d34da7msh0b2da59ae3dd7a6p13884cjsn24991aba5094";
        String city = "Kitchener";
        String country = "CA";
        String apiURL = "https://weather-by-api-ninjas.p.rapidapi.com/v1/weather?city=" + city + "&country=" + country;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiURL))
                .header("X-RapidAPI-Host", "weather-by-api-ninjas.p.rapidapi.com")
                .header("X-RapidAPI-Key", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());

    }
}
