/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class Prestamos {

    private static int ultimoId = 0; // Campo para almacenar el último ID utilizado
    private int id;
    private int idEstudiante;
    private List<Integer> libros;
    private int cantidad;
    private String fechaPrestamos;
    private Date fechaDevolucion;
    private String Observaciones;

    public Prestamos() {
        // Incrementar el ID automáticamente cada vez que se crea un nuevo libro
        ultimoId++;
        id = ultimoId;
    }

    public Prestamos(int id, int idEstudiante, List<Integer> libros, int cantidad, String fechaPrestamos, Date fechaDevolucion, String Observaciones) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.libros = libros;
        this.cantidad = cantidad;
        this.fechaPrestamos = fechaPrestamos;
        this.fechaDevolucion = fechaDevolucion;
        this.Observaciones = Observaciones;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Prestamos.ultimoId = ultimoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public List<Integer> getLibros() {
        return libros;
    }

    public void setLibros(List<Integer> libros) {
        this.libros = libros;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaPrestamos() {
        return fechaPrestamos;
    }

    public void setFechaPrestamos(String fechaPrestamos) {
        this.fechaPrestamos = fechaPrestamos;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

}
