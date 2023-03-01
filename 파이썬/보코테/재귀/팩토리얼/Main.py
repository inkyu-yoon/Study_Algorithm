def Factorial(i):
    if i==0:
        return 1
    return i*Factorial(i-1)


N = int(input())

print(Factorial(N))