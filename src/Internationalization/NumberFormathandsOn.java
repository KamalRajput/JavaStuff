package Internationalization;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormathandsOn {

    public static void main(String args[]){

        /*By Default Locale is US. By default only 3 fraction digits will be visible. To control it we can use setMinimumFractionDigits Method.
        You can also control rounding by Setting it as Ceiling or floor.
        Floor will not round of.
        Ceil will round off according to the last digit.
         */
        Double d=123456789.12344545;
        NumberFormat nf=NumberFormat.getInstance(Locale.US);
        nf.setMaximumFractionDigits(5);
        RoundingMode floor = RoundingMode.CEILING;
        nf.setRoundingMode(floor);
        System.out.println(nf.format(d));
    }
}
