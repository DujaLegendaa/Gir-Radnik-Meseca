package rs.gir.anketa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import rs.gir.anketa.dao.RadnikDao;
import rs.gir.anketa.model.Radnik;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

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

    public List<Radnik> getAllRadnici() {
        return radnikDAO.selectSviRadnici();
    }

   public  void deleteRadnici(UUID id) {
        radnikDAO.deleteRadnikaById(id);
    }
    public void updateRadnik(UUID radnikId, Radnik radnik) {


        Optional.ofNullable(radnik.getIme())
                .filter(ime -> !StringUtils.isEmpty(ime))
                .map(StringUtils::capitalize)
                .ifPresent(ime -> radnikDAO.updateRadnika(radnikId, ime));

    }


}
