/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.CarreraUniDAO;
import appbibliotecadb.Model.CarreraUni;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class CarreraUniService {

    private CarreraUniDAO carreraUniDAO;

    public CarreraUniService(CarreraUniDAO carreraUniDAO) {
        this.carreraUniDAO = carreraUniDAO;
    }

    public List<CarreraUni> readAll() {
        return carreraUniDAO.readAll();
    }

    public CarreraUni readById(int id) {
        return carreraUniDAO.readById(id);
    }

}
