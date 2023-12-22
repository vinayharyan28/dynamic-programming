package introductiondynamicprogramming;

import java.util.Arrays;

public class ZeroOneKnapsack {
    static int knapsack(int[] value, int[] weight, int totalCapacity, int n){
        if (totalCapacity == 0 || n == 0){
            return 0;
        }

        if (weight[n-1] <= totalCapacity){
            int firstAnswer = value[n-1] + knapsack(value, weight, totalCapacity-weight[n-1], n-1); // Include
            int secondAnswer = knapsack(value, weight, totalCapacity, n-1); //Exclude
            return Math.max(firstAnswer, secondAnswer);
        }else { // Not valid
            return knapsack(value, weight, totalCapacity, n-1);
        }
    }

    static int knapsackMemoization(int[] value, int[] weight, int totalCapacity, int n, int[][] dp){
        if (totalCapacity == 0 || n == 0){
            return 0;
        }

        if(dp[n][totalCapacity] != -1){
            return dp[n][totalCapacity];
        }

        if (weight[n-1] <= totalCapacity){
            int firstAnswer = value[n-1] + knapsackMemoization(value, weight, totalCapacity-weight[n-1], n-1, dp); // Include
            int secondAnswer = knapsackMemoization(value, weight, totalCapacity, n-1, dp); //Exclude
            dp[n][totalCapacity] = Math.max(firstAnswer, secondAnswer);
        }else { // Not valid
            dp[n][totalCapacity] = knapsackMemoization(value, weight, totalCapacity, n-1, dp);
        }
        return dp[n][totalCapacity];
    }

    static int knapsackTabulation(int[] value, int[] weight, int capacity){
        int n = value.length;
        int[][] dp = new int[n+1][capacity+1];

        for (int i=1; i<n+1; i++){
            for(int j=1; j<capacity+1; j++){
                int v = value[i-1];
                int w = weight[i-1];
                if (w <= j){ // Valid
                    int includeProfit = v + dp[i-1][j-w];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else {
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        return dp[n][capacity];

    }

    static boolean targetSubSubset(int[] arr, int sum){ // O(n * sum)
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            dp[i][0] = true;
        }

        for (int i=1; i<n+1; i++){
            for (int j=1; j<sum+1; j++){
                int v = arr[i-1];
                //Include
                if (v <= j && dp[i - 1][j - v]){
                    dp[i][j] = true;
                }

                //Exclude
                else if (dp[i-1][j]) {
                    dp[i][j] = true;
                }

            }
        }

        for (boolean[] i: dp){
            System.out.println(Arrays.toString(i));
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] value = {15, 14, 10, 45, 30};
        int[] weight = {2, 5, 1, 3, 4};
        int totalCapacity = 7;

        int[][] dp = new int[value.length+1][totalCapacity+1];
        for(int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(value, weight, totalCapacity, value.length));
        System.out.println(knapsackMemoization(value, weight, totalCapacity, value.length, dp)); // O(n*totalCapacity)
        System.out.println(knapsackTabulation(value, weight, totalCapacity));

        int[] arr = {4, 2, 7, 1, 3};
        int sum = 10;

        System.out.println(targetSubSubset(arr, sum));


    }
}
