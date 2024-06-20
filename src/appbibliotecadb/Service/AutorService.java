/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.AutorDAO;
import appbibliotecadb.Model.Autor;
import java.util.List;

/**
 *
 * @author JoseCv1495
 */
public class AutorService {

    private AutorDAO autorDAO;

    public AutorService(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
    }

    public List<Autor> listAll() {
        return autorDAO.listAll();
    }

    public Autor readById(int id) {
        return autorDAO.readById(id);
    }
}
