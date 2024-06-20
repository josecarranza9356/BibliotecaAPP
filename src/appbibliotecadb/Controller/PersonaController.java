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
                        resultSet.getString("documento"), resultSet.getString("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("estado")
                );
                personas.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;
    }

}
