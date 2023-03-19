def solution(s):
    nums = list(map(int, s.split()))
    _max, _min = max(nums), min(nums)

    return (str)(_min) + " " + (str)(_max)