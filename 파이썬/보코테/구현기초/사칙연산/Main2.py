def sum(A,B):
    return A+B
def sub(A,B):
    return A-B
def mul(A,B):
    return A*B
def div(A,B):
    return int(A/B)
def sur(A,B):
    return A%B

A,B=map(int,input().split())

print(sum(A,B))
print(sub(A,B))
print(mul(A,B))
print(div(A,B))
print(sur(A,B))