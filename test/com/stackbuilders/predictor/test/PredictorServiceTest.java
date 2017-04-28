/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackbuilders.predictor.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stackbuilders.predictor.entity.Horario;
import com.stackbuilders.predictor.entity.PicoPlaca;
import com.stackbuilders.predictor.entity.Predictor;
import com.stackbuilders.predictor.enums.DiaEnum;

import junit.framework.TestSuite;

/**
 *
 * @author CRISTHIAN
 */
public class PredictorServiceTest extends TestSuite {

	// DATOS DE INGRESO
	private static String placa;
	private static String fecha;
	private static String hora;

	Predictor predictor;

	public PredictorServiceTest() {
	}

	@BeforeClass
	public static void setUpClass() {

	}

	@AfterClass
	public static void tearDownClass() {

	}

	@Before
	public void setUp() {
		predictor = new Predictor();
		placa = "PCH-1807";
		fecha = "26-04-2017";
		hora = "19:00";
	}

	@After
	public void tearDown() {

	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	public void verificarPicoPlaca() {

		predictor.setPlaca(placa);
		predictor.setFecha(fecha);
		predictor.setHora(hora);
		System.out.println("\nDATOS: " + predictor.toString());
		System.out.println("Dia de la fecha ingresada = "
				+ predictor.getFechaHora().getDisplayName(Calendar.DAY_OF_WEEK, 2, new Locale("es")) + "("
				+ predictor.getFechaHora().get(Calendar.DAY_OF_WEEK) + ")");
		System.out.println("Hora ingresada = " + predictor.getFechaHora().get(Calendar.HOUR_OF_DAY) + ":"
				+ predictor.getFechaHora().get(Calendar.MINUTE));

		System.out.println("\nPara la Placa Nro. " + placa + " el Ultimo digito es: " + predictor.ultimoDigitoPlaca());
		PicoPlaca picoPlacaValidacion = validarPicoPlaca();
		System.out.println("\nRESULTADO==>> " + predictor.mostrarResultadoFinal());
		if (picoPlacaValidacion != null) {
			System.out.println("\nHORARIO " + picoPlacaValidacion.toString());
		}

	}

	private PicoPlaca validarPicoPlaca() {
		PicoPlaca picoPlacaValidacion = null;
		for (PicoPlaca picoPlaca : configuracionHorariosPicoPlaca()) {
			picoPlacaValidacion = picoPlaca.estaEnPicoPlaca(predictor.getDiaSemana(), predictor.getFechaHora(),
					predictor.ultimoDigitoPlaca());
			if (picoPlacaValidacion == null) {
				predictor.setPermitido(Boolean.TRUE);
			} else {
				predictor.setPermitido(Boolean.FALSE);
				break;
			}
		}
		return picoPlacaValidacion;
	}

	public static List<PicoPlaca> configuracionHorariosPicoPlaca() {
		Horario horario = new Horario();
		List<PicoPlaca> listaPicoPlaca = new ArrayList<>();
		listaPicoPlaca.add(new PicoPlaca(1, DiaEnum.LUN, horario.getHorarioDiurno(), "1"));
		listaPicoPlaca.add(new PicoPlaca(2, DiaEnum.LUN, horario.getHorarioNocturno(), "1"));
		listaPicoPlaca.add(new PicoPlaca(3, DiaEnum.LUN, horario.getHorarioDiurno(), "2"));
		listaPicoPlaca.add(new PicoPlaca(4, DiaEnum.LUN, horario.getHorarioNocturno(), "2"));

		listaPicoPlaca.add(new PicoPlaca(5, DiaEnum.MAR, horario.getHorarioDiurno(), "3"));
		listaPicoPlaca.add(new PicoPlaca(6, DiaEnum.MAR, horario.getHorarioNocturno(), "3"));
		listaPicoPlaca.add(new PicoPlaca(7, DiaEnum.MAR, horario.getHorarioDiurno(), "4"));
		listaPicoPlaca.add(new PicoPlaca(8, DiaEnum.MAR, horario.getHorarioNocturno(), "4"));

		listaPicoPlaca.add(new PicoPlaca(9, DiaEnum.MIE, horario.getHorarioDiurno(), "5"));
		listaPicoPlaca.add(new PicoPlaca(10, DiaEnum.MIE, horario.getHorarioNocturno(), "5"));
		listaPicoPlaca.add(new PicoPlaca(11, DiaEnum.MIE, horario.getHorarioDiurno(), "6"));
		listaPicoPlaca.add(new PicoPlaca(12, DiaEnum.MIE, horario.getHorarioNocturno(), "6"));

		listaPicoPlaca.add(new PicoPlaca(13, DiaEnum.JUE, horario.getHorarioDiurno(), "7"));
		listaPicoPlaca.add(new PicoPlaca(14, DiaEnum.JUE, horario.getHorarioNocturno(), "7"));
		listaPicoPlaca.add(new PicoPlaca(15, DiaEnum.JUE, horario.getHorarioDiurno(), "8"));
		listaPicoPlaca.add(new PicoPlaca(16, DiaEnum.JUE, horario.getHorarioNocturno(), "8"));

		listaPicoPlaca.add(new PicoPlaca(17, DiaEnum.VIE, horario.getHorarioDiurno(), "9"));
		listaPicoPlaca.add(new PicoPlaca(18, DiaEnum.VIE, horario.getHorarioNocturno(), "9"));
		listaPicoPlaca.add(new PicoPlaca(19, DiaEnum.VIE, horario.getHorarioDiurno(), "0"));
		listaPicoPlaca.add(new PicoPlaca(20, DiaEnum.VIE, horario.getHorarioNocturno(), "0"));

		return listaPicoPlaca;
	}

}
