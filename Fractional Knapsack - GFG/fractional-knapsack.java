//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/



class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Sort the items based on value per weight in descending order.
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double vpw1 = (double) item1.value / item1.weight;
                double vpw2 = (double) item2.value / item2.weight;
                if (vpw1 > vpw2) {
                    return -1;
                } else if (vpw1 < vpw2) {
                    return 1;
                }
                return 0;
            }
        });

        double totalValue = 0.0;
        int currentWeight = 0;

        for (int i = 0; i < n; i++) {
            if (currentWeight + arr[i].weight <= W) {
                // If the entire item can be added to the knapsack, add it.
                currentWeight += arr[i].weight;
                totalValue += arr[i].value;
            } else {
                // If only a fraction of the item can be added, add the fraction.
                double remainingCapacity = W - currentWeight;
                double fraction = (double) remainingCapacity / arr[i].weight;
                totalValue += fraction * arr[i].value;
                break;
            }
        }

        return totalValue;
    }
}

/*Next Suggested Problem(s):
Pizza Mania
Tricky Subset Problem
Police and Thieves*/
