package rs.gir.anketa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Radnik {

    private final UUID id;
    private final String ime;

    public Radnik(@JsonProperty("id") UUID id, @JsonProperty("ime") String ime) {
        this.id = id;
        this.ime = ime;
    }

    public UUID getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }
}
