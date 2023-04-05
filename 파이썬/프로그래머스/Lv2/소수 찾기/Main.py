import math
from itertools import permutations
def isPrime(num):
    if num ==1 or num ==0:
        return False
    for i in range(2,(int)(math.sqrt(num))+1):
        if num%i==0:
            return False
    return True
def solution(numbers):
    answer = 0
    numbers = list(numbers)
    _set = set()
    for i in range(1,len(numbers)+1):
        c = permutations(numbers,i)
        for case in c:
            target = (int)(''.join(case))
            if isPrime(target) and target not in _set:
                _set.add(target)
    answer = len(_set)
    return answer