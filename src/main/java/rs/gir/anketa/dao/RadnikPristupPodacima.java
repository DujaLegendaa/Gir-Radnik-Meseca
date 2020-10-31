package rs.gir.anketa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rs.gir.anketa.model.Radnik;

import java.util.List;
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

    @Override
    public int updateRadnika(UUID id, String ime) {
        String sql = "" +
                "UPDATE radnik " +
                "SET ime = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, ime, id);
    }

    @Override
    public int deleteRadnikaById(UUID id) {
        String sql = "" +
                "DELETE FROM radnik " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Radnik> selectSviRadnici() {
        String sql = "" +
                "SELECT " +
                " id, " +
                " ime " +
                "FROM radnik";

        return jdbcTemplate.query(sql, mapSRadnikFomDb());
    }

    private RowMapper<Radnik> mapSRadnikFomDb() {
        return (resultSet, i) -> {
            String radnikIdStr = resultSet.getString("id");
            UUID radnikId = UUID.fromString(radnikIdStr);

            String ime = resultSet.getString("ime");
            return new Radnik(
                    radnikId,
                    ime
            );
        };
    }
}
