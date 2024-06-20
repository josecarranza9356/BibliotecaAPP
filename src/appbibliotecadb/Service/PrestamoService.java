/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.PrestamoDAO;
import appbibliotecadb.Model.Prestamos;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class PrestamoService {

    private PrestamoDAO prestamoDAO;

    public PrestamoService(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public void createPrestamo(Prestamos prestamo) {
        prestamoDAO.createPrestamo(prestamo);
    }

    public List<Prestamos> readAll() {
        return prestamoDAO.readAll();
    }

    public Prestamos readById(int id) {
        return prestamoDAO.readById(id);
    }

    public void update(Prestamos prestamo) {
        prestamoDAO.update(prestamo);
    }

    public void delete(int id) {
        prestamoDAO.delete(id);
    }
}
