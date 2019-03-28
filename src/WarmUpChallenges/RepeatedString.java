package WarmUpChallenges;

import java.util.Scanner;

public class RepeatedString {

	public static void main(String args[]) {
		
		Scanner scn=new Scanner(System.in);
		 System.out.println("kamal");
	    String s = scn.nextLine();
        long n = scn.nextLong();
        long result = RepeatedString(s, n);
        
        System.out.println(result);
    }
        

	

	static long RepeatedString(String s, long n) {
		 
        long countForSubstring = 0;
        long totalCount = 0;
       
        //Determines how many a's are in a substring
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'a')
            {
                countForSubstring++;
            }
        }
        //Determines how many complete substrings we will analyze
        long divisor = n / s.length();
        totalCount += divisor * countForSubstring;        
        //Determines how many characters in we will analyze towards the end of our n range
        long remainder = n % s.length();
        
        for(int i = 0; i < remainder; i++)
        {
            if(s.charAt(i) == 'a')
            {
                totalCount++;
            }
        }
		 
		 return totalCount;
	}
	
}
	
