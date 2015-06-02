package com.mutual.util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.DatePicker;

public class Utilidades {

    public static final URL restToURL(String res) {
	return Utilidades.class.getResource(res);
    }

    @SuppressWarnings("deprecation")
    public static Date datePickerToDate(DatePicker datePicker) {
	Date fechaDate = new Date();
	fechaDate.setYear(datePicker.getValue().getYear() - 1900);
	fechaDate.setMonth(datePicker.getValue().getMonthValue() - 1);
	fechaDate.setDate(datePicker.getValue().getDayOfMonth());
	fechaDate.setHours(23);
	fechaDate.setMinutes(59);
	fechaDate.setSeconds(59);
	return fechaDate;
    }

    @SuppressWarnings("deprecation")
    public static DatePicker dateToDatePicker(Date date) {
	DatePicker datePicker = new DatePicker();

	datePicker.setValue(LocalDateTime.ofInstant(
		Instant.ofEpochMilli((new Date(date.getYear(), date.getMonth(),
			date.getDate())).getTime()), ZoneId.systemDefault())
		.toLocalDate());

	return datePicker;
    }

    @SuppressWarnings("deprecation")
    public static Date sumarRestarDiasFecha(Date fecha, int dias) {

	Calendar calendar = Calendar.getInstance();

	calendar.setTime(fecha); // Configuramos la fecha que se recibe

	calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
						  // restar en caso de días<0
	calendar.getTime().setHours(23);
	calendar.getTime().setMinutes(59);

	return calendar.getTime(); // Devuelve el objeto Date con los nuevos
				   // días añadidos

    }

    @SuppressWarnings("deprecation")
    public static Date blanquearHora(Date date) {
	date.setHours(00);
	date.setMinutes(00);
	date.setSeconds(00);
	return date;
    }

    @SuppressWarnings("deprecation")
    public static Date siguienteDia(Date date) {

	date.setDate(date.getDate() + 1);
	return date;
    }

    public static boolean fechaValida(DatePicker fecha) {
	try {
	    fecha.getValue().toString();
	    return false;
	} catch (Exception e) {
	    return true;
	}
    }

    public static boolean validarEntero(String entero) {
	try {
	    Integer.parseInt(entero);
	    return true;
	} catch (NumberFormatException e) {
	    return false;
	}
    }

    public static boolean validarFlotante(String flotante) {
	try {
	    Float.parseFloat(flotante);
	    return true;
	} catch (NumberFormatException e) {
	    return false;
	}
    }

    public static void abrirLinkWeb(String direccion) {

	File htmlFile = new File(direccion);
	try {
	    Desktop.getDesktop().browse(htmlFile.toURI());
	    // Desktop.getDesktop().open(htmlFile);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static boolean esSimbolo(String text) {
	return (text.equals("!")) || (text.equals("")) || (text.equals("#"))
		|| (text.equals("$")) || (text.equals("%"))
		|| (text.equals("&")) || (text.equals("/"))
		|| (text.equals("(")) || (text.equals(")"))
		|| (text.equals("=")) || (text.equals("?"))
		|| (text.equals("¡")) || (text.equals("¨"))
		|| (text.equals("*")) || (text.equals("}"))
		|| (text.equals("{")) || (text.equals("_"))
		|| (text.equals(":")) || (text.equals(";"))
		|| (text.equals("'")) || (text.equals("¿"))
		|| (text.equals("´")) || (text.equals("+"))
		|| (text.equals("]")) || (text.equals("["))
		|| (text.equals("|")) || (text.equals("°"))
		|| (text.equals("¬")) || (text.equals(""))
		|| (text.equals("-")) || (text.equals("."))
		|| (text.equals(",")) || (text.equals("$"))
		|| (text.equals("\"") || (text.equals("@")));
    }

    public static boolean esDinero(String text) {
	return (text.equals("!")) || (text.equals("")) || (text.equals("#"))
		|| (text.equals("$")) || (text.equals("%"))
		|| (text.equals("&")) || (text.equals("/"))
		|| (text.equals("(")) || (text.equals(")"))
		|| (text.equals("=")) || (text.equals("?"))
		|| (text.equals("¡")) || (text.equals("¨"))
		|| (text.equals("*")) || (text.equals("}"))
		|| (text.equals("{")) || (text.equals("_"))
		|| (text.equals(":")) || (text.equals(";"))
		|| (text.equals("'")) || (text.equals("¿"))
		|| (text.equals("´")) || (text.equals("+"))
		|| (text.equals("]")) || (text.equals("["))
		|| (text.equals("|")) || (text.equals("°"))
		|| (text.equals("¬")) || (text.equals(""))
		|| (text.equals("-")) || (text.equals(","))
		|| (text.equals("$"))
		|| (text.equals("\"") || (text.equals("@")));
    }

    public static String fechaFormateada(Date date) {
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	return formatter.format(date);
    }
}
