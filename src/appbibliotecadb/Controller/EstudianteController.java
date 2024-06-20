/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.EstudianteDAO;
import appbibliotecadb.Model.Estudiante;
import appbibliotecadb.Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public boolean documentoExiste(String documento) {
        try {
            String query = "SELECT COUNT(*) FROM persona WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, documento);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean codigoExiste(String codigo) {
        try {
            String query = "SELECT COUNT(*) FROM estudiante WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int createPersona(Persona persona) {
        String sqlPersona = "INSERT INTO persona (documento, nombre, apellidos, genero, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int id_persona = -1;

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Insertar en persona
            try (PreparedStatement statementPersona = connection.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS)) {
                statementPersona.setString(1, persona.getDocumento());
                statementPersona.setString(2, persona.getNombre());
                statementPersona.setString(3, persona.getApellidos());
                statementPersona.setString(4, persona.getGenero());
                statementPersona.setString(5, persona.getTelefono());
                statementPersona.setString(6, persona.getDireccion());
                statementPersona.setString(7, persona.getEstado());

                statementPersona.executeUpdate();

                // Obtener el ID generado de persona
                ResultSet generatedKeys = statementPersona.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id_persona = generatedKeys.getInt(1);
                }
            }

            connection.commit(); // Confirmar transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar el modo de autocommit
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return id_persona;
    }

    @Override
    public boolean createEstudiante(Estudiante estudiante) {
        String sqlEstudiante = "INSERT INTO estudiante (id_persona, codigo, nivel_Ciclo, grado_Edad, seccion, turno, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean isInserted = false;

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            try (PreparedStatement statementEstudiante = connection.prepareStatement(sqlEstudiante)) {
                statementEstudiante.setInt(1, estudiante.getId_persona());
                statementEstudiante.setString(2, estudiante.getCodigo());
                statementEstudiante.setString(3, estudiante.getNivel_Ciclo());
                statementEstudiante.setString(4, estudiante.getGrado_Edad());
                statementEstudiante.setString(5, estudiante.getSeccion());
                statementEstudiante.setString(6, estudiante.getTurno());
                statementEstudiante.setString(7, estudiante.getEstado());

                int rowsInserted = statementEstudiante.executeUpdate();
                isInserted = rowsInserted > 0;
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar el modo de autocommit
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return isInserted;
    }

    @Override
    public List<Estudiante> readAll() {
        String sql = "SELECT \n"
                + "    estudiante.id,\n"
                + "    estudiante.id_persona,\n"
                + "    estudiante.codigo,\n"
                + "    persona.documento,    \n"
                + "    CONCAT(persona.nombre, ' ', persona.apellidos) AS nombre_completo,\n"
                + "    persona.genero,\n"
                + "    persona.telefono,\n"
                + "    persona.direccion,\n"
                + "    estudiante.Nivel_Ciclo,\n"
                + "    estudiante.Grado_Edad,\n"
                + "    estudiante.seccion,\n"
                + "    estudiante.Turno\n"
                + "FROM \n"
                + "    estudiante\n"
                + "JOIN \n"
                + "    persona ON estudiante.id_persona = persona.id\n"
                + "WHERE\n"
                + "    estudiante.estado = 'A'\n"
                + "ORDER BY \n"
                + "    estudiante.id DESC;";
        List<Estudiante> estudiantes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Estudiante estudiante = new Estudiante(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_persona"),
                        resultSet.getString("codigo"),
                        resultSet.getString("documento"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("genero"),
                        resultSet.getString("telefono"),
                        resultSet.getString("direccion"),
                        resultSet.getString("nivel_Ciclo"),
                        resultSet.getString("grado_Edad"),
                        resultSet.getString("seccion"),
                        resultSet.getString("turno")
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
        String sql = "SELECT \n"
                + "    estudiante.id,\n"
                + "    estudiante.id_persona,\n"
                + "    estudiante.codigo,\n"
                + "    persona.documento,    \n"
                + "    CONCAT(persona.nombre, ' ', persona.apellidos) AS nombre_completo,\n"
                + "    persona.genero,\n"
                + "    persona.telefono,\n"
                + "    persona.direccion,\n"
                + "    estudiante.Nivel_Ciclo,\n"
                + "    estudiante.Grado_Edad,\n"
                + "    estudiante.seccion,\n"
                + "    estudiante.Turno\n"
                + "FROM \n"
                + "    estudiante\n"
                + "JOIN \n"
                + "    persona ON estudiante.id_persona = persona.id\n"
                + "WHERE estudiante.id = ?";

        Estudiante estudiante = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    estudiante = new Estudiante(
                            resultSet.getInt("id"),
                            resultSet.getInt("id_persona"),
                            resultSet.getString("codigo"),
                            resultSet.getString("documento"),
                            resultSet.getString("nombre_completo"),
                            resultSet.getString("genero"),
                            resultSet.getString("telefono"),
                            resultSet.getString("direccion"),
                            resultSet.getString("nivel_Ciclo"),
                            resultSet.getString("grado_Edad"),
                            resultSet.getString("seccion"),
                            resultSet.getString("turno")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiante;
    }

    public boolean updatePersona(Persona persona) {
        String sql = "UPDATE persona SET documento = ?, nombre = ?, apellidos = ?, genero = ?, telefono = ?, direccion = ?, estado = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getDocumento());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellidos());
            statement.setString(4, persona.getGenero());
            statement.setString(5, persona.getTelefono());
            statement.setString(6, persona.getDireccion());
            statement.setString(7, persona.getEstado());
            statement.setInt(8, persona.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEstudiante(Estudiante estudiante) {
        String sql = "UPDATE estudiante SET codigo = ?, nivel_Ciclo = ?, grado_Edad = ?, seccion = ?, turno = ?, estado = ? WHERE id_persona = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estudiante.getCodigo());
            statement.setString(2, estudiante.getNivel_Ciclo());
            statement.setString(3, estudiante.getGrado_Edad());
            statement.setString(4, estudiante.getSeccion());
            statement.setString(5, estudiante.getTurno());
            statement.setString(6, estudiante.getEstado());
            statement.setInt(7, estudiante.getId_persona());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void delete(int id) {
        String sqlUpdateEstudiante = "UPDATE estudiante SET estado = 'I' WHERE id = ?";
        String sqlUpdatePersona = "UPDATE persona SET estado = 'I' WHERE id = (SELECT id_persona FROM estudiante WHERE id = ?)";

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Actualizar estado en estudiante
            try (PreparedStatement statementEstudiante = connection.prepareStatement(sqlUpdateEstudiante)) {
                statementEstudiante.setInt(1, id);
                statementEstudiante.executeUpdate();
            }

            // Actualizar estado en persona
            try (PreparedStatement statementPersona = connection.prepareStatement(sqlUpdatePersona)) {
                statementPersona.setInt(1, id);
                statementPersona.executeUpdate();
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar el modo de autocommit
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
