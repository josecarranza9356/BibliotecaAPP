/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Prestamos;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public interface PrestamoDAO {
    
     boolean createPrestamo(Prestamos prestamo);

    List<Prestamos> readAll();

    Prestamos readById(int id);

    void update(Prestamos prestamo);

    void delete(int id);
}
