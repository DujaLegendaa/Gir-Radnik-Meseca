package rs.gir.anketa.dao;

import rs.gir.anketa.model.Radnik;

import java.util.UUID;

public interface RadnikDao {

   int  insertRadnika(UUID id, Radnik radnik);


   default int insertRadnika(Radnik radnik){
     UUID id = UUID.randomUUID();
     return insertRadnika(id,radnik);
   }

}
