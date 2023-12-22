package introductiondynamicprogramming;

/*
* 1. Create a 2D DP table with dimensions (n+1)*(w+1), where 'n' is the number of items and 'w' is the maximum capacity of the knapsack. initialize all cell to 0
* 2. Start filling to DP table from the top-left cell and move row by row.
* 3. For each cell DP[i][j], consider two options
*    A. If the weight of the current item (w[i-1)) is greater thant the current knapsack capacity (j), then DP[i][j] is the same as DP[i][j] (exclude the item).
*    B. If the weight of the current item is less than or equal to the current knapsack capacity then calculate the maximum value by choosing either to include the item (v[i-1] + DP[i-1][j-w[i-j]) or exclude the item (DP[i-1][j]).
* 4. The final cell DP[n][w] contains the maximum value achievable, which is the solution to the problem.
*
* Time complexity
* The time complexity of solving the 0/1 Knapsack problem using dynamic programming, as demonstrated in the java code provided, is O(n*w),
* Where 'n' is the number of items and 'w' is the maximum capacity of the knapsack.
*
* */

public class ZeroOneKnapsackTest {
    public static int zeroOneKnapsack(int[] values, int[] weights, int capacity){
        int valuesLength = values.length;
        int[][] dp = new int[valuesLength+1][capacity+1];
        for (int i=0; i<=valuesLength; i++){
            for (int w=0; w <= capacity; w++){
                if (i == 0 || w == 0){
                    dp[i][w] = 0;
                }else if (weights[i-1] <= w){
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w-weights[i-1]]);
                }else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[valuesLength][capacity];
    }

    public static void main(String[] args){
        int[] values = {60, 100, 200}; //{1, 2, 3};
        int[] weights = {10, 20, 30}; //{4, 5, 6};
        int capacity = 50;
        System.out.println(zeroOneKnapsack(values, weights, capacity));
    }

}
