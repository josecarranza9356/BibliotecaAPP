/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.UsuarioDao;
import appbibliotecadb.Model.Usuario;
import java.util.List;

/**
 *
 * @author JoseCv1495
 */
public class UsuarioService {
    private UsuarioDao usuarioDao;

    public UsuarioService(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void create(Usuario usuario) {
        usuarioDao.create(usuario);
    }

    public List<Usuario> listAll() {
        return usuarioDao.listAll();
    }

    public Usuario readById(int id) {
        return usuarioDao.readById(id);
    }

    public void update(Usuario usuario) {
        usuarioDao.update(usuario);
    }

    public void delete(int id) {
        usuarioDao.delete(id);
    }
    
}
