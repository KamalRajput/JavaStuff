package ProblemSolving;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSum {

	public static void main(String[] args) {
		Scanner scn =new Scanner (System.in);
		System.out.println("inputs");
		int n=scn.nextInt();
		int ar[]=new int[n];
		System.out.println("Enter the numbers");
		for(int i=0;i<n;i++) {
				ar[i]=scn.nextInt();
		}
		
	  Arrays.sort(ar);
	  long min=0;
	  long max=0;
	  for(int k=0;k<4;k++) {
		  min+=ar[k];
	  }
	  for(int m=n-1;m>=(n)-4;m--) {
		  
		  max+=ar[m];
	  }
		System.out.println(min+ " " + max);

	}

}
