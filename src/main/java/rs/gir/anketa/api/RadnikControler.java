package rs.gir.anketa.api;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import rs.gir.anketa.model.Radnik;
    import rs.gir.anketa.services.RadnikService;
    @RequestMapping("api/v1/radnik")
    @RestController
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

}
