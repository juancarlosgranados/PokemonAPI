package com.example.pokemonapi;

public class pokemon {
    private String name;
    private int height;
    private int weigth;
    private String imagen;
    private String dtailsURL;

    public String getDtailsURL() {
        return dtailsURL;
    }

    public void setDtailsURL(String dtailsURL) {
        this.dtailsURL = dtailsURL;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "pokemon{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weigth=" + weigth +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
