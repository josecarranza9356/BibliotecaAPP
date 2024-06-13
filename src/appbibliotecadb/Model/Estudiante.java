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
    private String nivel_Ciclo;
    private String grado_Edad;
    private String seccion;
    private String turno;
    private String estado;

    //campos de tabla persona no requeridos
    private String nombre_completo;
    private String telefono;
    private String direccion;
    private String genero;

    public Estudiante() {
    }

    public Estudiante(int id, int id_persona, String codigo, String nivel_Ciclo, String grado_Edad, String seccion, String turno, String estado) {
        this.id = id;
        this.id_persona = id_persona;
        this.codigo = codigo;
        this.nivel_Ciclo = nivel_Ciclo;
        this.grado_Edad = grado_Edad;
        this.seccion = seccion;
        this.turno = turno;
        this.estado = "A";
    }

    public Estudiante(int id, String codigo, String nivel_Ciclo, String grado_Edad, String seccion, String turno, String estado, String nombre_completo, String telefono, String direccion, String genero) {
        this.id = id;
        this.codigo = codigo;
        this.nivel_Ciclo = nivel_Ciclo;
        this.grado_Edad = grado_Edad;
        this.seccion = seccion;
        this.turno = turno;
        this.estado = estado;
        this.nombre_completo = nombre_completo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
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

    public String getNivel_Ciclo() {
        return nivel_Ciclo;
    }

    public void setNivel_Ciclo(String nivel_Ciclo) {
        this.nivel_Ciclo = nivel_Ciclo;
    }

    public String getGrado_Edad() {
        return grado_Edad;
    }

    public void setGrado_Edad(String grado_Edad) {
        this.grado_Edad = grado_Edad;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    

}
