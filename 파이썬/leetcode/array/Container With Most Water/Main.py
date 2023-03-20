class Solution(object):
    def maxArea(self, height):
        left = 0
        right = len(height) - 1

        ans = -1

        while left < right:
            w = right - left

            heightL = height[left]
            heightR = height[right]
            h = min(heightL, heightR)

            ans = max(ans, h * w)
            if heightL <= heightR:
                left += 1
            else:
                right -= 1

        return ans