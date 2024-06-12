package model;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameStore {
    public List<Game> searchByName(String name) {
        List<Game> foundItems = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gameList WHERE name LIKE ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                foundItems.add(new Game(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getInt("stock"), 
                    rs.getInt("price"),
                    rs.getString("category").split(","), 
                    rs.getString("platform"), 
                    rs.getString("gambar"), 
                    rs.getString("description") 
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundItems;
    }

    public List<Game> searchByPrice(int price) {
        List<Game> foundItems = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gameList WHERE price <= ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, price);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                foundItems.add(new Game(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getInt("stock"), 
                    rs.getInt("price"),
                    rs.getString("category").split(","), 
                    rs.getString("platform"), 
                    rs.getString("gambar"), 
                    rs.getString("description")  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundItems;
    }

    public List<Game> searchByCategory(String category) {
        List<Game> foundItems = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gameList WHERE FIND_IN_SET(?, category)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                foundItems.add(new Game(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getInt("stock"), 
                    rs.getInt("price"),
                    rs.getString("category").split(","), 
                    rs.getString("platform"), 
                    rs.getString("gambar"), 
                    rs.getString("description")  
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundItems;
    }

    public Game getGameById(int id) {
        Game game = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gameList WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                game = new Game(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getInt("stock"), 
                    rs.getInt("price"),
                    rs.getString("category").split(","), 
                    rs.getString("platform"), 
                    rs.getString("gambar"), 
                    rs.getString("description")  
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM gameList";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Game game = new Game(
                    rs.getInt("id"), 
                    rs.getString("name"), 
                    rs.getInt("stock"), 
                    rs.getInt("price"),
                    rs.getString("category").split(","), 
                    rs.getString("platform"), 
                    rs.getString("gambar"), 
                    rs.getString("description")
                );
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
