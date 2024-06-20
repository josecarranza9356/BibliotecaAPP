/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appbibliotecadb.Model;

/**
 *
 * @author JoseCv1495
 */
public class Usuario {

    private int id;
    private int id_persona;
    private int id_rol;
    private String nombre_completo;
    private String t_documento;
    private String telefono;
    private String rol_nombre;
    private String usuario;
    private String contraseña;
    private String estado;

    public Usuario() {

    }

    public Usuario(int id, String nombre_completo, String t_documento, String telefono, String rol_nombre, String usuario, String contraseña, String estado) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.t_documento = t_documento;
        this.telefono = telefono;
        this.rol_nombre = rol_nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Usuario(int id, int id_persona, int id_rol, String usuario, String contraseña, String estado) {
        this.id = id;
        this.id_persona = id_persona;
        this.id_rol = id_rol;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getT_documento() {
        return t_documento;
    }

    public void setT_documento(String t_documento) {
        this.t_documento = t_documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
