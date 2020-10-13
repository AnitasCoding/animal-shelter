package de.animalshelter.dao;

import de.animalshelter.model.Animal;
import de.animalshelter.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<News> selectNews() {
        return this.jdbcTemplate.query(
                "SELECT * FROM news ORDER BY date",
                (rs, rowNum) -> new News(
                        rs.getInt("nid")
                        , rs.getString("title"), rs.getString("information"), rs.getDate("date"), rs.getBlob("image")));
    }

    public List<Animal> selectAnimalsOrdered() {
        return this.jdbcTemplate.query(
                "SELECT * FROM animal WHERE lost = 'false' AND found = 'false' ORDER BY age ASC ",
                (rs, rowNum) -> new Animal(rs.getInt("aid"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image")));
    }

    public List<Animal> selectLostFoundAnimals() {
        return this.jdbcTemplate.query(
                "SELECT * FROM animal WHERE lost = 'true' OR found = 'true'",
                (rs, rowNum) -> new Animal(rs.getInt("aid"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getBoolean("lost"), rs.getBoolean("found")));
    }


}
