/*
 *  Todos os direitos reservados.
 *    * 
 */
package visitas.hoken.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Elaine Cecília Gatto - Cissa (elainececiliagatto@gmail.com)
 */
public class Utils {

    /**
     * Converte LocalDate para Date
     *
     * @param datePicker
     * @return date
     */
    public static Date toDate(DatePicker datePicker) {
        LocalDate ld = datePicker.getValue();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        return date;
    }

    /**
     * Converte Date para LocalDate
     *
     * @param d
     * @return LocalDate
     */
    public static LocalDate converteLocalDateEmDate(Date d) {
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

    public LocalDate converteLocalDateEmString(String data) {
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formataData);
        return localDate;
    }

    public LocalTime converteLocalTimeEmString1(String hora) {
        DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(hora, formataHora);
        return localTime;
    }

    public LocalTime converteLocalTimeEmString2(String hora) {
        DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:m");
        LocalTime localTime = LocalTime.parse(hora, formataHora);
        return localTime;
    }

    public Date converteDateEmString1(String data) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date d = new java.sql.Date(sdf.parse(data).getTime());
        return d;
    }

    public Time converteTimeEmString(String hora) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("HH:mm");
        java.sql.Time d = new java.sql.Time(sdf.parse(hora).getTime());
        return d;
    }

    public String converteStringEmLocalDate(LocalDate data) {
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String a = data.format(formataData);
        return a;
    }

    public String converteDateString(Date data) {
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String a = data.toString();
        return a;
    }

    public static Date converteStringDate(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    public String converteSemana(int d) {
        String a = "";
        switch (d) {
            case 1:
                a = "Domingo";
                break;
            case 2:
                a = "Segunda-feira";
                break;
            case 3:
                a = "Terça-feira";
                break;
            case 4:
                a = "Quarta-feira";
                break;
            case 5:
                a = "Quinta-feira";
                break;
            case 6:
                a = "Sexta-feira";
                break;
            case 7:
                a = "Sábado";
                break;
        }

        return a;
    }

}
