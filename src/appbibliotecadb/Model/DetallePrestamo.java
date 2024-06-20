/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

/**
 *
 * @author JoseCv1495
 */
public class DetallePrestamo {

    private int id;
    private int id_prestamo;
    private int id_libro;
    private String estado;

    public DetallePrestamo() {
    }

    public DetallePrestamo(int id, int id_prestamo, int id_libro, String estado) {
        this.id = id;
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
