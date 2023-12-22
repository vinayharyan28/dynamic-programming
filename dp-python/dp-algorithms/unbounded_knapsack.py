def unbounded_knapsack(value_array, weight_array, total_capacity):
    dp_table = [[0 for _ in range(total_capacity+1)] for _ in range(len(value_array) + 1)]
    for i in range(1, len(value_array)+1):
        for j in range(1, total_capacity+1):
            if weight_array[i-1] <= j:
                dp_table[i][j] = max(
                    value_array[i-1] + dp_table[i][j-weight_array[i-1]],
                    dp_table[i-1][j]
                )
            else:
                dp_table[i][j] = dp_table[i-1][j]

    return dp_table[len(value_array)][total_capacity]


if __name__ == '__main__':
    print(unbounded_knapsack([15, 14, 10, 45, 30], [2, 5, 1, 3, 4], 7))
