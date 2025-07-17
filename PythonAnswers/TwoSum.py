# Leetcode Problem 1

# copies the exact logic of my java answer
def twoSumOriginal(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    sum_map = {}
    for i in range(len(nums)):
        if nums[i] in sum_map:
            return [sum_map[nums[i]], i]
        else:
            sum_map[target - nums[i]] = i
        
    return []

def twoSumNew(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    sum_map = {} # number -> index
    for i, num in enumerate(nums):
        if num in sum_map:
            return [sum_map[num], i]

        sum_map[target - nums[i]] = i
        
    return []

# testing
if __name__ == "__main__":
    nums = [[2, 7, 11, 15], [3,2,4], [1,2,3,4,5], [4,5,6,7]]
    targets = [9, 6, 4, 9]
    
    for i in range(len(targets)):
        print("\ntest #" + str(i + 1) + ", nums: " + str(nums[i]) + ", target:", targets[i])
        print("answer:", twoSumNew(nums[i], targets[i]))
    