/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JoseCv14
 */
public class Prestamos {

    private int id;
    private int id_estudiante;
    private String estudiante;
    private int id_usuario;
    private String usuario;
    private String fecha_prestamo;
    private Date fecha_devolucion;
    private String observaciones;
    private int total_libros;
    private String estado;    
    private List<DetallePrestamo> detalles;

    public Prestamos() {
    }

    public Prestamos(int id, int id_estudiante, String estudiante, int id_usuario, String  fecha_prestamo, Date  fecha_devolucion, String observaciones, int total_libros, String usuario, String estado) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.estudiante = estudiante;
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.observaciones = observaciones;
        this.total_libros = total_libros;
        this.estado = estado;
    }

    public Prestamos(int id_estudiante, int id_usuario,  String  fecha_prestamo, Date  fecha_devolucion, String observaciones, int total_libros, String estado,List<DetallePrestamo> detalles) {
        this.id_estudiante = id_estudiante;
        this.id_usuario = id_usuario;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.observaciones = observaciones;
        this.total_libros = total_libros;
        this.estado = estado;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getTotal_libros() {
        return total_libros;
    }

    public void setTotal_libros(int total_libros) {
        this.total_libros = total_libros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetallePrestamo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePrestamo> detalles) {
        this.detalles = detalles;
    }

    
    
}
