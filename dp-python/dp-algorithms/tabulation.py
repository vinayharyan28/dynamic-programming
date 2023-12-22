def fib_tabulation(number):
    dp_table = [0] * (number+1)
    dp_table[0], dp_table[1] = 0, 1
    for i in range(2, number+1):
        dp_table[i] = dp_table[i-1] + dp_table[i-2]

    return dp_table[number]


if __name__ == '__main__':
    print(fib_tabulation(6))
