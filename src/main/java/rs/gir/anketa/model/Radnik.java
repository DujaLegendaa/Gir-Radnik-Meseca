package rs.gir.anketa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Radnik {

    private final UUID id;
    private final String ime;

    public String getSlika() {
        return slika;
    }

    private final String slika;

    public Radnik(@JsonProperty("id") UUID id, @JsonProperty("ime") String ime, @JsonProperty("slika") String slika) {
        this.id = id;
        this.ime = ime;
        this.slika = slika;
    }

    public UUID getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }
}
