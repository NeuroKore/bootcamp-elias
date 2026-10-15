package com.neurokore.bootcamp.elias.beer.dao;

import com.neurokore.bootcamp.elias.beer.entities.Beer;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("beerDaoJdbc")
public class BeerDAOImpl implements BeerDAO {

    private final DataSource dataSource;

    public BeerDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Beer save(Beer beer) {
        String sql = "INSERT INTO beer (brand, company, type, color, mililiters, abv, flavour, olor) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            bindBeer(statement, beer);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    beer.setId(generatedKeys.getLong(1));
                }
            }
            return beer;
        } catch (SQLException e) {
            throw new BeerPersistenceException("Error al guardar la cerveza", e);
        }
    }

    @Override
    public Optional<Beer> findById(Long id) {
        String sql = "SELECT id, brand, company, type, color, mililiters, abv, flavour, olor "
                + "FROM beer WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new BeerPersistenceException("Error al buscar la cerveza con id " + id, e);
        }
    }

    @Override
    public List<Beer> findAll() {
        String sql = "SELECT id, brand, company, type, color, mililiters, abv, flavour, olor FROM beer";
        List<Beer> beers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                beers.add(mapRow(resultSet));
            }
            return beers;
        } catch (SQLException e) {
            throw new BeerPersistenceException("Error al listar las cervezas", e);
        }
    }

    @Override
    public Beer update(Beer beer) {
        String sql = "UPDATE beer SET brand = ?, company = ?, type = ?, color = ?, mililiters = ?, "
                + "abv = ?, flavour = ?, olor = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            bindBeer(statement, beer);
            statement.setLong(9, beer.getId());
            statement.executeUpdate();
            return beer;
        } catch (SQLException e) {
            throw new BeerPersistenceException("Error al actualizar la cerveza con id " + beer.getId(), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM beer WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new BeerPersistenceException("Error al eliminar la cerveza con id " + id, e);
        }
    }

    private void bindBeer(PreparedStatement statement, Beer beer) throws SQLException {
        statement.setString(1, beer.getBrand());
        statement.setString(2, beer.getCompany());
        statement.setString(3, beer.getType());
        statement.setString(4, beer.getColor());
        statement.setInt(5, beer.getMililiters());
        statement.setFloat(6, beer.getAbv());
        statement.setString(7, beer.getFlavour());
        statement.setString(8, beer.getOlor());
    }

    private Beer mapRow(ResultSet resultSet) throws SQLException {
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
