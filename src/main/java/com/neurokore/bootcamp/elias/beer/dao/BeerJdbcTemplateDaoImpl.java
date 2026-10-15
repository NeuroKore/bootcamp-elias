package com.neurokore.bootcamp.elias.beer.dao;

import com.neurokore.bootcamp.elias.beer.entities.Beer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository("beerDaoJdbcTemplate")
public class BeerJdbcTemplateDaoImpl implements BeerDAO {

    private final JdbcTemplate jdbcTemplate;

    public BeerJdbcTemplateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Beer save(Beer beer) {
        String sql = "INSERT INTO beer (brand, company, type, color, mililiters, abv, flavour, olor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, beer.getBrand());
            statement.setString(2, beer.getCompany());
            statement.setString(3, beer.getType());
            statement.setString(4, beer.getColor());
            statement.setInt(5, beer.getMililiters());
            statement.setFloat(6, beer.getAbv());
            statement.setString(7, beer.getFlavour());
            statement.setString(8, beer.getOlor());
            return statement;
        }, keyHolder);
        beer.setId(keyHolder.getKey().longValue());
        return beer;
    }

    @Override
    public Optional<Beer> findById(Long id) {
        String sql = "SELECT id, brand, company, type, color, mililiters, abv, flavour, olor "
                + "FROM beer WHERE id = ?";
        return jdbcTemplate.query(sql, this::mapRow, id).stream().findFirst();
    }

    @Override
    public List<Beer> findAll() {
        String sql = "SELECT id, brand, company, type, color, mililiters, abv, flavour, olor FROM beer";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    @Override
    public Beer update(Beer beer) {
        String sql = "UPDATE beer SET brand = ?, company = ?, type = ?, color = ?, mililiters = ?, "
                + "abv = ?, flavour = ?, olor = ? WHERE id = ?";
        jdbcTemplate.update(sql, beer.getBrand(), beer.getCompany(), beer.getType(), beer.getColor(),
                beer.getMililiters(), beer.getAbv(), beer.getFlavour(), beer.getOlor(), beer.getId());
        return beer;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM beer WHERE id = ?", id);
    }

    private Beer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Beer beer = new Beer();
        beer.setId(resultSet.getLong("id"));
        beer.setBrand(resultSet.getString("brand"));
        beer.setCompany(resultSet.getString("company"));
        beer.setType(resultSet.getString("type"));
        beer.setColor(resultSet.getString("color"));
        beer.setMililiters(resultSet.getInt("mililiters"));
        beer.setAbv(resultSet.getFloat("abv"));
        beer.setFlavour(resultSet.getString("flavour"));
        beer.setOlor(resultSet.getString("olor"));
        return beer;
    }

}
