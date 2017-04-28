/**
 * 
 */
package com.stackbuilders.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.stackbuilders.predictor.entity.Horario;
import com.stackbuilders.predictor.entity.PicoPlaca;
import com.stackbuilders.predictor.entity.Predictor;
import com.stackbuilders.predictor.enums.DiaEnum;

/**
 * @author cfcg070314
 *
 */
public class PredictorApp {

	public void verificarPicoPlaca(Predictor predictor) {

		System.out.println("\nDATOS: " + predictor.toString());
		System.out.println("Dia de la fecha ingresada = "
				+ predictor.getFechaHora().getDisplayName(Calendar.DAY_OF_WEEK, 2, new Locale("es")) + "("
				+ predictor.getFechaHora().get(Calendar.DAY_OF_WEEK) + ")");
		System.out.println("Hora ingresada = " + predictor.getFechaHora().get(Calendar.HOUR_OF_DAY) + ":"
				+ predictor.getFechaHora().get(Calendar.MINUTE));

		System.out.println("\nPara la Placa Nro. " + predictor.getPlaca() + " el Ultimo digito es: "
				+ predictor.ultimoDigitoPlaca());
		PicoPlaca picoPlacaValidacion = validarPicoPlaca(predictor);
		System.out.println("\nRESULTADO==>> " + predictor.mostrarResultadoFinal());
		if (picoPlacaValidacion != null) {
			System.out.println("\nHORARIO " + picoPlacaValidacion.toString());
		}

	}

	private PicoPlaca validarPicoPlaca(Predictor predictor) {
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

	private static List<PicoPlaca> configuracionHorariosPicoPlaca() {
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

	/**
	 * 
	 */
	public PredictorApp() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String placa;
		String fecha;
		String hora;

		Scanner sc = new Scanner(System.in);
		System.out.println("VALIDACION DE PICO Y PLACA ");
		System.out.println("**Ingrese los siguientes datos**");
		System.out.println("Numero de Placa (Ejm. PCX-1822): ");
		placa = sc.nextLine();
		System.out.println("Fecha que circula (dd-mm-aaaa Ejm. 27-04-2017): ");
		fecha = sc.nextLine();
		System.out.println("Hora que circula (HH:mm Ejm. 08:00): ");
		hora = sc.nextLine();
		sc.close();

		Predictor predictor = new Predictor();

		predictor.setPlaca(placa);
		predictor.setFecha(fecha);
		predictor.setHora(hora);
		
		PredictorApp app = new PredictorApp();
		app.verificarPicoPlaca(predictor);

	}

}
