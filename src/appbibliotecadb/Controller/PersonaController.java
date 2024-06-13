/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.PersonaDAO;
import appbibliotecadb.Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import conection.DatabaseConnection;

/**
 *
 * @author JoseCv14
 */
public class PersonaController implements PersonaDAO {

    private Connection connection;

    public PersonaController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(Persona persona) {
        String sql = "INSERT INTO persona (documento, nombre, apellidos, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {           
            statement.setString(1, persona.getDocumento());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellidos());
            statement.setString(4, persona.getTelefono());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, String.valueOf(persona.getEstado()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> listAllPersonas() {
        String sql = "SELECT\n"
                + "    p.id,\n"
                + "    CONCAT(p.nombre, ' ', p.apellidos) AS nombre_completo,\n"
                + "    p.documento,   \n"
                + "    p.telefono,\n"
                + "    p.estado \n"
                + "FROM persona p ORDER BY  p.id DESC;";
        List<Persona> personas = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Persona persona = new Persona(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("documento"),
                        resultSet.getString("telefono"),
                        resultSet.getString("estado")
                );
                personas.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;
    }

    @Override
    public Persona readById(int id) {
        String sql = "SELECT * FROM persona WHERE id = ?";
        Persona persona = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                persona = new Persona(
                        resultSet.getInt("id"),
                        resultSet.getString("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("estado")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persona;
    }

    @Override
    public void update(Persona persona) {
        String sql = "UPDATE persona SET id_tipo_documento = ?, documento = ?, nombre = ?, apellidos = ?, telefono = ?, direccion = ?, estado = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getDocumento());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellidos());
            statement.setString(4, persona.getTelefono());
            statement.setString(5, persona.getDireccion());
            statement.setString(6, String.valueOf(persona.getEstado()));
            statement.setInt(7, persona.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM persona WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
