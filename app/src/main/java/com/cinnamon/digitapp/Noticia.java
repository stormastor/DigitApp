package com.cinnamon.digitapp;

/**
 * Created by Christian on 9/6/2016.
 */
public class Noticia {

    private String titular;
    private String descripcion;
    private Integer imagenID;
    private Integer tiempo;
    private Integer imagenCategorias;


    public Noticia(String titular,String descripcion,Integer imagenID,Integer tiempo,Integer imagenCategorias){
        this.titular=titular;
        this.descripcion=descripcion;
        this.imagenID=imagenID;
        this.tiempo=tiempo;
        this.imagenCategorias=imagenCategorias;
    }

    public String getTitular() {
        return titular;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getImagenID() {
        return imagenID;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public Integer getImagenCategorias() {
        return imagenCategorias;
    }
}
