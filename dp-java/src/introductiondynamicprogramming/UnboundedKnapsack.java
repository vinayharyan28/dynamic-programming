package dynamicprogramming;


public class UnboundedKnapsack {
    static int unBoundedKnapsack(int[] value, int[] weight, int totalCapacity){
        int n = value.length;
        int[][] dp = new int[n+1][totalCapacity+1];

        for(int i=1; i<n+1; i++){
            for(int j=1; j<totalCapacity+1; j++){
                if (weight[i-1] <= j){ // Valid
                    int include = value[i-1] + dp[i][j-weight[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][totalCapacity];
    }

    static int coinChange(int[] coins, int sum){
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];

        for (int i=0; i<n+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if (coins[i-1] <= j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];

    }


    public static void main(String[] args) {
        int[] value = {15, 14, 10, 45, 30};
        int[] weight = {2, 5, 1, 3, 4};
        int capacity = 7;
        System.out.println(unBoundedKnapsack(value, weight, capacity));

        int[] coins = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange(coins, sum));
    }
}
