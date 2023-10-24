def zero_one_knapsack(values, weights, capacity):
    values_length = len(values)
    dp = [[0 for _ in range(capacity + 1)] for _ in range(values_length + 1)]
    for v in range(values_length + 1):
        for w in range(capacity + 1):
            if w == 0 or v == 0:
                dp[v][w] = 0
            elif weights[v - 1] <= w:
                dp[v][w] = max(dp[v - 1][w], values[v - 1] + dp[v - 1][w - weights[v - 1]])
            else:
                dp[v][w] = dp[v-1][w]

    return dp[values_length][capacity]


if __name__ == '__main__':
    print(zero_one_knapsack([1, 2, 3], [4, 5, 1], 4))
