//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    
		    Solution obj = new Solution();
		    long res = obj.sumXOR(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution {
   
    // Function for finding maximum and value pair
    public long sumXOR(int arr[], int n) {
        // Initialize an array to store the frequency of each bit position
        int[] bitCount = new int[32]; // Assuming integers are 32 bits

        // Count the number of elements with a particular bit set at each position
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if ((arr[i] & (1 << j)) != 0) {
                    bitCount[j]++;
                }
            }
        }

        // Calculate the XOR sum using the formula
        long xorSum = 0;
        for (int i = 0; i < 32; i++) {
            xorSum += (1L << i) * bitCount[i] * (n - bitCount[i]);
        }

        return xorSum;
    }
}



