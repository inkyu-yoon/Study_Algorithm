
info = input()

text = []
_sum = 0

for i in range(len(info)):
    if info[i].isdigit():
        _sum+=int(info[i])
    else:
        text.append(info[i])
text.sort()
print(''.join(text) + str(_sum))



'''
K1KA5CB7

ABCKK13


AJKDLSI412K4JSJ9D

ADDIJJJKKLSS20
'''