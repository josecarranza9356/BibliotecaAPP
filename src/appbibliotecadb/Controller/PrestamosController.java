/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.PrestamoDAO;
import appbibliotecadb.Model.DetallePrestamo;
import appbibliotecadb.Model.Prestamos;
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
public class PrestamosController implements PrestamoDAO {

    private Connection connection;

    public PrestamosController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean guardarPrestamo(Prestamos prestamo, List<DetallePrestamo> detallesPrestamo) {
        boolean prestamoGuardado = false;
        boolean detallesGuardados = false;

        String sqlPrestamo = "INSERT INTO prestamo (id_estudiante, id_usuario, fecha_prestamo, fecha_devolucion, observaciones, total_libros, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String sqlDetallePrestamo = "INSERT INTO detalle_prestamo (id_prestamo, id_libro, estado) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Insertar en prestamo
            try (PreparedStatement pst = connection.prepareStatement(sqlPrestamo, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1, prestamo.getId_estudiante());
                pst.setInt(2, prestamo.getId_usuario());
                pst.setString(3, prestamo.getFecha_prestamo());
                pst.setDate(4, new java.sql.Date(prestamo.getFecha_devolucion().getTime()));
                pst.setString(5, prestamo.getObservaciones());
                pst.setInt(6, prestamo.getTotal_libros());
                pst.setString(7, String.valueOf(prestamo.getEstado()));
                int affectedRows = pst.executeUpdate();

                if (affectedRows > 0) {
                    // Obtener el ID generado del prestamo
                    try (var rs = pst.getGeneratedKeys()) {
                        if (rs.next()) {
                            int prestamoId = rs.getInt(1);
                            prestamo.setId(prestamoId);
                            System.out.println("ID del prestamo generado: " + prestamoId);

                            // Guardar los detalles del prestamo
                            detallesGuardados = guardarDetallesPrestamo(prestamoId, detallesPrestamo, sqlDetallePrestamo);
                        }
                    }
                    prestamoGuardado = true;
                }
            }

            if (prestamoGuardado && detallesGuardados) {
                connection.commit(); // Confirmar transacción
            } else {
                connection.rollback(); // Revertir transacción en caso de error
            }
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

        return prestamoGuardado && detallesGuardados;
    }

    private boolean guardarDetallesPrestamo(int prestamoId, List<DetallePrestamo> detallesPrestamo, String sqlDetalle) {
        try (PreparedStatement pst = connection.prepareStatement(sqlDetalle)) {
            for (DetallePrestamo detalle : detallesPrestamo) {
                System.out.println("Guardando detalle: id_prestamo=" + prestamoId + ", id_libro=" + detalle.getId_libro() + ", estado=" + detalle.getEstado());
                pst.setInt(1, prestamoId);
                pst.setInt(2, detalle.getId_libro());
                pst.setString(3, String.valueOf(detalle.getEstado()));
                pst.addBatch();
            }
            pst.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Prestamos> readAll() {

        String sql = "SELECT\n"
                + "    p.id,\n"
                + "    p.id_estudiante,\n"
                + "    CONCAT('  DNI - ',per_usuario.documento,'  - ',per_estudiante.nombre, ' ', per_estudiante.apellidos) AS estudiante,\n"
                + "    p.id_usuario,\n"
                + "    CONCAT(per_usuario.nombre, ' ', per_usuario.apellidos) AS usuario,\n"
                + "    p.fecha_prestamo,\n"
                + "    p.fecha_devolucion,\n"
                + "    p.observaciones,\n"
                + "    p.total_libros,\n"
                + "    p.estado\n"
                + "FROM prestamo p\n"
                + "JOIN estudiante e ON p.id_estudiante = e.id\n"
                + "JOIN persona per_estudiante ON e.id_persona = per_estudiante.id\n"
                + "JOIN usuario u ON p.id_usuario = u.id\n"
                + "JOIN persona per_usuario ON u.id_persona = per_usuario.id\n"
                + "WHERE p.estado = 'A' ORDER BY p.id DESC;";
        List<Prestamos> prestamos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Prestamos prestamo = new Prestamos(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_estudiante"),
                        resultSet.getString("estudiante"),
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("fecha_prestamo"),
                        resultSet.getDate("fecha_devolucion"),
                        resultSet.getString("observaciones"),
                        resultSet.getInt("total_libros"),
                        resultSet.getString("usuario"),
                        resultSet.getString("estado")
                );

                prestamos.add(prestamo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;

    }

    @Override
    public Prestamos readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Prestamos prestamo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean createPrestamo(Prestamos prestamo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
