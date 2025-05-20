package com.dargorvz.clima;

public record Clima(String name,
                    double temp,
                    int humidity,
                    String description) {

    @Override
    public String toString() {
        return """
                Ciudad: %s
                Temperatura: %.1f °C
                Humedad: %d%%
                Clima: %s
                """.formatted(name, temp, humidity, description);
    }
}
