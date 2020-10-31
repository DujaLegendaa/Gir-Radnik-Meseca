package rs.gir.anketa.dao;

import rs.gir.anketa.model.Radnik;

import java.util.UUID;
import java.util.List;

public interface RadnikDao {

   int  insertRadnika(UUID id, Radnik radnik);
   int updateRadnika(UUID id, String ime);
   int deleteRadnikaById(UUID id);
   List<Radnik> selectSviRadnici();

   default int insertRadnika(Radnik radnik){
     UUID id = UUID.randomUUID();
     return insertRadnika(id,radnik);
   }

}
