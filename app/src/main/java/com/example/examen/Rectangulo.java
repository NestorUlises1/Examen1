package com.example.examen;

import java.io.Serializable;

public class Rectangulo implements Serializable {
    private double base;
    private double altura;

    public Rectangulo(){

    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double calcularArea(){
        return this.altura*this.base;
    }
    public double calcularPerimetro(){
        return (this.base*2)+(this.altura)*2;
    }
}
