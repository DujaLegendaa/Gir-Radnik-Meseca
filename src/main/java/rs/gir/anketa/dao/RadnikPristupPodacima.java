package rs.gir.anketa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rs.gir.anketa.model.Radnik;

import java.sql.ResultSet;
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
                " ime, " +
                " slika) " +
                "VALUES (?, ?,?)";
        return jdbcTemplate.update(
                sql,
                id,
                radnik.getIme(),
                radnik.getSlika());
    }

    @Override
    public int updateRadnika(UUID id, String ime, String slika) {
        String sql = "" +
                "UPDATE radnik " +
                "SET ime = ? , slika = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, ime, slika,  id);
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
                " ime, " +
                " slika " +
                "FROM radnik";

        return jdbcTemplate.query(sql, mapSRadnikFomDb());
    }

    private RowMapper<Radnik> mapSRadnikFomDb() {
        return (resultSet, i) -> {
            String radnikIdStr = resultSet.getString("id");
            UUID radnikId = UUID.fromString(radnikIdStr);

            String ime = resultSet.getString("ime");
            String slika = resultSet.getString("slika");
            return new Radnik(
                    radnikId,
                    ime,
                    slika
            );
        };
    }

    @Override
    public Radnik getRadnik(UUID id) {
        String sql = "" +
                "SELECT " +
                " id, " +
                " ime, " +
                " slika " +
                "FROM radnik WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Radnik(
                        UUID.fromString(rs.getString("id")),
                        rs.getString("ime"),
                        rs.getString("slika")
                ));

    }
}
