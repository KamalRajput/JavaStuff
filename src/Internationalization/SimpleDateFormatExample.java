package Internationalization;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {

    public static void main(String args[]) throws ParseException {

        //Object to String using Format
        SimpleDateFormat sdf=new SimpleDateFormat("M/dd/yyyy hh:mm:ssa");
        String date = sdf.format(new Date());
        System.out.println(date);

        //String to Object
        System.out.println(sdf.parse(date));

    }
}
