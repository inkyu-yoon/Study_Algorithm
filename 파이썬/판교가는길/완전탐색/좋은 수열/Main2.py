N = int(input())

stack = []

def isBad(num):
    size = len(num)
    for i in range(1,size//2+1):
        if num[-i:] == num[-2*i:-i]:
            return True
    return False


def bt():
    if len(stack)==N:
        print(''.join(map(str,stack)))
        exit()
    for i in range(1,4):
        if isBad(''.join(map(str,stack))+str(i)):
            continue
        stack.append(i)
        bt()
        stack.pop()

bt()