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
    private String titulo;
    private int id_autor;
    private int id_editorial;
    private int id_categoria;
    private String nombre_Autor;
    private String nombre_Editorial;
    private String categoria;
    private int cantidad;
    private Date A_publicacion;
    private String estado;

    
    public Libros(int id, String titulo, int id_autor, int id_editorial, int id_categoria, int cantidad, Date A_publicacion, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.id_autor = id_autor;
        this.id_editorial = id_editorial;
        this.id_categoria = id_categoria;
        this.cantidad = cantidad;
        this.A_publicacion = A_publicacion;
        this.estado = estado;
    }

    public Libros(int id, String titulo, String nombre_Autor, String nombre_Editorial, String categoria, int cantidad, Date A_publicacion, String estado) {
        this.id = id;
        this.titulo = titulo;
        this.nombre_Autor = nombre_Autor;
        this.nombre_Editorial = nombre_Editorial;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.A_publicacion = A_publicacion;
        this.estado = estado;
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

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_Autor() {
        return nombre_Autor;
    }

    public void setNombre_Autor(String nombre_Autor) {
        this.nombre_Autor = nombre_Autor;
    }

    public String getNombre_Editorial() {
        return nombre_Editorial;
    }

    public void setNombre_Editorial(String nombre_Editorial) {
        this.nombre_Editorial = nombre_Editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
