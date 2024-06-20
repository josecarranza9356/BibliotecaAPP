/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.AutorDAO;
import appbibliotecadb.Model.Autor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conection.DatabaseConnection;
import java.sql.Connection;

/**
 *
 * @author JoseCv1495
 */
public class AutorController implements AutorDAO {

    private Connection connection;

    public AutorController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Autor> listAll() {
        String sql = "SELECT A.id,A.nombre, A.estado from autor as A WHERE A.estado='A' ORDER by A.id DESC ";
        List<Autor> autores = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Autor autor = new Autor(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("estado")
                );
                autores.add(autor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autores;
    }

    @Override
    public Autor readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
