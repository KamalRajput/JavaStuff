package Internationalization;/*
 *@project Logic
 *@autho kamal.rajput on 09-03-2019
 */

import java.util.Locale;

public class LocaleTest {

    public static void main(String args[]){
        Locale l = Locale.getDefault();
        System.out.println(l.getCountry() + " : "+l.getLanguage()+ " : "+l.getDisplayCountry()+ ": "+l.getDisplayLanguage());
        Locale.setDefault(Locale.UK);
        System.out.println(Locale.getDefault().getDisplayCountry());

        //same for language
        String[] isoCountries = Locale.getISOCountries();
            for(String ctry:isoCountries){
                System.out.println(ctry);
            }
    }
}
