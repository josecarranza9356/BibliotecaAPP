/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.EstudianteDAO;
import appbibliotecadb.Model.Estudiante;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class EstudianteService {

    private EstudianteDAO estudianteDAO;

    public EstudianteService(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public void create(Estudiante persona) {
        estudianteDAO.create(persona);
    }

    public List<Estudiante> readAll() {
        return estudianteDAO.readAll();
    }

    public Estudiante readById(int id) {
        return estudianteDAO.readById(id);
    }

    public void update(Estudiante estudiante) {
        estudianteDAO.update(estudiante);
    }

    public void delete(int id) {
        estudianteDAO.delete(id);
    }
}
