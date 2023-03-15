N,target = map(int,input().split())
arr = list(map(int,input().split()))

def binarySearch(arr,target,start,end):
    while start<=end:
        mid = (start+end)//2
        if arr[mid]==target:
            return mid
        elif arr[mid]<target:
            start = mid+1
        else:
            end = mid-1
    return '원소가 존재하지 않습니다.'


result = binarySearch(arr,target,0,N-1)
print(result)



'''
10 7
1 3 5 7 9 11 13 15 17 19

4
'''