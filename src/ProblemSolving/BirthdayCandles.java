package ProblemSolving;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCandles {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		System.out.println("enter the age");
		int n=scn.nextInt();
		int candles[]=new int[n];
		int countCandles=0;
		System.out.println("Enter the candles of different numbers.");
		for(int i=0;i<n;i++) {
			candles[i]=scn.nextInt();
		}
		
		Arrays.sort(candles);
		int highestNum=candles[n-1];
		
		for(int m=0;m<n;m++) {
			if(candles[m]==highestNum) {
				countCandles+=1;
			}
		}
		System.out.println(countCandles);
	}

}
