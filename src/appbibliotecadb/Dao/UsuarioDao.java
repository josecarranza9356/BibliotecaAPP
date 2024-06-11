/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Usuario;
import java.util.List;

/**
 *
 * @author JoseCv1495
 */
public interface UsuarioDao {

    void create(Usuario usuario);

    List<Usuario> listAll();

    Usuario readById(int id);

    void update(Usuario usuario);

    void delete(int id);
}
