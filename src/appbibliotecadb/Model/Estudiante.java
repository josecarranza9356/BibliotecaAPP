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
    private int id_persona;
    private String codigo;
    private String nombre_completo;
    private String telefono;
    private String direccion;
    private String Nivel_Ciclo;
    private String Grado_Edad;
    private String seccion;
    private String Turno;
    private String estado;

    public Estudiante() {
    }

    public Estudiante(int id, String codigo, String nombre_completo, String telefono, String direccion, String Nivel_Ciclo, String Grado_Edad, String seccion, String Turno, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre_completo = nombre_completo;        
        this.telefono = telefono;
        this.direccion = direccion;
        this.Nivel_Ciclo = Nivel_Ciclo;
        this.Grado_Edad = Grado_Edad;
        this.seccion = seccion;
        this.Turno = Turno;
        this.estado = estado;
    }

    

    public Estudiante(int id, int id_persona, String codigo, String Nivel_Ciclo, String Grado_Edad, String seccion, String Turno, String estado) {
        this.id = id;
        this.id_persona = id_persona;
        this.codigo = codigo;
        this.Nivel_Ciclo = Nivel_Ciclo;
        this.Grado_Edad = Grado_Edad;
        this.seccion = seccion;
        this.Turno = Turno;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getNivel_Ciclo() {
        return Nivel_Ciclo;
    }

    public void setNivel_Ciclo(String Nivel_Ciclo) {
        this.Nivel_Ciclo = Nivel_Ciclo;
    }

    public String getGrado_Edad() {
        return Grado_Edad;
    }

    public void setGrado_Edad(String Grado_Edad) {
        this.Grado_Edad = Grado_Edad;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

}
