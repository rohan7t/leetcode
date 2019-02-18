class Solution
    def twoSum(self, nums 'List[int]', target 'int') - 'List[int]'
        result = []
        s = set()
        for i, num in enumerate(nums)
            diff = target - num
            if diff in s
                result.append(nums.index(diff))
                result.append(i)
                break
            else
                s.add(num)
        return result