N = int(input())
arr = list(map(int,input().split()))
M = int(input())
targets = list(map(int,input().split()))

def binarySearch(arr,target,left,right):
    while left<=right:
        mid = (left+right)//2
        if arr[mid]<target:
            left = mid + 1
        elif arr[mid]>target:
            right = mid - 1
        else:
            return 'yes'
    return 'no'

arr.sort()
ans = []
for target in targets:
    ans.append(binarySearch(arr,target,0,N-1))
print(*ans)

'''
5
8 3 7 9 2
3
5 7 9


'''