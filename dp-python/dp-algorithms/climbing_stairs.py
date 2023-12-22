def climbing_stairs(stair):
    if stair == 0:
        return 1

    if stair < 0:
        return 0

    return climbing_stairs(stair - 1) + climbing_stairs(stair - 2)


def climbing_stairs_memoization(stair, dp_array):
    if stair == 0:
        return 1

    if stair < 0:
        return 0

    if dp_array[stair] != 0:
        return stair

    dp_array[stair] = climbing_stairs_memoization(stair-1, dp_array) + climbing_stairs_memoization(stair-2, dp_array)

    return dp_array[stair]


def climbing_stairs_tabulation(stair):
    dp_array = [0] * (stair + 1)
    dp_array[0], dp_array[1] = 1, 1
    for i in range(2, stair+1):
        dp_array[i] = dp_array[i-1] + dp_array[i-2]
    return dp_array[stair]


if __name__ == '__main__':
    print(climbing_stairs(5))
    print(climbing_stairs_memoization(5, [0]*6))
    print(climbing_stairs_tabulation(5))
