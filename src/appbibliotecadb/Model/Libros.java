/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

import java.util.Date;

/**
 *
 * @author JoseCv14
 */
public class Libros {

    private static int ultimoId = 0; // Campo para almacenar el último ID utilizado
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private String materia;
    private Integer cantidad;

    
    private Date aPublicacion;

    private String descripcion;

    public Libros() {
        // Incrementar el ID automáticamente cada vez que se crea un nuevo libro
        ultimoId++;
        id = ultimoId;
    }

    public Libros(int id, String titulo, String autor, String editorial, String materia, Integer cantidad, Date aPublicacion, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.materia = materia;
        this.cantidad = cantidad;
        this.aPublicacion = aPublicacion;
        this.descripcion = descripcion;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getaPublicacion() {
        return aPublicacion;
    }

    public void setaPublicacion(Date aPublicacion) {
        this.aPublicacion = aPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
