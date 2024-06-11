/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.CarreraUniDAO;
import appbibliotecadb.Model.CarreraUni;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conection.DatabaseConnection;

/**
 *
 * @author JoseCv14
 */
public class CarreraUniController implements CarreraUniDAO {

    private Connection connection;

    public CarreraUniController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<CarreraUni> readAll() {

        String sql = "SELECT * FROM carrera";
        List<CarreraUni> carreras = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CarreraUni carreraUni = new CarreraUni(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("estado")
                );
                carreras.add(carreraUni);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carreras;

    }

    @Override
    public CarreraUni readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
