def zero_one_knapsack(value_array, weight_array, total_capacity, index):
    if total_capacity == 0 or index == 0:
        return 0

    if weight_array[index - 1] <= total_capacity:
        first_answer = value_array[index - 1] + zero_one_knapsack(value_array, weight_array,
                                                                  total_capacity - weight_array[index - 1], index - 1)
        second_answer = zero_one_knapsack(value_array, weight_array, total_capacity, index - 1)
        return max(first_answer, second_answer)
    else:
        return zero_one_knapsack(value_array, weight_array, total_capacity, index - 1)


def zero_one_knapsack_memoization(value_array, weight_array, total_capacity, index, dp):
    if total_capacity == 0 or index == 0:
        return 0

    if dp[index][total_capacity] != -1:
        return dp[index][total_capacity]

    if weight_array[index - 1] <= total_capacity:
        first_answer = value_array[index - 1] + zero_one_knapsack_memoization(value_array, weight_array,
                                                                              total_capacity - weight_array[index - 1],
                                                                              index - 1, dp)
        second_answer = zero_one_knapsack_memoization(value_array, weight_array, total_capacity, index - 1, dp)
        dp[index][total_capacity] = max(first_answer, second_answer)
    else:
        dp[index][total_capacity] = zero_one_knapsack_memoization(value_array, weight_array, total_capacity, index - 1,
                                                                  dp)

    return dp[index][total_capacity]


def zero_one_knapsack_tabulation(value_array, weight_array, total_capacity):
    dp_table = [[0 for _ in range(total_capacity + 1)] for _ in range(len(value_array) + 1)]

    for i in range(1, len(value_array) + 1):
        value_ = value_array[i - 1]
        weight_ = weight_array[i - 1]
        for j in range(1, total_capacity + 1):
            if weight_ <= j:
                include = value_ + dp_table[i - 1][j - weight_]
                exclude = dp_table[i - 1][j]
                dp_table[i][j] = max(include, exclude)
            else:
                dp_table[i][j] = dp_table[i - 1][j]

    return dp_table[len(value_array)][total_capacity]


def target_subset(arr, target_sum):
    dp_table = [[False for _ in range(target_sum + 1)] for _ in range(len(arr) + 1)]
    for i in range(len(arr) + 1):
        dp_table[i][0] = True

    for i in range(1, len(arr) + 1):
        for j in range(1, target_sum + 1):
            value_ = arr[i - 1]
            if value_ <= j and dp_table[i - 1][j - value_]:
                dp_table[i][j] = True
            elif dp_table[i - 1][j]:
                dp_table[i][j] = True
    return dp_table[len(arr)][target_sum]


if __name__ == '__main__':
    value, weight, capacity = [15, 14, 10, 45, 30], [2, 5, 1, 3, 4], 7
    print(zero_one_knapsack(value, weight, capacity, len(value)))
    two_dimension_array = [[-1 for i in range(capacity + 1)] for _ in range(len(value) + 1)]
    print(zero_one_knapsack_memoization(value, weight, capacity, len(value), two_dimension_array))
    print(zero_one_knapsack_tabulation(value, weight, capacity))
    print(target_subset([4, 2, 7, 1, 3], 10))  # O(n * sum)
