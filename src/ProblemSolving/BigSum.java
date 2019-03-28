package ProblemSolving;

import java.util.Scanner;

public class BigSum {

	public static void main(String[] args) {


		Scanner scn =new Scanner (System.in);
		System.out.println("inputs");
		int n=scn.nextInt();
		Long ar[]=new Long[n];
		System.out.println("Enter the numbers");
		for(int i=0;i<n;i++) {
				ar[i]=scn.nextLong();
		}
		
		long sum=0;
		for(int k=0;k<n;k++) {
			sum+=ar[k];
		}
		System.out.println(sum);
		
	}

}
