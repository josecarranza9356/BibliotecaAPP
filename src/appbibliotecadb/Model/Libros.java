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

    private int id;
    private int id_autor;
    private String titulo;
    private String editorial;
    private String categoria;
    private String nombre_Autor;
    private int cantidad;
    private Date A_publicacion;
    private String estado;

    public Libros() {
    }

    public Libros(int id_autor, String titulo, String editorial, String categoria, int cantidad, Date A_publicacion, String estado) {
        this.id_autor = id_autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.A_publicacion = A_publicacion;
        this.estado = estado;
    }

    public Libros(int id, int id_autor, String titulo, String editorial, String categoria, String nombre_Autor, int cantidad, Date A_publicacion, String estado) {
        this.id = id;
        this.id_autor = id_autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.categoria = categoria;
        this.nombre_Autor = nombre_Autor;
        this.cantidad = cantidad;
        this.A_publicacion = A_publicacion;
        this.estado = estado;
    }

    // constructor para prestamos 
    public Libros(int id, String titulo, String nombre_Autor, int cantidad) {
        this.id = id;
        this.titulo = titulo;
        this.nombre_Autor = nombre_Autor;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre_Autor() {
        return nombre_Autor;
    }

    public void setNombre_Autor(String nombre_Autor) {
        this.nombre_Autor = nombre_Autor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getA_publicacion() {
        return A_publicacion;
    }

    public void setA_publicacion(Date A_publicacion) {
        this.A_publicacion = A_publicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

}
