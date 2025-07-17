# Leetcode problem 70
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.my_map = {1:1, 2:2, 3:3}
        return self.recursiveSolution(n)
    
    def recursiveSolution(self, n):
        if n not in self.my_map:
            self.my_map[n] = self.recursiveSolution(n - 1) + self.recursiveSolution(n - 2)

        return self.my_map[n]
    
if __name__ == "__main__":
    solution = Solution()
    
    for i in range(1, 100):
        print("test #" + str(i) + ": " + str(solution.climbStairs(i)))