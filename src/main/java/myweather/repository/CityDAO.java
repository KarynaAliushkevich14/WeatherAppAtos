package myweather.repository;

import myweather.model.CityWithSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    public class CityDAO {

        private static JdbcTemplate jdbcTemplate;

        @Autowired
        public CityDAO(JdbcTemplate jdbcTemplate){
            this.jdbcTemplate=jdbcTemplate;
        }

        public List<CityWithSelection> index(){
            return jdbcTemplate.query("SELECT * FROM city", new BeanPropertyRowMapper<>(CityWithSelection.class));
        }

        public CityWithSelection findById(int id) {
            return jdbcTemplate.query("SELECT * FROM city WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(CityWithSelection.class))
                    .stream().findAny().orElse(null);
        }

        public CityWithSelection findByLat(String lat) {
            return jdbcTemplate.query("SELECT * FROM city WHERE lat=?", new Object[]{lat}, new BeanPropertyRowMapper<>(CityWithSelection.class))
                    .stream().findAny().orElse(null);
        }

        public CityWithSelection findNameIgnoreCase(String name) {
            return jdbcTemplate.query("SELECT * FROM city WHERE name=?", new Object[]{name}, new BeanPropertyRowMapper<>(CityWithSelection.class))
                    .stream().findAny().orElse(null);
        }

    }


