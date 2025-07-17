# Leetcode 20
class Solution(object):
    
    # copies logic from my python solution
    def isValidOriginal(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) == 0:
            return True
        
        my_map = {"(": ")", "[": "]", "{": "}"}
        stack = []

        for c in s:
            if c == "(" or c == "[" or c == "{":
                stack.append(c)
            else:
                if c == ")" or c == "]" or c == "}":
                    if len(stack) == 0 or my_map[stack.pop()] != c:
                        return False
        
        return len(stack) == 0
    
    def isValidNew(self, s):
        """
        :type s: str
        :rtype: bool
        """
        my_map = {"(": ")", "[": "]", "{": "}"}
        stack = []

        for c in s:
            if c in my_map:
                stack.append(c)
            else:
                if c == ")" or c == "]" or c == "}":
                    if not stack or my_map[stack.pop()] != c:
                        return False
        
        return not stack
    
if __name__ == "__main__":
    solution = Solution()
    
    tests = ["()", "()[]{}", "(]", "([])"]
    answers = [True, True, False, True]
    
    for i in range(len(answers)):
        print("test #" + str(i + 1) + ": " + tests[i] + ", "
              + str(solution.isValidNew(tests[i]) == answers[i]))
        