/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Persona;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public interface PersonaDAO {

    void create(Persona persona);

    List<Persona> listAllPersonas();

    Persona readById(int id);

    void update(Persona persona);

    void delete(int id);

}
