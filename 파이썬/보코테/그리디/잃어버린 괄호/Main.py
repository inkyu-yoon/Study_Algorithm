# - 가 나온 뒤, +가 나오면 괄호쳐서 합치면 됨 ( - 가 나오기 전까지)
import sys

st = input().split("-")
ans = 0

for num in st[0].split("+"):
    ans += int(num)

for eq in st[1:]:
    sum = 0
    for num in eq.split("+"):
        sum += int(num)
    ans -= sum

print(ans)
