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
        String sql = "SELECT \n"
                + "    estudiante.id,\n"
                + "    estudiante.codigo,\n"
                + "    CONCAT(persona.nombre, ' ', persona.apellidos) AS nombre_completo,\n"
                + "    persona.telefono,\n"
                + "    persona.direccion,\n"
                + "    estudiante.Nivel_Ciclo,\n"
                + "    estudiante.Grado_Edad,\n"
                + "    estudiante.seccion,\n"
                + "    estudiante.Turno,\n" + "   "
                + "    estudiante.genero,\n"
                + "    estudiante.estado\n"
                + "FROM \n"
                + "    estudiante\n"
                + "JOIN \n"
                + "    persona ON estudiante.id_persona = persona.id ORDER BY estudiante.id DESC;";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante(
                        resultSet.getInt("id"),
                        resultSet.getString("codigo"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("nivel_Ciclo"),
                        resultSet.getString("grado_Edad"),
                        resultSet.getString("seccion"),
                        resultSet.getString("turno"),
                        resultSet.getString("genero"),
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
                        resultSet.getInt("codigo"),
                        resultSet.getString("id_persona"),
                        resultSet.getString("estado"),
                        resultSet.getString("estado"),
                        resultSet.getString("estado"),
                        resultSet.getString("estado"),
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
