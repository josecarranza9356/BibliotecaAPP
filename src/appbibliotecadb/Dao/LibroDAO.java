/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Libros;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public interface LibroDAO {

    boolean create(Libros libros);

    List<Libros> listAll();

    Libros readById(int id);

    boolean  update(Libros libros);

    void delete(int id);

}
