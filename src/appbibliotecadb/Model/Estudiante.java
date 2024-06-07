/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

/**
 *
 * @author JoseCv14
 */
public class Estudiante {

    private int id;
    private String codigo;
    private int id_persona;
    private String carrera;
    private String estado;
    private String tipo_documento;
    private String documento;
    private String nombre_completo;
    private String telefono;
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(String tipo_documento, String documento, String codigo, String nombre_completo, String telefono, String direccion, String estado) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.codigo = codigo;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Estudiante(int id, String codigo, int id_persona, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.id_persona = id_persona;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
   
}
