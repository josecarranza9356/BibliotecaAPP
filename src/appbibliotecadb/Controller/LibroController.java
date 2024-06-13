/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.LibroDAO;
import appbibliotecadb.Model.Libros;
import conection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class LibroController implements LibroDAO {

    private Connection connection;

    public LibroController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(Libros libros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Libros> listAll() {
        String sql = "SELECT \n"
                + "    libro.id,\n"
                + "    libro.titulo,\n"
                + "    autor.nombre AS autor,\n"
                + "    libro.editorial,\n"
                + "    libro.categoria,\n"
                + "    libro.cantidad,\n"
                + "    libro.A_publicacion,\n"
                + "    libro.estado\n"
                + "\n"
                + "FROM \n"
                + "    libro\n"
                + "JOIN \n"
                + "    autor ON libro.id_autor = autor.id ORDER BY libro.id DESC;";

        List<Libros> libros = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Libros libro = new Libros(
                        resultSet.getInt("id"),
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getString("editorial"),
                        resultSet.getString("categoria"),
                        resultSet.getInt("cantidad"),
                        resultSet.getDate("A_publicacion"),
                        resultSet.getString("estado")
                );
                libros.add(libro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;

    }

    @Override
    public Libros readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Libros libros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
