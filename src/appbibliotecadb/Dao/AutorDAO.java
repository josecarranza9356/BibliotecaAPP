/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.Autor;
import java.util.List;

/**
 *
 * @author JoseCv1495
 */
public interface AutorDAO {

    List<Autor> listAll();

    Autor readById(int id);
}
