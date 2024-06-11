/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.LibroDAO;
import appbibliotecadb.Model.Libros;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class LibroService {
    private LibroDAO libroDao;

    public LibroService(LibroDAO libroDao) {
        this.libroDao = libroDao;
    }

    public void create(Libros libros) {
        libroDao.create(libros);
    }

    public List<Libros> listAll() {
        return libroDao.listAll();
    }

    public Libros readById(int id) {
        return libroDao.readById(id);
    }

    public void update(Libros libros) {
        libroDao.update(libros);
    }

    public void delete(int id) {
        libroDao.delete(id);
    }
}
