package com.example.biography.Modelos;

import java.io.Serializable;

public class Biografia implements Serializable {
    private int idPersonaje;
    private String imagen;
    private String nombre;
    private String titulo;
    private String escritor;
    private String fecha;
    private String biografia;
    private Categoria categorias;

    public Biografia(int idPersonaje, String imagen, String nombre, String titulo, String escritor, String fecha, String biografia, Categoria categorias) {
        this.idPersonaje = idPersonaje;
        this.imagen = imagen;
        this.nombre = nombre;
        this.titulo = titulo;
        this.escritor = escritor;
        this.fecha = fecha;
        this.biografia = biografia;
        this.categorias = categorias;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }
}
