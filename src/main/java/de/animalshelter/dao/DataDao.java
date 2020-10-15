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
                "SELECT * FROM ANIMAL WHERE lost = 'true' OR found = 'true'",
                (rs, rowNum) -> new Animal(rs.getInt("aid"), rs.getString("name"), rs.getInt("age"), rs.getBlob("image"), rs.getBoolean("lost"), rs.getBoolean("found")));
    }

    public void insertAnimal(Animal animal) {
        boolean lost = false;
        boolean found = false;
        switch (animal.getStatus()) {
            case "lost":
                lost = true;
                break;
            case "found":
                found = true;
                break;
        }
        this.jdbcTemplate.update("INSERT INTO animal (aid,age,found, image, lost, name) VALUES (1,"
                + animal.getAge() + ","
                + found + ","
                + "file_read('"
                + animal.getDisplayImage().getAbsolutePath() + "'),"
                + lost + ",'"
                + animal.getName() + "')");
    }


}
