/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Estudiante;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public interface EstudianteDAO {

    boolean createEstudiante(Estudiante estudiante);

    List<Estudiante> readAll();

    Estudiante readById(int id);

    void update(Estudiante estudiante);

    void delete(int id);

}
