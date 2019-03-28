package WarmUpChallenges;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
	  // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	int pair=0;
            Map<Integer,Integer> m=new HashMap<>();
            for(int i=0;i<n;i++){
                if ((m.containsKey(ar[i]) && m.get(ar[i]).equals(new Integer(1)))) {
                	m.put(ar[i], 0);
                	pair+=1;
                	continue;
                }
               m.put(ar[i], 1);
            }

			return pair;
    }
	
	  

	    public static void main(String[] args) throws IOException {
	    	Scanner scanner = new Scanner(System.in);
	    	 System.out.println("enter the length of array");


	        int n = scanner.nextInt();
	        int[] ar = new int[n];
	        for (int i = 0; i < n; i++) {
	            int arItem = scanner.nextInt();
	            ar[i] = arItem;
	        }
	        int result = sockMerchant(n, ar);
	        System.out.println(result);
		        scanner.close();
	    }

}
