/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.UsuarioDao;
import appbibliotecadb.Model.Usuario;
import conection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoseCv1495
 */
public class UsuarioController implements UsuarioDao {

    private Connection connection;

    public UsuarioController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listAll() {

        String sql = "SELECT\n"
                + "    u.id,\n"
                + "    r.nombre AS rol_nombre,        \n"
                + "    CONCAT(p.nombre, ' ', p.apellidos) AS nombre_completo,\n"
                + "    CONCAT(td.nombre, ' _ ', p.documento) AS t_documento,    \n"
                + "    p.telefono,\n"
                + "    u.usuario,\n"
                + "    u.contraseña,\n"
                + "    u.estado\n"
                + "FROM\n"
                + "    usuario u\n"
                + "JOIN\n"
                + "    persona p ON u.id_persona = p.id\n"
                + "JOIN\n"
                + "    tipo_documento td ON p.id_tipo_documento = td.id\n"
                + "JOIN\n"
                + "    rol r ON u.id_rol = r.id ORDER BY u.id DESC;";

        List<Usuario> usuarios = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre_completo"),
                        resultSet.getString("t_documento"),
                        resultSet.getString("telefono"),
                        resultSet.getString("rol_nombre"),
                        resultSet.getString("usuario"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("estado")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;

    }

    @Override
    public Usuario readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
