import java.util.List;

public class RespuestaClima {
    private String name;
    private Main main;
    private List<Weather> weather;

    public Clima toClima() {
        return new Clima(name, main.getTemp(), main.getHumidity(), weather.get(0).getDescription());
    }
}
