package rs.gir.anketa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.gir.anketa.model.Radnik;

import java.util.UUID;
@Repository
public class RadnikPristupPodacima implements RadnikDao{
    private final JdbcTemplate jdbcTemplate;
@Autowired
    public RadnikPristupPodacima(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRadnika(UUID id, Radnik radnik) {
        String sql = "" +
                "INSERT INTO radnik (" +
                " id, " +
                " ime) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                id,
                radnik.getIme());
    }


}
