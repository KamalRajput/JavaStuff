package ProblemSolving;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) throws ParseException {
		Scanner scn =new Scanner(System.in);
		String time=scn.nextLine();
		String output=timeConversion(time); 
		System.out.println(output);

	}
	static String timeConversion(String s) throws ParseException {
		
		DateFormat df12=new SimpleDateFormat("hh:mm:ssa",Locale.US);
		DateFormat df24=new SimpleDateFormat("HH:mm:ss",Locale.US);
		
		
		return df24.format(df12.parse(s));
       

    }

}
