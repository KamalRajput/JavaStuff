package ProblemSolving;

import java.util.Scanner;

public class PlusMinus {
	public static void main(String args[]) {
		
		Scanner scn =new Scanner (System.in);
		System.out.println("inputs");
		int n=scn.nextInt();
		int ar[]=new int[n];

		double positive = 0;
        double negative = 0;
        double zero = 0;
		System.out.println("Enter the numbers");
		
		
		for(int i = 0; i<n; i++)
        {
            int value = scn.nextInt();
            positive += value>0 ? 1:0;
            negative += value<0 ? 1:0;
            zero     += value==0 ? 1:0;
        }
		
	
		
		System.out.println(positive/n);
        System.out.println(negative/n);
        System.out.println(zero/n);
		
	}
	
}
