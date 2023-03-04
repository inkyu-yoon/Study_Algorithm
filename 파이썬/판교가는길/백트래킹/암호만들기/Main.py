import sys
# 서로 다른 L개의 암호를 C개의 문자에서 골라서 사용
# 최소 한개의 모음(a e i o u) 과 두개의 자음 증가하는 순서로 배열
L,C = map(int,input().split())
texts = list(map(str,sys.stdin.readline().split()))
texts.sort()

stack = []
checked = [False]*(C+1)
conditions = ['a','e','i','o','u']

# ['a', 'c', 'i', 's', 't', 'w']
def bt(start):
    if len(stack) == L:
        condition1 = 0
        condition2 = 0
        for s in stack:
            if s in conditions:
                condition1+=1
            else:
                condition2+=1
        if condition1>=1 and condition2>=2:
            print(''.join(stack))
            return
    for i in range(start,C):

        if checked[i] == True:
            continue
        if len(stack)>=1 and stack[-1]>texts[i]:
            continue

        stack.append(texts[i])
        checked[i]=True
        bt(start+1)
        stack.pop()
        checked[i]=False
bt(0)




