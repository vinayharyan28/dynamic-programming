def fibonacci(number):
    if number == 0 or number == 1:
        return number
    return fibonacci(number - 1) + fibonacci(number - 2)


def dp_fibonacci(number, array_stored):
    if number == 0 or number == 1:
        return number

    if array_stored[number] != 0:
        return array_stored[number]

    array_stored[number] = dp_fibonacci(number - 1, array_stored) + dp_fibonacci(number - 2, array_stored)
    return array_stored[number]


if __name__ == '__main__':
    print(fibonacci(6))
    print(dp_fibonacci(6, [0] * 7))  # memoization
