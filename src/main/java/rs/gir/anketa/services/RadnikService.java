package rs.gir.anketa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.gir.anketa.dao.RadnikDao;
import rs.gir.anketa.model.Radnik;
@Service
public class RadnikService {

    private final RadnikDao radnikDAO;
    @Autowired
    public RadnikService(RadnikDao radnikDAO) {
        this.radnikDAO = radnikDAO;
    }

    public int addRadnik(Radnik radnik){

        return radnikDAO.insertRadnika(radnik);
}

}
