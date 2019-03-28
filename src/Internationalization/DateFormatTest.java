package Internationalization;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {


    public static void main(String args[]) {

        Date d=new Date();
        //DateInstance
        DateFormat usDF = DateFormat.getDateInstance(0, Locale.US);
        DateFormat ukDF = DateFormat.getDateInstance(0, Locale.UK);

        System.out.println(usDF.format(d));
        System.out.println(ukDF.format(d));

        //TimeInstance
        DateFormat timeInstance = DateFormat.getTimeInstance();
        System.out.println(timeInstance.format(d));
        //DateTimeInstance
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(0, 0);
        System.out.println(dateTimeInstance.format(d));
    }
}