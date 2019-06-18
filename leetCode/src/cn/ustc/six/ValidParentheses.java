package cn.ustc.six;

import java.util.Stack;

/**
 * 效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        int n = s.length();
        if(s.isEmpty()) return true;
        else if(n % 2 == 1) return false;
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder(s);
        for(int i = 0; i < n; i++) {
            try {
                String str = builder.substring(i, i + 1);

                if(str.equals(")") && "(".equals(stack.peek())) {
                    stack.pop();
                } else if(str.equals("}") && "{".equals(stack.peek())) {
                    stack.pop();
                } else if(str.equals("]") && "[".equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(str);
                }
            } catch(Exception e) {
                return false;
            }
        }
        return stack.empty();
    }

}
