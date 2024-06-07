/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.EstudianteDAO;
import appbibliotecadb.Model.Estudiante;
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
public class EstudianteController implements EstudianteDAO {

    private Connection connection;

    public EstudianteController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(Estudiante estudiante) {
        String sql = "INSERT INTO estudiante (id_persona, codigo, nombre, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, estudiante.getId_persona());
            statement.setString(2, estudiante.getCodigo());
            statement.setString(7, String.valueOf(estudiante.getEstado()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Estudiante> readAll() {
        String sql = "SELECT td.nombre AS tipo_documento,p.documento,e.codigo,CONCAT(p.nombre, ' ', p.apellidos) AS nombre_completo,p.telefono,p.direccion, e.estado AS estado\n"
                + "FROM estudiante e JOIN persona p ON e.id_persona = p.id JOIN tipo_documento td ON p.id_tipo_documento = td.id;";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante(
                        resultSet.getString("tipo_documento"),
                        resultSet.getString("documento"),
                        resultSet.getString("codigo"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("estado")
                );
                estudiantes.add(estudiante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }

    @Override
    public Estudiante readById(int id) {
        String sql = "SELECT * FROM persona WHERE id = ?";
        Estudiante estudiante = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                estudiante = new Estudiante(
                        resultSet.getInt("id"),
                        resultSet.getString("codigo"),
                        resultSet.getInt("id_persona"),
                        resultSet.getString("estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiante;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM estudiante WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Estudiante estudiante) {

    }
}
