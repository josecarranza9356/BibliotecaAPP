/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package appbibliotecadb.Dao;

import appbibliotecadb.Model.TipoDocumento;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public interface TipoDocumentoDAO {

    List<TipoDocumento> readAll();

    TipoDocumento readById(int id);
}
