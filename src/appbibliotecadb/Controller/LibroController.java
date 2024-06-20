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
    public boolean create(Libros libros) {
        String sql = "INSERT INTO libro (id_autor, titulo, editorial, categoria, cantidad, A_publicacion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, libros.getId_autor());
            statement.setString(2, libros.getTitulo());
            statement.setString(3, libros.getEditorial());
            statement.setString(4, libros.getCategoria());
            statement.setInt(5, libros.getCantidad());
            statement.setDate(6, new java.sql.Date(libros.getA_publicacion().getTime()));
            statement.setString(7, libros.getEstado());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        libros.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Libros> listAll() {
        String sql = "SELECT \n"
                + "    libro.id,\n"
                + "    libro.id_autor,\n"
                + "    libro.titulo,\n"
                + "    libro.editorial,\n"
                + "    libro.categoria,\n"
                + "    autor.nombre AS nombre_autor,\n"
                + "    libro.cantidad,\n"
                + "    libro.A_publicacion,\n"
                + "    libro.estado\n"
                + "FROM \n"
                + "    libro \n"
                + "JOIN \n"
                + "    autor ON libro.id_autor = autor.id WHERE libro.estado='A' ORDER BY libro.id DESC ;";
        List<Libros> libros = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Libros libro = new Libros(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_autor"),
                        resultSet.getString("titulo"),
                        resultSet.getString("editorial"),
                        resultSet.getString("categoria"),
                        resultSet.getString("nombre_autor"),
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
        String sql = "SELECT libro.id,\n"
                + "    libro.id_autor,\n"
                + "    libro.titulo,\n"
                + "    libro.editorial,\n"
                + "    libro.categoria,\n"
                + "    autor.nombre AS nombre_autor,\n"
                + "    libro.cantidad,\n"
                + "    libro.A_publicacion,\n"
                + "    libro.estado\n"
                + "    FROM libro JOIN autor ON libro.id_autor = autor.id WHERE libro.id = ?";
        Libros libro = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    libro = new Libros();
                    libro.setId(rs.getInt("id"));
                    libro.setId_autor(rs.getInt("id_autor"));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setEditorial(rs.getString("editorial"));
                    libro.setCategoria(rs.getString("categoria"));
                    libro.setNombre_Autor(rs.getString("nombre_autor"));
                    libro.setCantidad(rs.getInt("cantidad"));
                    libro.setA_publicacion(rs.getDate("A_publicacion"));
                    libro.setEstado(rs.getString("estado"));
                    System.out.println("Libro encontrado: " + libro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }

    @Override
    public boolean update(Libros libros) {
        String sql = "UPDATE libro SET id_autor = ?, titulo = ?, editorial = ?, categoria = ?, cantidad = ?, A_publicacion = ?, estado = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, libros.getId_autor());
            statement.setString(2, libros.getTitulo());
            statement.setString(3, libros.getEditorial());
            statement.setString(4, libros.getCategoria());
            statement.setInt(5, libros.getCantidad());
            statement.setDate(6, new java.sql.Date(libros.getA_publicacion().getTime()));
            statement.setString(7, libros.getEstado());
            statement.setInt(8, libros.getId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Libro actualizado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int id) {

        String sqlUpdateLibro = "UPDATE libro SET estado = 'I' WHERE id = ?";

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Actualizar estado en libro
            try (PreparedStatement statementLibro = connection.prepareStatement(sqlUpdateLibro)) {
                statementLibro.setInt(1, id);
                statementLibro.executeUpdate();
            }

            connection.commit(); // Confirmar transacción
            System.out.println("Libro marcado como inactivo correctamente.");
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

}
