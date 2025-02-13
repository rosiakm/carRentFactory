package exercise.helpers;

import java.time.LocalDate;

public class DateFormatHelper {

    public static String convertLocalDateToString(LocalDate date){
        return String.valueOf(date);
    }

    public static LocalDate convertStringToLocalDate (String date){
        return LocalDate.parse(date);
    }
}
