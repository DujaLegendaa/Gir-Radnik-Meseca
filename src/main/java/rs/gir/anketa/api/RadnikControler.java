package rs.gir.anketa.api;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;
    import rs.gir.anketa.model.Radnik;
    import rs.gir.anketa.services.RadnikService;

    import java.util.List;
    import java.util.UUID;

@RequestMapping("api/v1/radnik")
    @RestController
    @CrossOrigin(origins = "http://localhost:3000")
    public class RadnikControler {
    private final RadnikService radnikservice;
    @Autowired
    public RadnikControler(RadnikService radnikservice) {
        this.radnikservice = radnikservice;
    }

    @PostMapping(consumes={"application/json"})
    public void dodajRadnika(@RequestBody Radnik radnik){
    radnikservice.addRadnik(radnik);
}

    @GetMapping
    public List<Radnik> getAllRadnici() {
        return radnikservice.getAllRadnici();
    }

    @GetMapping(path = "{radnikId}")
    public Radnik  getRadnik(@PathVariable("radnikId") UUID id ) {
        return radnikservice.getradnik(id);
    }

    @PutMapping(path = "{radnikId}")
    public void updateRadnik(@PathVariable("radnikId") UUID radnikId,
                              @RequestBody Radnik radnik) {
        radnikservice.updateRadnik(radnikId, radnik);
    }

    @DeleteMapping("{radnikId}")
    public void deleteRadnik(@PathVariable("radnikId") UUID radnikId) {
        radnikservice.deleteRadnici(radnikId);
    }
}
