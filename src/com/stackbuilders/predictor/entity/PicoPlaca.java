/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.predictor.entity;

import java.util.Calendar;

import com.stackbuilders.predictor.enums.DiaEnum;

/**
 *
 * @author CRISTHIAN
 */
public class PicoPlaca {

	private int id;
	private DiaEnum diaEnum;
	private Horario horario;
	private String ultimoDigito;

	public PicoPlaca(int id, DiaEnum diaEnum, Horario horario, String ultimoDigito) {
		this.id = id;
		this.diaEnum = diaEnum;
		this.horario = horario;
		this.ultimoDigito = ultimoDigito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DiaEnum getDiaEnum() {
		return diaEnum;
	}

	public void setDiaEnum(DiaEnum diaEnum) {
		this.diaEnum = diaEnum;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getUltimoDigito() {
		return ultimoDigito;
	}

	public void setUltimoDigito(String ultimoDigito) {
		this.ultimoDigito = ultimoDigito;
	}

	@Override
	public String toString() {
		return "PicoPlaca{dia=" + diaEnum.getNombreDia() + ", horario=" + horario.getDescripcion()
				+ ", Placa terminada en = " + ultimoDigito + '}';
	}

	public PicoPlaca estaEnPicoPlaca(int dia, Calendar hora, String ultimoDigito) {

//		System.out.println("Dia " + this.getDiaEnum().getNumeroDia() + " digito " + this.getUltimoDigito()
//				+ " esta en horario: " + this.getHorario().estaEnHoraPico(this.getHorario(), hora));
		if (dia == this.getDiaEnum().getNumeroDia() && this.getUltimoDigito().equals(ultimoDigito)
				&& this.getHorario().estaEnHoraPico(this.getHorario(), hora)) {
			return this;
		}
		return null;
	}

}
