class Solution(object):
    def productExceptSelf(self, nums):
        result = 1
        zero = []

        # for문 탐색으로 nums에 0이 존재하는지 확인 & 0을 제외한 모든 원소의 곱 계산
        for i in range(len(nums)):
            num = nums[i]
            if num == 0:
                zero.append(i)
            else:
                result *= num

        # nums 에 zero가 2개 이상인 경우, 모든 값은 0이 된다.
        if len(zero) >= 2:
            return [0] * len(nums)

        # nums에 zero가 1개인 경우, zero인 원소 위치를 제외한 다른 곳은 다 0, zero 위치는 모든 원소의 곱이 됨
        elif len(zero) == 1:
            return [0] * zero[0] + [result] + [0] * (len(nums) - zero[0] - 1)

        ans = []

        # nums 에 0이 하나도 없는 경우, 모든 원소의 곱을 해당 원소로 나누면 됨
        for i in range(len(nums)):
            ans.append(result // nums[i])

        return ans