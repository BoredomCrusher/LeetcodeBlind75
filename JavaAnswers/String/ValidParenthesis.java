package String;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
   public boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty() || map.get(stack.pop()) != c)
                        return false;
                }
            }
        }

        return stack.size() == 0;
    }
}
