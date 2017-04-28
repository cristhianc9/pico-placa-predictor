/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.predictor.enums;

import java.util.Calendar;

/**
 *
 * @author CRISTHIAN
 */
public enum DiaEnum {

    LUN(Calendar.MONDAY, "Lunes"), MAR(Calendar.TUESDAY, "Martes"), MIE(Calendar.WEDNESDAY, "Miercoles"), JUE(Calendar.THURSDAY, "Jueves"), VIE(Calendar.FRIDAY, "Viernes");

    private int numeroDia;
    private String nombreDia;

    private DiaEnum() {
    }

    public int getNumeroDia() {
        return numeroDia;
    }

    public void setNumeroDia(int numeroDia) {
        this.numeroDia = numeroDia;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    private DiaEnum(int numeroDia, String nombreDia) {
        this.numeroDia = numeroDia;
        this.nombreDia = nombreDia;
    }

}
