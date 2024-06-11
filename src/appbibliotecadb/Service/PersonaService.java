/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.PersonaDAO;
import appbibliotecadb.Model.Persona;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class PersonaService {

    private PersonaDAO personaDAO;

    public PersonaService(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void create(Persona persona) {
        personaDAO.create(persona);
    }

    public List<Persona> readAll() {
        return personaDAO.readAll();
    }

    public Persona readById(int id) {
        return personaDAO.readById(id);
    }

    public void update(Persona persona) {
        personaDAO.update(persona);
    }

    public void delete(int id) {
        personaDAO.delete(id);
    }

}
