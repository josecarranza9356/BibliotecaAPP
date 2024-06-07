/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Controller;

import appbibliotecadb.Dao.TipoDocumentoDAO;
import appbibliotecadb.Model.TipoDocumento;
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
public class TipoDocumentoController implements TipoDocumentoDAO {

    private Connection connection;

    public TipoDocumentoController(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<TipoDocumento> readAll() {
        String sql = "SELECT * FROM tipo_documento";
        List<TipoDocumento> estudiantes = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getString("estado")
                );
                estudiantes.add(tipoDocumento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiantes;

    }

    @Override
    public TipoDocumento readById(int id) {
        return null;

    }

}
