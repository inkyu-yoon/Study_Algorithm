import math
def trans(n,k):
    nums = ''
    while n !=0:
        nums+=(str)(n%k)
        n=n//k
    return nums[::-1]

def isPrime(num):
    if num == 1:
        return False
    for i in range(2,int(math.sqrt(num))+1):
        if num%i==0:
            return False
    return True

def solution(n, k):
    answer = 0
    nums = trans(n,k)
    nums = nums.split('0')
    for num in nums:
        if num != '' and isPrime((int)(num)):
            answer+=1
    return answer