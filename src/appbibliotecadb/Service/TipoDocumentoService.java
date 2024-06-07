/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Service;

import appbibliotecadb.Dao.TipoDocumentoDAO;
import appbibliotecadb.Model.TipoDocumento;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class TipoDocumentoService {

    private TipoDocumentoDAO tipoDocumentoDAO;

    public TipoDocumentoService(TipoDocumentoDAO tipoDocumentoDAO) {
        this.tipoDocumentoDAO = tipoDocumentoDAO;
    }

    public List<TipoDocumento> readAll() {
        return tipoDocumentoDAO.readAll();
    }

    public TipoDocumento readById(int id) {
        return tipoDocumentoDAO.readById(id);
    }
}
